package oopdevelopgradle.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import oopdevelopgradle.model.Bullet;
import oopdevelopgradle.model.Elements;
import oopdevelopgradle.model.GamePlayModel;
import oopdevelopgradle.model.NormalProfessor;
import oopdevelopgradle.model.Professor;
import oopdevelopgradle.model.Rector;
import oopdevelopgradle.model.Score;
import oopdevelopgradle.model.Student;
import oopdevelopgradle.model.Tutor;
import oopdevelopgradle.view.GamePlayView;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * The class GamePlayController controls the game logic, manages the game state,
 * and communicates between the model and view components of the game.
 */
public final class GamePlayController implements GamePlayControllerInterface {
    private boolean gameStatus;
    /**
     * Game status when the player wins.
     */
    public static final String STATUS_VITTORIA = "Vittoria";
    /**
     * Game status when the player looses.
     */
    public static final String STATUS_SCONFITTA = "Sconfitta";
    /**
     * Time between consecutive shots fired by the professors.
     */
    public static final int TIME_TO_SHOOT = 4;
    /**
     * Initial energy of the player.
     */
    public static final int ENERGY_INIT = 20;
    /**
     * Initial total time of the game.
     */
    public static final int TEMPO_TOT_INIT = 60;
    /**
     * Seconds of sleep of threads.
     */
    private static final int SLEEP_1 = 10_000;
    /**
     * Seconds of sleep of threads.
     */
    private static final int SLEEP_2 = 6000;
    private int numStudOndata;
    private static GamePlayModel gameModel;
    private GamePlayView gamePlayView;
    private Score scoreMatch;
    private List<Bullet> bulletNormalList = new ArrayList<>();
    private List<Bullet> bulletDiagonalList = new ArrayList<>();
    private List<Tutor> tutorInGame = new ArrayList<>();
    private List<NormalProfessor> normalPInGame = new ArrayList<>();
    private List<Rector> rectorInGame = new ArrayList<>();
    private List<Student> studInGame = new ArrayList<>();
    private final List<List<? extends Professor>> allProfessors = new ArrayList<>();
    private final Logger log = Logger.getLogger(GamePlayController.class.getName());

    /**
     * Function that create a list of lists of all types of professors in the game.
     * 
     * @param tutorInGame   list of tutors in game
     * @param normalPInGame list of normal professors in game
     * @param rectorInGame  list of rectors in game
     */
    public void addAllLists(final List<Tutor> tutorInGame, final List<NormalProfessor> normalPInGame,
            final List<Rector> rectorInGame) {
        allProfessors.clear();
        allProfessors.add(tutorInGame);
        allProfessors.add(normalPInGame);
        allProfessors.add(rectorInGame);
    }
    private static synchronized void setDataSource(final GamePlayModel ds) {
         gameModel = ds; 
    }
    @SuppressFBWarnings({ "EI_EXPOSE_REP" })
    //Justification = this method is used in a controlled manner within 
    //the game controller and game view.
    @Override
    public void initData(final GamePlayView gamePlayView) {
        numStudOndata = 1;
        scoreMatch = new Score();
        scoreMatch.resetScore();
        gameStatus = true;
        setDataSource(new GamePlayModel()); //gameModel = new GamePlayModel();
        gameModel.setScoreMacth(scoreMatch.getScore());
        gameModel.setTimeTot(TEMPO_TOT_INIT);
        gameModel.setEnergy(ENERGY_INIT);
        bulletNormalList = gameModel.getBulletListNormal();
        bulletDiagonalList = gameModel.getBulletListDiagonal();
        tutorInGame = gameModel.getTutorList();
        normalPInGame = gameModel.getNormalProfList();
        rectorInGame = gameModel.getRectorList();
        studInGame = gameModel.getStudentList();
        addAllLists(tutorInGame, normalPInGame, rectorInGame);
        this.gamePlayView = gamePlayView;
        gamePlayView.setFirstProfPicked(false);
        try {
            initGamePlay();
        } catch (IOException e) {
            log.fine(e.toString());
        }
        if (!studInGame.isEmpty()) {
            gamePlayView.initializeView();
            startGame(gamePlayView);
        }
    }

    @Override
    public void initGamePlay() throws IOException {
        if (gameStatus) {
            synchronizeLists(() -> {
                gameModel.generateWave(numStudOndata);
                gamePlayView.updatePositions(studInGame, allProfessors, bulletNormalList, bulletDiagonalList);
            });
        }
    }

    @Override
    public void moveStudents() {
        final List<Student> studentToRemove = new ArrayList<>();
        final List<Student> studentCopy = new ArrayList<>(studInGame);
        final Iterator<Student> studentIterator = studentCopy.iterator();
        while (studentIterator.hasNext()) {
            final Student student = studentIterator.next();
            if (student.getHealthStudent() > 0) {
                if (!collisionProfAndStudent(student, allProfessors) && student.getPosition().getX() > 0) {
                    student.setPosition(new Elements<Integer, Integer>(student.getPosition().getX() - 1,
                            student.getPosition().getY()));
                }
                if (student.getPosition().getX() == 0) {
                    if (collisionProfAndStudent(student, allProfessors)) {
                        synchronizeLists(() -> {
                            gamePlayView.updatePositions(studInGame, allProfessors, bulletNormalList,
                                    bulletDiagonalList);
                        });
                    } else {
                        gameStatus = false;
                        gamePlayView.setTimerStop(true);
                        try {
                            userGame(STATUS_SCONFITTA);
                        } catch (IOException e) {
                            log.fine(e.toString());
                        }
                        break;
                    }
                }
            } else {
                studentToRemove.add(student);
            }
        }
        studInGame.removeAll(studentToRemove);
    }

    @Override
    public void handleProfessors() {
        final List<Professor> professorsToRemove = new ArrayList<>();
        final List<List<? extends Professor>> allProfessorsCopy = new ArrayList<>(allProfessors);
        if (!allProfessorsCopy.isEmpty()) {
            for (final List<? extends Professor> professorList : allProfessorsCopy) {
                final Iterator<? extends Professor> profIterator = professorList.iterator();
                while (profIterator.hasNext() && !professorList.isEmpty()) {
                    final Professor prof = profIterator.next();
                    if (prof.getHealthPointsProf() <= 0) {
                        gameModel.setEnergy(Math.max(0, gameModel.getEnergy() - prof.getEnergyProfessor()));
                        prof.setAttacked(false);
                        professorsToRemove.add(prof);
                        profIterator.remove();
                    } else if (!collisionProfAndStudents(studInGame, prof)
                            && gameModel.getTimeTot() % TIME_TO_SHOOT == 0 && !prof.isAttacked()) {
                        if (prof instanceof Tutor) {
                            final Tutor curr = (Tutor) prof;
                            bulletNormalList.add(
                                    new Bullet(curr.getBulletSpeed(), curr.getDamageProf(), curr.getPositionProf()));
                            gameModel.setBulletListNormal(bulletNormalList);
                        } else if (prof instanceof NormalProfessor) {
                            final NormalProfessor normalProfessor = (NormalProfessor) prof;
                            bulletNormalList.add(new Bullet(normalProfessor.getBulletSpeed(),
                                    normalProfessor.getDamageProf(), normalProfessor.getPositionProf()));
                            gameModel.setBulletListNormal(bulletNormalList);
                        } else {
                            final Rector curr = (Rector) prof;
                            bulletDiagonalList.add(
                                    new Bullet(curr.getBulletSpeed(), curr.getDamageProf(), curr.getPositionProf()));
                            gameModel.setBulletListDiagonal(bulletDiagonalList);
                        }
                    }
                }
            }
        }
        for (final List<? extends Professor> professorList : allProfessors) {
            professorsToRemove.forEach(bullet -> {
                removeProfessorView(bullet);
            });
            professorList.removeIf(professorsToRemove::contains);
        }
    }

    @Override
    public void advanceBullets() {
        final List<Bullet> bulletToRemoveN = new ArrayList<>();
        final List<Bullet> bulletNormalCopy = new ArrayList<>(bulletNormalList);
        final Iterator<Bullet> bulletNormalIterator = bulletNormalCopy.iterator();
        while (bulletNormalIterator.hasNext() && !bulletNormalCopy.isEmpty()) {
            final Bullet bullet = bulletNormalIterator.next();
            if (collisionBulletAndStudents(studInGame, bullet)) {
                bulletToRemoveN.add(bullet);
            } else {
                bullet.move();
            }
            if (bullet.getPosition().getX() > 8) {
                bulletToRemoveN.add(bullet);
            }
        }
        bulletNormalList.removeIf(bulletToRemoveN::contains);
        final List<Bullet> bulletToRemoveD = new ArrayList<>();
        final List<Bullet> bulletDiagonalCopy = new ArrayList<>(bulletDiagonalList);
        final Iterator<Bullet> bulletDiagonalIterator = bulletDiagonalCopy.iterator();
        while (bulletDiagonalIterator.hasNext() && !bulletDiagonalCopy.isEmpty()) {
            final Bullet bullet = bulletDiagonalIterator.next();
            if (collisionBulletAndStudents(studInGame, bullet)) {
                bulletToRemoveD.add(bullet);
            } else {
                bullet.shootDiagonal();
            }
            if (bullet.getPosition().getX() > 8 || bullet.getPosition().getY() > 4 || bullet.getPosition().getY() < 0) {
                bulletToRemoveD.add(bullet);
            }
        }
        bulletDiagonalList.removeIf(bulletToRemoveD::contains);
    }

    @Override
    public void startGame(final GamePlayView gamePlayView) {
        if (gameStatus) {
            new Thread(() -> {
                while (gameStatus) {
                    synchronizeLists(() -> {
                        if (gameModel.getTimeTot() == 0 || gameModel.getEnergy() == 0
                                && allProfessors.stream().allMatch(list -> list.isEmpty())) {
                            gameStatus = false;
                            if (allProfessors.stream().allMatch(list -> list.isEmpty())) {
                                try {
                                    userGame(STATUS_SCONFITTA);
                                } catch (IOException e) {
                                    log.fine(e.toString());
                                }
                            } else {
                                try {
                                    userGame(STATUS_VITTORIA);
                                } catch (IOException e) {
                                    log.fine(e.toString());
                                }
                            }
                        }
                    });
                }
            }).start();
            new Thread(() -> {
                while (gameStatus) {
                    sleep(SLEEP_2);
                    synchronizeLists(() -> {
                        gamePlayView.updatePositions(studInGame, allProfessors, bulletNormalList, bulletDiagonalList);
                        moveStudents();
                        gamePlayView.updatePositions(studInGame, allProfessors, bulletNormalList, bulletDiagonalList);
                    });
                }
            }).start();
            new Thread(() -> {
                while (gameStatus) {
                    try {
                        sleep(SLEEP_1);
                        initGamePlay();
                    } catch (IOException e) {
                        log.fine(e.toString());
                    }
                }
            }).start();
            new Thread(() -> {
                while (gameStatus) {
                    synchronizeLists(() -> {
                        gamePlayView.updatePositions(studInGame, allProfessors, bulletNormalList, bulletDiagonalList);
                        advanceBullets();
                        handleProfessors();
                        gamePlayView.updatePositions(studInGame, allProfessors, bulletNormalList, bulletDiagonalList);
                    });
                    sleep(1000);
                }
            }).start();
        }
    }

    /**
     * Executes an action within a synchronized section, ensuring safe access to the
     * shared lists {@code studInGame}, {@code profInGame},
     * {@code bulletNormalList}, and {@code bulletDiagonalList}.
     *
     * @param action the action to be performed within the synchronized section
     */
    private void synchronizeLists(final Runnable action) {
        synchronized (studInGame) {
            synchronized (allProfessors) {
                synchronized (bulletNormalList) {
                    synchronized (bulletDiagonalList) {
                        action.run();
                    }
                }
            }
        }
    }

    @Override
    public void userGame(final String status) throws IOException {
        Platform.runLater(() -> {
            try {
                final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/StatusGameView.fxml"));
                final Parent lostGame = (Parent) fxmlLoader.load();
                final Stage stage = new Stage();
                stage.setScene(new Scene(lostGame));
                final Label label = (Label) lostGame.lookup("#gameLabel");
                if (STATUS_VITTORIA.equals(status)) {
                    label.setText("Hai vinto!");
                } else if (STATUS_SCONFITTA.equals(status)) {
                    label.setText("Hai perso!");
                }
                stage.show();
            } catch (IOException e) {
                log.fine(e.toString());
            }
        });
    }

    /**
     * Delays the execution of the current thread for the specified number of
     * milliseconds, allowing for the visibility of the game to be adjusted.
     *
     * @param num The number of milliseconds to sleep.
     */
    private void sleep(final int num) {
        if (gameModel.getTimeTot() > 0) {
            try {
                Thread.sleep(num);
            } catch (InterruptedException e) {
                log.fine(e.toString());
            }
        }
    }

    @Override
    public boolean collisionBulletAndStudents(final List<Student> studentList, final Bullet bullet) {
        final List<Student> studentToRemove = new ArrayList<>();
        boolean collisionDetected = false;
        for (final Student currentStud : studentList) {
            if (bullet.getPosition().equals(currentStud.getPosition())) {
                currentStud.takeDamageStudents(bullet.getBulletDamage());
                collisionDetected = true;
                if (currentStud.getHealthStudent() <= 0) {
                    scoreMatch.addScore();
                    gameModel.setScoreMacth(scoreMatch.getScore());
                    gameModel.setEnergy(gameModel.getEnergy() + currentStud.getEnergy());
                    studentToRemove.add(currentStud);
                }
            }
        }
        for (final Student student : studentToRemove) {
            studentList.remove(student);
        }
        return collisionDetected;
    }

    @Override
    public boolean collisionProfAndStudents(final List<Student> students, final Professor prof) {
        for (final Student currentStud : students) {
            if (currentStud.getPosition().equals(prof.getPosition())) {
                prof.receiveDamageProf(currentStud.getDamage());
                if (prof.getHealthPointsProf() > 0) {
                    prof.setAttacked(true);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean collisionProfAndStudent(final Student currentStud, final List<List<? extends Professor>> profList) {
        for (final List<? extends Professor> professors : profList) {
            final Optional<? extends Professor> result = professors.stream()
                    .filter(prof -> prof.getPositionProf().equals(currentStud.getPosition())).findFirst();
            if (result.isPresent()) {
                final Professor professor = result.get();
                if (professor.getHealthPointsProf() > 0) {
                    professor.setAttacked(true);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public void removeProfessorView(final Professor prof) {
        if (prof instanceof Tutor) {
            tutorInGame.remove(prof);
        } else if (prof instanceof NormalProfessor) {
            normalPInGame.remove(prof);
        } else if (prof instanceof Rector) {
            rectorInGame.remove(prof);
        } else {
            return;
        }
    }

    /*@Override
    public Score getScoreMatch() {
        return scoreMatch;
    }*/

   /* @Override
    public void setScoreMatch(final Score scoreMatch) {
        this.scoreMatch = scoreMatch;
    }*/

    @Override
    public boolean isGameStatus() {
        return gameStatus;
    }

    @Override
    public void setGameStatus(final boolean status) {
        gameStatus = status;
    }

    /*@Override
    public GamePlayView getGamePlayView() {
        return gamePlayView;
    }*/

    /**
     * Retrieves the GamePlayModel associated with this controller.
     *
     * @return The GamePlayModel associated with this controller.
     */
    public static List<GamePlayModel> getGameModel() {
        return Collections.unmodifiableList(Arrays.asList(gameModel));
    }
    /*public static GamePlayModel getGameModel() {
    return gameModel;
}*/
    /*@Override
    public List<Student> getStudInGame() {
        return studInGame;
    }*/
/*
    @Override
    public void setStudInGame(final List<Student> studInGame) {
        this.studInGame = studInGame;
    }*/

}

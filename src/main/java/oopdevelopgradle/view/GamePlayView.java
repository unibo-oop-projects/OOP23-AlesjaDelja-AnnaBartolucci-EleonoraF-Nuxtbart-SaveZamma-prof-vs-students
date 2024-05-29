package oopdevelopgradle.view;

import java.util.List;
import java.util.Iterator;
import oopdevelopgradle.model.Bullet;
import oopdevelopgradle.model.GamePlayModel;
import oopdevelopgradle.model.NormalProfessor;
import oopdevelopgradle.model.Professor;
import oopdevelopgradle.model.Rector;
import oopdevelopgradle.model.Student;
import oopdevelopgradle.model.Tutor;
import oopdevelopgradle.controller.GamePlayController;
import java.io.IOException;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
/**
 * The class GamePlayView implements the interface GamePlayViewInterface. 
 * This class implements the methods of its interface in order to manage
 * the view of the game play.
 */
public class GamePlayView implements GamePlayViewInterface {
	@FXML
    private AnchorPane gamePlayRoot;
    @FXML
    private ImageView lawnImage;
    @FXML
    private ImageView sunCountImage;
    @FXML
    private Label matchScoreLabel;
    @FXML
    private Label energyLabel;
    @FXML
    private ImageView gameMenuButton;
    @FXML
    private GridPane lawnGrid;
    @FXML
    private Label timeLabel;
    private GamePlayController gameController;
    private GamePlayModel gamePlayModel;
    private final List<Tutor> tutorInGrid = new ArrayList<>();
    private final List<NormalProfessor> normalProfInGrid = new ArrayList<>();
    private final List<Rector> rectorInGrid = new ArrayList<>();
    private List<Student> studentInGrid = new ArrayList<>();
    private List<Bullet>  bulletInGrid = new ArrayList<>();
    private List<List<? extends Professor>> profsInGrid = new ArrayList<>();
    private boolean firstProfPicked;
    private AnimationTimer  timer;
    private int timeTot;
    private int matchScore;
    private long lastTimeUpdate = 0;
    private static final long ONE_SECOND = 1_000_000_000;
    private static final int ONE_MINUTE = 60;
    private boolean timerStop = false;
    private int profChoosen;
    @Override
	public void setController(final GamePlayController gameController) {
        this.gameController = gameController;
    }
    @Override
	public boolean isFirstProfPicked() {
		return firstProfPicked;
	}
    @Override
	public void setFirstProfPicked(final boolean firstProfPicked) {
		this.firstProfPicked = firstProfPicked;
	}
	/**
	 * Initializes the view by setting up the game controller and starting the timer for updating game elements.
	 */
    @FXML
    public void initialize() {
        try {
        	gameController = new GamePlayController();
            gameController.initData(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initializeView() {
    	profChoosen = -1;
    	gamePlayModel = GamePlayController.getGameModel();
		timer = new AnimationTimer() {
            @Override
            public void handle(final long now) {
            	if (!timerStop) {
                    if (now - lastTimeUpdate >= ONE_SECOND) {
                    	timeTot = gamePlayModel.getTimeTot();
                    	if (timeTot > 0) {
                    		updateTempoLabel();
                    		updateEnergyLabel();
                    		updateMatchScoreLabel();
                            lastTimeUpdate = now;
                    	} else {
                        	timer.stop();
                    	}
                    }
            	} else {
            		timer.stop();
            	}
           }
        };
        timer.start();
    }
    @Override
    public boolean isTimerStop() {
		return timerStop;
	}
    @Override
	public void setTimerStop(final boolean timerStop) {
		this.timerStop = timerStop;
	}
	/**
	 * Updates the displayed time on the game view.
	 */
	private void updateTempoLabel() {
    	// funzione che mi aggiorna il tempo che scorre
    	timeTot--;
        final int min = timeTot / ONE_MINUTE;
        final int sec = timeTot % ONE_MINUTE;
        timeLabel.setText(String.format("%02d:%02d", min, sec));
        gamePlayModel.setTimeTot(timeTot);
	}
	/**
	 * Updates the displayed energy on the game view.
	 */
	public void updateEnergyLabel() {
		energyLabel.setText(String.format("%d", gamePlayModel.getEnergy()));
	}
	/**
	 * Updates the displayed match score on the game view.
	 */
	public void updateMatchScoreLabel() {
		matchScoreLabel.setText(String.format("Score: %d", gamePlayModel.getScoreMacth()));
	}
	@Override
	public int getMatchScore() {
		return matchScore;
	}
	@Override
	public void setMatchScore(final int matchScore) {
		this.matchScore = matchScore;
	}
	@Override
	public void updatePositions(final List<Student> studentList, final List<List<? extends Professor>> profList, 
			final List<Bullet> bulletListNormal, final List<Bullet> bulletList) {
		Platform.runLater(() -> {
			removeImageViews();
	        updateStudentPositions(studentList);
	        updateProfessorPositions(profList);
	        updateBulletPositions(bulletList);
	        updateBulletPositions(bulletListNormal);
	    });
    }
	/**
	 * Removes the image views of game elements from the view.
	 */
	private void removeImageViews() {
	    lawnGrid.getChildren().removeIf(node -> node instanceof ImageView);
	}
	/**
	 * Updates the positions of students on the view.
	 *
	 * @param studentList The list of students.
	 */
	private void updateStudentPositions(final List<Student> studentList) {
		studentInGrid = studentList;
	    final List<Student> studentInGridCopy = new ArrayList<>(studentInGrid);
	    final Iterator<Student> iterator = studentInGridCopy.iterator();
	    while (iterator.hasNext()) {
	        final Student student = iterator.next();
	        final StudentView studView = new StudentView(lawnGrid);
	        studView.displayElement(student.getPosition());
	    }
	}

	/**
	 * Updates the positions of professors on the view.
	 *
	 * @param profsList The list of professors.
	 */
	private void updateProfessorPositions(final List<List<? extends Professor>> profsList) {
	    final List<List<? extends Professor>> professorsToRemove = new ArrayList<>();
	    for (final List<? extends Professor> professors : profsInGrid) {
	        if (!profsList.contains(professors)) {
	            professorsToRemove.add(professors);
	        }
	    }
	    profsInGrid.removeAll(professorsToRemove);
	    for (final List<? extends Professor> professors : profsInGrid) {
	        final Iterator<? extends Professor> iterator = professors.iterator();
	        while (iterator.hasNext() && !professors.isEmpty()) {
	            final Professor prof = iterator.next();
	            if (prof instanceof Tutor) {
	                final Tutor tutor = (Tutor) prof;
	                final TutorView tutorView = new TutorView(lawnGrid);
	                tutorView.displayElement(tutor.getPositionProf());
	            } else if (prof instanceof NormalProfessor) {
	                final NormalProfessor normalProfessor = (NormalProfessor) prof;
	                final NormalProfView normalProfessorView = new NormalProfView(lawnGrid);
	                normalProfessorView.displayElement(normalProfessor.getPositionProf());
	            } else if (prof instanceof Rector) {
	                final Rector rector = (Rector) prof;
	                final RectorView rectorView = new RectorView(lawnGrid);
	                rectorView.displayElement(rector.getPositionProf());
	            }
	        }
	    }
	}
	/**
	 * Updates the positions of bullets on the view.
	 *
	 * @param bulletList The list of bullets.
	 */
	private void updateBulletPositions(final List<Bullet> bulletList) {
	    bulletInGrid = bulletList;
	    final List<Bullet> bulletInGridCopy = new ArrayList<>(bulletInGrid);

	    final Iterator<Bullet> iterator = bulletInGridCopy.iterator();
	    while (iterator.hasNext() && !bulletInGridCopy.isEmpty()) {
	        final Bullet bullet = iterator.next();

	        final BulletView bulletView = new BulletView(lawnGrid);
	        bulletView.displayElement(bullet.getPosition());
	    }
	}
	@Override
	public void removePosition(final List<? extends ElementView> elementsToRemove) {
	    Platform.runLater(() -> {
	        for (final ElementView elem : elementsToRemove) {
	            elem.removeElement();
	        }
	    });
	}
	
	/**
	 * Handles the mouse click event for selecting a professor card.
	 *
	 * @param event The mouse click event.
	 */
    @FXML
    private void handleMouseClick(final MouseEvent event) {
        final Integer columnIndex = GridPane.getColumnIndex((Region) event.getSource());
        final Integer rowIndex = GridPane.getRowIndex((Region) event.getSource());
        System.out.println("Clicked at column " + columnIndex + " and row " + rowIndex);
	    	if (profChoosen != -1 && columnIndex != null && rowIndex != null 
	    			&& !isProfInCell(columnIndex, rowIndex) 
	    			&& !isStudentInCell(columnIndex, rowIndex)) {
	    		setFirstProfPicked(true);
	    		switch (profChoosen) {
	    			case 1:
	    				final Tutor tutornew = new Tutor(columnIndex, rowIndex);
	    				final Bullet tutorBullet = tutornew.tutorBullet;
	    				if (tutornew.getEnergyProfessor() <= gamePlayModel.getEnergy()) {
	    					gamePlayModel.getTutorList().add(tutornew);
	    					tutorInGrid.add(tutornew);
	    					gamePlayModel.getBulletListNormal().add(tutorBullet);
	    					addProfsInListAndUpdate();
	    	    			gamePlayModel.decreaseEnergy(tutornew.getEnergyProfessor());
	    	    		}
	    				break;
	    			case 2:
	    				final NormalProfessor normalProfNew = new NormalProfessor(columnIndex, rowIndex);
	    				final Bullet nProfBullet = normalProfNew.normalProfBullet;
	    				if (normalProfNew.getEnergyProfessor() <= gamePlayModel.getEnergy()) {
	    					gamePlayModel.getNormalProfList().add(normalProfNew);
	    					normalProfInGrid.add(normalProfNew);
	    					gamePlayModel.getBulletListNormal().add(nProfBullet); 
	    					addProfsInListAndUpdate();
	    	    			gamePlayModel.decreaseEnergy(normalProfNew.getEnergyProfessor());
	    	    		}
	    				break;
	    			case 3:
	    				final Rector rectornew = new Rector(columnIndex, rowIndex);
	    				final Bullet rectorBullet = rectornew.rectorBullet;
	    				if (rectornew.getEnergyProfessor() <= gamePlayModel.getEnergy()) {
	    					gamePlayModel.getRectorList().add(rectornew);
	    					rectorInGrid.add(rectornew);
	    					gamePlayModel.getBulletListDiagonal().add(rectorBullet);
	    					addProfsInListAndUpdate();

	    	    			gamePlayModel.decreaseEnergy(rectornew.getEnergyProfessor());
	    	    		}
	    				break;
	    			default:
	    		        System.out.println("Il numero non è né 1, né 2, né 3");
	    		        break;
	    		 }
	    }
    }
    /**
     *  Add all types of professors to the General list of professors in grid and update the positions on the view.
     */
    private void addProfsInListAndUpdate() {
    	profsInGrid.add(gamePlayModel.getTutorList());
		profsInGrid.add(gamePlayModel.getNormalProfList());
		profsInGrid.add(gamePlayModel.getRectorList());
		updatePositions(gamePlayModel.getStudentList(), profsInGrid, gamePlayModel.getBulletListNormal(), 
				gamePlayModel.getBulletListDiagonal());
    }
    /**
     * Function that opens the Game Menu.
     * @param event
     * @throws IOException
     */
    @FXML
    void gameMenu(final MouseEvent event) throws IOException {
    	gameController.setGameStatus(false);
    	timerStop = true;
    	GamePlayController.getInstance().setGameStatus(false);
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/MenuView.fxml"));
        final Parent gameMenu = (Parent) fxmlLoader.load();
        final Stage stage = new Stage();
        stage.setScene(new Scene(gameMenu));
        stage.show();
    }
    /**
     * Handles the selection of the tutor card.
     */
    @FXML
    public void handleTutorCardClick() {
    	profChoosen = 1;
    }
    /**
     * Handles the selection of the normal professor card.
     */
    @FXML
    public void handleNormalCardClick() {
    	profChoosen = 2;
    }
    /**
     * Handles the selection of the rector card.
     */
    @FXML
    public void handleRectorCardClick() {
    	profChoosen = 3;
    }
    /**
     * Checks if a professor is present in the specified cell.
     *
     * @param columnIndex The column index of the cell.
     * @param rowIndex    The row index of the cell.
     * @return True if a professor is present in the cell, false otherwise.
     */
	private boolean isProfInCell(final int columnIndex, final int rowIndex) {
		return rectorInGrid.stream().anyMatch(p -> p.getPositionProf().getX() == columnIndex 
				&& p.getPositionProf().getY() == rowIndex)
				&& tutorInGrid.stream().anyMatch(p -> p.getPositionProf().getX() == columnIndex 
				&& p.getPositionProf().getY() == rowIndex)
				&& normalProfInGrid.stream().anyMatch(p -> p.getPositionProf().getX() == columnIndex 
				&& p.getPositionProf().getY() == rowIndex);
	}

	/**
     * Checks if a student is present in the specified cell.
     *
     * @param columnIndex The column index of the cell.
     * @param rowIndex    The row index of the cell.
     * @return True if a student is present in the cell, false otherwise.
     */
	private boolean isStudentInCell(final int columnIndex, final int rowIndex) {
		return studentInGrid.stream().anyMatch(s -> s.getPosition().getX() == columnIndex 
				&& s.getPosition().getY() == rowIndex);
	}
}

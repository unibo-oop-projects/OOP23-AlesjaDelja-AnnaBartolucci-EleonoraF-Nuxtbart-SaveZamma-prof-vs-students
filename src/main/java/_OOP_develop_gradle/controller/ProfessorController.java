package _OOP_develop_gradle.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import _OOP_develop_gradle.model.Bullet;
import _OOP_develop_gradle.model.Elements;
import _OOP_develop_gradle.model.GamePlayModel;
import _OOP_develop_gradle.model.NormalProfessor;
import _OOP_develop_gradle.model.Professor;
import _OOP_develop_gradle.model.Rector;
import _OOP_develop_gradle.model.Score;
import _OOP_develop_gradle.model.Student;
import _OOP_develop_gradle.model.Tutor;
import _OOP_develop_gradle.view.BulletView;
import _OOP_develop_gradle.view.ElementView;
import _OOP_develop_gradle.view.GamePlayView;
import _OOP_develop_gradle.view.NormalProfView;
import _OOP_develop_gradle.view.RectorView;
import _OOP_develop_gradle.view.StudentView;
import _OOP_develop_gradle.view.TutorView;
//INCOMPLETA
/*public class ProfessorController {

	private GamePlayModel gameModel;
    private GamePlayView gamePlayView;
    private List<? extends Professor> professors;

    public ProfessorController(GamePlayModel gameModel, GamePlayView gamePlayView) {
        this.gameModel = gameModel;
        this.gamePlayView = gamePlayView;
    }
    
    public void handleProfessors() {
        List<Professor> professorsToRemove = new ArrayList<>();
        for (List<? extends Professor> professorList : gameModel.getAllProfessors()) {
            Iterator<? extends Professor> profIterator = professorList.iterator();
            while (profIterator.hasNext() && !professorList.isEmpty()) {
                Professor prof = profIterator.next();
                if (prof.getHealthPointsProf() <= 0) {
                    // Rimuovi il professore se la sua salute è inferiore o uguale a zero
                    gamePlayView.removeProfessorView(prof);
                    professorsToRemove.add(prof);
                } else {
                    // Altrimenti, controlla se è tempo di sparare e aggiungi i bullet alla vista
                    if (gamePlayView.isTimeToShoot(prof)) {
                        Bullet bullet = prof.shoot();
                        gamePlayView.addBulletView(bullet);
                        prof.setBullet(bullet);
                    }
                }
            }
        }
        // Rimuovi i professori morti dalle liste
        for (List<? extends Professor> professorList : gameModel.getAllProfessors()) {
            professorList.removeAll(professorsToRemove);
        }
    }

    public void advanceBullets() {
        for (List<? extends Professor> professorList : gameModel.getAllProfessors()) {
            for (Professor professor : professorList) {
                if (professor.getBullet() != null) {
                    professor.getBullet().move();
                }
            }
        }
    }

    public void removeBulletView(Bullet bullet) {
        // Implementa la logica per rimuovere la vista del bullet
        // Assicurati di rimuovere il bullet anche dall'oggetto Professor associato
    }

    public void removeProfessorView(Professor professor) {
        // Implementa la logica per rimuovere la vista del professore
    }
}
*/
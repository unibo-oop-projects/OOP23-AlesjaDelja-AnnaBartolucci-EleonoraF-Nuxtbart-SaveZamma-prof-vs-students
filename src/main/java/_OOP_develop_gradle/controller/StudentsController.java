package _OOP_develop_gradle.controller;

import java.io.IOException;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class StudentsController extends Application {
	@FXML
	private GridPane gridPane;


	public void back(ActionEvent e) throws IOException {
		StageChangeController stageChanger = new StageChangeController();
        stageChanger.mainMenu(e);
	}

	    public void initialize() {
	        try {
	            // Carica l'elemento FXML 	imparare come fare quello ma in un'altra classe
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Student.fxml"));
	            Pane studentPane = loader.load();
	            //posizione Random dello studente
	            int rowIndex = new Random().nextInt(6); 
	            // Aggiungi l'elemento FXML alla GridPane
	            gridPane.add(studentPane, 8, rowIndex); // Ad esempio, aggiungi l'elemento FXML alla colonna 0 e riga 0
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	
	public void showStudents() {
		//TO DO Aggiungere la parte in cui si rende visibile lo studente
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

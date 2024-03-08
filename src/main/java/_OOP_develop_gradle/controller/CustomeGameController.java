package _OOP_develop_gradle.controller;

import java.io.IOException;

import javafx.event.ActionEvent;

public class CustomeGameController {

	
	public void back(ActionEvent e) throws IOException {
		StageChangeController stageChanger = new StageChangeController();
        stageChanger.mainMenu(e);
	}
	
}

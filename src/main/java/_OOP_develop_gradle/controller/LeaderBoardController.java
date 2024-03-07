package application.controller;

import java.io.IOException;

import javafx.event.ActionEvent;

public class LeaderBoardController {

	
	public void back(ActionEvent e) throws IOException {
		StageChangeController stageChanger = new StageChangeController();
        stageChanger.mainMenu(e);
	}
	
}

package _OOP_develop_gradle.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

public class HelpGameController implements GameControllerInterface {

    @FXML
    private ScrollPane scrollPane; // Dichiarazione dello ScrollPane

    @FXML
    private Label helpLabel; // Dichiarazione della Label per il testo di aiuto
	@Override
    public void initialize() throws IOException {
        // Impostazione del testo di aiuto nella label
		 String helpText = new String(Files.readAllBytes(Paths.get("../../../../../README.md")));
        helpLabel.setText(helpText);

        // Impostazione delle proprietà per rendere la label scorrevole
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
    }
    @Override
    public void back(ActionEvent e) throws IOException {
        StageChangeController stageChanger = new StageChangeController();
        stageChanger.mainMenu(e);
    }
}

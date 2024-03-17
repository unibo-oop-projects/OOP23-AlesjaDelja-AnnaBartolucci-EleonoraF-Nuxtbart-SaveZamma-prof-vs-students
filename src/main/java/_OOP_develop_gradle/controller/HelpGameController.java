package _OOP_develop_gradle.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

public class HelpGameController implements GameControllerInterface {

    @FXML
    private ScrollPane scrollPane; // Dichiarazione dello ScrollPane

    @FXML
    private Label helpLabel; // Dichiarazione della Label per il testo di aiuto
    
    private String TEST_LABEL ="Prof vs. Students is a strategy and defense game where the player must protect their house from waves of students using a variety of profs with special abilities.\r\n"
    		+ "Players can plant various types of profs each with unique defensive functions such as shooting direct and diagonal projectiles . \r\n"
    		+ "During gameplay, players must strategically plan the placement of prof and manage resources (energy) to plant new defenses. \r\n"
    		+ "The player MUST choose the first time a prof and then where to plant it(where there isn't anything), if he doesn't choose a different prof then he will plant the last choosen prof.\r\n"
    		+ "Students will come from different directions.\r\n"
    		+ "The ultimate goal is to survive for as a minute, protecting your house and preventing the students from reaching the final goal.\r\n"
    		+ "\r\n"
    		+ "LEGENDS:\r\n"
    		+ "Student-> Health 100 - Damage 25\r\n"
    		+ "When a students dies it will decrease the energy by 10\r\n"
    		+ "Prof:\r\n"
    		+ "  The enegy statistic is the enegy needed to summon that prof.\r\n"
    		+ "    Tutor-> Health 50 - Damage 25 - Energy 10 - Shoots direct projeciles\r\n"
    		+ "    Normal-> Health 100 - Damage 50 - Energy 20 - Shoots direct projeciles\r\n"
    		+ "    Rector-> Health 150 - Damage 50 - Energy 30 - Shoots diagonal projectiles";
	@Override
    public void initialize() throws IOException {
        // Impostazione del testo di aiuto nella label
		 //String helpText = new String(Files.readAllBytes(Paths.get("Help.txt")));
        helpLabel.setText(TEST_LABEL);

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

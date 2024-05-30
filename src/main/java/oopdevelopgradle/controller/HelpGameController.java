package oopdevelopgradle.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * This class implements the GameControllerInterface. HelpGameController
 * implements the functions in order to display the game's rules.
 */
public final class HelpGameController implements GameControllerInterface {
    @FXML
    private Label helpLabel;
    private static final String TEST_LABEL = "Prof vs. Students is a strategy and defense game where the player "
            + "must protect their house from waves of students using a variety of profs with special abilities.\r\n"
            + "Players can plant various types of profs each with unique defensive functions such as shooting direct "
            + "and diagonal projectiles . \r\n"
            + "During the game, players must strategically plan the placement of prof and manage resources (energy)"
            + " to plant new defenses. \r\n"
            + "The player MUST choose the first time a prof and then where to plant it (where there isn't anything) "
            + "on the grid, if he doesn't choose a different prof then he will plant the last choosen prof.\r\n"
            + "If there isn't enough energy, the player can't plant the prof in the grid.\r\n"
            + "Students will come from different directions.\r\n"
            + "The ultimate goal is to survive for as a minute, protecting your university and preventing the students"
            + " from reaching the final goal.\r\n" + "\r\n" + "LEGENDS:\r\n" + "Student-> Health 100 - Damage 25\r\n"
            + "When a student dies it will increase the energy by 10, otherwise when a prof dies it will decrease by 10.\r\n"
            + "Prof:\r\n" + "  The enegy statistic is the enegy needed to summon that prof.\r\n"
            + "    Tutor-> Health 50 - Damage 25 - Energy 10 - Shoots direct projeciles\r\n"
            + "    Normal-> Health 100 - Damage 50 - Energy 20 - Shoots direct projeciles\r\n"
            + "    Rector-> Health 150 - Damage 50 - Energy 30 - Shoots diagonal projectiles";

    /**
     * Function that displays the rules of the game.
     * 
     * @throws IOException
     */
    public void initialize() throws IOException {
        helpLabel.setText(TEST_LABEL);
    }

    @Override
    public void back(final ActionEvent e) throws IOException {
        final StageChangeController stageChanger = new StageChangeController();
        stageChanger.mainMenu(e);
    }
}

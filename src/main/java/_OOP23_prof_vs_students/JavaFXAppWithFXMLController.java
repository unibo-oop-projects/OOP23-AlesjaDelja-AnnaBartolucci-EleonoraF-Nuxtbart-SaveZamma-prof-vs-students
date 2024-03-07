package _OOP23_prof_vs_students;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class JavaFXAppWithFXMLController {
	@FXML
    private Label myLabel;

   @FXML
   private Button myButton;
    
    @FXML
    private ImageView exit;

    /**
     * Event handler for `myButton`.
     * @param e
     */
    @FXML
    public final void myButtonOnClickHandler(final MouseEvent e) {
        myLabel.setText("Clicked! " + e.getClickCount());
    }
    
    @FXML
    public final void exitHandler(final MouseEvent e) {
        myLabel.setText("Clicked! " + e.getClickCount());
    }
}

package _OOP_develop_gradle;

import javafx.application.Application;

public class App {

	private App() { }
	
	public static void main(final String[] args) {
        Application.launch(JavaFXAppWithFXML.class, args);
        // The following line raises: Error: class it.unibo.samplejavafx.App is not a subclass of javafx.application.Application
        // JavaFXApp.launch(args);
        // While the following would do just fine:
        // JavaFXApp.run(args)
    }
}

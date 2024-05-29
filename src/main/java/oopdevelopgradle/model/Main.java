package oopdevelopgradle.model;


import javafx.application.Application;
/**
 * The Main class launches the application.
 */
final class Main {
	private Main() {}
	/**
	 * This methods launches the JavaFX application by invoking the Application.launch.
	 * @param args commend line arguments passed
	 */
	public static void main(final String[] args) {
		Application.launch(MainMenuImp.class, args);
		}
}

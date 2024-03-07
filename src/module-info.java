module module{
	requires javafx.controls;
    requires javafx.fxml;
	requires javafx.media;
	//requires javafx.graphics;
	requires javafx.base;
	requires transitive javafx.graphics;

	exports application;
    opens application;
}
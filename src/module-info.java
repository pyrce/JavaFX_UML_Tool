module UMLModeler {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.base;
	requires jdk.jdeps;
	requires yfiles.javafx;
	requires javafx.swing;
	requires java.desktop;
	requires javafx.graphics;

	opens application to javafx.graphics, javafx.fxml;
}

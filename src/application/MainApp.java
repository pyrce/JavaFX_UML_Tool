package application;




import com.yworks.yfiles.view.GraphControl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {


	public GraphControl graphControl;
	  public static void main(String[] args) {
		    launch(args);
		  }

	@Override
	public void start(Stage premierStage) throws Exception {
		// TODO Auto-generated method stub
	    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("uml.fxml"));
	    Parent root = fxmlLoader.load();
	    Scene scene = new Scene(root);
	    scene.getStylesheets().add(MainApp.class.getResource("application.css").toExternalForm());
	    premierStage.setOnShown(windowEvent -> ( fxmlLoader.<MainController>getController()).onLoaded());
System.out.println(fxmlLoader.<MainController>getController());
	    premierStage.setTitle("Hello, yFiles for JavaFX");
	    premierStage.setScene(scene);
	    premierStage.show();

	}

}

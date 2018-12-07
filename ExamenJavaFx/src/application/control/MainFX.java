package application.control;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
/**
 * 
 * @author jorge
 * @version 1.0
 */
public class MainFX extends Application {
	Stage stage;
	@FXML
	AnchorPane mypane, mypane2;

	@FXML
	Label logoLabel;

	@Override
	public void start(Stage myStage) throws Exception {
		stage = myStage;

		MainWindow();

	}

	private void MainWindow() {

		try {
			// primero cargamos la vista fxml en el FXMLLoader
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Profile.fxml"));
			mypane = loader.load();
			// cargamos el segundo fxml
			FXMLLoader loader2 = new FXMLLoader(getClass().getResource("Getme.fxml"));
			mypane2 = (AnchorPane) loader2.load();

			Scene scene = new Scene(mypane);
			scene.getStylesheets().addAll(getClass().getResource("application.css").toExternalForm());

			// adding Custom fonts
			Font.loadFont(getClass().getResourceAsStream("../view/assets/PoiretOne-Regular.ttf"), 20);
			stage.setTitle("My GitHub Profile");

			stage.setScene(scene);
			stage.show();
			
			ControlFX controller = loader.getController();
			controller.setStageAndMyPaneSecundario(stage, mypane2);
			controller.setStageAndMyPanePrincipal(mypane);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void closeStage() {
		stage.close();
	}

	public static void main(String[] args) {
		launch(args);

	}
}

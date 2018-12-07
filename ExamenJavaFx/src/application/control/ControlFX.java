package application.control;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControlFX {

	Stage stage;
	AnchorPane mypanePrincipal, mypaneSecundario;

	@FXML
	Pane PANEL1;

	public ControlFX() {

	}

	@FXML
	private void handleClose() {

		System.exit(0);
	}

	@FXML
	public void cambiarEscenaSecundaria() throws IOException {

		// añade la escena al stage y la titula
		stage.setScene(new Scene(mypaneSecundario));
		//initialize();

	}

	@FXML
	public void cambiarEscenaPrincipal() throws IOException {

		// añade la escena al stage y la titula
		stage.setScene(new Scene(mypanePrincipal));

	}

	public void setStageAndMyPaneSecundario(Stage stage, AnchorPane mypane2) {
		this.stage = stage;
		this.mypaneSecundario = mypane2;
	}

	public void setStageAndMyPanePrincipal(AnchorPane mypane) {

		this.mypanePrincipal = mypane;
	}

	public void initialize() {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.1), PANEL1);
		translateTransition.setByY(700);
		translateTransition.play();

		translateTransition.setOnFinished(event -> {

			TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(1), PANEL1);
			translateTransition1.setByY(-700);

			translateTransition1.play();

		});

	}

}

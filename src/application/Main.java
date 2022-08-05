package application;
	
import java.net.URL;

import application.fxml.MySQLConnection;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	URL url = null;
	public static int ID = 1;
	@Override
	public void start(Stage primaryStage) {
		try {
			url = getClass().getResource("fxml/authorization.fxml");
			System.out.println(url);
			AnchorPane root = (AnchorPane)FXMLLoader.load(url);
			Scene scene = new Scene(root,1000,500);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Login");
			primaryStage.show();
			//
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
/*
”Ќ»¬≈–—јЋ№Ќџ… ЎјЅЋќЌ ƒЋя  Ќќѕ » ƒ≈…—“¬»я

@FXML
    void reg(ActionEvent event) {
    //«десь должен быть дальше метод действи€
    	MySQLConnection.registrationChild(textfieldname.getText(), textfieldsurname.getText(),
					textfieldsecondname.getText(), Integer.parseInt(textfieldage.getText()), Integer.parseInt(textfieldclass.getText()), Main.ID, textfieldlogin.getText(),
					textfieldpassword.getText());
    }
 */

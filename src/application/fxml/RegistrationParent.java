/**
 * Sample Skeleton for 'RegistrationParent.fxml' Controller Class
 */

package application.fxml;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistrationParent {


    @FXML // fx:id="textregistration"
    private Text textregistration; // Value injected by FXMLLoader

    @FXML // fx:id="textfieldname"
    private TextField textfieldname; // Value injected by FXMLLoader

    @FXML // fx:id="textfieldsurname"
    private TextField textfieldsurname; // Value injected by FXMLLoader

    @FXML // fx:id="textfieldsecondname"
    private TextField textfieldsecondname; // Value injected by FXMLLoader

    @FXML // fx:id="textfieldage"
    private TextField textfieldage; // Value injected by FXMLLoader

    @FXML // fx:id="textfieldlogin"
    private TextField textfieldlogin; // Value injected by FXMLLoader

    @FXML // fx:id="textfieldpassword"
    private TextField textfieldpassword; // Value injected by FXMLLoader

    @FXML // fx:id="textfieldpassword2"
    private TextField textfieldpassword2; // Value injected by FXMLLoader

    @FXML // fx:id="buttonregistration"
    private Button buttonregistration; // Value injected by FXMLLoader

    @FXML
    void reg(ActionEvent event) {
    	String errorMessage = "";
    	try {
			Integer.parseInt(textfieldage.getText());
		} catch (NumberFormatException e) {
			errorMessage += "Format Age is not a number!\n";
		}
    	if (!textfieldpassword.getText().equals(textfieldpassword2.getText())) {
    		errorMessage += "Passwords not equal!\n";
    	}
    	if (errorMessage.length() == 0) {
			MySQLConnection.registration(textfieldname.getText(), textfieldsurname.getText(),
					textfieldsecondname.getText(), Integer.parseInt(textfieldage.getText()), textfieldlogin.getText(),
					textfieldpassword.getText());
			try {
				Stage stage = (Stage) buttonregistration.getScene().getWindow();
				stage.close();

				Stage primaryStage = new Stage();
				URL url = getClass().getResource("authorization.fxml");
				System.out.println(url);
				AnchorPane root = (AnchorPane) FXMLLoader.load(url);
				Scene scene = new Scene(root, 1000, 500);
				primaryStage.setScene(scene);
				primaryStage.setTitle("Main");
				primaryStage.show();
			} catch (Exception e) {
				System.out.println(e);
			}
    	} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
		}
    }
    
    
}
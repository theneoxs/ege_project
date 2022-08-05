/**
 * Sample Skeleton for 'PleaseProvideControllerClassName.fxml' Controller Class
 */

package application.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
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

public class PleaseProvideControllerClassName {

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

    @FXML // fx:id="textfieldclass"
    private TextField textfieldclass; // Value injected by FXMLLoader

    @FXML // fx:id="textfieldlogin"
    private TextField textfieldlogin; // Value injected by FXMLLoader

    @FXML // fx:id="textfieldpassword"
    private TextField textfieldpassword; // Value injected by FXMLLoader

    @FXML // fx:id="textfieldpassword2"
    private TextField textfieldpassword2; // Value injected by FXMLLoader

    @FXML // fx:id="buttonregistration"
    private Button buttonregistration; // Value injected by FXMLLoader

    @FXML
    void entered(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
    @FXML
    void reg(ActionEvent event) {
    	String errorMessage = "";
    	try {
			Integer.parseInt(textfieldage.getText());
		} catch (NumberFormatException e) {
			errorMessage += "Format Age is not a number!\n";
		}
    	try {
			Integer.parseInt(textfieldclass.getText());
		} catch (NumberFormatException e) {
			errorMessage += "Format Age is not a number!\n";
		}
    	if (errorMessage.length() == 0) {
			MySQLConnection.registrationChild(textfieldname.getText(), textfieldsurname.getText(),
					textfieldsecondname.getText(), Integer.parseInt(textfieldage.getText()), Integer.parseInt(textfieldclass.getText()), Main.ID, textfieldlogin.getText(),
					textfieldpassword.getText());
			textregistration.setText("Зарегистрировано");
    	} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
		}
    }
}

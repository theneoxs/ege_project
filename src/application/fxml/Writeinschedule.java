package application.fxml;
/**
 * Sample Skeleton for 'Untitled' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Writeinschedule {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="textfieldplaceinschedule"
    private TextField textfieldplaceinschedule; // Value injected by FXMLLoader

    @FXML // fx:id="textfieldstudent"
    private TextField textfieldstudent; // Value injected by FXMLLoader

    @FXML // fx:id="buttonwrite"
    private Button buttonwrite; // Value injected by FXMLLoader
    @FXML
    private ComboBox<String> cbId; 
	//список от него
	@FXML private ObservableList<String> cblId;
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	cblId = FXCollections.observableArrayList(MySQLConnection.listAllShedule());
    	cbId.setItems(cblId);
    }
    @FXML
	private void writeAction() {  
		try {
			Stage stage = (Stage) buttonwrite.getScene().getWindow();
		    stage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}

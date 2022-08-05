package application.fxml;
/**
 * Sample Skeleton for 'AddMark.fxml' Controller Class
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

public class AddMark {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="textfieldplaceinschedule"
    private TextField textfieldplaceinschedule; // Value injected by FXMLLoader

    @FXML // fx:id="textfieldmark"
    private TextField textfieldmark; // Value injected by FXMLLoader

    @FXML // fx:id="buttonadd"
    private Button buttonadd; // Value injected by FXMLLoader

    @FXML // fx:id="textfieldcomment"
    private TextField textfieldcomment; // Value injected by FXMLLoader
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
	private void addMarkAction() {
	    
		try {
			Stage stage = (Stage) buttonadd.getScene().getWindow();
		    stage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}

package application.fxml;
/**
 * Sample Skeleton for 'Delete.fxml' Controller Class
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

public class Delete {
	//ComboBox, само
	@FXML
    private ComboBox<String> cbId; 
	//список от него
	@FXML private ObservableList<String> cblId;
	
    @FXML
    private Button buttondelete; 

    @FXML
    void initialize() {
    	cblId = FXCollections.observableArrayList(MySQLConnection.listAllShedule());
    	cbId.setItems(cblId);
    }
    
    @FXML
	private void deleteAction() {
	    String id = cbId.getValue().substring(0, cbId.getValue().indexOf(" "));

		try {
			Stage stage = (Stage) buttondelete.getScene().getWindow();
		    stage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}

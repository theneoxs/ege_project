package application.fxml;
/**
 * Sample Skeleton for 'AddLesson.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddLesson {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="textfieldsubject"
    private TextField textfieldsubject; // Value injected by FXMLLoader

    @FXML // fx:id="textfieldtime"
    private TextField textfieldtime; // Value injected by FXMLLoader

    @FXML // fx:id="buttonaddlesson"
    private Button buttonaddlesson; // Value injected by FXMLLoader

    @FXML // fx:id="textfieldteacher"
    private TextField textfieldteacher; // Value injected by FXMLLoader

    @FXML // fx:id="textfieldplaceinschedule"
    private TextField textfieldplaceinschedule; // Value injected by FXMLLoader

    @FXML // fx:id="textfieldstatus"
    private TextField textfieldstatus; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
    
    @FXML
   	private void addLessonAction() {  
    	
   		try {
   			Stage stage = (Stage) buttonaddlesson.getScene().getWindow();
   		    stage.close();
   		} catch(Exception e) {
   			e.printStackTrace();
   		}

   	}
}

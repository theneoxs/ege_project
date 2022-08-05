package application.fxml;

import java.net.URL;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContrForAuth {
	@FXML
	private Text text;
	@FXML
	private Button bParent;
	@FXML
	private Button bLearner;
	@FXML
	private Button bTeacher;
	@FXML
	private Button bTechnical;
	@FXML
	private Button bEnter;
	@FXML
	private Button bRegister;
	@FXML
	private Button bBack;
	
	@FXML
	private TextField tfLogin;
	@FXML
	private PasswordField pfPassword;
	
	int access = 0;
	
	@FXML
	private void parentPress() {
		next(true);
		access = 1;
	}
	@FXML
	private void learnerPress() {
		next(false);
		access = 2;
	}
	@FXML
	private void teacherPress() {
		next(false);
		access = 3;
	}
	@FXML
	private void techPress() {
		next(false);
		access = 4;
	}
	
	@FXML
	private void enter() {
		writeAccess();
		if (tfLogin.getText().equals("admin") && pfPassword.getText().equals("admin")) {
			try {
				Stage stage = (Stage) bEnter.getScene().getWindow();
			    stage.close();
			    
				Stage primaryStage = new Stage();
				URL url = getClass().getResource("main.fxml");
				System.out.println(url);
				AnchorPane root = (AnchorPane)FXMLLoader.load(url);
				Scene scene = new Scene(root,1820,980);
				primaryStage.setScene(scene);
				primaryStage.setTitle("Main");
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			if (access == 1 && MySQLConnection.checkDataParent(tfLogin.getText(), pfPassword.getText())) {
				try {
					Stage stage = (Stage) bEnter.getScene().getWindow();
				    stage.close();
				    
					Stage primaryStage = new Stage();
					URL url = getClass().getResource("main.fxml");
					System.out.println(url);
					AnchorPane root = (AnchorPane)FXMLLoader.load(url);
					Scene scene = new Scene(root,1820,980);
					primaryStage.setScene(scene);
					primaryStage.setTitle("Main");
					primaryStage.show();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			else if (access == 2 && MySQLConnection.checkDataChild(tfLogin.getText(), pfPassword.getText())) {
				try {
					Stage stage = (Stage) bEnter.getScene().getWindow();
				    stage.close();
				    
					Stage primaryStage = new Stage();
					URL url = getClass().getResource("main.fxml");
					System.out.println(url);
					AnchorPane root = (AnchorPane)FXMLLoader.load(url);
					Scene scene = new Scene(root,1820,980);
					primaryStage.setScene(scene);
					primaryStage.setTitle("Main");
					primaryStage.show();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		text.setText("Неверный логин/пароль");
	}
	
	@FXML
	private void entered() {
			try {
				Stage stage = (Stage) bEnter.getScene().getWindow();
			    stage.close();
			    
				Stage primaryStage = new Stage();
				URL url = getClass().getResource("RegistrationParent.fxml");
				System.out.println(url);
				AnchorPane root = (AnchorPane)FXMLLoader.load(url);
				Scene scene = new Scene(root,500,500);
				primaryStage.setScene(scene);
				primaryStage.setTitle("Main");
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		text.setText("Неверный логин/пароль");
	}
	private void addmark() {
		try {
			Stage stage = (Stage) bEnter.getScene().getWindow();
		    stage.close();
		    
			Stage primaryStage = new Stage();
			URL url = getClass().getResource("AddMark.fxml");
			System.out.println(url);
			AnchorPane root = (AnchorPane)FXMLLoader.load(url);
			Scene scene = new Scene(root,600,500);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Main");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	text.setText("Неверный логин/пароль");
}
	private void next(boolean parentCheck) {
		bParent.setVisible(false);
		bLearner.setVisible(false);
		bTeacher.setVisible(false);
		bTechnical.setVisible(false);
		
		tfLogin.setVisible(true);
		pfPassword.setVisible(true);
		bEnter.setVisible(true);
		bBack.setVisible(true);
		if (parentCheck) {
			bRegister.setVisible(true);
		}
		else {
			bEnter.setLayoutX(500-bEnter.getPrefWidth()/2);
		}
		text.setText("Репетиторство");
		
	}
	
	@FXML
	private void back() {
		bParent.setVisible(true);
		bLearner.setVisible(true);
		bTeacher.setVisible(true);
		bTechnical.setVisible(true);
		
		tfLogin.setVisible(false);
		pfPassword.setVisible(false);
		bEnter.setVisible(false);
		bBack.setVisible(false);
		bRegister.setVisible(false);
		bEnter.setLayoutX(552);
		
		text.setText("Репетиторство");
	}
	
	private void writeAccess(){
		try {
			FileWriter file = new FileWriter("lvl");
			file.write(access+"\n");
			file.close();
		}
		catch(Exception e) {
			
		}
	}
}

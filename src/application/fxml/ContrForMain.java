package application.fxml;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ContrForMain {
	@FXML private Pane pane1;
	@FXML private Pane pane2;
	@FXML private Pane pane3;
	@FXML private Pane pane4;
	
	@FXML private AnchorPane spane1;
	@FXML private AnchorPane spane2;
	@FXML private AnchorPane spane3;
	@FXML private AnchorPane spane4;
	
	@FXML private Label label1;
	@FXML private Label label2;
	@FXML private Label label3;
	@FXML private Label label4;
	@FXML private ObservableList<String> cblLearners;
	@FXML private ObservableList<String> cblSubjects;
	@FXML private ObservableList<String> cblBisyness;
	@FXML private ComboBox<String> learners = new ComboBox<String>();
	@FXML private ComboBox<String> subjects = new ComboBox<String>();
	@FXML private ComboBox<String> bisynesses = new ComboBox<String>();
	
	@FXML private Button bReg;
	@FXML private Button bWrite;
	@FXML private Button bProgress;
	
	Date date = new Date();

	private ArrayList<Data> datas = new ArrayList<Data>();
	
	//ЗАПОЛНЯТЬ ДАННЫМИ ДЛЯ ОТОБРАЖЕНИЯ!!!
	private ArrayList<Cell> cells1 = new ArrayList<Cell>();
	private ArrayList<Cell> cells2 = new ArrayList<Cell>();
	private ArrayList<Cell> cells3 = new ArrayList<Cell>();
	private ArrayList<Cell> cells4 = new ArrayList<Cell>();
	//-----------------------------
	
	private Scanner scan;
	private String level_accept;
	@FXML
	private void initialize() {
		readAccess();
		
		cblLearners = FXCollections.observableArrayList(MySQLConnection.listAllLearner());
		learners.setItems(cblLearners);
		cblSubjects = FXCollections.observableArrayList(MySQLConnection.listAllSubjects());
		subjects.setItems(cblSubjects);
		cblBisyness = FXCollections.observableArrayList(listAllBisyness());
		bisynesses.setItems(cblBisyness);
		
		DateFormat df = new SimpleDateFormat("dd MMM yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		label1.setText(df.format(date));
		c.add(Calendar.DATE,1);
		label2.setText(df.format(c.getTime()));
		c.add(Calendar.DATE,1);
		label3.setText(df.format(c.getTime()));
		c.add(Calendar.DATE,1);
		label4.setText(df.format(c.getTime()));
		
		learners.setPromptText("Учитель");
		subjects.setPromptText("Предмет");
		bisynesses.setPromptText("Занятость");
		bReg.setText("Зарегистрировать ученика");
		bWrite.setText("Записать");
		bProgress.setText("Успеваемость");
		
		if (level_accept.equals("2")) {
			bisynesses.setVisible(false);
			bWrite.setVisible(false);
			bReg.setVisible(false);
		}
		else if (level_accept.equals("3")) {
			learners.setVisible(false);
			bWrite.setVisible(false);
			bReg.setVisible(false);
			bProgress.setText("Оценить");
		}
		else if (level_accept.equals("4")) {
			bReg.setVisible(false);
			bWrite.setText("Добавить");
			bProgress.setText("Удалить");
		}
		
		datas = MySQLConnection.getLearnerList();
		
		fillCells();
		showCells();
	}
	String PathWindow = "";
	@FXML
	private void clearSort() {
		clear();
		showCells();
	}
	@FXML
	private void sortByOne(ActionEvent event){
		clear();
		String sorting = learners.getValue().substring(0, learners.getValue().lastIndexOf(" "));
		for (Cell i : cells1) {
			if (i.getData().getDataTeacher().equals(sorting)) {
				spane1.getChildren().add(i.pane);
			}
		}
		for (Cell i : cells2) {
			if (i.getData().getDataTeacher().equals(sorting)) {
				spane2.getChildren().add(i.pane);
			}
		}
		for (Cell i : cells3) {
			if (i.getData().getDataTeacher().equals(sorting)) {
				spane3.getChildren().add(i.pane);
			}
		}
		for (Cell i : cells4) {
			if (i.getData().getDataTeacher().equals(sorting)) {
				spane4.getChildren().add(i.pane);
			}
		}
	}
	
	@FXML
	private void sortByTwo(ActionEvent event){
		clear();
		String sorting = bisynesses.getValue();
		for (Cell i : cells1) {
			if (i.getData().getDataStatus().equals(sorting)) {
				spane1.getChildren().add(i.pane);
			}
		}
		for (Cell i : cells2) {
			if (i.getData().getDataStatus().equals(sorting)) {
				spane2.getChildren().add(i.pane);
			}
		}
		for (Cell i : cells3) {
			if (i.getData().getDataStatus().equals(sorting)) {
				spane3.getChildren().add(i.pane);
			}
		}
		for (Cell i : cells4) {
			if (i.getData().getDataStatus().equals(sorting)) {
				spane4.getChildren().add(i.pane);
			}
		}
	}
	
	@FXML
	private void sortByThree(ActionEvent event){
		clear();
		String sorting = subjects.getValue();
		for (Cell i : cells1) {
			if (i.getData().getDataLearn().equals(sorting)) {
				spane1.getChildren().add(i.pane);
			}
		}
		for (Cell i : cells2) {
			if (i.getData().getDataLearn().equals(sorting)) {
				spane2.getChildren().add(i.pane);
			}
		}
		for (Cell i : cells3) {
			if (i.getData().getDataLearn().equals(sorting)) {
				spane3.getChildren().add(i.pane);
			}
		}
		for (Cell i : cells4) {
			if (i.getData().getDataLearn().equals(sorting)) {
				spane4.getChildren().add(i.pane);
			}
		}
	}
	
	private void clear() {
		spane1.getChildren().clear();
		spane2.getChildren().clear();
		spane3.getChildren().clear();
		spane4.getChildren().clear();
	}
	
	@FXML
	private void showAdditionalWindows(ActionEvent event) {
	    if (event.getSource() == bReg) {
	    	System.out.println("Work!");
	    	PathWindow="PleaseProvideControllerClassName.fxml";
	    }
	    else if(event.getSource() == bWrite) {
	    	System.out.println("Work! x2"); 
	    	if (level_accept.equals("4")) {
	    		PathWindow="AddLesson.fxml";
	    	}
	    	else {
	    		PathWindow="Writeinschedule.fxml";
	    	}
	    }
	    else if (event.getSource() == bProgress) {
	    	System.out.println("Work! x3. Напиши уже вид свой"); 
	    	if (level_accept.equals("3")) {
	    		PathWindow="AddMark.fxml";
	    	}
	    	else if (level_accept.equals("4")) {
	    		PathWindow="Delete.fxml";
	    	}
	    	else {
	    		PathWindow=""; //Вставить вид на успеваемость
	    	}
	    }
		try {
			URL url = null;
			url = getClass().getResource(PathWindow);
			
			Stage primaryStage = new Stage();
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			System.out.println(url);
			AnchorPane root = (AnchorPane)FXMLLoader.load(url);
			Scene scene = new Scene(root,700,700);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("test");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	@FXML
	private void back() {
		
	}
	
	private void test() {
		System.out.println("Work!");
	}
	
	private void readAccess(){
		try {
			FileReader lvl= new FileReader("lvl");
	        scan = new Scanner(lvl);
	        level_accept = scan.nextLine();
	        lvl.close();
		}
		catch(Exception e) {
			
		}
	}
	
	private void fillCells() {
		int start = 10;
		int delta = 160;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		Calendar c = Calendar.getInstance();
		for (Data i : datas) {
			c.setTime(date);
			if (i.getDataTime().getDay() == c.getTime().getDay()) {
				cells1.add(new Cell(start+delta*count1, i.getDataStatus().equals("Свободно") ? COLOR.CYAN : i.getDataStatus().equals("Занято") ? COLOR.RED : COLOR.GRAY, i));
				count1++;
			}
			c.add(Calendar.DATE,1);
			if (i.getDataTime().getDay() == c.getTime().getDay()) {
				cells2.add(new Cell(start+delta*count2, i.getDataStatus().equals("Свободно") ? COLOR.CYAN : i.getDataStatus().equals("Занято") ? COLOR.RED : COLOR.GRAY, i));
				count2++;
			}
			c.add(Calendar.DATE,1);
			if (i.getDataTime().getDay() == c.getTime().getDay()) {
				
				cells3.add(new Cell(start+delta*count3, i.getDataStatus().equals("Свободно") ? COLOR.CYAN : i.getDataStatus().equals("Занято") ? COLOR.RED : COLOR.GRAY, i));
				count3++;
			}
			c.add(Calendar.DATE,1);
			if (i.getDataTime().getDay() == c.getTime().getDay()) {
				cells4.add(new Cell(start+delta*count4, i.getDataStatus().equals("Свободно") ? COLOR.CYAN : i.getDataStatus().equals("Занято") ? COLOR.RED : COLOR.GRAY, i));
				count4++;
			}
			System.out.println(i.getDataStatus());
		}
	}
	
	private void showCells() {
		for (Cell i : cells1) {
			spane1.getChildren().add(i.pane);
		}
		for (Cell i : cells2) {
			spane2.getChildren().add(i.pane);
		}
		for (Cell i : cells3) {
			spane3.getChildren().add(i.pane);
		}
		for (Cell i : cells4) {
			spane4.getChildren().add(i.pane);
		}
	}
	
	public static List<String> listAllBisyness() {
		List<String> list = new ArrayList<String>();
		list.add("Свободно");
		list.add("Занято");
		return list;
	}
}

package application.fxml;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;

public class Cell {
	private int locX;
	private int locY;
	private int sizeX;
	private int sizeY;
	private COLOR color;
	private Data data;
	public Pane pane = new Pane();
	private Label dataTime = new Label();
	private Label dataLearn = new Label();
	private Label dataTeacher = new Label();
	private Label dataPlace = new Label();
	private Label dataStatus = new Label();
	DropShadow dropShadow = new DropShadow();

	public Cell(int locY, COLOR color, Data data) {
		this.locX = 10;
		this.locY = locY;
		this.sizeX = 350;
		this.sizeY = 140;
		this.color = color;
		this.data = data;
		setUpLabel();
		createPane();
	}
	
	public Cell(int locX, int locY, int sizeX, int sizeY, COLOR color, Data data) {
		this.locX = locX;
		this.locY = locY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.color = color;
		this.data = data;
		setUpLabel();
		createPane();
	}

	private void createPane() {
		dropShadow.setRadius(5.5);
		dropShadow.setOffsetX(2.0);
		dropShadow.setOffsetY(2.0);
		dropShadow.setWidth(12.0);
		dropShadow.setHeight(12.0);
		dropShadow.setColor(Color.BLACK);
		
		pane.setPrefHeight(sizeY);
		pane.setPrefWidth(sizeX);
		pane.setLayoutX(locX);
		pane.setLayoutY(locY);
		pane.setStyle("-fx-background-color: " + color.toString());
		setUpLabel();
		pane.getChildren().add(dataTime);
		pane.getChildren().add(dataLearn);
		pane.getChildren().add(dataTeacher);
		pane.getChildren().add(dataPlace);
		pane.getChildren().add(dataStatus);
		pane.setEffect(dropShadow);
	}
	
	private void setUpLabel() {
		settingsLabel(dataTime, data.getDataTime().toLocaleString(), 5, 5);
		settingsLabel(dataLearn, data.getDataLearn(), 17, 40);
		settingsLabel(dataTeacher, data.getDataTeacher(), 200, 60);
		dataTeacher.setTextAlignment(TextAlignment.RIGHT);
		settingsLabel(dataPlace, data.getDataPlace(), 17, 80);	
		dataPlace.setTextAlignment(TextAlignment.RIGHT);
		settingsLabel(dataStatus, data.getDataStatus().toString(), 17, 110);
		
	}
	
	private void settingsLabel(Label label, String text, int x, int y) {
		label.setText(text);
		label.setLayoutX(x);
		label.setLayoutY(y);
	}
	
	public int getLocX() {
		return locX;
	}

	public int getLocY() {
		return locY;
	}

	public int getSizeX() {
		return sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public COLOR getColor() {
		return color;
	}

	public Data getData() {
		return data;
	}

	public void setLocX(int locX) {
		this.locX = locX;
	}

	public void setLocY(int locY) {
		this.locY = locY;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	public void setColor(COLOR color) {
		this.color = color;
	}

	public void setData(Data data) {
		this.data = data;
	}
	
	
}

enum COLOR{
	RED("#FCBFBF"),
	GRAY("#C4C4C4"),
	GREEN("#A8FFB6"),
	CYAN("#BFF8FC");
	
	private String code;
	COLOR(String code){
        this.code = code;
    }
    public String toString(){ return code;}
}

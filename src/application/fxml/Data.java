package application.fxml;

import java.sql.Date;

public class Data {
	private Date dataTime;
	private String dataLearn;
	private String dataTeacher;
	private String dataPlace;
	private String dataStatus;
	
	public Data(Date dataTime, String dataLearn, String dataTeacher, String dataPlace, String dataStatus) {
		this.dataTime = dataTime;
		this.dataLearn = dataLearn;
		this.dataTeacher = dataTeacher;
		this.dataPlace = dataPlace;
		this.dataStatus = dataStatus;
	}

	public Date getDataTime() {
		return dataTime;
	}

	public String getDataLearn() {
		return dataLearn;
	}

	public String getDataTeacher() {
		return dataTeacher;
	}

	public String getDataPlace() {
		return dataPlace;
	}

	public String getDataStatus() {
		return dataStatus;
	}

	public void setDataTime(Date dataTime) {
		this.dataTime = dataTime;
	}

	public void setDataLearn(String dataLearn) {
		this.dataLearn = dataLearn;
	}

	public void setDataTeacher(String dataTeacher) {
		this.dataTeacher = dataTeacher;
	}

	public void setDataPlace(String dataPlace) {
		this.dataPlace = dataPlace;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}

	@Override
	public String toString() {
		return "Data [dataTime=" + dataTime + ", dataLearn=" + dataLearn + ", dataTeacher=" + dataTeacher
				+ ", dataPlace=" + dataPlace + ", dataStatus=" + dataStatus + "]";
	}
	
}


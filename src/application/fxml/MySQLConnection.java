package application.fxml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.Main;

public class MySQLConnection {

	
	public static String driver = "com.mysql.cj.jdbc.Driver"; //�������� ��� ������, ������� ��������� ��� java.sql.Driver
	public static String url = "jdbc:mysql://localhost/ege?&serverTimezone=UTC"; //�������� ���������� � ����������� � ���� ������
	public static String user = "root"; //�������� ��� ������������, ����������� ��� ����� � ���� ������
	public static String password = "qwerty"; //�������� ������, ����������� ��� ����� � ���� ������
	
	
	
	public static ArrayList<Data> getLearnerList() {
		ArrayList<Data> list = new ArrayList<Data>();
		try { //����� ������������ ����� ������ ������� ����������, ������� ���������, ����� ����� �� ����� ���� ������ � �����, ��������� driver
			Class.forName(driver).newInstance(); //�������� ������ �� ����� � ������������ ��� � DriverManager
			String query = "SELECT * FROM ege.Shedule a1, ege.Course a2, ege.Teacher a3 where Teacher_idTeacher = idTeacher and Course_idCourse = idCourse;"; // �������� ���������� SQL-������� � ��������� ���������� � ������ query
			try(
					Connection con = DriverManager.getConnection(url, user, password); //������� ���������� � ����� ������, ��������� URL, ��� ������������ � ������
					Statement st = con.createStatement(); //����� ���������� � ������������� ��������� ���, ����� ���������� ����� ���� �������� � ���� ������
					ResultSet rs = st.executeQuery(query)
							) 
			{ //���������� ���������� ��� �������� ������� � ���� ������ � ���������� ����� ����������� � ���������� rs
				while(rs.next()) { //������� ��������� ���������� �������
						list.add(new Data(rs.getDate("time"), rs.getString("shortname"), rs.getString("surname") + " " + rs.getString("name"), rs.getString("place"), rs.getString("status")));
					}
				}
			} catch (SQLException e) { //����� ������������ ����� ������ SQL ������� ����������, ����������� ��� ������ ������ �� �������
				System.out.println("Error: "+ e.getMessage());
			}
			catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
				System.out.println(e.getMessage());
			} 
		return list;
	}
	public static List<String> listAllLearner() {
		List<String> list = new ArrayList<String>();
		try { //����� ������������ ����� ������ ������� ����������, ������� ���������, ����� ����� �� ����� ���� ������ � �����, ��������� driver
			Class.forName(driver); //�������� ������ �� ����� � ������������ ��� � DriverManager
			String query = "SELECT * FROM ege. Teacher;"; // �������� ���������� SQL-������� � ��������� ���������� � ������ query
			try(
					Connection con = DriverManager.getConnection(url, user, password); //������� ���������� � ����� ������, ��������� URL, ��� ������������ � ������
					Statement st = con.createStatement(); //����� ���������� � ������������� ��������� ���, ����� ���������� ����� ���� �������� � ���� ������
					ResultSet rs = st.executeQuery(query)
							) 
			{ //���������� ���������� ��� �������� ������� � ���� ������ � ���������� ����� ����������� � ���������� rs
				while(rs.next()) { //������� ��������� ���������� �������
						
						list.add(rs.getString("surname") + " " + rs.getString("name") + " " + rs.getString("lastname"));
					}
				}
			} catch (SQLException e) { //����� ������������ ����� ������ SQL ������� ����������, ����������� ��� ������ ������ �� �������
				System.out.println(e);
			}
			catch (ClassNotFoundException e) {
				System.out.println(e);
			}
		return list;
	}
	public static List<String> listAllSubjects() {
		List<String> list = new ArrayList<String>();
		try { //����� ������������ ����� ������ ������� ����������, ������� ���������, ����� ����� �� ����� ���� ������ � �����, ��������� driver
			Class.forName(driver); //�������� ������ �� ����� � ������������ ��� � DriverManager
			String query = "SELECT * FROM ege.Course;"; // �������� ���������� SQL-������� � ��������� ���������� � ������ query
			try(
					Connection con = DriverManager.getConnection(url, user, password); //������� ���������� � ����� ������, ��������� URL, ��� ������������ � ������
					Statement st = con.createStatement(); //����� ���������� � ������������� ��������� ���, ����� ���������� ����� ���� �������� � ���� ������
					ResultSet rs = st.executeQuery(query)
							) 
			{ //���������� ���������� ��� �������� ������� � ���� ������ � ���������� ����� ����������� � ���������� rs
				while(rs.next()) { //������� ��������� ���������� �������
					list.add(rs.getString("shortName"));
					}
				}
			} catch (SQLException e) { //����� ������������ ����� ������ SQL ������� ����������, ����������� ��� ������ ������ �� �������
				System.out.println(e);
			}
			catch (ClassNotFoundException e) {
				System.out.println(e);
			}
		return list;
	}
	public static boolean checkDataParent(String login, String passwd) {
		boolean list = false;
		try { //����� ������������ ����� ������ ������� ����������, ������� ���������, ����� ����� �� ����� ���� ������ � �����, ��������� driver
			Class.forName(driver); //�������� ������ �� ����� � ������������ ��� � DriverManager
			String query = "SELECT * FROM ege.Parent where login = '"+login+"' and password = '"+passwd+"';"; // �������� ���������� SQL-������� � ��������� ���������� � ������ query
			try(
					Connection con = DriverManager.getConnection(url, user, password); //������� ���������� � ����� ������, ��������� URL, ��� ������������ � ������
					Statement st = con.createStatement(); //����� ���������� � ������������� ��������� ���, ����� ���������� ����� ���� �������� � ���� ������
					ResultSet rs = st.executeQuery(query)
							) 
			{ //���������� ���������� ��� �������� ������� � ���� ������ � ���������� ����� ����������� � ���������� rs
				while(rs.next()) { //������� ��������� ���������� �������
					list = true;
					Main.ID = Integer.parseInt(rs.getString("idParent"));
					}
				}
			} catch (SQLException e) { //����� ������������ ����� ������ SQL ������� ����������, ����������� ��� ������ ������ �� �������
				System.out.println(e);
			}
			catch (ClassNotFoundException e) {
				System.out.println(e);
			}
		return list;
	}
	public static boolean checkDataChild(String login, String passwd) {
		boolean list = false;
		try { //����� ������������ ����� ������ ������� ����������, ������� ���������, ����� ����� �� ����� ���� ������ � �����, ��������� driver
			Class.forName(driver); //�������� ������ �� ����� � ������������ ��� � DriverManager
			String query = "SELECT * FROM ege.Child where login = '"+login+"' and password = '"+passwd+"';"; // �������� ���������� SQL-������� � ��������� ���������� � ������ query
			try(
					Connection con = DriverManager.getConnection(url, user, password); //������� ���������� � ����� ������, ��������� URL, ��� ������������ � ������
					Statement st = con.createStatement(); //����� ���������� � ������������� ��������� ���, ����� ���������� ����� ���� �������� � ���� ������
					ResultSet rs = st.executeQuery(query)
							) 
			{ //���������� ���������� ��� �������� ������� � ���� ������ � ���������� ����� ����������� � ���������� rs
				while(rs.next()) { //������� ��������� ���������� �������
					list = true;
					}
				}
			} catch (SQLException e) { //����� ������������ ����� ������ SQL ������� ����������, ����������� ��� ������ ������ �� �������
				System.out.println(e);
			}
			catch (ClassNotFoundException e) {
				System.out.println(e);
			}
		return list;
	}
	public static boolean registration(String a, String b, String c, int d, String e, String f) {
		boolean list = false;
		try { //����� ������������ ����� ������ ������� ����������, ������� ���������, ����� ����� �� ����� ���� ������ � �����, ��������� driver
			Class.forName(driver); //�������� ������ �� ����� � ������������ ��� � DriverManager
			String query = "INSERT into ege.parent (name, surname, lastname, age, login, password) VALUES ('"+a+"', '"+b+"', '"+c+"', '"+d+"', '"+e+"', '"+f+"');"; // �������� ���������� SQL-������� � ��������� ���������� � ������ query
			try {
					Connection con = DriverManager.getConnection(url, user, password); //������� ���������� � ����� ������, ��������� URL, ��� ������������ � ������
					Statement st = con.createStatement(); //����� ���������� � ������������� ��������� ���, ����� ���������� ����� ���� �������� � ���� ������
					int rs = st.executeUpdate(query);
					list = true;
			} 
			catch (SQLException ee) { //����� ������������ ����� ������ SQL ������� ����������, ����������� ��� ������ ������ �� �������
				System.out.println(ee);
			}
		}
		catch (Exception e1) {
			System.out.println(e1);
		}
		return list;
	}
	public static boolean registrationChild(String a, String b, String c, int d, int cn, int idp, String e, String f) {
		boolean list = false;
		try { //����� ������������ ����� ������ ������� ����������, ������� ���������, ����� ����� �� ����� ���� ������ � �����, ��������� driver
			Class.forName(driver); //�������� ������ �� ����� � ������������ ��� � DriverManager
			String query = "INSERT into ege.child (name, surname, lastname, age, classNum, Parent_idParent, login, password) VALUES ('"+a+"', '"+b+"', '"+c+"', '"+d+"', '"+cn+"','"+idp+"','"+e+"', '"+f+"');"; // �������� ���������� SQL-������� � ��������� ���������� � ������ query
			try {
					Connection con = DriverManager.getConnection(url, user, password); //������� ���������� � ����� ������, ��������� URL, ��� ������������ � ������
					Statement st = con.createStatement(); //����� ���������� � ������������� ��������� ���, ����� ���������� ����� ���� �������� � ���� ������
					int rs = st.executeUpdate(query);
					list = true;
			} 
			catch (SQLException ee) { //����� ������������ ����� ������ SQL ������� ����������, ����������� ��� ������ ������ �� �������
				System.out.println(ee);
			}
		}
		catch (Exception e1) {
			System.out.println(e1);
		}
		return list;
	}
	
	//������!!!
	public static boolean addLesson(String time, String status, int idTeacher, int idCourse, String place) {
		return true;
	}
	
	public static List<String> listAllShedule() {
		List<String> list = new ArrayList<String>();
		try { //����� ������������ ����� ������ ������� ����������, ������� ���������, ����� ����� �� ����� ���� ������ � �����, ��������� driver
			Class.forName(driver); //�������� ������ �� ����� � ������������ ��� � DriverManager
			String query = "SELECT * FROM ege.Shedule, ege.Course where ege.Shedule.Course_idCourse = ege.Course.idCourse;"; // �������� ���������� SQL-������� � ��������� ���������� � ������ query
			try(
					Connection con = DriverManager.getConnection(url, user, password); //������� ���������� � ����� ������, ��������� URL, ��� ������������ � ������
					Statement st = con.createStatement(); //����� ���������� � ������������� ��������� ���, ����� ���������� ����� ���� �������� � ���� ������
					ResultSet rs = st.executeQuery(query)
							) 
			{ //���������� ���������� ��� �������� ������� � ���� ������ � ���������� ����� ����������� � ���������� rs
				while(rs.next()) { //������� ��������� ���������� �������
						
						list.add(rs.getString("idShedule")+" "+rs.getString("time")+" "+rs.getString("fullName"));
					}
				}
			} catch (SQLException e) { //����� ������������ ����� ������ SQL ������� ����������, ����������� ��� ������ ������ �� �������
				System.out.println(e);
			}
			catch (ClassNotFoundException e) {
				System.out.println(e);
			}
		return list;
	}
}




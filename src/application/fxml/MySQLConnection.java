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

	
	public static String driver = "com.mysql.cj.jdbc.Driver"; //содержит имя класса, который реализует код java.sql.Driver
	public static String url = "jdbc:mysql://localhost/ege?&serverTimezone=UTC"; //содержит информацию о подключении к базе данных
	public static String user = "root"; //содержит имя пользователя, необходимое для входа в базу данных
	public static String password = "qwerty"; //содержит пароль, необходимый для входа в базу данных
	
	
	
	public static ArrayList<Data> getLearnerList() {
		ArrayList<Data> list = new ArrayList<Data>();
		try { //будет обрабатывать любые ошибки времени выполнения, которые возникают, когда класс не может быть найден в месте, указанном driver
			Class.forName(driver).newInstance(); //получает ссылку на класс и регистрирует его в DriverManager
			String query = "SELECT * FROM ege.Shedule a1, ege.Course a2, ege.Teacher a3 where Teacher_idTeacher = idTeacher and Course_idCourse = idCourse;"; // содержит содержимое SQL-запроса в строковой переменной с именем query
			try(
					Connection con = DriverManager.getConnection(url, user, password); //создает соединение с базой данных, используя URL, имя пользователя и пароль
					Statement st = con.createStatement(); //берет соединение и устанавливает интерфейс так, чтобы инструкция могла быть передана в базу данных
					ResultSet rs = st.executeQuery(query)
							) 
			{ //использует инструкцию для передачи запроса в базу данных и возвращает набор результатов в переменную rs
				while(rs.next()) { //Выводим результат выполнения запроса
						list.add(new Data(rs.getDate("time"), rs.getString("shortname"), rs.getString("surname") + " " + rs.getString("name"), rs.getString("place"), rs.getString("status")));
					}
				}
			} catch (SQLException e) { //будет обрабатывать любые ошибки SQL времени выполнения, возникающие при выводе ошибки на консоль
				System.out.println("Error: "+ e.getMessage());
			}
			catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
				System.out.println(e.getMessage());
			} 
		return list;
	}
	public static List<String> listAllLearner() {
		List<String> list = new ArrayList<String>();
		try { //будет обрабатывать любые ошибки времени выполнения, которые возникают, когда класс не может быть найден в месте, указанном driver
			Class.forName(driver); //получает ссылку на класс и регистрирует его в DriverManager
			String query = "SELECT * FROM ege. Teacher;"; // содержит содержимое SQL-запроса в строковой переменной с именем query
			try(
					Connection con = DriverManager.getConnection(url, user, password); //создает соединение с базой данных, используя URL, имя пользователя и пароль
					Statement st = con.createStatement(); //берет соединение и устанавливает интерфейс так, чтобы инструкция могла быть передана в базу данных
					ResultSet rs = st.executeQuery(query)
							) 
			{ //использует инструкцию для передачи запроса в базу данных и возвращает набор результатов в переменную rs
				while(rs.next()) { //Выводим результат выполнения запроса
						
						list.add(rs.getString("surname") + " " + rs.getString("name") + " " + rs.getString("lastname"));
					}
				}
			} catch (SQLException e) { //будет обрабатывать любые ошибки SQL времени выполнения, возникающие при выводе ошибки на консоль
				System.out.println(e);
			}
			catch (ClassNotFoundException e) {
				System.out.println(e);
			}
		return list;
	}
	public static List<String> listAllSubjects() {
		List<String> list = new ArrayList<String>();
		try { //будет обрабатывать любые ошибки времени выполнения, которые возникают, когда класс не может быть найден в месте, указанном driver
			Class.forName(driver); //получает ссылку на класс и регистрирует его в DriverManager
			String query = "SELECT * FROM ege.Course;"; // содержит содержимое SQL-запроса в строковой переменной с именем query
			try(
					Connection con = DriverManager.getConnection(url, user, password); //создает соединение с базой данных, используя URL, имя пользователя и пароль
					Statement st = con.createStatement(); //берет соединение и устанавливает интерфейс так, чтобы инструкция могла быть передана в базу данных
					ResultSet rs = st.executeQuery(query)
							) 
			{ //использует инструкцию для передачи запроса в базу данных и возвращает набор результатов в переменную rs
				while(rs.next()) { //Выводим результат выполнения запроса
					list.add(rs.getString("shortName"));
					}
				}
			} catch (SQLException e) { //будет обрабатывать любые ошибки SQL времени выполнения, возникающие при выводе ошибки на консоль
				System.out.println(e);
			}
			catch (ClassNotFoundException e) {
				System.out.println(e);
			}
		return list;
	}
	public static boolean checkDataParent(String login, String passwd) {
		boolean list = false;
		try { //будет обрабатывать любые ошибки времени выполнения, которые возникают, когда класс не может быть найден в месте, указанном driver
			Class.forName(driver); //получает ссылку на класс и регистрирует его в DriverManager
			String query = "SELECT * FROM ege.Parent where login = '"+login+"' and password = '"+passwd+"';"; // содержит содержимое SQL-запроса в строковой переменной с именем query
			try(
					Connection con = DriverManager.getConnection(url, user, password); //создает соединение с базой данных, используя URL, имя пользователя и пароль
					Statement st = con.createStatement(); //берет соединение и устанавливает интерфейс так, чтобы инструкция могла быть передана в базу данных
					ResultSet rs = st.executeQuery(query)
							) 
			{ //использует инструкцию для передачи запроса в базу данных и возвращает набор результатов в переменную rs
				while(rs.next()) { //Выводим результат выполнения запроса
					list = true;
					Main.ID = Integer.parseInt(rs.getString("idParent"));
					}
				}
			} catch (SQLException e) { //будет обрабатывать любые ошибки SQL времени выполнения, возникающие при выводе ошибки на консоль
				System.out.println(e);
			}
			catch (ClassNotFoundException e) {
				System.out.println(e);
			}
		return list;
	}
	public static boolean checkDataChild(String login, String passwd) {
		boolean list = false;
		try { //будет обрабатывать любые ошибки времени выполнения, которые возникают, когда класс не может быть найден в месте, указанном driver
			Class.forName(driver); //получает ссылку на класс и регистрирует его в DriverManager
			String query = "SELECT * FROM ege.Child where login = '"+login+"' and password = '"+passwd+"';"; // содержит содержимое SQL-запроса в строковой переменной с именем query
			try(
					Connection con = DriverManager.getConnection(url, user, password); //создает соединение с базой данных, используя URL, имя пользователя и пароль
					Statement st = con.createStatement(); //берет соединение и устанавливает интерфейс так, чтобы инструкция могла быть передана в базу данных
					ResultSet rs = st.executeQuery(query)
							) 
			{ //использует инструкцию для передачи запроса в базу данных и возвращает набор результатов в переменную rs
				while(rs.next()) { //Выводим результат выполнения запроса
					list = true;
					}
				}
			} catch (SQLException e) { //будет обрабатывать любые ошибки SQL времени выполнения, возникающие при выводе ошибки на консоль
				System.out.println(e);
			}
			catch (ClassNotFoundException e) {
				System.out.println(e);
			}
		return list;
	}
	public static boolean registration(String a, String b, String c, int d, String e, String f) {
		boolean list = false;
		try { //будет обрабатывать любые ошибки времени выполнения, которые возникают, когда класс не может быть найден в месте, указанном driver
			Class.forName(driver); //получает ссылку на класс и регистрирует его в DriverManager
			String query = "INSERT into ege.parent (name, surname, lastname, age, login, password) VALUES ('"+a+"', '"+b+"', '"+c+"', '"+d+"', '"+e+"', '"+f+"');"; // содержит содержимое SQL-запроса в строковой переменной с именем query
			try {
					Connection con = DriverManager.getConnection(url, user, password); //создает соединение с базой данных, используя URL, имя пользователя и пароль
					Statement st = con.createStatement(); //берет соединение и устанавливает интерфейс так, чтобы инструкция могла быть передана в базу данных
					int rs = st.executeUpdate(query);
					list = true;
			} 
			catch (SQLException ee) { //будет обрабатывать любые ошибки SQL времени выполнения, возникающие при выводе ошибки на консоль
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
		try { //будет обрабатывать любые ошибки времени выполнения, которые возникают, когда класс не может быть найден в месте, указанном driver
			Class.forName(driver); //получает ссылку на класс и регистрирует его в DriverManager
			String query = "INSERT into ege.child (name, surname, lastname, age, classNum, Parent_idParent, login, password) VALUES ('"+a+"', '"+b+"', '"+c+"', '"+d+"', '"+cn+"','"+idp+"','"+e+"', '"+f+"');"; // содержит содержимое SQL-запроса в строковой переменной с именем query
			try {
					Connection con = DriverManager.getConnection(url, user, password); //создает соединение с базой данных, используя URL, имя пользователя и пароль
					Statement st = con.createStatement(); //берет соединение и устанавливает интерфейс так, чтобы инструкция могла быть передана в базу данных
					int rs = st.executeUpdate(query);
					list = true;
			} 
			catch (SQLException ee) { //будет обрабатывать любые ошибки SQL времени выполнения, возникающие при выводе ошибки на консоль
				System.out.println(ee);
			}
		}
		catch (Exception e1) {
			System.out.println(e1);
		}
		return list;
	}
	
	//ДОПИШИ!!!
	public static boolean addLesson(String time, String status, int idTeacher, int idCourse, String place) {
		return true;
	}
	
	public static List<String> listAllShedule() {
		List<String> list = new ArrayList<String>();
		try { //будет обрабатывать любые ошибки времени выполнения, которые возникают, когда класс не может быть найден в месте, указанном driver
			Class.forName(driver); //получает ссылку на класс и регистрирует его в DriverManager
			String query = "SELECT * FROM ege.Shedule, ege.Course where ege.Shedule.Course_idCourse = ege.Course.idCourse;"; // содержит содержимое SQL-запроса в строковой переменной с именем query
			try(
					Connection con = DriverManager.getConnection(url, user, password); //создает соединение с базой данных, используя URL, имя пользователя и пароль
					Statement st = con.createStatement(); //берет соединение и устанавливает интерфейс так, чтобы инструкция могла быть передана в базу данных
					ResultSet rs = st.executeQuery(query)
							) 
			{ //использует инструкцию для передачи запроса в базу данных и возвращает набор результатов в переменную rs
				while(rs.next()) { //Выводим результат выполнения запроса
						
						list.add(rs.getString("idShedule")+" "+rs.getString("time")+" "+rs.getString("fullName"));
					}
				}
			} catch (SQLException e) { //будет обрабатывать любые ошибки SQL времени выполнения, возникающие при выводе ошибки на консоль
				System.out.println(e);
			}
			catch (ClassNotFoundException e) {
				System.out.println(e);
			}
		return list;
	}
}




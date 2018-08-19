package ru.unlimit;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class DBService {
	 
	public static Connection getConnection() throws Exception {
		try {
			Properties prop = props();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Properties connInfo = new Properties();
			connInfo.put("user", prop.getProperty("user"));
			connInfo.put("password", prop.getProperty("password"));
			connInfo.put("charaсterEncoding",prop.getProperty("characterEncoding"));
			Connection con = DriverManager.getConnection("jdbc:mysql://"+prop.getProperty("localHost")+"/"+prop.getProperty("schemaName")+"?useSSL=false",connInfo);
			return con;
		} catch (Exception e) {
			System.out.print(e);
		}
		return null;
	}

	public static void createTable(Connection con) throws Exception {

		try {
			PreparedStatement create = con.prepareStatement(
					"CREATE TABLE IF NOT EXISTS testtaskadress(id int NOT NULL AUTO_INCREMENT, firstname varchar(255), lastname varchar(255),email varchar(255), PRIMARY KEY(id))");
			create.executeUpdate();
			create.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
		}
	}

	public static void post(Connection con, String firstname, String lastName, String email) throws Exception {

		try {
			PreparedStatement posted = con
					.prepareStatement("INSERT INTO testtaskadress (firstname, lastname,email) VALUES ('" + firstname
							+ "', '" + lastName + "', '" + email + "')");
			posted.executeUpdate();
			posted.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
		}
	}

	public static Properties props()  {
	    try {
           Properties prop = new Properties();
            String propFileName = "C:/Temp/Test_task_microfocus-master/Test_task_microfocus-master/test task microfocus/src/config.properties";
            FileInputStream inputStream = new FileInputStream(propFileName);
                       
            prop.load(inputStream);
            inputStream.close();
       
           return prop;
 
        } catch (Exception e) {
            System.out.println("Ошибка в программе: файл не обнаружен");
            e.printStackTrace();
            return null;
        }		
	}
}

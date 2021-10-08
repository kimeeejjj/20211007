package co.eunji.dbprj;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.DriverManager;

public class DataSource {  //DAO객체만들자
	private String driver; //사용할 jdbc드라이버
	private String url;		//DBMS가 위치한 주소
	private String user;	//DB에 접속할 계정
	private String password; //DB 접속계정의 패스워드
	
	public Connection conn; //java에서 DBMS연결객체
	
	public DataSource() {
		getDbproperties();	//외부 properties파일을 읽어서 내부 변수에 담음
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("DB연결성공");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("DB연결실패");
		}
	}
	
	private void getDbproperties() {
		File path = new File("src/main/resources/db.properties"); //파일을 다루는 객체
		Properties properties = new Properties();
		try {
			FileReader file = new FileReader(path);
			properties.load(file); //저장메소드 load() 
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}

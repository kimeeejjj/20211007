package co.eunji.dbprj.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.eunji.dbprj.DataSource;

public class DevServiceImpl extends DataSource {
	private PreparedStatement psmt;
	private ResultSet rs;
	
//	public List<DevVO> selectList(){
//		DevVO vo;
//		List<DevVO> list = new ArrayList<DevVO>();
//		
//		
//		return list;
//	}
	
	public void selectList() {
		String sql = "select * from dev";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); //select구문은 무조건 executeQuery()임!!!
			while(rs.next()) { //돌아온 결과가 존재하면 이걸 실행!
				System.out.print(rs.getInt("id")+" ");
				System.out.print(rs.getString("name")+" ");
				System.out.print(rs.getString("column1")+" ");
				System.out.println(rs.getInt("age"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}

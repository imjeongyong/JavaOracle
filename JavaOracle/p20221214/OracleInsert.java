import java.sql.*;

public class OracleInsert {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 1521<-데이터베이스 포트, XE<- 오라클 서비스사용자 이름, @local~ <-대신 ip 주소 대신사용가능
		String user = "c##green";
		String password = "green1234";

		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");

			Statement stmt = conn.createStatement();

			String sql = "SELECT * FROM dept"; // sql에 쿼리문 작성
			ResultSet rs = stmt.executeQuery(sql); // ResultSet select절의 결과값을 저장하는 객체
			
			while (rs.next()) {
				System.out.print(rs.getString("deptno") + " ");
				System.out.print(rs.getString("dname") + " ");
				System.out.println(rs.getString("loc") + " ");
			}
			
		} catch (ClassNotFoundException e) {
//			System.out.println("jdbc driver loading fail.");
			e.printStackTrace();
		} catch (SQLException e) {
//			System.out.println("oracle connection fail.");
			e.printStackTrace();
		}
	}
}
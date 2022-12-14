package oracleInsert;
import java.sql.*;

public class oracleInsert1 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##green";
		String password = "green1234";

		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			Statement stmt = conn.createStatement(); // 데이터베이스 접속 쿼리

			String sql0 = "SELECT MAX(DEPTNO) MaxDeptno FROM DEPT";
			ResultSet rs0 = stmt.executeQuery(sql0);
			int ideptno = 0;
			rs0.next();
			ideptno = rs0.getInt("MaxDeptno");
			ideptno +=10;
			String sdname = "IT", sloc = "SEOUL";
			String sql = "INSERT INTO dept VALUES ('" + ideptno + "','" + sdname + "','" + sloc + "')";
			boolean b = stmt.execute(sql);
			if (!b) {
				System.out.println("Insert success.\n");
			} else {
				System.out.println("Insert fail.\n");
			}

			String sq12 = "SELECT deptno, dname, loc FROM dept";
			ResultSet rs = stmt.executeQuery(sq12);
			while (rs.next()) {
				System.out.print(rs.getString("deptno") + "\t");
				System.out.print(rs.getString("dname") + "\t");
				System.out.println(rs.getString("loc") + " ");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
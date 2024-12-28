package sysDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	
	// DBに接続する際の情報を、定数で定義。
	
	private static final String URL = "jdbc:mysql://localhost:3306/bentou_kamadoya_sys_data?useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "fishBerry3939";
	
	
	// コンストラクタをprivateにして、インスタンス化を防止。
	
	private DB() {}
	
	/** データベース接続を取得する、関数を作成。
	 * @return Connection データベース接続オブジェクト
	 * @throws SQLException SQL例外
	 */
	
	
	public static Connection getDBConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("JDBCドライバの取得に失敗しました: " + e.getMessage());
			throw new SQLException("JDBCドライバの、接続に失敗しました。", e);
		}
		
		return DriverManager.getConnection(URL, USER, PASS);
	}
	
	
	/** データベース接続を閉じる、関数を作成。
	 * @param Connction 閉じる対象のConnctionオブジェクト
	 */
	
	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("接続のクローズ中に、エラーが発生しました。: " + e.getMessage());
		}
	}
	

}

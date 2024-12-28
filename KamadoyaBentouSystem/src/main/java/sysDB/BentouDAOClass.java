package sysDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bentouSysModel.BentouClass;

public class BentouDAOClass {
	
	
	/** 全ての弁当データを取得するメソッド
	 * @return BentouClass型 リスト
	 * @throws SQLException SQL例外
	 */
	
	public List<BentouClass> getAllBentous() throws SQLException {
		
		// 全ての弁当データを格納する、BentouClass型リスト。
		
		List<BentouClass> bentouList = new ArrayList<>();
		
		// SQL文
		
		String sql = "SELECT * FROM bentou_data";
		
		try (Connection connection = DB.getDBConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql);
				
			// SQL実行
				
			ResultSet rs = pstmt.executeQuery()) {
			
			// 繰り返し文で、既にあるリストに全ての要素を追加。
			
			while (rs.next()) {
				
				int id = rs.getInt("id");
				String kind = rs.getString("kind");
				String bentouName = rs.getString("bentou_name");
				int price = rs.getInt("price");
				String material = rs.getString("material");
				String optionPlus = rs.getString("option_plus");
				String img = rs.getString("img");
				
				BentouClass bentou = new BentouClass(id, kind, bentouName, price, material, optionPlus, img);
				
				bentouList.add(bentou);
				
				
			}
			
		} catch (SQLException e) {
			System.err.println("データ取得中にエラーが発生しました: " + e.getMessage());
			throw e;
		}
		
		// 繰り返し文で各データを格納した、List<BentouClass>型bentouListを返す。
		
		return bentouList;
	}
	
	
	
	
	/**
	 * 
	 * @param id 弁当のID
	 * @return BentouClass型のインスタンス
	 * @throws SQLException SQL例外
	 */
	
	
	public BentouClass getBentouById(int id) throws SQLException {
		
		BentouClass bentou2 = null;
		
		String sql = "SELECT * FROM bentou_data WHERE id = ?";
		
		
		try (Connection connection = DB.getDBConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql)) {
			
			// パラメーターにidをセットする
			
			pstmt.setInt(1, id);
			
			
			// SQL 実行
			
			try (ResultSet rs = pstmt.executeQuery()) {
				
				// 結果があれば、それぞれの値を取得。
				
				
				if (rs.next()) {
					String kind = rs.getString("kind");
					String bentouName = rs.getString("bentou_name");
					int price = rs.getInt("price");
					String material = rs.getString("material");
					String optionPlus = rs.getString("option_plus");
					String img = rs.getString("img");
					
					// 返すBentouClassのインスタンスを作成
					
					bentou2 = new BentouClass(id, kind, bentouName, price, material, optionPlus, img);
				}
				
				
				
			}
		} catch (SQLException e) {
			
			
			System.err.println("データの取得中に、エラーが発生しました。: " + e.getMessage());
			throw e;
			
		}
		
		
		
		return bentou2;
		
	}
	
	
	

}

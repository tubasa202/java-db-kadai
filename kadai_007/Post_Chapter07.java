package kadai_007;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Post_Chapter07 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		 Connection con = null;
		 PreparedStatement insertstatement = null;
		 
		 String[][] postsList = {
					{"1003", "2023-02-08", "昨日の夜は徹夜でした・・", "13"},
					{"1002", "2023-02-08", "お疲れ様です！", "12"},
					{"1003", "2023-02-09", "今日も頑張ります！", "18"},
					{"1001", "2023-02-09", "無理は禁物ですよ！", "17"},
					{"1002", "2023-02-10", "明日から連休ですね！", "20"}
			};

	     try {
	            // データベースに接続
	            con = DriverManager.getConnection(
	                "jdbc:mysql://localhost/challenge_java",
	                "root",
	                "Tubasa13171225a"
	            );
                 System.out.println("データベース接続成功：" + con );
                 
     			String createTablesql = """
    					CREATE TABLE IF NOT EXISTS posts(
    					post_id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    					user_id INT(11) NOT NULL,
    					posted_at DATE NOT NULL,
    					post_content VARCHAR(255) NOT NULL,
    					likes INT(11) DEFAULT 0
    					)
    					""";
    			Statement statement = con.createStatement();
    			statement.execute(createTablesql);
    			statement.close();

    			String sql = "INSERT INTO posts(user_id, posted_at, post_content, likes) VALUES(?, ?, ?, ?);";
    			insertstatement = con.prepareStatement(sql);
    			System.out.println("レコード追加を実行します");
    			
    			int rowCnt = 0;
    			for(String[] post : postsList) {
    				int user_id = Integer.parseInt(post[0]);
    				String posted_at = post[1];
    				String post_content = post[2];
    				int likes = Integer.parseInt(post[3]);

    				insertstatement.setInt(1, user_id);
    				insertstatement.setString(2, posted_at);
    				insertstatement.setString(3, post_content);
    				insertstatement.setInt(4, likes);

    				
    				rowCnt = insertstatement.executeUpdate();
    			}	
    			System.out.println(rowCnt*5 + "件のレコードが追加されました");
    			System.out.println("ユーザーIDが1002のレコードを検索しました");
    			String searchsql = "SELECT posted_at, post_content, likes FROM posts WHERE user_id = 1002;";
    			
    			Statement searchstatement = con.createStatement();

    			ResultSet result = searchstatement.executeQuery(searchsql);
    			while(result.next()) {
    				Date posted_at = result.getDate("posted_at");
    				String post_content = result.getString("post_content");
    				int likes = result.getInt("likes");
    				System.out.println(result.getRow() + "件目:投稿日時=" + posted_at + "/投稿内容=" + post_content + "/いいね数=" + likes);
    			}
    			searchstatement.close();

    		}catch(SQLException e) {
    			System.out.println("エラー発生:" + e.getMessage());
    		}finally {
    			if(insertstatement != null) {
    				try {insertstatement.close();}catch(SQLException ignore) {}
    			}
    			if(con != null) {
    				try {con.close();}catch(SQLException ignore) {}
    			}
    		}
    	}
    }
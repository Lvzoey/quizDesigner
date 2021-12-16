package quizdesigner;

import java.sql.*;
class db{

    public static void CreateDatabase(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/quiz_designer","root","123");
            Statement stmt=con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Quizes " +
                    "(name TEXT, " +
                    " quizInfo TEXT)";

            stmt.execute(sql);
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
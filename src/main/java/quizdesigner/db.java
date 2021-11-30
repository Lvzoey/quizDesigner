package quizdesigner;

import java.sql.*;
class MysqlCon{
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/quiz_designer","root","123");
            Statement stmt=con.createStatement();
            String sql = "CREATE TABLE question " +
                    "(id INTEGER not NULL, " +
                    " questionType TEXT, " +
                    " question TEXT, " +
                    " answer TEXT)";

            stmt.execute(sql);
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
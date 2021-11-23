package quizdesigner;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.*;


public class quizModify {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/Quiz_List";

    //  Database credentials
    static final String USER = "quiz";
    static final String PASS = "123456";


    public void create(String quizName) throws SQLException, IOException {
        //Create a new quiz
        Quiz q = new Quiz(quizName);
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //Execute a query
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();
            //TODO: Design database
            String sql = "INSERT INTO Quiz_List " +
                    "VALUES ()";
            stmt.executeUpdate(sql);
        } catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    public void delete(String quizName) {

    }

    public void read(String quizName) {

    }

    public void update(String quizName) {

    }

}

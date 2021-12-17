package quizdesigner;

import java.io.*;
import java.nio.file.Files;
import java.sql.*;
import java.util.*;

import com.google.gson.*;

public class test {
    public static byte[] saveObjToByteFile(Quiz a) {
        try {
            byte[] std;
            ByteArrayOutputStream byt = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byt);
            oos.writeObject(a);
            std = byt.toByteArray();
            oos.close();
            return std;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Quiz getObjFromByteFile(byte[] std) {
        try {
            ByteArrayInputStream byteInt = new ByteArrayInputStream(std);
            ObjectInputStream objInt = new ObjectInputStream(byteInt);
            Quiz q = (Quiz) objInt.readObject();
            return q;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection DbConnect() {
        Connection conn;
        PreparedStatement pres;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库加载成功!!!");
            String url = "jdbc:mysql://localhost:3306/quiz_designer";
            String user = "root";
            String password = "1";

            conn = DriverManager.getConnection(url, user, password); //建立连接
            System.out.println("数据库连接成功!!!");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void DbCreateTable(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Quiz " +
                    "(name TEXT, " + "quiz BLOB)";
            stmt.execute(sql);
        } catch (Exception e) {

        }
    }

    public static void DbSaveByteFile(Connection conn, byte[] std) {
        try {
            PreparedStatement preps;
            preps = conn.prepareStatement("INSERT INTO Quiz (name, quiz) values (?, ?)");
            preps.setString(1, "demo1");
            preps.setBytes(2, std);
            preps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static byte[] DbGetByteFile(Connection conn) {
        try {
            byte[] std;
            ResultSet rs;
            PreparedStatement preps;
            preps = conn.prepareStatement("select quiz from Quiz where name = ?");
            preps.setString(1, "demo1");
            rs = preps.executeQuery();
            if (rs.next()) {
                std = rs.getBytes(1);
                return std;
            }
            return null;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }


    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Quiz demo1 = new Quiz("demo1");
        Questions q = new TrueFalseQuestions("ak", "0");
        demo1.Qs.add(q);

        Connection conn = DbConnect();
        DbCreateTable(conn);

        byte[] demo1_byte_file = saveObjToByteFile(demo1);
        DbSaveByteFile(conn, demo1_byte_file);

        byte[] demo1_byte_file_from_db = DbGetByteFile(conn);
        Quiz b = getObjFromByteFile(demo1_byte_file_from_db);
        System.out.println(b.Qs.get(0));
    }

}

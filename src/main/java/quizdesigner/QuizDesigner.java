package quizdesigner;

import java.io.*;
import java.util.*;
import java.sql.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;

public class QuizDesigner {
    List<String> names = new ArrayList<>();

    //Initialize the user input to let the user create, update and read the quizes
    private void UserInput() throws IOException, SQLException {
        boolean flag = true;
        while (flag) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = null;
            String user_input = null;
            System.out.println("Enter:");
            System.out.println("1: Create A Quiz");
            System.out.println("2: Update A Quiz");
            System.out.println("3: Read A Quiz");
            System.out.println("Enter: Quit");

            str = br.readLine();
            if (str.equals("")) {
                flag = false;
            }else{
                user_input = str;
            }

            switch (user_input) {
                case "1":
                    Create_A_Quiz();
                    break;
                case "2":
                    Update_A_Quiz();
                    break;
                case "3":
                    Read_A_Quiz();
                    break;
                case "Quit":
                    flag = false;
                    break;
                default:
                    System.out.println("Please Enter Again");
                    break;
            }

        }
    }

    private void Create_A_Quiz() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        System.out.println("Enter the quiz name:");
        str = br.readLine();
        Quiz q = new Quiz(str);
        q.UserInput();
        System.out.println("Do you want to save the quiz(y/n)?");
        str = br.readLine();
        if (str.equals("y")  || str.equals("yes")){
            save(q);
            names.add(q.quizName);
            System.out.println("quiz saved");
        } else {
            System.out.println("quiz not saved");
        }
    }

    private void Update_A_Quiz() throws IOException, SQLException {
        System.out.println("Enter the quiz name(not ID) you want to update from following");
        print_current_quizes();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        update(str);
    }

    private void Read_A_Quiz() throws IOException, SQLException{
        System.out.println("Enter the quiz name(not ID) you want to read from following");
        print_current_quizes();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        read(str);
    }

    private void print_current_quizes() throws IOException{
        try {
            Connection conn = DbConnect();
            PreparedStatement preps;
            preps = conn.prepareStatement("SELECT * FROM Quiz");
            ResultSet rs = preps.executeQuery();
            int i = 1;
            while (rs.next()){
                System.out.print(i++);
                System.out.print(". ");
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //helper function for the Create_A_Quiz function
    private void save(Quiz q) throws IOException{
        try
        {
            Connection conn = DbConnect();
            DbCreateTable(conn);
            byte[] demo1_byte_file = saveObjToByteFile(q);
            DbSaveByteFile(conn, demo1_byte_file, q.quizName);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    //helper function for the Update_A_Quiz function
    private void update(String name) throws IOException, SQLException {
        try
        {

            Connection conn = DbConnect();
            byte[] demo1_byte_file_from_db = DbGetByteFile(conn, name);
            Quiz b = getObjFromByteFile(demo1_byte_file_from_db);
            b.UserInput();
            byte[] std = saveObjToByteFile(b);
            System.out.println("Do you want to update the quiz(y/n)?");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = null;
            str = br.readLine();
            if (str.equals("y")  || str.equals("yes")){
                DbUpdateByteFile(conn, std, name);
                System.out.println("quiz updated");
            } else {
                System.out.println("quiz not updated");
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    //helper function for the Read_A_Quiz function
    public void read(String name) throws IOException, SQLException {
        try
        {
            Connection conn = DbConnect();
            byte[] demo1_byte_file_from_db = DbGetByteFile(conn, name);
            Quiz b = getObjFromByteFile(demo1_byte_file_from_db);
            for (int i = 0; i < b.Qs.size(); i++){
                System.out.println(b.Qs.get(i));
                System.out.println("\n");
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

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
    //The database connection
    public static Connection DbConnect() {
        Connection conn;
        PreparedStatement pres;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/quiz_designer";
            String user = "root";
            String password = "123";
            conn = DriverManager.getConnection(url, user, password); //建立连接
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

    public static void DbSaveByteFile(Connection conn, byte[] std, String name) {
        try {
            PreparedStatement preps;
            preps = conn.prepareStatement("INSERT INTO Quiz (name, quiz) values (?, ?)");
            preps.setString(1, name);
            preps.setBytes(2, std);
            preps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void DbUpdateByteFile(Connection conn, byte[] std, String name){
        try {
            PreparedStatement preps;
            preps = conn.prepareStatement("UPDATE Quiz SET quiz = ? WHERE name = ?");
            preps.setBytes(1, std);
            preps.setString(2, name);
            preps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static byte[] DbGetByteFile(Connection conn, String name) {
        try {
            byte[] std;
            ResultSet rs;
            PreparedStatement preps;
            preps = conn.prepareStatement("select quiz from Quiz where name = ?");
            preps.setString(1, name);
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

    public static void main(String[] args) throws IOException, SQLException {
        QuizDesigner a = new QuizDesigner();
        a.UserInput();
    }
}

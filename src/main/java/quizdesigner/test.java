package quizdesigner;

import java.io.*;
import java.nio.file.Files;
import java.sql.*;
import java.util.*;
import com.google.gson.*;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        String file_name = "C:\\Users\\123\\Desktop\\object.txt";
        String file1_name = "C:\\Users\\123\\Desktop\\Bull_Shit_object.txt";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test","root","123");
            Statement stmt=con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Quizes " +
                    "(name TEXT, " +
                    " quizInfo TEXT)";

            stmt.execute(sql);
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file_name))) {
            Quiz a = new Quiz("q_name");
            Questions q = new TrueFalseQuestions("tf", "0");
            a.Qs.add(q);
            oos.writeObject(a);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            File file = new File(file_name);
            InputStreamReader rd = new InputStreamReader(new FileInputStream(file), "gbk");
            BufferedReader br = new BufferedReader(rd);
            String line = "";
            line = br.readLine();
            StringBuffer ss = new StringBuffer();
            while (line != null) {
                line = br.readLine();
                ss.append(line);
            }
            String db_input = ss.toString();
            PreparedStatement preps;
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test","root","123");
            preps = con.prepareStatement("insert into Quizes (name, quizInfo) values (?, ?)");
            preps.setString(1, "test1");
            preps.setString(2, db_input);
            preps.execute();
        }catch (Exception e){

        }

        try{
            PreparedStatement preps;
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test","root","123");
            preps = con.prepareStatement("select quizInfo from Quizes where name = ?");
            preps.setString(1, "test1");
            ResultSet rs = preps.executeQuery();
            String deserializeStr = "";
            if (rs.next()){
                deserializeStr = rs.getString("quizInfo");
            }

            File writename = new File(file1_name);
//            writename.createNewFile();
            BufferedWriter out = new BufferedWriter((new FileWriter(writename)));
            out.write(deserializeStr);
            out.flush();
            out.close();
        } catch(Exception e){

        }

        try(ObjectInputStream oos = new ObjectInputStream(new FileInputStream(file1_name))){
            Quiz b = (Quiz) oos.readObject();
            System.out.println("s");
        }



    }

}

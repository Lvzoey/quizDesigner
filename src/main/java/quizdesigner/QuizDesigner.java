package quizdesigner;

import java.io.*;
import java.util.*;
import java.sql.*;
import com.google.gson.*;

public class QuizDesigner {
    List<String> names = new ArrayList<>();
    private void UserInput() throws IOException, SQLException {
        boolean flag = true;
        while (flag) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = null;
            String user_input = null;
            print_current_quizes();
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
//        q.UserInput();
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

    private void Update_A_Quiz() throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = null;
//        print_current_quizes();
//        System.out.println("which one do you want to update");
//        str = br.readLine();
//        int idx = Integer.parseInt(str) - 1;
//        Questions q = Qs.get(idx);
//        System.out.println(q);
    }

    private void Read_A_Quiz() throws IOException, SQLException{
        System.out.println("Enter the quiz name you want to read");
        print_current_quizes();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        read(str);
    }

    private void print_current_quizes() throws IOException{
        for (int i = 0; i < names.size(); i++){
            System.out.println("Quiz " + (i + 1) + ": " + names.get(i));
        }
    }

    private void save(Quiz q) throws IOException{
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/quiz_designer","root","123");
            PreparedStatement preps;
            Gson gson = new Gson();
            String curQuiz = gson.toJson(q);
            System.out.println(curQuiz);
            preps = con.prepareStatement("insert into Quizes (name, quizInfo) values (?, ?)");
            preps.setString(1, q.quizName);
            preps.setString(2, curQuiz);
            preps.execute();
        }catch(ClassNotFoundException | SQLException i)
        {
            i.printStackTrace();
        }
    }
    private void read(String name) throws IOException, SQLException {
        ResultSet rs = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/quiz_designer","root","123");
            PreparedStatement preps;
            preps = con.prepareStatement("select quizInfo from Quizes where name = ?");
            preps.setString(1, name);
            rs = preps.executeQuery();
        }catch(ClassNotFoundException | SQLException i)
        {
            i.printStackTrace();
        }
        if (rs.next()){
            Gson gson = new Gson();
            String jsonInString = rs.getString(1);
            Quiz q = gson.fromJson(jsonInString, Quiz.class);
            System.out.println(q.getName() + q.Qs.get(0).getName());

            q.UserInput();
        }
    }

    public static void main(String[] args) throws IOException, SQLException {
        db.CreateDatabase();
        QuizDesigner a = new QuizDesigner();
        a.UserInput();
    }
}

package quizdesigner;
import java.io.*;
import java.util.*;

public class Quiz {

    String name;
    List<Questions> Qs = new ArrayList<>();
    public Quiz(String name) throws IOException {
        this.name = name;
        UserInput();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void UserInput() throws IOException {
        boolean flag = true;
        while (flag) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = null;
            String user_input;
            System.out.println("Enter:");
            System.out.println("1: Create A Question");
            System.out.println("2: Delete A Question");
            System.out.println("3: Update A Question");
            System.out.println("4: Read A Question");
            System.out.println("Enter: Quit");

            str = br.readLine();
            if (str.equals("")) {
                flag = false;
            }else{
                user_input = str;
            }

            switch (str) {
                case "1":
                    Create_A_Question();
                    break;
                case "2":
                    Delete_A_Question();
                    break;
                case "3":
                    Update_A_Question();
                    break;
                case "4":
                    Read_A_Question();
                    break;
                default:
                    System.out.println("Please Enter Again");
                    break;
            }

        }
    }

    private void Create_A_Question() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        System.out.println("Enter:");
        System.out.println("1: True And False");
        System.out.println("2: Multiple Choice");
        System.out.println("3: Text Questions");
        System.out.println("4: Matching Questions");
        System.out.println("5: Fill Blank");
        str = br.readLine();
        switch (str) {
            case "1":
                BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                String Q = null;
                String A = null;
                System.out.println("Enter Your Question: ");
                Q = br1.readLine();
                System.out.println("Enter Your Answer: ");
                A = br1.readLine();

                Questions Q1 = new TrueFalseQuestions(Q, A);
                Qs.add(Q1);

                break;

            default:
                System.out.println("Please Enter Again");
                break;
        }
    }

    private void Delete_A_Question() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        System.out.println("You have " + Qs.size() + " in the quiz, which one do you want to delete");
        //TODO
        System.out.println("Maybe show the questions here ???");

        str = br.readLine();
        int idx = Integer.parseInt(str);
        Qs.remove(idx);
        System.out.println("Question deleted. " + Qs.size() + " left in the quiz");
    }

    private void Update_A_Question() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        System.out.println("You have " + Qs.size() + " in the quiz, which one do you want to update");
        //TODO
        System.out.println("Maybe show the questions here ???");

        str = br.readLine();
        int idx = Integer.parseInt(str);
        //TODO 怎么拿到具体question的类型？？
        Questions q = Qs.get(idx);
        q.set();
        //TODO blah blah
        System.out.println("Question updated. ");
    }


    private void Read_A_Question() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        System.out.println("You have " + Qs.size() + " in the quiz, which one do you want to read");
        //TODO
        System.out.println("Maybe show the questions here ???");

        str = br.readLine();
        int idx = Integer.parseInt(str);
        //TODO 怎么拿到具体question的类型？？
        Questions q = Qs.get(idx);
        q.get();
        //TODO show

    }
}


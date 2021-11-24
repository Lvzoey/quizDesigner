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
            String user_input = null;
            print_current_questions();
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

            switch (user_input) {
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
        String Q = null;
        String A = null;
        String Correct = null;
        switch (str) {
            case "1":
                System.out.println("Enter Your Question: ");
                Q = br.readLine();
                System.out.println("Enter Your Answer: 0 for False, 1 for True");
                A = br.readLine();
                Questions Q1 = new TrueFalseQuestions(Q, A);
                Qs.add(Q1);
                break;

            case "2":
                List<String> Multiple_As = new ArrayList<>();
                System.out.println("Enter Your Question: ");
                Q = br.readLine();
                int i=0;
                while (true) {
                    System.out.println("Enter Your Answer " + String.valueOf((char)(i+65)) + " or Press Enter To Quit");
                    i+=1;
                    A = br.readLine();
                    if (A.equals("")) {
                        break;
                    }
                    System.out.println("Is It The Correct One? 0 For False, 1 For True");
                    Correct = br.readLine();
                    Multiple_As.add(A + "|" + Correct);
                }
                Questions Q2 = new MultipleQuestions(Q, Multiple_As);
                Qs.add(Q2);
                break;

            case "3":
                System.out.println("Enter Your Question: ");
                Q = br.readLine();
                Questions Q3 = new TextQuestions(Q);
                Qs.add(Q3);
                break;

            case "4":
                List<String> Matching_Qs = new ArrayList<>();
                List<String> Matching_As = new ArrayList<>();
                while (true) {
                    System.out.println("Enter Your Question or Press Enter To Quit: ");
                    Q = br.readLine();
                    if (Q.equals("")) {
                        break;
                    } else {
                        Matching_Qs.add(Q);
                    }
                    System.out.println("Enter Your Answer For This Question: ");
                    A = br.readLine();
                    if (A.equals("")) {
                        System.out.println("Please Enter Your Answer For This Question: ");
                        A = br.readLine();
                        Matching_As.add(A);
                    } else {
                        Matching_As.add(A);
                    }
                }
                Questions Q4 = new MatchingQuestions(Matching_Qs, Matching_As);
                Qs.add(Q4);
                break;

            case "5":
                System.out.println("Enter Your Question and use $ for blank: ");
                Q = br.readLine();
                System.out.println("Enter Your Answer");
                A = br.readLine();
                Questions Q5 = new FillBlankQuestions(Q, A);
                Qs.add(Q5);
                break;
            default:
                System.out.println("Please Enter Again");
                break;
        }
    }

    private void Delete_A_Question() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        print_current_questions();

        str = br.readLine();
        int idx = Integer.parseInt(str) - 1;
        System.out.println("Is this question you want to delete?");
        System.out.println(Qs.get(idx));
        System.out.println("Enter y/n:");
        str = br.readLine().toLowerCase(Locale.ROOT);
        if (str.equals("y") || str.equals("yes")) {
            Qs.remove(idx);
            System.out.println("Question deleted. " + Qs.size() + " left in the quiz");
        } else {
            System.out.println("No Question deleted. " + Qs.size() + " left in the quiz");
        }
    }

    private void Update_A_Question() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        print_current_questions();

        str = br.readLine();
        int idx = Integer.parseInt(str) - 1;
        Questions q = Qs.get(idx);
        System.out.println("Old Question:");
        System.out.println(q);

        System.out.println("Update question: (Press Enter for no editing)");
        str = br.readLine();
        if (!str.equals("")) {
            q.setQuestion(str);
        }

        System.out.println("Update answer: (Press Enter for no editing)");
        if (!str.equals("")) {
            q.setAnswer(str);
        }

        System.out.println("Question updated. ");
        System.out.println(q);
    }

    private void Read_A_Question() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        System.out.println("You have " + Qs.size() + " in the quiz, which one do you want to read");

        str = br.readLine();
        int idx = Integer.parseInt(str) - 1;
        Questions q = Qs.get(idx);
        System.out.println(q);
    }

    private void print_current_questions() {
        System.out.println("==========================================================================================");
        System.out.println("You have " + Qs.size() + " Questions now:");
        for (int i=0; i < Qs.size(); i++) {
            System.out.println("Question " + (i+1) + " " + Qs.get(i).getName());
        }
        System.out.println("==========================================================================================");
    }

    public static void main(String[] args) throws IOException{
        Quiz a = new Quiz("week");
        a.UserInput();
    }


}


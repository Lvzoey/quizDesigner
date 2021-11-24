package quizdesigner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MatchingQuestions extends Questions {
    Question question;
    Answer answer;
    String name = "Match Question";

    public MatchingQuestions(List<String> question, List<String> answer) {
        this.question = new Question(question);
        this.answer = new Answer(answer);
    }

    @Override
    public Answer getAnswer() {
        return this.answer;
    }

    @Override
    public Question getQuestion() {
        return this.question;
    }

    @Override
    public void setAnswer(List<String> answer) {
        this.answer = new Answer(answer);
    }

    @Override
    public void setQuestion(List<String> question) {
        this.question = new Question(question);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        int max_len = 100;
        String s = "";
        for (int i = 0; i < this.question.List_question.size(); i++) {
            String q = (i + 1) + " Question: " + this.question.List_question.get(i);
            String a = "Answer: " + this.answer.List_answer.get(i);
            int len = q.length();
            int mid_blank_len = max_len - len;
            s += q + " ".repeat(mid_blank_len) + a + "\n";
        }
        return s;
    }

    @Override
    public void update() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        String Q = null;
        String A = null;
        System.out.println("Old Question:");
        System.out.println(this);

        while (true) {
            System.out.println("Update a question (Enter U) or Add a new one (Enter A) or Press Enter To Quit:");
            Q = br.readLine();
            if (Q.equals("")) {
                break;
            } else if (Q.equals("U")) {
                System.out.println("Which one do you want to update?");
                str = br.readLine();
                int idx = Integer.parseInt(str) - 1;
                System.out.println("Enter Your Question or Press Enter To Quit: ");
                Q = br.readLine();
                if (Q.equals("")) {
                    break;
                } else {
                    this.question.List_question.set(idx, Q);
                }
                System.out.println("Enter Your Answer or Press Enter To Quit: ");
                A = br.readLine();
                if (A.equals("")) {
                    break;
                } else {
                    this.answer.List_answer.set(idx, Q);
                }
            } else if (Q.equals("A")) {
                System.out.println("Enter Your Question or Press Enter To Quit: ");
                Q = br.readLine();
                if (Q.equals("")) {
                    break;
                } else {
                    this.question.List_question.add(Q);
                }
                System.out.println("Enter Your Answer");
                A = br.readLine();
                this.answer.List_answer.add(Q);

            }


            System.out.println("Updated Question:");
            System.out.println(this);
        }
    }

//    public static void main(String[] args) {
//        List<String> q = new ArrayList<>();
//        q.add("A");
//        q.add("BBB");
//        q.add("CC");
//        q.add("DDDDDD");
//        List<String> a = new ArrayList<>();
//        a.add("aaa");
//        a.add("b");
//        a.add("ccccc");
//        a.add("dd");
//        MatchingQuestions ac = new MatchingQuestions(q, a);
//        System.out.println(ac);
//    }

}

package quizdesigner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class MultipleQuestions extends Questions {
    Answer answer;
    Question question;
    String name = "Multiple Choice";

    public MultipleQuestions(String question, List<String> answer) {
        this.question = new Question(question);
        List<String> convered_answer = new ArrayList<>();
        for (String s : answer) {
            String[] answer_correct = s.split("\\|");

            if (answer_correct[1].equals("0")) {
                convered_answer.add(answer_correct[0] + "|" + "False");
            } else if (answer_correct[1].equals("1")) {
                convered_answer.add(answer_correct[0] + "|" + "True");
            }
        }
        this.answer = new Answer(convered_answer);
    }

    @Override
    public Answer getAnswer() {
        return answer;
    }

    @Override
    public Question getQuestion() {
        return question;
    }

    @Override
    public void setAnswer(List<String> answer) {
        this.answer = new Answer(answer);
    }

    @Override
    public void setQuestion(String question) {
        this.question = new Question(question);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        int max_len = 50;

        String s = "Question : ";
        String q = this.question.String_question;
        s += q + "\n";

        for (int i = 0; i < this.answer.List_answer.size(); i++) {
            String a = this.answer.List_answer.get(i);
            String[] answer_correct = a.split("\\|");
            int len = max_len - answer_correct[0].length();
            s += String.valueOf((char) (i + 65)) + ": " + answer_correct[0] + " ".repeat(len) + answer_correct[1] + "\n";
        }
        return s;
    }

    public void update() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        String Q = null;
        String A = null;
        String Correct = null;
        System.out.println("Old Question:");
        System.out.println(this);

        while (true) {
            System.out.println("Update a question? (y/n) or Press Enter to quit");
            Q = br.readLine();
            if (Q.equals("")) {
                break;
            } else if (Q.equals("y")) {
                System.out.println("Enter Your Question or Press Enter To Quit: ");
                Q = br.readLine();
                if (Q.equals("")) {
                    break;
                } else {
                    this.question.String_question = Q;
                }
            } else if (Q.equals("n")) {
                System.out.println("Update a Choice? (C) or Add a Choice (A) or Press Enter to quit");
                Q = br.readLine();
                if (Q.equals("")) {
                    break;
                } else if (Q.equals("C")) {
                    System.out.println("Which one do you want to update");
                    str = br.readLine();
                    int idx = (int)str.charAt(0)- 65;
                    System.out.println("Enter Your Answer " + String.valueOf((char) (idx + 65)));
                    A = br.readLine();
                    System.out.println("Is It The Correct One? 0 For False, 1 For True");
                    Correct = br.readLine();

                    if (Correct.equals("0")) {
                        Correct = "False";
                    } else if (Correct.equals("1")) {
                        Correct = "True";
                    }

                    this.answer.List_answer.set(idx, A + "|" + Correct);
                } else if (Q.equals("A")) {
                    System.out.println("Enter Your Answer " + String.valueOf((char) (this.answer.List_answer.size() + 65)));
                    A = br.readLine();
                    System.out.println("Is It The Correct One? 0 For False, 1 For True");
                    Correct = br.readLine();
                    if (Correct.equals("0")) {
                        Correct = "False";
                    } else if (Correct.equals("1")) {
                        Correct = "True";
                    }
                    this.answer.List_answer.add(A + "|" + Correct);
                }
            }
            System.out.println("Updated Question:");
            System.out.println(this);
        }
    }

    public static void main(String[] args) {
        String q = "asdfasfasdfasdfasdfadf";

        List<String> a = new ArrayList<>();
        a.add("aaa|1");
        a.add("b|0");
        a.add("ccccc|0");
        a.add("dd|0");
        MultipleQuestions ac = new MultipleQuestions(q, a);
        System.out.println(ac);
    }
}
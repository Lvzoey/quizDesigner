package quizdesigner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Locale;

public class TrueFalseQuestions extends Questions implements Serializable {
    Answer answer;
    Question question;
    String name = "True and False Question";

    public TrueFalseQuestions(String question, String answer) {

        if (answer.equals("0")) {
            answer = "False";
        } else if (answer.equals("1")) {
            answer = "True";
        }

        this.answer = new Answer(answer);
        this.question = new Question(question);
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
    public void setAnswer(String answer) {
        if (answer.equals("0")) {
            answer = "False";
        } else if (answer.equals("1")) {
            answer = "True";
        }
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

    public String toString() {
        String s = "Question: \n" + this.question.String_question + "\n" + "Answer:" + "\n" + this.answer.String_answer;
        return s;
    }

    @Override
    public void update() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;

        System.out.println("Old Question:");
        System.out.println(this);

        System.out.println("Update Question(Q) or Update Answer(A) or Press Enter for no editing)");
        str = br.readLine().toUpperCase();
        if (str.equals("")) {
            return;
        } else if (str.equals("Q")) {
            System.out.println("Enter Your Question");
            str = br.readLine();
            if (!str.equals("")) {
                this.setQuestion(str);
            }
            System.out.println("Do you want to update Your Answer? (y/n)");
            str = br.readLine();
            if (str.equals("y")) {
                System.out.println("Enter Your Answer: 0 for False, 1 for True");
                str = br.readLine();
                this.setAnswer(str);
            }
        } else if (str.equals("A")) {
            System.out.println("Enter Your Answer: 0 for False, 1 for True");
            str = br.readLine();
            this.setAnswer(str);
        }


        System.out.println("Question updated. ");
        System.out.println(this);
    }

}

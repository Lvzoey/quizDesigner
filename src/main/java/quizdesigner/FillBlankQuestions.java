package quizdesigner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillBlankQuestions extends Questions {
    Question question;
    Answer answer;
    String name = "Fill Blank Question";

    public FillBlankQuestions(String question, String answer) {
        this.question = new Question(question);
        this.answer = new Answer(answer);
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
        String s = this.question.String_question.replace("$", "______") + "\nAnswer: " + this.answer.String_answer;
        return s;
    }

    @Override
    public void update() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;

        System.out.println("Old Question:");
        System.out.println(this);

        System.out.println("Update Question(Q) or Update Answer(A) or Press Enter for no editing)");
        str = br.readLine();
        if (str.equals("Q")) {
            System.out.println("Enter Your Question and use $ for blank: ");
            str = br.readLine();
            this.setQuestion(str);
            System.out.println("Do you want update your answer? (y/n)");
            str = br.readLine();
            if (str.equals("y")) {
                System.out.println("Update answer: (Press Enter for no editing)");
                str = br.readLine();
                this.setAnswer(str);
            }
        } else if (str.equals("A")) {
            System.out.println("Update answer: (Press Enter for no editing)");
            str = br.readLine();
            this.setAnswer(str);
        }


        System.out.println("Question updated. ");
        System.out.println(this);
    }

}

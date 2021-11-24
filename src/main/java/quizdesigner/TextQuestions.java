package quizdesigner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextQuestions extends Questions {
    Question question;
    String name = "Text Question";

    public TextQuestions(String question) {
        this.question = new Question(question);
    }

    @Override
    public Question getQuestion() {
        return question;
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
        String s = "Questions: \n" + this.question.String_question;
        return s;
    }

    @Override
    public void update() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;

        System.out.println("Old Question:");
        System.out.println(this);

        System.out.println("Update Question or Press Enter for no editing)");
        System.out.println("Enter Your Question");
        str = br.readLine();
        if (!str.equals("")) {
            this.setQuestion(str);
        }

        System.out.println("Question updated. ");
        System.out.println(this);
    }
}

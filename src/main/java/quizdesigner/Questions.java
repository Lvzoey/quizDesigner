package quizdesigner;

import org.springframework.boot.context.properties.bind.Name;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Questions implements Serializable {
    String Qname;

    public Question getQuestion() {
        return new Question();
    }

    public Answer getAnswer() {
        return new Answer();
    }

    public void setQuestion(List<String> question) {
    }

    public void setQuestion(String question) {
    }

    public void setAnswer(List<String> answer) {
    }

    public void setAnswer(String answer) {
    }

    public String getName() {
        return this.Qname;
    }

    public void update() throws IOException {
    }
}

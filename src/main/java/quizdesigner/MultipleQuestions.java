package quizdesigner;

import java.util.*;
public class MultipleQuestions extends Questions{
    List<String> answer;
    private List<String> question = new ArrayList<>();
    public MultipleQuestions(List<String> question, List<String> answer){
        this.question = question;
        this.answer = answer;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public List<String> getQuestion() {
        return question;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }

    public void setQuestion(List<String> question) {
        this.question = question;
    }

}
package quizdesigner;

import java.util.*;
public class MultipleQuestions extends Questions{
    String name;
    int answer;
    int numQuestion;
    List<String> questions = new ArrayList<>();
    public MultipleQuestions(String name, int numQuestion, List<String> questions, int answer){
        this.name = name;
        this.numQuestion = numQuestion;
        this.questions = questions;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public int getAnswer() {
        return answer;
    }

    public int getNumQuestion() {
        return numQuestion;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumQuestion(int numQuestion) {
        this.numQuestion = numQuestion;
    }

}
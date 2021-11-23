package quizdesigner;

import java.util.*;
public class MultipleQuestions extends Questions{
    int answer;
    int numQuestion;
    List<String> questions = new ArrayList<>();
    public MultipleQuestions(int numQuestion, List<String> questions, int answer){
        this.numQuestion = numQuestion;
        this.questions = questions;
        this.answer = answer;
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

    public void setNumQuestion(int numQuestion) {
        this.numQuestion = numQuestion;
    }

}
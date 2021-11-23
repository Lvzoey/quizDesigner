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


}
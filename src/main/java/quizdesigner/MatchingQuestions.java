package quizdesigner;

import java.util.*;
public class MatchingQuestions extends Questions{
    List<String> question;
    List<String> matchingAnswers;


    public MatchingQuestions(List<String> questions, List<String> matchingAnswers){
        this.question = question;
        this.matchingAnswers = matchingAnswers;
    }

    public List<String> getMatchingAnswers() {
        return matchingAnswers;
    }

    public List<String> getQuestion() {
        return question;
    }

    public void setMatchingAnswers(List<String> matchingAnswers) {
        this.matchingAnswers = matchingAnswers;
    }

    public void setQuestion(List<String> question) {
        this.question = question;
    }
}

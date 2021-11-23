import java.util.*;
public class MatchingQuestions extends Questions{
    List<String> questions;
    List<String> matchingAnswers;

    // The index means the number of questions, the value means the number of matching answers
    List<Integer> answer;

    public MatchingQuestions(List<String> questions, List<String> matchingAnswers, List<Integer> answer){
        this.questions = questions;
        this.matchingAnswers = matchingAnswers;
        this.answer = answer;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public List<String> getMatchingAnswers() {
        return matchingAnswers;
    }

    public List<String> getQuestions() {
        return questions;
    }
}

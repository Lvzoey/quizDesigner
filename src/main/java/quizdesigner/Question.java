package quizdesigner;
import java.util.*;
public class Question {
    public Question(){
    }

    public List<String> getMultipleQuestion(Enum questionType){
        return MultipleQuestions.getQuestions();
    }
}

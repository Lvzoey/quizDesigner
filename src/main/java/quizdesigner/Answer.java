package quizdesigner;

import java.util.List;

public class Answer {
    String String_answer=null;
    List<String> List_answer=null;

    public Answer() {}
    public Answer(String answer){
        this.String_answer = answer;
    }
    public Answer(List<String> answer){
        this.List_answer = answer;
    }
}

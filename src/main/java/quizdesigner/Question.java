package quizdesigner;
import java.util.*;
public class Question {

    String String_question=null;
    List<String> List_question=null;

    public Question() {}

    public Question(String question){
        this.String_question = question;
    }
    public Question(List<String> question){
        this.List_question = question;
    }

}

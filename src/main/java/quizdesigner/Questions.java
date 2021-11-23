package quizdesigner;
import org.springframework.boot.context.properties.bind.Name;

import java.util.*;
public class Questions {


    public Question getQuestion(Enum questionType){
        return Question.get(questionType);
    }

    public Answer getAnswer(){
        return new Answer();
    }

    public void setQuestion(){

    }

    public void setAnswer(){

    }
}

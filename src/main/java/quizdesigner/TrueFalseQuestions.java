package quizdesigner;

public class TrueFalseQuestions extends Questions{
    boolean answer;
    String question;
    public TrueFalseQuestions(boolean answer, String question){
        this.answer = answer;
        this.question = question;
    }

    public boolean getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }


    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}

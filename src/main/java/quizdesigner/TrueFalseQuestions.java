package quizdesigner;

public class TrueFalseQuestions extends Questions{
    String answer;
    String question;
    public TrueFalseQuestions( String question, String answer){
        this.answer = answer;
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }


    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

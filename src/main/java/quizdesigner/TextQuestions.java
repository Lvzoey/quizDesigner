package quizdesigner;

public class TextQuestions extends Questions{
    String question;
    public TextQuestions(String question){
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}

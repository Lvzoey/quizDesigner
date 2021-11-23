package quizdesigner;

public class TextQuestions extends Questions{
    String name;
    String question;
    public TextQuestions(String name, String question){
        this.name = name;
        this.question = question;
    }

    public String getName() {
        return name;
    }

    public String getQuestion() {
        return question;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}

package quizdesigner;

public class FillBlankQuestions extends Questions{
    String name;
    String question;
    String answer;
    public FillBlankQuestions(String name, String question, String answer){
        this.name = name;
        this.question = question;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}

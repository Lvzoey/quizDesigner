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
}

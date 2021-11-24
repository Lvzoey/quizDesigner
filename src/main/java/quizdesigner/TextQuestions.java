package quizdesigner;

public class TextQuestions extends Questions{
    Question question;
    String name = "Text Question";

    public TextQuestions(String question){
        this.question = new Question(question);
    }

    @Override
    public Question getQuestion() {
        return question;
    }

    @Override
    public void setQuestion(String question) {
        this.question = new Question(question);
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        String s = "Questions: \n" + this.question.String_question;
        return s;
    }
}

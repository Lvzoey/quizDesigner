public class TrueFalseQuestions extends Questions{
    String name;
    boolean answer;
    String question;
    public TrueFalseQuestions(String name, boolean answer, String question){
        this.name = name;
        this.answer = answer;
        this.question = question;
    }

    public String getName() {
        return name;
    }

    public boolean getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }


}

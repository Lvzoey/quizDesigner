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

}

package quizdesigner;

public class FillBlankQuestions extends Questions {
    Question question;
    Answer answer;
    String name = "Fill Blank Question";

    public FillBlankQuestions(String question, String answer) {
        this.question = new Question(question);
        this.answer = new Answer(answer);
    }

    @Override
    public Answer getAnswer() {
        return answer;
    }

    @Override
    public Question getQuestion() {
        return question;
    }

    @Override
    public void setAnswer(String answer) {
        this.answer = new Answer(answer);
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
        String s = this.question.String_question.replace("$", "______") + "\nAnswer: " + this.answer.String_answer;
        return s;
    }

//    public static void main(String[] args) {
//        FillBlankQuestions a = new FillBlankQuestions("adasfasdf $ asdf asdf asdf", "asdfa");
//        System.out.println(a);
//    }
}

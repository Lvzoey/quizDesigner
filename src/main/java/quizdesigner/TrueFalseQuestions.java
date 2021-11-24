package quizdesigner;

public class TrueFalseQuestions extends Questions{
    Answer answer;
    Question question;
    String name = "True and False Question";

    public TrueFalseQuestions(String question, String answer){

        if (answer == "0") {
            answer = "False";
        } else if (answer == "1") {
            answer = "True";
        }

        this.answer = new Answer(answer);
        this.question = new Question(question);
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
    public String toString() {
        String s = "Question: \n" + this.question.String_question + "\n" + "Answer:" + "\n" +  this.answer.String_answer;
        return s;
    }
}

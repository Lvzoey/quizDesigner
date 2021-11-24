package quizdesigner;

import java.util.*;
public class MatchingQuestions extends Questions{
    Question question;
    Answer answer;
    String name = "Match Question";

    public MatchingQuestions(List<String> question, List<String> answer){
        this.question = new Question(question);
        this.answer = new Answer(answer);
    }

    @Override
    public Answer getAnswer() {
        return this.answer;
    }
    @Override
    public Question getQuestion() {
        return this.question;
    }
    @Override
    public void setAnswer(List<String> answer) {
        this.answer = new Answer(answer);
    }

    @Override
    public void setQuestion(List<String> question) {
        this.question = new Question(question);
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        int max_len = 100;
        String s = "";
        for (int i = 0; i < this.question.List_question.size(); i++) {
            String q = "Question: " + this.question.List_question.get(i);
            String a = "Answer: " + this.answer.List_answer.get(i);
            int len = q.length();
            int mid_blank_len = max_len - len;
            s += q + " ".repeat(mid_blank_len) + a + "\n";
        }
        return s;
    }

//    public static void main(String[] args) {
//        List<String> q = new ArrayList<>();
//        q.add("A");
//        q.add("BBB");
//        q.add("CC");
//        q.add("DDDDDD");
//        List<String> a = new ArrayList<>();
//        a.add("aaa");
//        a.add("b");
//        a.add("ccccc");
//        a.add("dd");
//        MatchingQuestions ac = new MatchingQuestions(q, a);
//        System.out.println(ac);
//    }

}

package mockexamtool.core;

import mockexamtool.examination.AnswerColumn;
import mockexamtool.examination.AnswerSheet;
import mockexamtool.examination.Option;
import mockexamtool.examination.Question;
import mockexamtool.examination.QuestionContainer;
import mockexamtool.examination.QuestionSheet;

public class StartUp {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		QuestionContainer questionContainer = new QuestionContainer();
		
		String examName = questionContainer.getAllExamName().get(0);
		QuestionSheet questionSheet = questionContainer.getQuestionSheet(examName);

		IUser user = new User();
		AnswerSheet answerSheet = questionSheet.startExam(user);
		
		AnswerColumn answerColumn = answerSheet.getCurrentAnswerColumn();
		Question question = answerColumn.getQuestion();
		
		System.out.println(question.getExamName());
		System.out.println("");
		System.out.println(question.getSentence());

		for(Option option : question.getOptions()) {
			System.out.println(option.getSentence());
		}
		
		
		
	}
}

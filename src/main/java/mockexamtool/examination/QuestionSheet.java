package mockexamtool.examination;

import java.util.Calendar;
import java.util.List;

import mockexamtool.core.IUser;

/**
 * 
 * @author Hiroyuki
 *
 */
public class QuestionSheet {
	
	/**
	 * 作成日
	 */
	private Calendar createDate;
	
	/**
	 * @return createDate
	 */
	public Calendar getCreateDate() {
		return createDate;
	}

	/**
	 * @return questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}

	/**
	 * 問題リスト
	 */
	private List<Question> questions;

	/**
	 * @param createDate
	 * @param list
	 */
	public QuestionSheet(List<Question> list) {
		super();
		this.createDate = Calendar.getInstance();
		this.questions = list;
	}

	/**
	 * 試験を開始します。
	 * @param user
	 * @return
	 */
	public AnswerSheet startExam(IUser user) {
		return new AnswerSheet(user, this);
	}

	public void add(Question question) {
		this.questions.add(question);		
	}
}

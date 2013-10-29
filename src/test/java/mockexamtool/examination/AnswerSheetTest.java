/**
 * 
 */
package mockexamtool.examination;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import mockexamtool.core.IUser;
import mockexamtool.core.User;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Hiroyuki
 *
 */
public class AnswerSheetTest {

	private static QuestionSheet questionSheet;
	private static List<Question> questions = new ArrayList<>();
	private static List<Option> options = new ArrayList<>();
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		options.add(new Option("1", false));
		options.add(new Option("2", false));
		options.add(new Option("3", true));
		options.add(new Option("4", false));

		questions.add(new Question(Category.AP, 24, Season.Autumn, 10, "sentence10", options));
		questions.add(new Question(Category.AP, 25, Season.Spring, 1, "sentence1", options));
		questions.add(new Question(Category.AP, 25, Season.Spring, 2, "sentence", options));
		questions.add(new Question(Category.FE, 25, Season.Autumn, 1, "sentence1", options));
		questions.add(new Question(Category.FE, 25, Season.Autumn, 2, "sentence2", options));

		questionSheet = new QuestionSheet(questions);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * {@link mockexamtool.examination.AnswerSheet#AnswerSheet(mockexamtool.core.IUser, mockexamtool.examination.QuestionSheet)} のためのテスト・メソッド。
	 */
	@Test
	public void answerSheet_正常() {
		AnswerSheet as = new AnswerSheet(new User(), questionSheet);
		assertNotNull(as);
	}

	/**
	 * {@link mockexamtool.examination.AnswerSheet#getOperationDate()} のためのテスト・メソッド。
	 */
	@Test
	public void getOperationDate_正常() {
		AnswerSheet as = new AnswerSheet(new User(), questionSheet);
		Calendar expected = Calendar.getInstance();
		Calendar actual = as.getOperationDate();
		
		assertThat(actual.get(Calendar.YEAR), is(expected.get(Calendar.YEAR)));
		assertThat(actual.get(Calendar.MONTH), is(expected.get(Calendar.MONTH)));
		assertThat(actual.get(Calendar.DAY_OF_MONTH), is(expected.get(Calendar.DAY_OF_MONTH)));
		assertThat(actual.get(Calendar.HOUR_OF_DAY), is(expected.get(Calendar.HOUR_OF_DAY)));
		assertThat(actual.get(Calendar.MINUTE), is(expected.get(Calendar.MINUTE)));
		assertThat(actual.get(Calendar.SECOND), is(expected.get(Calendar.SECOND)));
	}

	/**
	 * {@link mockexamtool.examination.AnswerSheet#mark()} のためのテスト・メソッド。
	 */
	@Test
	public void mark_2点_正常() {
		AnswerSheet as = new AnswerSheet(new User(), questionSheet);
		as.getAnswerColumns().get(0).markAnswer(options.get(0));
		as.getAnswerColumns().get(1).markAnswer(options.get(0));
		as.getAnswerColumns().get(2).markAnswer(options.get(2));
		as.getAnswerColumns().get(3).markAnswer(options.get(2));
		as.mark();
		
		assertThat(as.getScore(), is(2));
		assertThat(as.isFinished(), is(true));
	}

	/**
	 * {@link mockexamtool.examination.AnswerSheet#getQuestionCount()} のためのテスト・メソッド。
	 */
	@Test
	public void getQuestionCount_正常() {
		AnswerSheet as = new AnswerSheet(new User(), questionSheet);
		int expected = 5;
		int actual = as.getQuestionCount();
		
		assertThat(actual, is(expected));
	}

	/**
	 * {@link mockexamtool.examination.AnswerSheet#getUser()} のためのテスト・メソッド。
	 */
	@Test
	public void getUser_正常() {
		IUser expected = new User();
		AnswerSheet as = new AnswerSheet(expected, questionSheet);
		IUser actual = as.getUser();
		
		assertThat(actual, is(expected));
	}

	/**
	 * {@link mockexamtool.examination.AnswerSheet#getQuestionSheet()} のためのテスト・メソッド。
	 */
	@Test
	public void getQuestionSheet_正常() {
		QuestionSheet expected = questionSheet;
		AnswerSheet as = new AnswerSheet(new User(), expected);
		QuestionSheet actual = as.getQuestionSheet();
		
		assertThat(actual, is(expected));
	}

	/**
	 * {@link mockexamtool.examination.AnswerSheet#getAnswerColumns()} のためのテスト・メソッド。
	 */
	@Test
	public void getAnswerColumns_正常() {
		AnswerSheet as = new AnswerSheet(new User(), questionSheet);
		List<AnswerColumn> actual = as.getAnswerColumns();
		
		assertThat(actual.size(), is(5));
	}

	/**
	 * {@link mockexamtool.examination.AnswerSheet#isFinished()} のためのテスト・メソッド。
	 */
	@Test
	public void isFinished_終了() {
		AnswerSheet as = new AnswerSheet(new User(), questionSheet);
		as.mark();
		boolean expected = true;
		boolean actual = as.isFinished();

		assertThat(actual, is(expected));
	}

	/**
	 * {@link mockexamtool.examination.AnswerSheet#isFinished()} のためのテスト・メソッド。
	 */
	@Test
	public void isFinished_未終了() {
		AnswerSheet as = new AnswerSheet(new User(), questionSheet);
		boolean expected = false;
		boolean actual = as.isFinished();

		assertThat(actual, is(expected));
	}

	/**
	 * {@link mockexamtool.examination.AnswerSheet#getScore()} のためのテスト・メソッド。
	 */
	@Test
	public void getScore_得点0点() {
		AnswerSheet as = new AnswerSheet(new User(), questionSheet);
		as.mark();
		int expected = 0;
		int actual = as.getScore();

		assertThat(actual, is(expected));
	}

	/**
	 * {@link mockexamtool.examination.AnswerSheet#getCurrentAnswerColumn()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetCurrentAnswerColumn() {
		AnswerSheet as = new AnswerSheet(new User(), questionSheet);
		AnswerColumn expected = as.getAnswerColumns().get(0);
		AnswerColumn actual = as.getCurrentAnswerColumn();

		assertThat(actual, is(expected));
	}

}

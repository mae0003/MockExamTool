/**
 * 
 */
package mockexamtool.examination;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import mockexamtool.core.User;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Hiroyuki
 * 
 */
public class QuestionSheetTest {

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

		questions.add(new Question(Category.AP, 24, Season.Autumn, 10,
				"sentence10", options));
		questions.add(new Question(Category.AP, 25, Season.Spring, 1,
				"sentence1", options));
		questions.add(new Question(Category.AP, 25, Season.Spring, 2,
				"sentence", options));
		questions.add(new Question(Category.FE, 25, Season.Autumn, 1,
				"sentence1", options));
		questions.add(new Question(Category.FE, 25, Season.Autumn, 2,
				"sentence2", options));

	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * {@link mockexamtool.examination.QuestionSheet#getCreateDate()}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void getCreateDate_正常() {
		Calendar expected = Calendar.getInstance();
		QuestionSheet qc = new QuestionSheet(questions);
		Calendar actual = qc.getCreateDate();

		assertThat(actual.get(Calendar.YEAR), is(expected.get(Calendar.YEAR)));
		assertThat(actual.get(Calendar.MONTH), is(expected.get(Calendar.MONTH)));
		assertThat(actual.get(Calendar.DAY_OF_MONTH),
				is(expected.get(Calendar.DAY_OF_MONTH)));
		assertThat(actual.get(Calendar.HOUR_OF_DAY),
				is(expected.get(Calendar.HOUR_OF_DAY)));
		assertThat(actual.get(Calendar.MINUTE),
				is(expected.get(Calendar.MINUTE)));
		assertThat(actual.get(Calendar.SECOND),
				is(expected.get(Calendar.SECOND)));
	}

	/**
	 * {@link mockexamtool.examination.QuestionSheet#getQuestions()}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void getQuestions() {
		List<Question> expected = questions;
		QuestionSheet qc = new QuestionSheet(questions);
		List<Question> actual = qc.getQuestions();

		assertThat(actual, is(expected));

	}

	/**
	 * {@link mockexamtool.examination.QuestionSheet#startExam(mockexamtool.core.IUser)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void startExam_正常() {
		QuestionSheet qc = new QuestionSheet(questions);
		AnswerSheet as = qc.startExam(new User());

		assertNotNull(as);
	}

	/**
	 * {@link mockexamtool.examination.QuestionSheet#add(mockexamtool.examination.Question)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void add() {
		QuestionSheet qc = new QuestionSheet(questions);
		qc.add(new Question(Category.FE, 25, Season.Autumn, 2, "sentence2", options));

		int expected = 6;
		int actual = 6;
		
		assertThat(actual, is(expected));
	}
}

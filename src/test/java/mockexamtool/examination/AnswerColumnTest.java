/**
 * 
 */
package mockexamtool.examination;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Hiroyuki
 *
 */
public class AnswerColumnTest {

	private static AnswerColumn answerColumn;
	private static Question question;
	
	@BeforeClass
	public static void setUp() {		
		List<Option> options = new ArrayList<>();
		options.add(new Option("1", false));
		options.add(new Option("2", false));
		options.add(new Option("3", true));
		options.add(new Option("4", false));
		question = new Question(Category.AP, 2013, Season.Autumn, 1, "sentence", options);
	}
	
	@Before
	public void initContainer() {
		answerColumn = new AnswerColumn(question);
	}

	@Test
	public void getQuestion_正常動作() {
		Question expected = question;
		Question actual = answerColumn.getQuestion();
		
		assertSame(expected, actual);
	}
	
	@Test
	public void getSelectedOption_正常()
	{
		Option expected = question.getOptions().get(2);
		answerColumn.markAnswer(expected);
		Option actual = answerColumn.getSelectedOption();
		
		assertThat(actual, is(expected));
	}
	
	@Test
	public void isAnswer_正解選択(){
		answerColumn.markAnswer(question.getOptions().get(2));
		boolean expected = true;
		boolean actual = answerColumn.isAnswer();

		assertThat(actual, is(expected));
	}

	@Test
	public void isAnswer_不正解選択(){
		answerColumn.markAnswer(question.getOptions().get(3));
		boolean expected = false;
		boolean actual = answerColumn.isAnswer();

		assertThat(actual, is(expected));
	}

}

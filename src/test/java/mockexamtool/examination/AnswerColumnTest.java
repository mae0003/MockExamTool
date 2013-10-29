/**
 * 
 */
package mockexamtool.examination;

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
	private static Option option1;
	private static Option option2;
	private static Option option3;
	private static Option option4;
	
	
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
	
}

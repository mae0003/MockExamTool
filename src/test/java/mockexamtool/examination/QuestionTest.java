package mockexamtool.examination;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Qestionのテストクラスです。
 * @author H.Maeda
 *
 */
public class QuestionTest {

	private Category expectedCategory =  Category.FE;
	private int expectedYear = 24;
	private Season expectedSeason = Season.Spring;
	private int expectedNo = 1;
	private String expectedSentence = "問題文";

	@Test
	public void Question_正常() {
		
		ArrayList<Option> expectedOptions = new ArrayList<Option>();
		expectedOptions.add(new Option("1", false));
		expectedOptions.add(new Option("2", false));
		expectedOptions.add(new Option("3", true));
		expectedOptions.add(new Option("4", false));
		
		Question question = new Question(expectedCategory, expectedYear, expectedSeason, expectedNo, expectedSentence, expectedOptions); 
		
		assertSame(expectedCategory, question.getCategory());
		assertSame(expectedYear, question.getYear());
		assertSame(expectedSeason, question.getSeason());
		assertSame(expectedNo, question.getNo());
		assertSame(expectedSentence, question.getSentence());
		assertEquals(expectedOptions, question.getOptions());
	}

	@Test(expected=IllegalArgumentException.class)
	public void Question_正解なし() {
		ArrayList<Option> options = new ArrayList<Option>();
		options.add(new Option("1", false));
		options.add(new Option("2", false));
		options.add(new Option("3", false));
		options.add(new Option("4", false));		

		Question question = new Question(expectedCategory, expectedYear, expectedSeason, expectedNo, expectedSentence, options); 
	}

	@Test(expected=IllegalArgumentException.class)
	public void Question_正解複数() {
		ArrayList<Option> options = new ArrayList<Option>();
		options.add(new Option("1", false));
		options.add(new Option("2", false));
		options.add(new Option("3", true));
		options.add(new Option("4", true));		
		Question question = new Question(expectedCategory, expectedYear, expectedSeason, expectedNo, expectedSentence, options); 
	}
	
	@Test
	public void getExamName_平成24年XX() {
		ArrayList<Option> options = new ArrayList<Option>();
		options.add(new Option("1", false));
		options.add(new Option("2", false));
		options.add(new Option("3", true));
		options.add(new Option("4", false));
		
		Question question = new Question(expectedCategory, expectedYear, expectedSeason, expectedNo, expectedSentence, options); 
		String expected = String.format("平成%d年 %s %s", expectedYear, expectedSeason.toString(), expectedCategory.toString()) ;
		String actual = question.getExamName();
		
		assertThat(actual, is(expected));
	}
}

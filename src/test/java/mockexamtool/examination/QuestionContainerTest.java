package mockexamtool.examination;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class QuestionContainerTest {

	private static Category category =  Category.FE;
	private static int year = 24;
	private static Season season = Season.Spring;
	private static int no = 1;
	private static String sentence = "問題文";
	private static ArrayList<Option> options = new ArrayList<Option>();
	
	private static QuestionContainer container;
	
	@BeforeClass
	public static void setUp() {		
		// 問題１
		options.add(new Option("1", false));
		options.add(new Option("2", false));
		options.add(new Option("3", true));
		options.add(new Option("4", false));
	}
	
	@Before
	public void initContainer() {
		container = new QuestionContainer();
	}
	
	@Test
	public void size_0件() {
		int expected = 0;
		int actual = container.size();		

		assertThat(actual, is(expected));
	}
	
	@Test
	public void size_5件() {
		container.add(new Question(Category.AP, 24, Season.Autumn, 10, sentence, options));
		container.add(new Question(Category.AP, 25, Season.Spring, 1, sentence, options));
		container.add(new Question(Category.AP, 25, Season.Spring, 2, sentence, options));
		container.add(new Question(Category.FE, 25, Season.Autumn, 2, sentence, options));
		container.add(new Question(Category.FE, 25, Season.Autumn, 2, sentence, options));

		int expected = 5;
		int actual = container.size();		

		assertThat(actual, is(expected));
	}
	
	@Test
	public void QuestionContainer_生成正常() {
		container = new QuestionContainer();
		assertNotNull(container);		
	}

	@Ignore
	// Travis で失敗するため無視
	public void ReadQuestionFile() {
		container.readQuestionFile();
		assertNotEquals(0, container.size());
	}

	@Test
	public void getAllExamName_1件取得() {
		container.add(new Question(category, year, season, no, sentence, options));
		List<String> expected = new ArrayList<>();
		expected.add(String.format("平成%d年 %s %s", year, season.toString(), category.toString()));
		List<String> actual = this.container.getAllExamName();

		assertThat(actual, is(expected));
	}

	@Test
	public void getAllExamName_問題5問中3件取得() {
		container.add(new Question(Category.AP, 24, Season.Autumn, 10, sentence, options));
		container.add(new Question(Category.AP, 25, Season.Spring, 1, sentence, options));
		container.add(new Question(Category.AP, 25, Season.Spring, 2, sentence, options));
		container.add(new Question(Category.FE, 25, Season.Autumn, 2, sentence, options));
		container.add(new Question(Category.FE, 25, Season.Autumn, 2, sentence, options));
		
		int expected = 3;
		int actual = this.container.getAllExamName().size();
		assertThat(actual, is(expected));
		assertTrue(container.getAllExamName().contains(String.format("平成%d年 %s %s", 24, Season.Autumn.toString(), Category.AP.toString())));
		assertTrue(container.getAllExamName().contains(String.format("平成%d年 %s %s", 25, Season.Spring.toString(), Category.AP.toString())));
		assertTrue(container.getAllExamName().contains(String.format("平成%d年 %s %s", 25, Season.Autumn.toString(), Category.FE.toString())));
	}

}

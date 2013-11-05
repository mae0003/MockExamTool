package mockexamtool.examination;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExamCategoryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExamCategory() {
		Category expectedCategory = Category.AP;
		int expectedYear = 25;
		Season expectedSeason = Season.Spring;
		String expectedExamName = "平成25年 春期 応用情報技術者";
		ExamCategory actual = new ExamCategory(expectedCategory, expectedYear,
				expectedSeason);

		assertThat(actual.getCategory(), is(expectedCategory));
		assertThat(actual.getYear(), is(expectedYear));
		assertThat(actual.getSeason(), is(expectedSeason));
		assertThat(actual.getExamName(), is(expectedExamName));
	}
}

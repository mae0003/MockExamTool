/**
 * 
 */
package mockexamtool.examination;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Hiroyuki
 *
 */
public class OptionTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * {@link mockexamtool.examination.Option#getSentence()} のためのテスト・メソッド。
	 */
	@Test
	public void GetSentence_正常() {
		String expected = "sentence";
		Option option = new Option(expected, false);
		String actual = option.getSentence();
		
		assertThat(actual, is(expected));
	}

	/**
	 * {@link mockexamtool.examination.Option#isAnswer()} のためのテスト・メソッド。
	 */
	@Test
	public void IsAnswer_真の場合() {
		boolean expected = true;
		Option option = new Option("sentence", expected);
		boolean actual = option.isAnswer();
		
		assertThat(actual, is(expected));
	}

	/**
	 * {@link mockexamtool.examination.Option#isAnswer()} のためのテスト・メソッド。
	 */
	@Test
	public void IsAnswer_偽の場合() {
		boolean expected = false;
		Option option = new Option("sentence", expected);
		boolean actual = option.isAnswer();
		
		assertThat(actual, is(expected));
	}

}

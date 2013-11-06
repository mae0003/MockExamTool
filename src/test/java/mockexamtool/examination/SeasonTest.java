package mockexamtool.examination;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SeasonTest {

	@Test
	public void toString_None() {
		Season actual = Season.None;
		assertThat(actual.toString(), is("なし"));
	}

	@Test
	public void toString_Spring() {
		Season actual = Season.Spring;
		assertThat(actual.toString(), is("春期"));
	}

	@Test
	public void toString_Autumn() {
		Season actual = Season.Autumn;
		assertThat(actual.toString(), is("秋期"));
	}

}

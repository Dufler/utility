package it.ltc.utility.miscellanea.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.ltc.utility.miscellanea.string.StringUtility;

public class TestString {
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	StringUtility su;

	@Before
	public void setUp() throws Exception {
		su = new StringUtility();
	}

	@Test
	public void testGetFormattedStringIntInt() {
		int n = 1;
		int length = 5;
		String expected = "00001";
		String actual = su.getFormattedString(n, length);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetFormattedStringIntIntString() {
		int n = 1;
		int length = 5;
		char padding = '_';
		String expected = "____1";
		String actual = su.getFormattedString(n, length, padding);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetFormattedStringStringInt() {
		String s = "s";
		int length = 5;
		String expected = "s    ";
		String actual = su.getFormattedString(s, length);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetFormattedStringStringIntString() {
		String s = "s";
		int length = 5;
		String padding = "_";
		String expected = "s____";
		String actual = su.getFormattedString(s, length, padding);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_10_5_3() {
		double d = 1.0;
		int length = 5;
		int decimal = 3;
		String expected = "01000";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_10_2_3() {
		double d = 1.0;
		int length = 2;
		int decimal = 3;
		String expected = "10";
		exception.expect(IllegalArgumentException.class);
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_10_1_3() {
		double d = 1.0;
		int length = 1;
		int decimal = 3;
		String expected = "1";
		exception.expect(IllegalArgumentException.class);
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_10_5_1() {
		double d = 1.0;
		int length = 5;
		int decimal = 1;
		String expected = "00010";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_10_2_1() {
		double d = 1.0;
		int length = 2;
		int decimal = 1;
		String expected = "10";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_10_1_1() {
		double d = 1.0;
		int length = 1;
		int decimal = 1;
		String expected = "1";
		exception.expect(IllegalArgumentException.class);
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_10_5_0() {
		double d = 1.0;
		int length = 5;
		int decimal = 0;
		String expected = "00001";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_10_2_0() {
		double d = 1.0;
		int length = 2;
		int decimal = 0;
		String expected = "01";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_10_1_0() {
		double d = 1.0;
		int length = 1;
		int decimal = 0;
		String expected = "1";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_11_5_3() {
		double d = 1.1;
		int length = 5;
		int decimal = 3;
		String expected = "01100";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_11_2_3() {
		double d = 1.1;
		int length = 2;
		int decimal = 3;
		String expected = "11";
		exception.expect(IllegalArgumentException.class);
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_11_1_3() {
		double d = 1.1;
		int length = 1;
		int decimal = 3;
		String expected = "1";
		exception.expect(IllegalArgumentException.class);
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_11_5_1() {
		double d = 1.1;
		int length = 5;
		int decimal = 1;
		String expected = "00011";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_11_2_1() {
		double d = 1.1;
		int length = 2;
		int decimal = 1;
		String expected = "11";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_11_1_1() {
		double d = 1.1;
		int length = 1;
		int decimal = 1;
		String expected = "1";
		exception.expect(IllegalArgumentException.class);
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_11_5_0() {
		double d = 1.0;
		int length = 5;
		int decimal = 0;
		String expected = "00001";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_11_2_0() {
		double d = 1.1;
		int length = 2;
		int decimal = 0;
		String expected = "01";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_11_1_0() {
		double d = 1.1;
		int length = 1;
		int decimal = 0;
		String expected = "1";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_01_5_3() {
		double d = 0.1;
		int length = 5;
		int decimal = 3;
		String expected = "00100";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_01_2_3() {
		double d = 0.1;
		int length = 2;
		int decimal = 3;
		String expected = "01";
		exception.expect(IllegalArgumentException.class);
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_01_1_3() {
		double d = 0.1;
		int length = 1;
		int decimal = 3;
		String expected = "0";
		exception.expect(IllegalArgumentException.class);
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_01_5_1() {
		double d = 0.1;
		int length = 5;
		int decimal = 1;
		String expected = "00001";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_01_2_1() {
		double d = 0.1;
		int length = 2;
		int decimal = 1;
		String expected = "01";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_01_1_1() {
		double d = 0.1;
		int length = 1;
		int decimal = 1;
		String expected = "0";
		exception.expect(IllegalArgumentException.class);
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_01_5_0() {
		double d = 0.1;
		int length = 5;
		int decimal = 0;
		String expected = "00000";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_01_2_0() {
		double d = 0.1;
		int length = 2;
		int decimal = 0;
		String expected = "00";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_01_1_0() {
		double d = 0.1;
		int length = 1;
		int decimal = 0;
		String expected = "0";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_00_5_3() {
		double d = 0;
		int length = 5;
		int decimal = 3;
		String expected = "00000";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_00_2_3() {
		double d = 0;
		int length = 2;
		int decimal = 3;
		String expected = "00";
		exception.expect(IllegalArgumentException.class);
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_00_1_3() {
		double d = 0;
		int length = 1;
		int decimal = 3;
		String expected = "0";
		exception.expect(IllegalArgumentException.class);
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_00_5_1() {
		double d = 0;
		int length = 5;
		int decimal = 1;
		String expected = "00000";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_00_2_1() {
		double d = 0;
		int length = 2;
		int decimal = 1;
		String expected = "00";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_00_1_1() {
		double d = 0;
		int length = 1;
		int decimal = 1;
		String expected = "0";
		exception.expect(IllegalArgumentException.class);
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_00_5_0() {
		double d = 0;
		int length = 5;
		int decimal = 0;
		String expected = "00000";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_00_2_0() {
		double d = 0;
		int length = 2;
		int decimal = 0;
		String expected = "00";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFormattedStringDoubleIntInt_00_1_0() {
		double d = 0;
		int length = 1;
		int decimal = 0;
		String expected = "0";
		String actual = su.getFormattedString(d, length, decimal);
		assertEquals(expected, actual);
	}

}

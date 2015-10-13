package org.workleanmobile;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StringCalculatorTest {
    private StringCalculator stringCalculator = null;

    @Mock
    private StringParser stringParser = null;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

// stringParser = new StringParserWithComma();

        stringCalculator = new StringCalculator(stringParser);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testEmptyString() {
        String[] value = { "" };
        when(stringParser.parse(anyString())).thenReturn(value);

        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void testOneNumberString() {
        String[] value = { "1" };
        when(stringParser.parse(anyString())).thenReturn(value);

        assertEquals(1, stringCalculator.add("1"));

        String[] value2 = { "2" };
        when(stringParser.parse(anyString())).thenReturn(value2);

        assertEquals(2, stringCalculator.add("2"));

        assertEquals(3478123, stringCalculator.add("3478123"));
        assertEquals(5, stringCalculator.add("5,"));
        assertEquals(5, stringCalculator.add(",5"));
        assertEquals(0, stringCalculator.add(","));
        assertEquals(3, stringCalculator.add(",,,,,,,,,,,,,,3"));
    }

    @Test
    public void testAddTwoNumberString() {
        assertEquals(344 + 100, stringCalculator.add("344,100"));
        assertEquals(0 + 0, stringCalculator.add("0,0"));
        assertEquals(-3 + 3, stringCalculator.add("-3,3"));
    }

    @Test
    public void specialTest() {
        StringParser parse = new StringParser() {

            public String[] parse(String source) {
                return source.split(",");
            }
        };
        stringCalculator = new StringCalculator(parse);
    }

    @Test
    public void testWhiteSpace() {
        assertEquals(-3 + 3, stringCalculator.add("-3, 3"));
        assertEquals(0, stringCalculator.add(" "));
    }

    @Test(expected = RuntimeException.class)
    public void testTooLowRangePoints() {
        StringCalculator.methodRankPoints(0);
    }

    public void testGoodRangePoints() {
        StringCalculator.methodRankPoints(145);
        assert (true);
    }
}

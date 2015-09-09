package org.workleanmobile;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
    private StringCalculator target = new StringCalculator();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testEmptyStringReturnsZero() {
        assertEquals(0, target.add(""));
    }

    @Test
    public void testOneNumberInString() {
        assertEquals(1, target.add("1"));
        assertEquals(2, target.add("2"));
        assertEquals(12318, target.add("12318"));
    }

    @Test
    public void testAddingTwoNumbersInString() {
        assertEquals(1 + 2, target.add("1,2"));
        assertEquals(34 + 43, target.add("34,43"));
    }

    @Test(expected = RuntimeException.class)
    public void AddingNonNumericNumbers() {
        target.add("1,abcdefg");
    }

    @Test
    public void AddArbitraryNumbers() {
        assertEquals(1 + 2 + 3 + 4, target.add("1,2,3,4"));
    }

    @Test
    public void AddEmptyArgs() {
        assertEquals(0, target.add(","));
    }

    @Test
    public void incompleteArgs() {
        assertEquals(57, target.add("57,"));
        assertEquals(76, target.add(",76"));
    }

    @Test
    public void testAddingNumbersWhereWhitespaceIsPresent() {
        assertEquals(1 + 2, target.add("1, 2"));
    }

}

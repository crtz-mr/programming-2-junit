package price.formatter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import refactoring.DayOfYear;

public class DayOfYearTest {

    private DayOfYear day;

    @BeforeEach
    void setUp() {
        day = new DayOfYear();
    }

    @Test
    void basicTest() {
        assertEquals(1, day.dayOfYear(1, 1, 2000));
    }

    @Test
    void leapYearTest() {
        assertEquals(61, day.dayOfYear(3, 1, 2020));
    }

    @Test
    void nonLeapYearTest() {
        assertEquals(121, day.dayOfYear(5, 1, 2026));
    }
}

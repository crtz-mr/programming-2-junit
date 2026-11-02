package price.formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Write your tests for the PriceFormatter here. See the specification of the
 * PriceFormatter and formatPrice method in the PriceFormatter class and the
 * readme file.
 */

// whenever formatPrice(double) is called -->
// it will return a string with the following format: 123 456,78 €
// space as thousand separator
// comma with decimal separator, rounded to two digits unless 0, € at the end.

public class PriceFormatterTest {

    private PriceFormatter formatter;

    @BeforeEach
    void setUp() {
        formatter = new PriceFormatter();
    }

    @Test
    void basicFormat() {
        assertEquals("3,14 €", formatter.formatPrice(3.141592653589793));
        // should return "3,14 €"
    }

    @Test
    void checkSpaceAsThousandSeparator() {
        assertEquals("12 345 678 €", formatter.formatPrice(12345678));
        // should return "12 345 678,00 €"
    }

    @Test
    void checkCommaAsDecimalSeparator() {
        assertEquals("12 345 678,90 €", formatter.formatPrice(12345678.90));
        // should return "12 345 678,90 €"
    }

    @Test
    void checkRounding() {
        assertEquals("123 456,79 €", formatter.formatPrice(123456.789));
        // should return "123 456,79 €"
    }

    @Test
    void checkCurrency() {
        assertEquals("12 345 €", formatter.formatPrice(12345));
        // should return "12 345,00 €"
    }

}

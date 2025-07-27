package converter.tests;

import converter.implementation.Binary2Decimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Binary2DecimalTest {
    /**
     * This method is used to execute the Binary2Decimal constructor with invalid binary numbers.
     * It will throw a BinaryException if the binary numbers are not valid.
     */
    private static void execute() {
        new Binary2Decimal("1010", "1112", "10000", "210 44");
    }

    /**
     * This test checks if the Binary2Decimal class throws a BinaryException when invalid binary numbers are provided to the list.
     */
    @Test
    public void testInvalidBinaries() {
        Assertions.assertThrows(converter.implementation.BinaryException.class, Binary2DecimalTest::execute);
    }
    /**
     * Test to check if the Binary2Decimal class can convert valid binary numbers to decimal.
     */
    @Test
    public void testValidBinaryConversion() {
        Binary2Decimal binaryConverter = new Binary2Decimal("1010", "1111", "10000", "111101111111111111111111111111111111011111111111111011111111011");
        Assertions.assertEquals(10, binaryConverter.converToDecimal(0));
        Assertions.assertEquals(15, binaryConverter.converToDecimal(1));
        Assertions.assertEquals(16, binaryConverter.converToDecimal(2));
        Assertions.assertEquals(8935141660635953147L, binaryConverter.converToDecimal(3));
    }
    @Test
    public void TestConversionAllBinaries() {
        Binary2Decimal binaryConverter = new Binary2Decimal("1010", "1111", "10000", "111101111111111111111111111111111111011111111111111011111111011", "101011110");
        Assertions.assertArrayEquals(new long[]{10, 15, 16, 8935141660635953147L, 350}, binaryConverter.convertAllToDecimal());
    }
}

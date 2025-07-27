package converter.implementation;

import java.util.ArrayList;
import java.util.Collections;

/***
 * This is the main class that have all the methods to conversion from binary to decimal.
 * This class have a List of binary numbers to be converted and have methods to converts individual binaru numbers or a list of binary numbers.
 *
 * @Author: <a href="https://github.com/lfslopes">Luiz Felipe Santos Lopes</a>
 */

public class Binary2Decimal{
    /**
     * This is a list of binary numbers that will be converted to decimal.
     */
    private final ArrayList<String> binaryNumbers = new ArrayList<>();
    /**
     * This is a regex that will be used to check if the binary number is valid.
     */
    private static final String BINARY_REGEX = "^[01]+$";
    /**
     * This is the constructor that will receive a list of binary numbers to be converted. The binary numbers must be valid, otherwise a BinaryException will be thrown.
     * @param binaryNumbers is a varargs parameter that will receive a list of binary numbers to be converted.
     */
    public Binary2Decimal(String...binaryNumbers) {
        for (String binary : binaryNumbers) {
            binaryConfirmation(binary);
        }
        Collections.addAll(this.binaryNumbers, binaryNumbers);
    }
    /**
     * This method is used to confirm if the binary number is valid.
     * This method is used in the constructor to confirm if all the binary numbers are valid before adding it to the list of binary numbers.
     * @param binary It's a String that represents a binary number. It must consist of only 0s and 1s. Otherwise, a BinaryException will be thrown.
     */
    private void binaryConfirmation(String binary) {
        if (!binary.matches(BINARY_REGEX)) {
            throw new BinaryException("Binary number must consist of only 0s and 1s.");
        }
    }
    /**
     * Just a getter to return one of the binary numbers in the list.
     * @param index It's the index of the binary number in the list. It must be a valid index, otherwise an IndexOutOfBoundsException will be thrown.
     * @return Returns the binary number at the specified index in the list of binary numbers.
     */
    public String getBinaryNumber(int index) {
        return this.binaryNumbers.get(index);
    }
    /**
     * This is the method used to convert a binary number to decimal. It receives the index of the binary number in the list
     * and returns the decimal equivalent of that binary number in a long type.
     * @param index of the binary number in the list. It must be a valid index, otherwise an IndexOutOfBoundsException will be thrown.
     * @return Return a long number that represents the decimal equivalent of the binary number at the specified index in the list.
     */
    public long converToDecimal(int index) {
        long result = 0;
        for (int i = 0; i < this.binaryNumbers.get(index).length(); i++)
            result += (long) (Long.parseLong(String.valueOf(this.binaryNumbers.get(index).charAt(binaryNumbers.get(index).length() - (i + 1)))) * Math.pow(2, i));

        return result;
    }

    /**
     * This method is used to convert all the binary numbers in the list to decimal.
     * @return Returns an array of long numbers that represents the decimal equivalent of all the binary numbers in the list.
     */
    public long[] convertAllToDecimal() {
        long[] result = new long[this.binaryNumbers.size()];
        for (int i = 0; i < this.binaryNumbers.size(); i++) {
            result[i] = converToDecimal(i);
        }
        return result;
    }
}

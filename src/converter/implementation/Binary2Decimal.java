package converter.implementation;

import java.util.ArrayList;
import java.util.Collections;

public class Binary2Decimal{
    private final ArrayList<String> binaryNumbers = new ArrayList<>();

    private static final String BINARY_REGEX = "^[01]+$";

    public Binary2Decimal(String...binaryNumbers) {
        for (String binary : binaryNumbers) {
            binaryConfirmation(binary);
        }
        Collections.addAll(this.binaryNumbers, binaryNumbers);
    }

    private void binaryConfirmation(String binary) {
        if (!binary.matches(BINARY_REGEX)) {
            throw new BinaryException("Binary number must consist of only 0s and 1s.");
        }
    }

    public String getBinaryNumber(int index) {
        return this.binaryNumbers.get(index);
    }

    public long converToDecimal(int index) {
        long result = 0;
        for (int i = 0; i < this.binaryNumbers.get(index).length(); i++)
            result += (long) (Long.parseLong(String.valueOf(this.binaryNumbers.get(index).charAt(binaryNumbers.get(index).length() - (i + 1)))) * Math.pow(2, i));

        return result;
    }
    public long[] convertAllToDecimal() {
        long[] result = new long[this.binaryNumbers.size()];
        for (int i = 0; i < this.binaryNumbers.size(); i++) {
            result[i] = converToDecimal(i);
        }
        return result;
    }
}

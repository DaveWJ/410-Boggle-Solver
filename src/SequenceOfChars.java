import java.util.Arrays;

/**
 * Created by david on 11/8/16.
 */
public class SequenceOfChars {
    private char[] chars;
    private int endIndex;

    public SequenceOfChars(int maxSize) {
        this.chars = new char[maxSize];
        this.endIndex = 0;
    }

    void append(char c) {
        chars[endIndex] = c;
        endIndex++;
    }

    char removeEnd() {
        endIndex--;
        return chars[endIndex];

    }

    String asString() {
        return endIndex == 0 ? "" : new String(Arrays.copyOfRange(chars, 0, endIndex));
    }

    char[] asCharArray(){
        return endIndex == 0 ? new char[0] : Arrays.copyOfRange(chars, 0, endIndex);
    }

    int length(){
        return endIndex;
    }

    @Override
    public String toString() {
        return endIndex == 0 ? "" : new String(Arrays.copyOfRange(chars, 0, endIndex));
    }
}

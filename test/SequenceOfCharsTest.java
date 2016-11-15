import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by david on 11/8/16.
 */
public class SequenceOfCharsTest {
    @Test
    public void asString() throws Exception {
        SequenceOfChars sequenceOfChars = new SequenceOfChars(16);
        for (int i = 0; i < 5; i++) {
            sequenceOfChars.append((char)('a' + i));
        }
        assertTrue("abcde".equals(sequenceOfChars.toString()));
        assertTrue("abcde".equals(sequenceOfChars.asString()));
    }

    @Test
    public void asCharArray() throws Exception {
        SequenceOfChars sequenceOfChars = new SequenceOfChars(16);

        for(int i = 0; i < 10; i++){
            sequenceOfChars.append((char)('a' + i));
        }
        char[] chars = sequenceOfChars.asCharArray();
        assertEquals(chars.length, 10);

        for(int i = 0; i < 10; i++){
            assertEquals((char)('a'+ i), chars[i]);
        }
    }

    @Test
    public void append() throws Exception {
        SequenceOfChars sequenceOfChars = new SequenceOfChars(16);
        for (int i = 0; i < 16; i++) {
            sequenceOfChars.append((char) ('a' + i));
        }

        char[] asCharArray = sequenceOfChars.asCharArray();
        for (int i = 0; i < asCharArray.length; i++) {
            assertEquals((char) ('a' + i), asCharArray[i]);
        }
    }

    @Test
    public void removeEnd() throws Exception {
        SequenceOfChars sequenceOfChars = new SequenceOfChars(16);

        for (int i = 0; i < 16; i++) {
            sequenceOfChars.append((char) ('a' + i));
        }

        for (int i = sequenceOfChars.length() - 1; i >= 0; i--) {
            assertEquals((char) ('a' + i), sequenceOfChars.removeEnd());
        }
    }

}
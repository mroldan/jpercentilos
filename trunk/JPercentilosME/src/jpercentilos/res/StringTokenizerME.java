/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpercentilos.res;

import java.util.NoSuchElementException;

/**
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public class StringTokenizerME {

    private int currentPosition;
    private int newPosition;
    private int maxPosition;
    private final String str;
    private final String delim;

    /**
     * Constructs a string tokenizer for the specified string. The
     * characters in the <code>delim</code> argument are the delimiters
     * for separating tokens. Delimiter characters themselves will not
     * be treated as tokens.
     * <p>
     * Note that if <tt>delim</tt> is <tt>null</tt>, this constructor does
     * not throw an exception. However, trying to invoke other methods on the
     * resulting <tt>StringTokenizerME</tt> may result in a
     * <tt>NullPointerException</tt>.
     *
     * @param   str     a string to be parsed.
     * @param   delim   the delimiters.
     * @exception NullPointerException if str is <CODE>null</CODE>
     */
    public StringTokenizerME(String str, String delim) {
        currentPosition = 0;
        newPosition = -1;
        this.str = str;
        maxPosition = str.length();
        this.delim = delim;
    }

    /**
     * Constructs a string tokenizer for the specified string. The 
     * tokenizer uses the default delimiter set, which is 
     * <code>"&nbsp;&#92;t&#92;n&#92;r&#92;f"</code>: the space character, 
     * the tab character, the newline character, the carriage-return character,
     * and the form-feed character.
     *
     * @param   str   a string to be parsed.
     * @exception NullPointerException if str is <CODE>null</CODE> 
     */
    public StringTokenizerME(String str) {
        this(str, " \t\n\r\f");
    }

    /**
     * Skips delimiters starting from the specified position. If retDelims
     * is false, returns the index of the first non-delimiter character at or
     * after startPos. If retDelims is true, startPos is returned.
     */
    private int skipDelimiters(int startPos) {
        if (delim == null) {
            throw new NullPointerException();
        }
        int position = startPos;
        while (position < maxPosition) {
            char c = str.charAt(position);
            if ((delim.indexOf(c) < 0)) {
                break;
            }
            position++;
        }
        return position;
    }

    /**
     * Skips ahead from startPos and returns the index of the next delimiter
     * character encountered, or maxPosition if no such delimiter is found.
     */
    private int scanToken(int startPos) {
        int position = startPos;
        while (position < maxPosition) {
            char c = str.charAt(position);
            if (delim.indexOf(c) >= 0) {
                break;
            }
            position++;
        }
        return position;
    }

    /**
     * Tests if there are more tokens available from this tokenizer's string.
     * If this method returns <tt>true</tt>, then a subsequent call to
     * <tt>nextToken</tt> with no argument will successfully return a token.
     *
     * @return  <code>true</code> if and only if there is at least one token
     *          in the string after the current position; <code>false</code>
     *          otherwise.
     */
    public boolean hasMoreTokens() {
        /*
         * Temporarily store this position and use it in the following
         * nextToken() method only if the delimiters haven't been changed in
         * that nextToken() invocation.
         */
        newPosition = skipDelimiters(currentPosition);
        return (newPosition < maxPosition);
    }

    /**
     * Returns the next token from this string tokenizer.
     *
     * @return     the next token from this string tokenizer.
     * @exception  NoSuchElementException  if there are no more tokens in this
     *               tokenizer's string.
     */
    public String nextToken() {
        /*
         * If next position already computed in hasMoreTokens() then use the
         * computed value.
         */
        currentPosition = (newPosition >= 0)
                ? newPosition : skipDelimiters(currentPosition);

        /* Reset these anyway */
        newPosition = -1;
        if (currentPosition >= maxPosition) {
            throw new NoSuchElementException();
        }
        int start = currentPosition;
        currentPosition = scanToken(currentPosition);
        return str.substring(start, currentPosition);
    }

    /**
     * Calculates the number of times that this tokenizer's
     * <code>nextToken</code> method can be called before it generates an
     * exception. The current position is not advanced.
     *
     * @return  the number of tokens remaining in the string using the current
     *          delimiter set.
     * @see     java.util.StringTokenizerME#nextToken()
     */
    public int countTokens() {
        int count = 0;
        int currpos = currentPosition;
        while (currpos < maxPosition) {
            currpos = skipDelimiters(currpos);
            if (currpos >= maxPosition) {
                break;
            }
            currpos = scanToken(currpos);
            count++;
        }
        return count;
    }
}

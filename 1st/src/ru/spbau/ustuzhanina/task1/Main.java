package ru.spbau.ustuzhanina.task1;

/**
 * The <code>Main</code> class represents additon integer numbers from
 * command line and print the result to console
 *
 * @author Ystuzhanina Kate
 * @version 1.0
 */

public class Main {
    /**
     * print to console sum, from numbers of command line
     *
     * @param args from command line
     */
    public static void main(String[] args) {
        int rezSum = 0;
        for (String str : args) {
            rezSum += stringHandle(str);
        }
        System.out.println(rezSum);
    }

    /**
     * adding numbers in string
     *
     * @param inStr string with numbers. numbers maybe divided with whitespaces
     * @return sum of numbers in string
     */
    public static int stringHandle(String inStr) {
        int rez = 0;
        int leftStringBorder = 0;
        int rightStringBorder = 0;
        int strLength = inStr.length();

        while (rightStringBorder != strLength) {
            while (leftStringBorder != strLength && Character.isWhitespace(inStr.charAt(leftStringBorder))) {
                leftStringBorder++;
            }
            if (leftStringBorder == strLength) {
                return rez;
            } else {
                rightStringBorder = leftStringBorder + 1;
                while (rightStringBorder != strLength && !Character.isWhitespace(inStr.charAt(rightStringBorder))) {
                    rightStringBorder++;
                }
                rez += stringToInt(inStr.substring(leftStringBorder, rightStringBorder));
                leftStringBorder = rightStringBorder;
            }
        }
        return rez;
    }

    /**
     * convert string to number, consider sign
     *
     * @param inStr string to convert
     * @return integer number
     */
    public static int stringToInt(String inStr) {
        int rez = 0;
        int i = 0;
        int sign = 1;
        int strLen = inStr.length();
        if (inStr.charAt(0) == '-') {
            sign = -1;
            i++;
        }
        for (; i < strLen; i++) {
            rez = rez * 10 + inStr.charAt(i) - '0';
        }
        return rez * sign;
    }
}

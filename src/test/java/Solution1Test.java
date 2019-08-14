import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class Solution1Test {

    private Solution soln = new Solution1();
    private String input;
    private int output;

    public Solution1Test(String in, int out) {
        input = in;
        output = out;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {"III", 3},
                {"IV", 4},
                {"IX", 9},
                {"LVIII", 58},
                {"MCMXCIV", 1994},
                {"I", 1},
                {"II", 2},
                {"III", 3},
                {"IV", 4},
                {"V", 5},
                {"VI", 6},
                {"VII", 7},
                {"VIII", 8},
                {"IX", 9},
                {"X", 10},
                {"XX", 20},
                {"XXX", 30},
                {"XL", 40},
                {"L", 50},
                {"LX", 60},
                {"LXX", 70},
                {"LXXX", 80},
                {"XC", 90},
                {"C", 100},
                {"MXI", 1011},
                {"MII", 1002}
        });
    }

    @Test
    public void testRomanToInteger() {
        System.out.println(String.format("input = %s, expected = %d, actual = %d",
                input, output, soln.romanToInteger(input)));
        assertEquals(output, soln.romanToInteger(input));
    }
}

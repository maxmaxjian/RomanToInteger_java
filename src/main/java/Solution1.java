
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class Solution1 implements Solution {
    @Override
    public int romanToInteger(String s) {

        Pattern pThousands = compile("M*");
        Pattern pHundreds = compile("M*(C[DM]|D?C*)");
        Pattern pTens = compile("M*(C[DM]|D?C*)(X[LC]|L?X*)");
        Pattern pOnes = compile("M*(C[DM]|D?C*)(X[LC]|L?X*)(I[VX]|V?I*)");
        String sThousands, sHundreds, sTens, sOnes;

        Matcher matcher_thousand = pThousands.matcher(s);
        Matcher matcher_hundred = pHundreds.matcher(s);
        Matcher matcher_ten = pTens.matcher(s);

        if (matcher_thousand.find()) {
            sThousands = matcher_thousand.group(0);
        } else {
            sThousands = "";
        }
        if (matcher_hundred.find()) {
            sHundreds = matcher_hundred.group(0);
        } else {
            sHundreds = "";
        }
        sHundreds = sHundreds.substring(sThousands.length());
        if (matcher_ten.find()) {
            sTens = matcher_ten.group(0);
        } else {
            sTens = "";
        }
        sTens = sTens.substring(sThousands.length()+sHundreds.length());
        sOnes = s.substring(sThousands.length()+sHundreds.length()+sTens.length());

        List<String> list = Arrays.asList(sThousands, sHundreds, sTens, sOnes);
        List<Unit> units = Arrays.asList(Unit.THOUSANDS, Unit.HUNDREDS, Unit.TENS, Unit.ONES);
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += digitToInt(list.get(i), units.get(i));
        }

        return result;
    }

    private int digitToInt(String s, Unit unit) {
        if (!unit.equals(Unit.THOUSANDS)) {
            char one = unit.one().charAt(0);
            char five = unit.five().charAt(0);
            char ten = unit.ten().charAt(0);

            String nine = new StringBuilder().append(one).append(ten).toString();
            String four = new StringBuilder().append(one).append(five).toString();
            String onetwothree = new StringBuilder().append(one).append('*').toString();

            int digit = 0;
            if (s.matches(compile(nine).pattern())) {
                digit = 9;
            } else if (s.matches(compile(four).pattern())) {
                digit = 4;
            } else if (s.matches(compile(onetwothree).pattern())) {
                digit = s.length();
            } else {
                digit = 4 + s.length();
            }
            switch (unit) {
                case ONES:
                    return digit;
                case TENS:
                    return 10 * digit;
                case HUNDREDS:
                    return 100 * digit;
                default:
                    return 1000 * digit;
            }
        } else {
            return s.length()*1000;
        }
    }
}

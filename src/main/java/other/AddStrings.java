package other;

public class AddStrings {
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i1 = num1.length()-1;
        int i2 = num2.length()-1;
        int remainder = 0;

        while (i1 >= 0 || i2 >= 0) {
            int arg1 = (i1 < 0 ? 0 : num1.charAt(i1) - '0');
            int arg2 = (i2 < 0 ? 0 : num2.charAt(i2) - '0');

            int sum = (arg1 + arg2 + remainder) % 10;
            remainder = (arg1 + arg2 + remainder) / 10;
            result.append(sum);

            i1--;
            i2--;
        }

        if (remainder > 0) {
            result.append(remainder);
        }
        return result.reverse().toString();
    }

}

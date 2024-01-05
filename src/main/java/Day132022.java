import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Day132022 {

    public static void main(String[] args) throws IOException {
        //part 1
        List<String> lines = Files.readAllLines(new File("src/main/Day132022.txt").toPath());
        String left;
        String right;
        int sum = 0;
        for (int i = 0; i <= lines.size(); i++) {
            left = lines.get(i);
            right = lines.get(i + 1);

            i++;
            i++;
            int pair = i / 3 + 1;
            boolean inOrder = tmp(left, right);
            if (inOrder) {
                sum += pair;
                System.out.println("yes: " + pair);
                System.out.println("sum: " + sum);
            } else {
                System.out.println("no: " + pair + " line " + i);
            }
        }
        System.out.println(sum);
    }

    public static boolean checkOrder(String left, String right) {
        int startLeft = 0;
        int startRight = 0;
        for (int i = startLeft; i < left.length(); i++) {
            for (int j = startRight; j < right.length(); j++) {
                if (left.charAt(i) == '[' && right.charAt(j) != '[') {
                    right = right.substring(0, j) + '[' + right.substring(j);
                }
                if (left.charAt(i) != '[' && right.charAt(j) == '[') {
                    left = left.substring(0, i) + '[' + left.substring(i);
                }
                if (left.charAt(i) == '[' && left.charAt(i + 1) == ']') {
                    return true;
                }
                if (right.charAt(j) == '[' && right.charAt(j + 1) == ']') {
                    return false;
                }

                int compare;
                if (left.charAt(i) == '1' && left.charAt(i + 1) == '0') {
                    compare = Integer.compare(10, Integer.parseInt(String.valueOf(right.charAt(j))));
                    i++;
                } else if (right.charAt(j) == '1' && right.charAt(j + 1) == '0') {
                    compare = Integer.compare(Integer.parseInt(String.valueOf(left.charAt(i))), 10);
                    startRight++;
                } else {
                    compare = Character.compare(left.charAt(i), right.charAt(j));
                }

                System.out.println("Compare =" + compare);
                if (compare < -48) {
                    return false;
                }
                if (compare < 0) {
                    return true;
                }
                if (compare > 0 && compare < 48) {
                    return false;
                }
                if (compare > 48) {
                    return true;
                }
                i++;
                startRight++;
            }
        }
        return false;
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static String getIntPrefix(String s) {
        String res = "";
        for (int i = 0; i < s.length() && isDigit(s.charAt(0)); i++) {
            res += s.charAt(0);
            s = s.substring(1);
        }
        return res;
    }

    public static boolean tmp(String left, String right) {
        if (left.isEmpty() && right.isEmpty()) {
            return false;
        }
        if (left.isEmpty() || right.isEmpty()) {
            throw new IllegalStateException("BUG");
        }
        if (left.startsWith(",")) {
            left = left.substring(1);
        }
        if (right.startsWith(",")) {
            right = right.substring(1);
        }
        if (isDigit(left.charAt(0)) && isDigit(right.charAt(0))) {
            String leftString = getIntPrefix(left);
            String rightString = getIntPrefix(right);
            int leftInt = Integer.parseInt(leftString);
            int rightInt = Integer.parseInt(rightString);
            if (leftInt > rightInt) {
                return false;
            }
            if (leftInt < rightInt) {
                return true;
            }
            return tmp(left.substring(leftString.length()), right.substring(rightString.length()));
        }
        if (left.charAt(0) == ']' && right.charAt(0) == ']') {
            // Fine, both lists equally long
            return tmp(left.substring(1), right.substring(1));
        }
        if (right.charAt(0) == ']') {
            // Left list longer, false
            return false;
        }
        if (left.charAt(0) == ']') {
            return true;
        }
        if (isDigit(left.charAt(0))) {
            // 7xxxxxxx -> [7]xxxxxxx
            String leftString = getIntPrefix(left);
            left = "[" + leftString + "]" + left.substring(leftString.length());
        }
        if (isDigit(right.charAt(0))) {
            String rightString = getIntPrefix(right);
            right = "[" + rightString + "]" + right.substring(rightString.length());
        }
        return tmp(left.substring(1), right.substring(1));
    }
}
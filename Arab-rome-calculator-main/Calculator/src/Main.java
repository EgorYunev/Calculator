import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        String value1 = null;
        String value2 = null;
        String result = null;
        String op = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение (без пробелов!)");
        String input = scanner.next();
        String[] parts = input.split("[+\\-*/]");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Error");
        }
        op = detectOperatinon(input);
        value1 = parts[0];
        value2 = parts[1];
            int valueInt1 = 0;
            int valueInt2 = 0;
            String valueRim1 = value1;
            String valueRim2 = value2;
            String[] rome = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
            String[] arab = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                    "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37",
                    "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56",
                    "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75",
                    "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94",
                    "95", "96", "97", "98", "99", "100"};
            int k;
            int l;
            for (k = 0; k <= 9; ++k) {
                for (l = 0; l <= 9; ++l) {
                    if (value1.equals(rome[k]) && value2.equals(rome[l])) {
                        value1 = arab[k];
                        value2 = arab[l];
                        valueInt1 = Integer.parseInt(value1);
                        valueInt2 = Integer.parseInt(value2);
                    } else if (value1.equals(arab[k]) && value2.equals(arab[l])) {
                        valueInt1 = Integer.parseInt(value1);
                        valueInt2 = Integer.parseInt(value2);
                    }
                }
            }

            if (valueInt1 > 0 && valueInt1 <= 10 && valueInt2 > 0 && valueInt2 <= 10) {
                if (op.equals("+")) {
                    result = String.valueOf(valueInt1 + valueInt2);
                }

                if (op.equals("-")) {
                    result = String.valueOf(valueInt1 - valueInt2);
                }

                if (op.equals("*")) {
                    result = String.valueOf(valueInt1 * valueInt2);
                }

                if (op.equals("/")) {
                    result = String.valueOf(valueInt1 / valueInt2);
                }

                if (Integer.parseInt(result) > 0) {
                    for (k = 0; k <= 9; ++k) {
                        for (l = 0; l <= 9; ++l) {
                            if (valueRim1.equals(rome[k]) && valueRim2.equals(rome[l])) {
                                result = rome[Integer.parseInt(result) - 1];
                            }
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Error");
                }
            } else {
                throw new IllegalArgumentException("Error");
            }

            System.out.println(result);
        }
    static String detectOperatinon(String parts) {
        if (parts.contains("+")) return "+";
        else if (parts.contains("-")) return "-";
        else if (parts.contains("*")) return  "*";
        else if (parts.contains("/")) return "/";
        else return null;
    }
}


package turing;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] array1) {
        if (array1 == null || array1.length == 0) {
            return "";
        }
        String prefix = array1[0];

        for (int i = 1; i < array1.length; i++) {

            while (array1[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}

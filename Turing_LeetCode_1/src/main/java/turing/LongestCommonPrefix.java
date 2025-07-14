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


    // Ve yaxud....
    public static String longestCommonPrefixx(String[] array1) {

        if (array1 == null || array1.length == 0 || array1[0].isEmpty()) return "";

        String prefix = "";
        int index = 0;
        while (true) {
            if (index >= array1[0].length()) return prefix;

            int counter = 0;
            char current = array1[0].charAt(index);

            for (int i = 0; i < array1.length; i++) {
                if (index >= array1[i].length() || array1[i].charAt(index) != current) {
                    return prefix;
                }
                counter++;
            }

            if (counter == array1.length) {
                prefix += current;
                index++;
            } else {
                return prefix;
            }

        }


    }

}

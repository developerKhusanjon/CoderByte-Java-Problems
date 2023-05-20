package dev.khusanjon.easy;

import java.util.Arrays;

public class AlphabetSoup {
    static String alphabetSoup(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.copyValueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(alphabetSoup("hello"));
    }
}

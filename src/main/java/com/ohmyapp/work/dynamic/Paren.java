package com.ohmyapp.work.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 4/2/2017.
 */
public class Paren {
    public static List<String> addParen(int number) {
        List<String> strings = new ArrayList<>();
        build(strings, number, number, new char[number * 2], 0);
        return strings;
    }

    private static void build(List<String> strings, int left, int right, char[] array, int index) {
        if (left < 0 || right < left) {
            return;
        }
        if (left == 0 && right == 0) {
            strings.add(new String(array));
            return;
        }
        array[index] = '(';
        build(strings, left - 1, right, array, index + 1);
//        if (left > right) {
//            return;
//        }
        array[index] = ')';
        build(strings, left, right - 1, array, index + 1);
    }
}

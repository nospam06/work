package com.ohmyapp.work.dynamic;

import java.util.Stack;

/**
 * Created by on 4/1/2017.
 */
public class Fab {
    public static long fab(int number) {
        long[] prevResult = new long[number + 2];
        prevResult[0] = 0;
        prevResult[1] = 1;
        recurse(number, prevResult);
        return prevResult[number];
    }

    private static long recurse(int number, long[] prevResult) {
        if (number > 1) {
            prevResult[number - 1] = recurse(number - 1, prevResult);
            prevResult[number] = prevResult[number - 1] + prevResult[number - 2];
        }
        return prevResult[number];
    }

    public static long fabWithStack(int number) {
        long[] prevResult = new long[number + 2];
        prevResult[0] = 0L;
        prevResult[1] = 1L;
        //push
        Stack<Integer> stack = new Stack<>();
        for (int current = number; current > 1; --current) {
            stack.push(current);
        }
        // pop
        while (!stack.isEmpty()) {
            int current = stack.pop();
            prevResult[current] = prevResult[current - 1] + prevResult[current - 2];
        }
        return prevResult[number];
    }
}

package com.ohmyapp.work.dynamic;

import org.junit.Test;

import java.util.List;

/**
 * Created 4/2/2017.
 */
public class ParenTest {
    @Test
    public void addParen() throws Exception {
        List<String> strings = Paren.addParen(18);
        System.out.println("# of combination = " + strings.size());
        //System.out.println(strings);
    }
}
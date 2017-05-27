package com.ohmyapp.work.dynamic;

import org.junit.Test;

/**
 * Created by Emerald on 4/1/2017.
 */
public class FabTest {
    @Test
    public void fab() throws Exception {
        for (int i = 0; i < 35000; ++i) {
            System.out.println(i + " = " + Fab.fab(i));
        }
    }

    @Test
    public void fabWithStack() throws Exception {
        for (int i = 0; i < 35000; ++i) {
            System.out.println(i + " = " + Fab.fabWithStack(i));
        }
    }
}
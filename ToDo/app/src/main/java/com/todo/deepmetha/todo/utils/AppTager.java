package com.todo.deepmetha.todo.utils;

/**
 * Created by deepmetha on 8/28/16.
 */
public class AppTager {

    public static String getTag() {
        String tag = "";
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        for (int i = 0; i < ste.length; i++) {
            if (ste[i].getMethodName().equals("getTag")) {
                tag = "("+ste[i + 1].getFileName() + ":" + ste[i + 1].getLineNumber()+")";
            }
        }
        return tag;
    }

}

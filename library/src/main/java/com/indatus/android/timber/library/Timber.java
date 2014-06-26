package com.indatus.android.timber.library;
//  Created by jonstaff on 6/26/14.

import android.util.Log;

public class Timber {

    private static String sClass;
    private static String sMethod;
    private static int sLine;

    private Timber() {
        // Disallow instantiation
    }

    public static <T> void v(T... args) {
        if (BuildConfig.DEBUG) {
            configureClassInfo();
            Log.v(sClass, generateString(args));
        }
    }

    public static <T> void d(T... args) {
        if (BuildConfig.DEBUG) {
            configureClassInfo();
            Log.d(sClass, generateString(args));
        }
    }

    public static <T> void i(T... args) {
        configureClassInfo();
        Log.i(sClass, generateString(args));
    }

    public static <T> void w(T... args) {
        configureClassInfo();
        Log.w(sClass, generateString(args));
    }

    public static <T> void e(T... args) {
        configureClassInfo();
        Log.e(sClass, generateString(args));
    }

    public static <T> void wtf(T... args) {
        configureClassInfo();
        Log.wtf(sClass, generateString(args));
    }

    private static void configureClassInfo() {
        final StackTraceElement[] elements = new Throwable().getStackTrace();
        sClass = elements[1].getClassName();
        sMethod = elements[1].getMethodName();
        sLine = elements[1].getLineNumber();
    }

    private static <T> String generateString(T... args) {
        final StringBuilder sb = new StringBuilder("[" + sMethod + ":" + sLine + "] ");
        for (T obj : args) {
            sb.append(obj);
        }
        return sb.toString();
    }
}

package com.indatus.android.timber.library;
//  Created by jonstaff on 6/26/14.

import android.util.Log;

public class Timber {

    private static String sClass;
    private static String sMethod;
    private static int sLine;

    //   ____                _                   _
    //  / ___|___  _ __  ___| |_ _ __ _   _  ___| |_ ___  _ __
    // | |   / _ \| '_ \/ __| __| '__| | | |/ __| __/ _ \| '__|
    // | |___ (_) | | | \__ \ |_| |  | |_| | (__| |_ (_) | |
    //  \____\___/|_| |_|___/\__|_|   \__,_|\___|\__\___/|_|
    //

    private Timber() {
        // Disallow instantiation
    }

    //  ____        _     _ _        __  __      _   _               _
    // |  _ \ _   _| |__ | (_) ___  |  \/  | ___| |_| |__   ___   __| |___
    // | |_) | | | | '_ \| | |/ __| | |\/| |/ _ \ __| '_ \ / _ \ / _` / __|
    // |  __/| |_| | |_) | | | (__  | |  | |  __/ |_| | | | (_) | (_| \__ \
    // |_|    \__,_|_.__/|_|_|\___| |_|  |_|\___|\__|_| |_|\___/ \__,_|___/
    //

    /**
     * Logs the provided params with log level VERBOSE.  If passing in multiple Strings, separating
     * them with a comma will improve performance.
     *
     * @param args comma separated list of Strings to print
     * @param <T>
     */
    public static <T> void v(T... args) {
        if (BuildConfig.DEBUG) {
            configureClassInfo();
            Log.v(sClass, generateString(args));
        }
    }

    /**
     * Logs the provided params with log level DEBUG.  If passing in multiple Strings, separating
     * them with a comma will improve performance.
     *
     * @param args comma separated list of Strings to print
     * @param <T>
     */
    public static <T> void d(T... args) {
        if (BuildConfig.DEBUG) {
            configureClassInfo();
            Log.d(sClass, generateString(args));
        }
    }

    /**
     * Logs the provided params with log level INFO.  If passing in multiple Strings, separating
     * them with a comma will improve performance.
     *
     * @param args comma separated list of Strings to print
     * @param <T>
     */
    public static <T> void i(T... args) {
        configureClassInfo();
        Log.i(sClass, generateString(args));
    }

    /**
     * Logs the provided params with log level WARN.  If passing in multiple Strings, separating
     * them with a comma will improve performance.
     *
     * @param args comma separated list of Strings to print
     * @param <T>
     */
    public static <T> void w(T... args) {
        configureClassInfo();
        Log.w(sClass, generateString(args));
    }

    /**
     * Logs the provided params with log level ERROR.  If passing in multiple Strings, separating
     * them with a comma will improve performance.
     *
     * @param args comma separated list of Strings to print
     * @param <T>
     */
    public static <T> void e(T... args) {
        configureClassInfo();
        Log.e(sClass, generateString(args));
    }

    /**
     * Logs the provided params with log level WTF.  If passing in multiple Strings, separating
     * them with a comma will improve performance.
     *
     * @param args comma separated list of Strings to print
     * @param <T>
     */
    public static <T> void wtf(T... args) {
        configureClassInfo();
        Log.wtf(sClass, generateString(args));
    }

    //  ____       _            _         __  __      _   _               _
    // |  _ \ _ __(_)_   ____ _| |_ ___  |  \/  | ___| |_| |__   ___   __| |___
    // | |_) | '__| \ \ / / _` | __/ _ \ | |\/| |/ _ \ __| '_ \ / _ \ / _` / __|
    // |  __/| |  | |\ V / (_| | |_  __/ | |  | |  __/ |_| | | | (_) | (_| \__ \
    // |_|   |_|  |_| \_/ \__,_|\__\___| |_|  |_|\___|\__|_| |_|\___/ \__,_|___/
    //

    /**
     * Internal helper method to set the class name, method name, and line number where Timber was
     * called.
     */
    private static void configureClassInfo() {
        final StackTraceElement[] elements = new Throwable().getStackTrace();
        sClass = elements[2].getClassName();
        sMethod = elements[2].getMethodName();
        sLine = elements[2].getLineNumber();
    }

    /**
     * Internal helper method to generate the actual string that will be logged.
     *
     * @param args comma separated list of Strings to print
     * @param <T>
     *
     * @return the String to be logged
     */
    private static <T> String generateString(T... args) {
        final StringBuilder sb = new StringBuilder("[" + sMethod + ":" + sLine + "] ");
        for (T obj : args) {
            sb.append(obj);
        }
        return sb.toString();
    }
}

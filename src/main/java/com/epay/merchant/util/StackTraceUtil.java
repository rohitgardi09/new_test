package com.epay.merchant.util;

public class StackTraceUtil {

    public static String getShortStackTrace(Throwable ex) {
        StringBuilder sb = new StringBuilder();
        sb.append(ex.getMessage()).append("\n");
        StackTraceElement[] elements = ex.getStackTrace();
        int limit = Math.min(elements.length, 10);
        for (int i = 0; i < limit; i++)
        {
            sb.append(elements[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
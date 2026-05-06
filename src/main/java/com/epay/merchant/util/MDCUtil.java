package com.epay.merchant.util;

import java.util.Map;

public class MDCUtil {
    public static String getIgnoreCase(
            Map<String, String> map,
            String... keys) {
        if (map == null) {
            return "";
        }
        for (String key : keys) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(key)) {
                    return entry.getValue();
                }
            }
        }
        return "";
    }
}
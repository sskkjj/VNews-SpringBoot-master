package com.mobine.vnews.util;

import java.util.UUID;

/**
 * @author Create by xuantang
 * @date on 12/9/17
 */
public class IdUtils {
    /**
     * Get id
     * @return
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "").substring(0, 20);
        return uuidStr;
    }

    public static void main(String[] args) {
        for (int index = 0; index < 10; index++){
            System.out.println(getUUID());
        }

    }
}

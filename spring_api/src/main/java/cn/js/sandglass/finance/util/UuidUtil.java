package cn.js.sandglass.finance.util;

import java.util.UUID;

public class UuidUtil {
    public static String get() {
        String uuid = UUID.randomUUID().toString();    //转化为String对象
        uuid = uuid.replace("-", "");   //因为UUID本身为32位只是生成时多了“-”，所以将它们去点就可
        return uuid;
    }
}

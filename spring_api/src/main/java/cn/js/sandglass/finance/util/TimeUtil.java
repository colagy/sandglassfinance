package cn.js.sandglass.finance.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static Timestamp timestampStrToTimestamp(String timestampStr) {
        Long timestampLong = Long.parseLong(timestampStr);
        return new Timestamp(timestampLong);
    }

    public static Timestamp timestampLongToTimestamp(Long timestampLong) {
        return new Timestamp((timestampLong));
    }

    public static Date stampToDate(Timestamp timestamp) {
        Date date = timestamp;
        return date;
    }

    public static Date timestampStrToDate(String timestampStr) {
        return timestampStrToTimestamp(timestampStr);
    }

    public static String dateToDateStr(Date date) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //Date转String时，这里的格式随意
        return sdf.format(date);
    }

    public static String timestampStrToDateStr(String timestampStr) {
        Date date = timestampStrToTimestamp(timestampStr);
        return dateToDateStr(date);
    }

    public static String timestampLongToDateStr(Long timestampLong) {
        Date date = timestampLongToTimestamp(timestampLong);
        return dateToDateStr(date);
    }

}

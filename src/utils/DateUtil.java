package utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * Creat by lijie on 2019/3/25
 * 时间工具类
 */
public class DateUtil {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println(getMonthStart(date));
        System.out.println(getMonthEnd(date));

        String str = "1986-04-08 12:30";
        String format = "yyyy-MM-dd HH:mm";
        System.out.println(strToDate(str, format));

        System.out.println(dateFormatToStr(date, "yyyy-MM-dd HH:mm"));

        System.out.println(getMonth(date));
    }

    /**
     * LocalDate转换为Date
     * @param localDate
     * @return
     */
    public static Date localDateToDate(LocalDate localDate){
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(zoneId);
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * LocalDateTime转换为Date
     * @param localDateTime
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime){
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * Date转换为LocalDate
     * @param date
     * @return
     */
    public static LocalDate dateToLocalDate(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    /**
     * Date转换为LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }
    /**
     * 获取本月第一天
     * @param date
     * @return
     */
    public static Date getMonthStart(Date date){
        LocalDate localDate = dateToLocalDate(date);
        return localDateToDate(localDate.with(TemporalAdjusters.firstDayOfMonth()));
    }

    /**
     * 获取本月最后一天
     * @param date
     * @return
     */
    public static Date getMonthEnd(Date date){
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        return localDateTimeToDate(localDateTime.with(TemporalAdjusters.lastDayOfMonth()));
    }

    /**
     * 根据字符串创建Date
     * @param string
     * @return
     */
    public static Date strToDate(String string, String format){
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime localDateTime = LocalDateTime.parse(string, timeFormatter);
        return localDateTimeToDate(localDateTime);
    }

    /**
     * 将日期按照格式转换为字符串
     * @param date
     * @param format
     */
    public static String  dateFormatToStr(Date date, String format){
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        return df.format(localDateTime);
    }

    /**
     * 获取日期所在的月份
     * @param date
     * @return
     */
    public static int getMonth(Date date){
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        Month month = localDateTime.getMonth();
        return month.getValue();
    }

}

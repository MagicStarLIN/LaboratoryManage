package com.lcl.labmanage.utils;





import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.time.*;
import java.util.*;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: DateUtils
 * @Description: 时间操作工具类
 * @date 2019/10/25 11:06 上午
 */
public class DateUtils {
    public static final SimpleDateFormat EXACTSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final SimpleDateFormat FUZSDF = new SimpleDateFormat("yyyy-MM-dd");

    public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM");

    public static final DateTimeFormatter LDTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static final DateTimeFormatter LTDTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static final String dateStartStr = " 00:00:00";

    public static final String dateEndStr = " 23:59:59";

    public static final String monthStart = "-01";

    public static final String monthEnd = "-31";

    public static YearMonth getYearMonth(String date) {
        return YearMonth.parse(date, DTF);
    }

    public static LocalDate getLocalDate(String date) {
        return LocalDate.parse(date, LDTF);
    }

    public static LocalDateTime getLocalDateTime(String time) {
        return LocalDateTime.parse(time, LTDTF);
    }

    public static LocalDate getLocalDate(long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDate();
    }

    public static long getTimeStamp(LocalDate localDate) {
        return localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
    }



    public static String getNowFormatDateStr() {
        return EXACTSDF.format(new Date());
    }

    public static String getFormatDateStr(Long timestmp) {
        if (timestmp == null) {
            return "";
        }
        return EXACTSDF.format(new Date(timestmp));
    }

    public static Date getFormatDate(Date date) {
        if (date == null) {
            return new Date();
        }
        Date parse;
        try {
            String format = EXACTSDF.format(new Date());
            parse = EXACTSDF.parse(format);
        } catch (Exception e) {
            e.printStackTrace();
            parse = new Date();
        }

        return parse;
    }

    /**
     * 返回 指定格式的日期字符串
     *
     * @param timestmp dateFormat
     * @return format date String
     */
    public static String getFormatDateStr(Long timestmp, SimpleDateFormat SDF) {
        if (timestmp == null) {
            return "";
        }
        return SDF.format(new Date(timestmp));
    }


    public static String getFormatDateStrBitAdd(Long timestmp, SimpleDateFormat SDF) {
        if (timestmp == null) {
            return "";
        }
        return SDF.format(new Date(timestmp * 1000));
    }

    /**
     * java.util.Date 返回 yyyy-MM-dd String 类型
     *
     * @param date
     * @return format date String
     */
    public static String getFormatDateStr(Date date) {
        if (date == null) {
            return "";
        }
        return EXACTSDF.format(date);
    }


    /**
     * 返回 指定格式的日期字符串
     *
     * @param date dateFormat(例如 yyyy-MM-dd)
     * @return format date String
     */
    public static String getFormatDateStr(Date date, String dateFormat) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat SDF = new SimpleDateFormat(dateFormat);
        return SDF.format(date);
    }


    /**
     * java.lang.Integer Epoch 返回 yyyy-MM-dd String 类型
     *
     * @param num
     * @return format date String
     */
    public static String getFormatEpochStr(int num) {
        long time = num * 1000L;
        return EXACTSDF.format(new Date(time));
    }

    /**
     * yyyy-MM-dd 返回 java.util.Date
     * 不会返回null, 产生异常时返回当前时间的Date对象的实例
     *
     * @param formatStr
     * @return
     */
    public static Date parseDateFromDateStr(String formatStr) {
        Date date;
        try {
            date = EXACTSDF.parse(formatStr);
        } catch (Exception exp) {
            date = new Date();
        }
        return date;
    }

    /**
     * 获取自昨天12点到今天12点的int类型
     *
     * @return {昨天12点epoch_int, 今天12点epoch_int}
     */
    public static int[] getDate() {
        Calendar calendar = getCalendar();
        int[] res = new int[2];
        res[1] = (int) (calendar.getTimeInMillis() / 1000);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        res[0] = (int) (calendar.getTimeInMillis() / 1000);
        return res;
    }

    /**
     * 获取yyyy-MM-dd 形式的前后日期时间
     * [0] prev_day [1] current day
     *
     * @param formatDate
     * @return
     */
    public static int[] getDate(String formatDate) {
        Calendar calendar = getCalendar();
        String[] dateStr = formatDate.split("-");
        calendar.set(Integer.valueOf(dateStr[0]), Integer.valueOf(dateStr[1]) - 1, Integer.valueOf(dateStr[2]));
        int[] res = new int[2];
        res[1] = (int) (calendar.getTimeInMillis() / 1000);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        res[0] = (int) (calendar.getTimeInMillis() / 1000);
        return res;
    }

    /**
     * 获取某一天的上一天 12点到当天12点的int类型
     *
     * @return {上一天12点epoch_int, 当天12点epoch_int}
     */
    public static int[] getBetweenDate(int n) {
        Calendar calendar = getCalendar();
        int[] res = new int[2];
        calendar.add(Calendar.DAY_OF_YEAR, 0 - n);
        res[1] = (int) (calendar.getTimeInMillis() / 1000);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        res[0] = (int) (calendar.getTimeInMillis() / 1000);
        return res;
    }



    private static Calendar getCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar;
    }

    /**
     * 比较两个时间的大小
     */
    public static int compareDate(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }


    /**
     * 将字符串时间格式转换成Date时间格式，参数String类型
     * 比如字符串时间："2017-12-15 21:49:03"
     * 转换后的date时间：Fri Dec 15 21:49:03 CST 2017
     *
     * @param datetime 类型为String
     * @return
     */
    public static Date StringToDate(String datetime, SimpleDateFormat sdFormat) {
//        SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        try {
            date = sdFormat.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public static Long getYesterTodayStartTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) - 1, 0, 0, 0);
        long tt = calendar.getTime().getTime() / 1000;
        return tt;

    }

    public static Long getYesterTodayEndTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) - 1, 0, 0, 0);
        long tt = calendar.getTime().getTime() / 1000;
        return tt + 86399;
    }

    /**
     * 判断给定日期是否为月末的一天
     *
     * @param date
     * @return true:是|false:不是
     */
    public static boolean isLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + 1));
        if (calendar.get(Calendar.DAY_OF_MONTH) == 1) {
            return true;
        }
        return false;
    }





    public static Long str2TimeStamp(String time, SimpleDateFormat format) {
        if (time == null) {
            return null;
        }
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //日期转时间戳（秒）
        return date.getTime() / 1000;
    }



    /**
     * @Title getTodayStartTime
     * @Description 获取今天开始时间
     * @Author liuchanglin
     * @Date 2020/4/7 5:30 下午
     * @Param []
     * @return java.lang.String
     **/
    public static String getTodayStartTime() {
        LocalDate nowDate = LocalDate.now();
        //设置零点
        LocalDateTime beginTime = LocalDateTime.of(nowDate,LocalTime.MIN);

        return beginTime.format(LTDTF);
    }

    /**
     * @Title getTodayEndTime
     * @Description 获取今天结束时间
     * @Author liuchanglin
     * @Date 2020/4/7 5:33 下午
     * @Param []
     * @return java.lang.String
     **/
    public static String getTodayEndTime() {
        //获取当前日期
        LocalDate nowDate = LocalDate.now();
        LocalDateTime endTime = LocalDateTime.of(nowDate,LocalTime.MAX);
        return LTDTF.format(endTime);
    }

    public static String getCurrentTime() {
        return getFormatDateStr(System.currentTimeMillis());
    }
}

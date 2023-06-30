package com.hronline.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author thanglv on 4/10/2022
 * @project recruiter-api
 */
public class DateUtils {
    public static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static LocalDateTime toDate(String date) {
        if (date == null) {
            return null;
        }
        var formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
        return LocalDateTime.parse(date, formatter);
    }

    public static String fromDate(LocalDateTime date) {
        if (date == null) {
            return null;
        }
        var formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
        return formatter.format(date);
    }

    public static LocalDateTime toDate(String date, String format) {
        if (date == null) {
            return null;
        }
        var formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(date, formatter);
    }

    public static String fromDate(LocalDateTime date, String format) {
        if (date == null) {
            return null;
        }
        var formatter = DateTimeFormatter.ofPattern(format);
        return formatter.format(date);
    }
}

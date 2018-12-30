package com.app.platform.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class DateUtil {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);


    private DateUtil() {
    }

    public static Date toUtilDate(String string) {

        try {
            synchronized (SIMPLE_DATE_FORMAT) {
                return SIMPLE_DATE_FORMAT.parse(string);
            }
        } catch (ParseException e) {
            LOGGER.error("String cast to date error", e);
        }
        return null;
    }

    public static Date toUtilDate(Instant instant) {
        return Date.from(instant);
    }

    public static Date toUtilDate(LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return toUtilDate(instant);
    }

    public static LocalDateTime toLocalDateTime(Instant instant) {
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return toLocalDateTime(date.toInstant());
    }

    public static Date toUtilDate(java.sql.Date sqlDate) {
        return sqlDate == null
                ? null
                : new Date(sqlDate.getTime());
    }

    public static Date toUtilDate(Timestamp timestamp) {
        return timestamp == null
                ? null
                : new Date(timestamp.getTime());
    }

    public static java.sql.Date toSqlDate(Date utilDate) {
        return utilDate == null
                ? null
                : new java.sql.Date(utilDate.getTime());
    }

    public static java.sql.Date toSqlDate(LocalDateTime localDateTime) {
        return localDateTime == null
                ? null
                : new java.sql.Date(localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }

    public static String toString(Date utilDate) {
        synchronized (SIMPLE_DATE_FORMAT) {
            return SIMPLE_DATE_FORMAT.format(utilDate);
        }
    }

    public static LocalDate toLocalDate(java.sql.Date sqlDate) {
        return sqlDate == null
                ? null
                : sqlDate.toLocalDate();
    }

    public static LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return timestamp == null
                ? null
                : timestamp.toLocalDateTime();
    }

    public static Instant toInstant(Timestamp timestamp) {
        return timestamp == null
                ? null
                : timestamp.toInstant();
    }

    public static Instant toInstant(LocalDateTime localDateTime) {
        return localDateTime == null
                ? null
                : localDateTime.toInstant(ZoneOffset.UTC);
    }

    public static String toString(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(formatter);
    }

    public static Timestamp toTimestamp(Instant instant) {
        return instant == null
                ? null
                : Timestamp.from(instant);
    }
}

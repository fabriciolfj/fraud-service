package com.github.fabriciolfj.fraud.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatedUtil {


    public static LocalDateTime ToLocalDateTime(final String value) {
        var patter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return LocalDateTime.parse(value, patter);
    }
}

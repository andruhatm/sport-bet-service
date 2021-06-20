package ru.student.data.formatter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * преобразование даты
 */
public class TimestampFormatter {
  public String format(Timestamp timestamp){
    return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(timestamp);
  }
}

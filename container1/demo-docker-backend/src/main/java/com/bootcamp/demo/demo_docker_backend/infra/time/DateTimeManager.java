package com.bootcamp.demo.demo_docker_backend.infra.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeManager {

  private Format format;

  public DateTimeManager(Format format) {
    this.format = format;
  }

  public static LocalDateTime unixToHK(Long unixTime) {
    return new DateTimeManager(UNIX.TO_HONG_KONG).getLocalDateTime(unixTime);
  }

  public LocalDateTime getLocalDateTime(Long unixTime) {
    if (format instanceof UNIX && unixTime == null)
      throw new IllegalArgumentException();
    ZoneId zoneId = ZoneId.systemDefault();
    if (format == UNIX.TO_HONG_KONG) {
      zoneId = ZoneId.of("Asia/Hong_Kong");
    }
    return LocalDateTime.ofInstant(Instant.ofEpochSecond(unixTime), zoneId);
  }
}

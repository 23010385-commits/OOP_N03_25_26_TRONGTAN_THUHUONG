package com.guitar.management.model;

import java.time.LocalTime;
import java.time.Duration;

public class Time {

  private LocalTime start;
  private LocalTime end;

  public Time(LocalTime start, LocalTime end) {
    this.start = start;
    this.end = end;
  }

  public long calculateDurationInMinutes() {
    return Duration.between(start, end).toMinutes();
  }

  public void displayTime() {
    System.out.println("Start: " + start + " | End: " + end);
  }
}

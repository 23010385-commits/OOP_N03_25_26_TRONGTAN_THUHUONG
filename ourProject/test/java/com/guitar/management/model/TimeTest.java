package com.guitar.management.model;

public class TimeTest {

  @Test
  public void testCalculateDurationInMinutes() {
    Time time = new Time(LocalTime.of(10, 0), LocalTime.of(11, 30));
    long duration = time.calculateDurationInMinutes();
    assertEquals(90, duration);
  }

  @Test
  public void testDisplayTime() {
    Time time = new Time(LocalTime.of(10, 0), LocalTime.of(11, 30));
    time.displayTime();
    // Manually verify the output
  }
}

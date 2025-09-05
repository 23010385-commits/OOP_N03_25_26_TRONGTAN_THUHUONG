public class Time {
    private int hour;
    private int minute;
    private int second;


    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        normalizeTime();
    }


    private void normalizeTime() {
        if (second >= 60) {
            minute += second / 60;
            second = second % 60;
        }
        if (minute >= 60) {
            hour += minute / 60;
            minute = minute % 60;
        }
        if (hour >= 24) {
            hour = hour % 24;
        }
    }

    public void displayTime() {
        System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
    }
}

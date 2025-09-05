public class TestTime {
    public static void main(String[] args) {
        Time t1 = new Time(2, 59, 70);  // 2h 59m 70s
        t1.displayTime();

        Time t2 = new Time(23, 120, 500); // 23h 120m 500s
        t2.displayTime();
    }
}

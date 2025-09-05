public class App {
    public static void main(String[] args) {
        System.out.println("Hello World");


        int n = 10;
        long startTime = System.nanoTime();
        int result = factorial(n);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("factorial(" + n + ") = " + result);
        System.out.println("User time (nanoseconds): " + duration);


    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}

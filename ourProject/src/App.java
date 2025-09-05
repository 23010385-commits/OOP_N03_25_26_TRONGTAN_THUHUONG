public class App {
    public static void main(String[] args) {
        System.out.println("===== RUNNING TESTS =====");

        // Gọi TestUser
        System.out.println("\n--- Test User ---");
        TestUser.main(null);

        // Gọi TestTime
        System.out.println("\n--- Test Time ---");
        TestTime.main(null);

        // Gọi TestRecursion
        System.out.println("\n--- Test Recursion ---");
        TestRecursion.main(null);
    }
}

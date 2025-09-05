public class TestUser {
    public static void main(String[] args) {
        User u1 = new User("Nguyen Van A", 20, "a@gmail.com");
        u1.displayInfo();

        u1.setAge(22);
        u1.setEmail("new_a@gmail.com");

        System.out.println("Sau khi cập nhật:");
        u1.displayInfo();
    }
}

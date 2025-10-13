package ourProject.test.java.com.guitar.management.model;
import ourProject.src.main.java.com.guitar.management.model.Lesson;

public class LessonTest {
    public static void main(String[] args) {
        // Tạo bài học mới
        Lesson lesson = new Lesson(1, "Guitar Basics", "Learn the basics of guitar", 60);

        // Hiển thị thông tin bài học
        System.out.println("=== Test Lesson ===");
        lesson.showInfo();

        // Test phương thức Batdau
        lesson.Batdau();

        // Test phương thức Luyentap
        lesson.Luyentap();

        // Test phương thức Hoanthanh
        lesson.Hoanthanh();
    }
}
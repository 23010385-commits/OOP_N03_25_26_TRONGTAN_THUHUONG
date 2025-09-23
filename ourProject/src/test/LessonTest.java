package test;
import models.Lesson;

public class LessonTest {

    public static void test(){

        Lesson l1 = new Lesson(1, "Gioi thieu ve dan guitar",  "Ten, Cac bo phan cua dan", 30);
    

        System.out.println("Thong tin bai hoc ban dau:");
        System.out.println(l1);

        l1.setTitle("GUITAR");
        l1.setNoiDung("Mo dau");
        l1.setThoiLuong(60);

        System.out.println("Thong tin bai hoc sau khi chinh sua:");
        System.out.println(l1);

    }
    
}

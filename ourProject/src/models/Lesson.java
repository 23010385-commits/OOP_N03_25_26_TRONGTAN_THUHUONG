package models;

public class Lesson {

    // thuộc tính - biến thành viên
    private int lessonID;
    private String title;
    private String noiDung;
    private int thoiLuong;

    // hàm tạo - để khởi tạo Lesson khi tạo đối tượng mới
    public Lesson(int id, String title, String nd, int thoiLuong){
        this.lessonID = id;
        this.title = title;
        this.noiDung = nd;
        this.thoiLuong = thoiLuong;
    }

    public int getLessonID(){
        return lessonID;
    }

    public void setLessonID( int lessonID){
        this.lessonID = lessonID;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle( String title){
        this.title = title;
    }

    public String getNoiDung(){
        return noiDung;
    }

    public void setNoiDung(String noiDung){
        this.noiDung = noiDung;
    }

    public int getThoiLuong(){
        return thoiLuong;
    }

    public void setThoiLuong( int thoiLuong){
        this.thoiLuong = thoiLuong;
    }

    public void showInfo(){
        System.out.println("ID: " + lessonID);
        System.out.println("Tieu de: " + title);
        System.out.println("Noi dung: " + noiDung);
        System.out.println("Thoi luong: " + thoiLuong + " phut");
        System.out.println();
    }

    @Override
public String toString() {
    return "Lesson{" +
            "ID=" + lessonID +
            ", Title='" + title + '\'' +
            ", Noi dung='" + noiDung + '\'' +
            ", Thoi luong=" + thoiLuong + " phut" +
            '}';
}

}

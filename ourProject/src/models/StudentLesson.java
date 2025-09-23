import java.util.Date;
import models.Lesson;
import models.KhoaHoc;
import models.HocVien;
import models.GiaoVien;

public class StudentLesson {
    private int id;
    private HocVien hocVien;
    private Lesson lesson;
    private Date ngayHoc;
    private String trangThai; // vd: "Dang hoc", "Hoan thanh"

    public StudentLesson(int id, HocVien hocVien, Lesson lesson, Date ngayHoc, String trangThai) {
        this.id = id;
        this.hocVien = hocVien;
        this.lesson = lesson;
        this.ngayHoc = ngayHoc;
        this.trangThai = trangThai;
    }

    public int getId() { return id; }
    public HocVien getHocVien() { return hocVien; }
    public Lesson getLesson() { return lesson; }
    public Date getNgayHoc() { return ngayHoc; }
    public String getTrangThai() { return trangThai; }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "StudentLesson{" +
                "id=" + id +
                ", hocVien=" + hocVien.getTen() +
                ", lesson=" + lesson.getTitle() +
                ", ngayHoc=" + ngayHoc +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}

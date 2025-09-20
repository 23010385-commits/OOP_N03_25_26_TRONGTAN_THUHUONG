package models;

public class Teaching {
    private GiaoVien giaovien;
    private KhoaHoc khoahoc;
    private List<Lesson> baihocs;

    public Teaching(GiaoVien giaovien, KhoaHoc khoahoc) {
        this.giaovien = giaovien;
        this.khoahoc = khoahoc;
        this.baihocs = new ArrayList<>();
    }

    // CRUD cho bài học trong Teaching
    public void addBaihoc(Lesson baihoc) {
        baihocs.add(baihoc);
    }

    public void removeBaihoc(int id) {
        baihocs.removeIf(b -> b.getLessonID() == id);
    }

    public void updateBaihoc(int id, String newTen) {
        for (Lesson b : baihocs) {
            if (b.getLessonID() == id) {
                b.setTitle(newTen);
                break;
            }
        }
    }

    public List<Lesson> getBaihocs() {
        return baihocs;
    }

    @Override
    public String toString() {
        return "Teaching{giaovien=" + giaovien +
                ", khoahoc=" + khoahoc +
                ", baihocs=" + baihocs + "}";
    }
}

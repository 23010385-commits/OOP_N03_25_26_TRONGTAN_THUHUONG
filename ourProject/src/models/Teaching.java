import java.util.ArrayList;
import java.util.List;

public class Teaching {
    private GiaoVien giaovien;
    private KhoaHoc khoahoc;
    private List<Baihoc> baihocs;

    public Teaching(GiaoVien giaovien, KhoaHoc khoahoc) {
        this.giaovien = giaovien;
        this.khoahoc = khoahoc;
        this.baihocs = new ArrayList<>();
    }

    // CRUD cho bài học trong Teaching
    public void addBaihoc(Baihoc baihoc) {
        baihocs.add(baihoc);
    }

    public void removeBaihoc(int id) {
        baihocs.removeIf(b -> b.getId() == id);
    }

    public void updateBaihoc(int id, String newTen) {
        for (Baihoc b : baihocs) {
            if (b.getId() == id) {
                b.setTen(newTen);
                break;
            }
        }
    }

    public List<Baihoc> getBaihocs() {
        return baihocs;
    }

    @Override
    public String toString() {
        return "Teaching{giaovien=" + giaovien +
                ", khoahoc=" + khoahoc +
                ", baihocs=" + baihocs + "}";
    }
}

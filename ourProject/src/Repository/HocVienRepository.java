package Repository;

import java.util.ArrayList;
import java.util.List;
import models.HocVien;

public class HocVienRepository {
    private List<HocVien> hocVienList;

    public HocVienRepository() {
        this.hocVienList = new ArrayList<>();
    }

    // Create
    public void addHocVien(HocVien hocVien) {
        hocVienList.add(hocVien);
    }

    // Read
    public HocVien getHocVienById(int id) {
        for (HocVien hocVien : hocVienList) {
            if (hocVien.getId() == id) {
                return hocVien;
            }
        }
        return null;
    }

    // Update
    public void updateHocVien(HocVien updatedHocVien) {
        for (int i = 0; i < hocVienList.size(); i++) {
            if (hocVienList.get(i).getId() == updatedHocVien.getId()) {
                hocVienList.set(i, updatedHocVien);
                return;
            }
        }
    }

    // Delete
    public void deleteHocVien(int id) {
        hocVienList.removeIf(hocVien -> hocVien.getId() == id);
    }

    // Get all HocVien
    public List<HocVien> getAllHocVien() {
        return new ArrayList<>(hocVienList);
    }
}


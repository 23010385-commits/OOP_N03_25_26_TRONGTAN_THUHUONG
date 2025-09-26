package Repository;

import java.util.ArrayList;
import java.util.List;
import models.GiaoVien;

public class GiaoVienRepository {
    private List<GiaoVien> giaoVienList;

    public GiaoVienRepository() {
        this.giaoVienList = new ArrayList<>();
    }

    // Create
    public void addGiaoVien(GiaoVien giaoVien) {
        giaoVienList.add(giaoVien);
    }

    // Read
    public GiaoVien getGiaoVienById(int id) {
        for (GiaoVien giaoVien : giaoVienList) {
            if (giaoVien.getId() == id) {
                return giaoVien;
            }
        }
        return null;
    }

    // Update
    public void updateGiaoVien(GiaoVien updatedGiaoVien) {
        for (int i = 0; i < giaoVienList.size(); i++) {
            if (giaoVienList.get(i).getId() == updatedGiaoVien.getId()) {
                giaoVienList.set(i, updatedGiaoVien);
                return;
            }
        }
    }

    // Delete
    public void deleteGiaoVien(int id) {
        giaoVienList.removeIf(giaoVien -> giaoVien.getId() == id);
    }

    // Get all GiaoVien
    public List<GiaoVien> getAllGiaoVien() {
        return new ArrayList<>(giaoVienList);
    }
}
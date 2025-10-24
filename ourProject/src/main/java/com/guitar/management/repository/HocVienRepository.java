package com.guitar.management.repository;

import java.util.ArrayList;
import java.util.List;
import com.guitar.management.model.HocVien;

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
            if (hocVien.getId() != null && Integer.valueOf(id).equals(hocVien.getId())) {
                return hocVien;
            }
        }
        return null;
    }

    // Update
    public void updateHocVien(HocVien updatedHocVien) {
        for (int i = 0; i < hocVienList.size(); i++) {
            Integer existingId = hocVienList.get(i).getId();
            Integer updatedId = updatedHocVien.getId();
            if (existingId != null && updatedId != null && existingId.equals(updatedId)) {
                hocVienList.set(i, updatedHocVien);
                return;
            }
        }
    }

    // Delete
    public void deleteHocVien(int id) {
        hocVienList.removeIf(hocVien -> hocVien.getId() != null && Integer.valueOf(id).equals(hocVien.getId()));
    }

    // Get all HocVien
    public List<HocVien> getAllHocVien() {
        return new ArrayList<>(hocVienList);
    }
}
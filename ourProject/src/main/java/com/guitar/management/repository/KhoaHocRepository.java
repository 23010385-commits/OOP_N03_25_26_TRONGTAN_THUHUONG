package com.guitar.management.repository;

import java.util.ArrayList;
import java.util.List;
import com.guitar.management.model.KhoaHoc;

public class KhoaHocRepository {
    private List<KhoaHoc> khoaHocList;

    public KhoaHocRepository() {
        this.khoaHocList = new ArrayList<>();
    }

    // Create
    public void addKhoaHoc(KhoaHoc khoaHoc) {
        khoaHocList.add(khoaHoc);
    }

    // Read
    public KhoaHoc getKhoaHocById(int id) {
        for (KhoaHoc khoaHoc : khoaHocList) {
            if (khoaHoc.getId() != null && Integer.valueOf(id).equals(khoaHoc.getId())) {
                return khoaHoc;
            }
        }
        return null;
    }

    // Update
    public void updateKhoaHoc(KhoaHoc updatedKhoaHoc) {
        for (int i = 0; i < khoaHocList.size(); i++) {
            Integer existingId = khoaHocList.get(i).getId();
            Integer updatedId = updatedKhoaHoc.getId();
            if (existingId != null && updatedId != null && existingId.equals(updatedId)) {
                khoaHocList.set(i, updatedKhoaHoc);
                return;
            }
        }
    }

    // Delete
    public void deleteKhoaHoc(int id) {
        khoaHocList.removeIf(khoaHoc -> khoaHoc.getId() != null && Integer.valueOf(id).equals(khoaHoc.getId()));
    }

    // Get all KhoaHoc
    public List<KhoaHoc> getAllKhoaHoc() {
        return new ArrayList<>(khoaHocList);
    }
}

package com.guitar.management.repository;

import java.util.ArrayList;
import java.util.List;
import com.guitar.management.model.HocVienKhoaHoc;

public class HVKHRepository {
    private List<HocVienKhoaHoc> hocVienKhoaHocList;

    public HVKHRepository() {
        this.hocVienKhoaHocList = new ArrayList<>();
    }

    // Create
    public void addHocVienKhoaHoc(HocVienKhoaHoc hocVienKhoaHoc) {
        hocVienKhoaHocList.add(hocVienKhoaHoc);
    }

    // Read
    public HocVienKhoaHoc getHocVienKhoaHocById(int id) {
        for (HocVienKhoaHoc hvkh : hocVienKhoaHocList) {
            if (hvkh.getId() == id) {
                return hvkh;
            }
        }
        return null;
    }

    // Update
    public boolean updateHocVienKhoaHoc(int id, HocVienKhoaHoc updatedHocVienKhoaHoc) {
        for (int i = 0; i < hocVienKhoaHocList.size(); i++) {
            if (hocVienKhoaHocList.get(i).getId() == id) {
                hocVienKhoaHocList.set(i, updatedHocVienKhoaHoc);
                return true;
            }
        }
        return false;
    }

    // Delete
    public boolean deleteHocVienKhoaHoc(int id) {
        return hocVienKhoaHocList.removeIf(hvkh -> hvkh.getId() == id);
    }

    // Get All
    public List<HocVienKhoaHoc> getAllHocVienKhoaHoc() {
        return new ArrayList<>(hocVienKhoaHocList);
    }
}

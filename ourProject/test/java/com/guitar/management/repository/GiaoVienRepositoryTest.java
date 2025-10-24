package com.guitar.management.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.guitar.management.model.GiaoVien;

class GiaoVienRepositoryTest {

    private GiaoVienRepository repo;

    @BeforeEach
    void setUp() {
        repo = new GiaoVienRepository();
    }

    @Test
    void addAndGetById() {
        GiaoVien gv = new GiaoVien(1, "A", 30, "Guitar");
        repo.addGiaoVien(gv);
        GiaoVien found = repo.getGiaoVienById(1);
        assertNotNull(found);
        assertEquals("A", found.getTen());
    }

    @Test
    void updateGiaoVien() {
        GiaoVien gv = new GiaoVien(1, "A", 30, "Guitar");
        repo.addGiaoVien(gv);
        GiaoVien updated = new GiaoVien(1, "B", 35, "Piano");
        repo.updateGiaoVien(updated);
        GiaoVien found = repo.getGiaoVienById(1);
        assertEquals("B", found.getTen());
        assertEquals(35, found.getTuoi());
    }

    @Test
    void deleteGiaoVien() {
        GiaoVien gv = new GiaoVien(1, "A", 30, "Guitar");
        repo.addGiaoVien(gv);
        repo.deleteGiaoVien(1);
        assertNull(repo.getGiaoVienById(1));
    }
}

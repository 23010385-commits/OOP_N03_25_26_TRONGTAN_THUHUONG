package com.guitar.management.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.guitar.management.model.HocVien;

class HocVienRepositoryTest {
    private HocVienRepository repo;

    @BeforeEach
    void setUp() {
        repo = new HocVienRepository();
    }

    @Test
    void addAndGetById() {
        HocVien hv = new HocVien(1, "H", "h@example.com", "0123");
        repo.addHocVien(hv);
        HocVien found = repo.getHocVienById(1);
        assertNotNull(found);
        assertEquals("H", found.getTen());
    }

    @Test
    void updateAndDelete() {
        HocVien hv = new HocVien(1, "H", "h@example.com", "0123");
        repo.addHocVien(hv);
        HocVien updated = new HocVien(1, "H2", "h2@example.com", "0987");
        repo.updateHocVien(updated);
        assertEquals("H2", repo.getHocVienById(1).getTen());
        repo.deleteHocVien(1);
        assertNull(repo.getHocVienById(1));
    }
}

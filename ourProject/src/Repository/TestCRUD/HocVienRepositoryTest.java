package Repository;

import models.HocVien;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HocVienRepositoryTest {

    private HocVienRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new HocVienRepository();
    }

    @Test
    public void testAddHocVien_ValidInput_Success() {
        HocVien hocVien = new HocVien(1, "Nguyen Van A", 20);
        repository.addHocVien(hocVien);
        assertEquals(1, repository.getAllHocVien().size());
        assertEquals(hocVien, repository.getHocVienById(1));
    }

    @Test
    public void testGetHocVienById_ValidId_ReturnsHocVien() {
        HocVien hocVien = new HocVien(1, "Nguyen Van A", 20);
        repository.addHocVien(hocVien);
        HocVien retrieved = repository.getHocVienById(1);
        assertNotNull(retrieved);
        assertEquals("Nguyen Van A", retrieved.getName());
    }

    @Test
    public void testDeleteHocVien_InvalidId_NoChange() {
        HocVien hocVien = new HocVien(1, "Nguyen Van A", 20);
        repository.addHocVien(hocVien);
        repository.deleteHocVien(2); // ID không tồn tại
        assertEquals(1, repository.getAllHocVien().size());
    }
}

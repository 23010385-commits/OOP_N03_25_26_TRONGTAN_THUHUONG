import java.util.List;

public class KhoaHoc {
    private int id;
    private String tenKhoaHoc;
    private String moTa;
    private GiaoVien giaoVien;      // giáo viên phụ trách
    private List<String> hocVien;   // danh sách học viên (chỉ tên để đơn giản)

    public KhoaHoc() {}

    public KhoaHoc(int id, String tenKhoaHoc, String moTa, GiaoVien giaoVien, List<String> hocVien) {
        this.id = id;
        this.tenKhoaHoc = tenKhoaHoc;
        this.moTa = moTa;
        this.giaoVien = giaoVien;
        this.hocVien = hocVien;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTenKhoaHoc() { return tenKhoaHoc; }
    public void setTenKhoaHoc(String tenKhoaHoc) { this.tenKhoaHoc = tenKhoaHoc; }

    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }

    public GiaoVien getGiaoVien() { return giaoVien; }
    public void setGiaoVien(GiaoVien giaoVien) { this.giaoVien = giaoVien; }

    public List<String> getHocVien() { return hocVien; }
    public void setHocVien(List<String> hocVien) { this.hocVien = hocVien; }

    @Override
    public String toString() {
        return "KhoaHoc{" +
                "id=" + id +
                ", tenKhoaHoc='" + tenKhoaHoc + '\'' +
                ", moTa='" + moTa + '\'' +
                ", giaoVien=" + (giaoVien != null ? giaoVien.getTen() : "Chưa có") +
                ", soHocVien=" + (hocVien != null ? hocVien.size() : 0) +
                '}';
    } 
}

package models;

public class GiaoVien {

    // thuoc tinh
    private int id;
    private String ten;
    private int tuoi;
    private String chuyenMon;

    public GiaoVien() {}

    public GiaoVien(int id, String ten, int tuoi, String chuyenMon) {
        this.id = id;
        this.ten = ten;
        this.tuoi = tuoi;
        this.chuyenMon = chuyenMon;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }

    public int getTuoi() { return tuoi; }
    public void setTuoi(int tuoi) { this.tuoi = tuoi; }

    public String getChuyenMon() { return chuyenMon; }
    public void setChuyenMon(String chuyenMon) { this.chuyenMon = chuyenMon; }

    @Override
    public String toString() {
        return "Giaovien{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", tuoi=" + tuoi +
                ", chuyenMon='" + chuyenMon + '\'' +
                '}';
    }
}

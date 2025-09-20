public class GiaoVien {
    private int id;
    private String ten;
    private int tuoi;
    private String chuyenMon;

    // ham tao
    public GiaoVien(int id, String ten, int tuoi, String chuyenMon) {
        this.id = id;
        this.ten = ten;
        this.tuoi = tuoi;
        this.chuyenMon = chuyenMon;
    }

    // getter va setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    // phuong thuc in thong tin giao vien
    public void showInfo() {
        System.out.println("------ Giao vien ------");
        System.out.println("ID         : " + id);
        System.out.println("Ten        : " + ten);
        System.out.println("Tuoi       : " + tuoi);
        System.out.println("Chuyen mon : " + chuyenMon);
        System.out.println("-----------------------\n");
    }
}

package Model;

public class Citizen {
    private int maHo;
    private String tenChuHo;
    private int soThanhVien;

    public Citizen(int id, String name, int num){
        this.maHo = id;
        this.tenChuHo = name;
        this.soThanhVien = num;
    }

    public Citizen(){

    }

    public int getMaHo() {
        return maHo;
    }

    public void setMaHo(int maHo) {
        this.maHo = maHo;
    }

    public String getTenChuHo() {
        return tenChuHo;
    }

    public void setTenChuHo(String tenChuHo) {
        this.tenChuHo = tenChuHo;
    }

    public int getSoThanhVien() {
        return soThanhVien;
    }

    public void setSoThanhVien(int soThanhVien) {
        this.soThanhVien = soThanhVien;
    }
}

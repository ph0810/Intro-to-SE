package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VE_Citizen {
    private int maHo;
    private String tenChuHo;
    private String ghiChu;
    private int soTien;

    public String getTenChuHo() {
        return tenChuHo;
    }

    public void setTenChuHo(String tenChuHo) {
        this.tenChuHo = tenChuHo;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public int getMaHo() {
        return maHo;
    }

    public void setMaHo(int maHo) {
        this.maHo = maHo;
    }

    public static List<VE_Citizen> getDataFromVEId(int id) {
        List<VE_Citizen> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String sql = "select MaHo, tenchuho, SoTien, GhiChu from donggop, hogiadinh\n" +
                "where MaHo = idhogiadinh and MaKhoan = " + id;
        try{
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                VE_Citizen veCitizen = new VE_Citizen();
                veCitizen.setMaHo(rs.getInt(1));
                veCitizen.setTenChuHo(rs.getString(2));
                veCitizen.setGhiChu(rs.getString(4));
                veCitizen.setSoTien(rs.getInt(3));
                list.add(veCitizen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void editVE_Citizen(VE_Citizen ve_citizen){
        String sql = "UPDATE `quanlythutien`.`donggop` SET " +
                "`GhiChu` = '"+ ve_citizen.getGhiChu() +"'," +
                " `SoTien` = '"+ ve_citizen.getSoTien() +
                "' WHERE (`MaKhoan` = '2') and (`MaHo` = '2');";
        DBConnection.execute(sql);
    }
}

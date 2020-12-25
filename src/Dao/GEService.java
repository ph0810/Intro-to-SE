package Dao;

import Model.Citizen;
import Model.GeneralEvent;
import Model.VoluntaryEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GEService {
    public static List<GeneralEvent> getList() {
        Connection connection = DBConnection.getConnection();
        String sql = "Select * from thuphibatbuoc";
        List<GeneralEvent> list = new ArrayList<>();
        try{
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GeneralEvent generalEvent = new GeneralEvent();
                generalEvent.setId(rs.getInt(1));
                generalEvent.setName(rs.getString(2));
                generalEvent.setMoney(rs.getInt(3));
                generalEvent.setNote(rs.getString(4));
                list.add(generalEvent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void add(GeneralEvent generalEvent) {
        String sql = "INSERT INTO `quanlythutien`.`thuphibatbuoc` (`Ma`, `Ten`, `Tien`, `GhiChu`) " +
                    "VALUES ('"+ generalEvent.getId() +"', " +
                    "'"+ generalEvent.getName() +"', " +
                    "'"+ generalEvent.getMoney() +"', " +
                    "'"+ generalEvent.getNote() +"');";
        DBConnection.execute(sql);
        CitizenService citizenService = new CitizenService();
        List<Citizen> list = citizenService.getList();
        for(var i : list) {
            sql = "INSERT INTO `quanlythutien`.`dongphi` (`MaKhoan`, `MaHo`) " +
                    "VALUES ('"+ generalEvent.getId() +"', '"+ i.getMaHo() +"');";
            DBConnection.execute(sql);
        }
    }

    public static void delete(GeneralEvent generalEvent) {
        String sql = "DELETE FROM `quanlythutien`.`thuphibatbuoc` WHERE (Ma = "+ generalEvent.getId() + ");";
        DBConnection.execute(sql);
    }

    public static void main(String[] args) {
        List<GeneralEvent> list = GEService.getList();
        for(var s : list) {
            System.out.println(s.getId() + " " + s.getName() + " " + s.getMoney() + " " + s.getNote());
        }
    }
}

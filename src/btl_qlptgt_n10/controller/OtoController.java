/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_qlptgt_n10.controller;

import btl_qlptgt_n10.util.CSDL;
import btl_qlptgt_n10.model.OTo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author naman
 */
public class OtoController { 
    public Boolean createNewOto(OTo oTo) {
        String sqlCreateNewTransport = "INSERT INTO PTGT (kieuDongCo, soChoNgoi, loaiPhuongTien ,hangSanXuat, namSanXuat, giaBan, mau) VALUES(?, ?, N'Ô tô', ?, ?, ?, ?)";
        try {
            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateNewTransport);
            preparedStatement.setString(1, oTo.getKieuDongCo());
            preparedStatement.setInt(2, oTo.getSoChoNgoi());
            preparedStatement.setString(3, oTo.getHangSanXuat());
            preparedStatement.setInt(4, oTo.getNamSanXuat());
            preparedStatement.setFloat(5, (float) oTo.getGiaBan());
            preparedStatement.setString(6, oTo.getMau());
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            System.out.println("Create new Transport success!");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<OTo> getAllOto() throws SQLException {
        List<OTo> oTos = new ArrayList<>();
        String sqlGetAllOto = "SELECT * FROM PTGT WHERE loaiPhuongTien = N'Ô tô'";
        try {
            Connection connection = CSDL.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlGetAllOto);
            while (resultSet.next()) {
                OTo oTo = new OTo(
                        resultSet.getString(7),
                        resultSet.getInt(8),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6)
                );
                oTos.add(oTo);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return oTos;
    }
    
    public Boolean updateOtoById(OTo oTo) {
        String sqlUpdateOto = "UPDATE PTGT SET kieuDongCo = ?, soChoNgoi = ?, hangSanXuat = ?, namSanXuat = ?, giaBan = ?, mau = ? WHERE id = ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdateOto);

            preparedStatement.setString(1, oTo.getKieuDongCo());
            preparedStatement.setInt(2, oTo.getSoChoNgoi());
            preparedStatement.setString(3, oTo.getHangSanXuat());
            preparedStatement.setInt(4, oTo.getNamSanXuat());
            preparedStatement.setFloat(5, oTo.getGiaBan());
            preparedStatement.setString(6, oTo.getMau());
            preparedStatement.setInt(7, oTo.getId());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean deleteOtoById(int id) {
        String sqlDeleteOto = "DELETE FROM PTGT WHERE id = ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteOto);

            preparedStatement.setInt(1, id);

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<OTo> getOtoByHangSanXuat(String hangSanXuat) {
        List<OTo> oTos = new ArrayList<>();
        String sqlGetAllOtoByHSX = "SELECT * FROM PTGT WHERE loaiPhuongTien = N'Ô tô' AND hangSanXuat = ?";
        try {
            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAllOtoByHSX);
            preparedStatement.setString(1, hangSanXuat);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                OTo oTo = new OTo(
                        resultSet.getString(7),
                        resultSet.getInt(8),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6)
                );
                oTos.add(oTo);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return oTos;
    }
    
    public List<OTo> getOtoByNam(String nam) {
        List<OTo> oTos = new ArrayList<>();
        String sqlGetAllOtoByNam = "SELECT * FROM PTGT WHERE loaiPhuongTien = N'Ô tô' AND namSanXuat = ?";
        try {
            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAllOtoByNam);
            preparedStatement.setString(1, nam);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                OTo oTo = new OTo(
                        resultSet.getString(7),
                        resultSet.getInt(8),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6)
                );
                oTos.add(oTo);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return oTos;
    }
    
    public List<OTo> getOtoByGiaBan(String giaBan) {
        List<OTo> oTos = new ArrayList<>();
        String sqlGetAll = "SELECT * FROM PTGT WHERE loaiPhuongTien = N'Ô tô' AND giaBan = ?";
        try {
            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            preparedStatement.setString(1, giaBan);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                OTo oTo = new OTo(
                        resultSet.getString(7),
                        resultSet.getInt(8),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6)
                );
                oTos.add(oTo);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return oTos;
    }
    
    public List<OTo> getOtoByMau(String mau) {
        List<OTo> oTos = new ArrayList<>();
        String sqlGetAll = "SELECT * FROM PTGT WHERE loaiPhuongTien = N'Ô tô' AND mau LIKE ?";
        try {
            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            preparedStatement.setString(1, "%" + mau + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                OTo oTo = new OTo(
                        resultSet.getString(7),
                        resultSet.getInt(8),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6)
                );
                oTos.add(oTo);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return oTos;
    }
    
    public List<OTo> getOtoByDongCo(String dongCo) {
        List<OTo> oTos = new ArrayList<>();
        String sqlGetAll = "SELECT * FROM PTGT WHERE loaiPhuongTien = N'Ô tô' AND kieuDongCo LIKE ?";
        try {
            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            preparedStatement.setString(1, "%" + dongCo + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                OTo oTo = new OTo(
                        resultSet.getString(7),
                        resultSet.getInt(8),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6)
                );
                oTos.add(oTo);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return oTos;
    }
    
    public List<OTo> getOtoBySoChoNgoi(String sochoNgoi) {
        List<OTo> oTos = new ArrayList<>();
        String sqlGetAll = "SELECT * FROM PTGT WHERE loaiPhuongTien = N'Ô tô' AND soChoNgoi = ?";
        try {
            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            preparedStatement.setString(1, sochoNgoi);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                OTo oTo = new OTo(
                        resultSet.getString(7),
                        resultSet.getInt(8),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6)
                );
                oTos.add(oTo);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return oTos;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_qlptgt_n10.controller;

import btl_qlptgt_n10.model.XeMay;
import btl_qlptgt_n10.util.CSDL;
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
public class XeMayController {
    public Boolean createNewXeMay(XeMay xeMay) {
        String sqlCreateNewTransport = "INSERT INTO PTGT (congSuat, loaiPhuongTien ,hangSanXuat, namSanXuat, giaBan, mau) VALUES(?, N'Xe máy', ?, ?, ?, ?)";
        try {
            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateNewTransport);
            preparedStatement.setInt(1, xeMay.getCongSuat());
            preparedStatement.setString(2, xeMay.getHangSanXuat());
            preparedStatement.setInt(3, xeMay.getNamSanXuat());
            preparedStatement.setFloat(4, (float) xeMay.getGiaBan());
            preparedStatement.setString(5, xeMay.getMau());
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
    
    public List<XeMay> getAllXeMay() throws SQLException {
        List<XeMay> xeMays = new ArrayList<>();
        String sqlGetAllXeMay = "SELECT * FROM PTGT WHERE loaiPhuongTien = N'Xe máy'";
        try {
            Connection connection = CSDL.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlGetAllXeMay);
            while (resultSet.next()) {
                XeMay xeMay = new XeMay(
                        resultSet.getInt(9),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6)
                );
                xeMays.add(xeMay);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return xeMays;
    }
    
    public Boolean updateXeMayById(XeMay xeMay) {
        String sqlUpdate = "UPDATE PTGT SET congSuat = ?, hangSanXuat = ?, namSanXuat = ?, giaBan = ?, mau = ? WHERE id = ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);

            preparedStatement.setInt(1, xeMay.getCongSuat());
            preparedStatement.setString(2, xeMay.getHangSanXuat());
            preparedStatement.setInt(3, xeMay.getNamSanXuat());
            preparedStatement.setFloat(4, xeMay.getGiaBan());
            preparedStatement.setString(5, xeMay.getMau());
            preparedStatement.setInt(6, xeMay.getId());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean deleteXeMayById(int id) {
        String sqlDelete = "DELETE FROM PTGT WHERE id = ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);

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
    
    public List<XeMay> getXeMayByHangSanXuat(String hangSanXuat) {
        List<XeMay> xeMays = new ArrayList<>();
        String sqlGetAllXeMayByHSX = "SELECT * FROM PTGT WHERE loaiPhuongTien = N'Xe máy' AND hangSanXuat = ?";
        try {
            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAllXeMayByHSX);
            preparedStatement.setString(1, hangSanXuat);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                XeMay xeMay = new XeMay(
                        resultSet.getInt(9),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6)
                );
                xeMays.add(xeMay);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return xeMays;
    }
    
    public List<XeMay> getXeMayByNam(String nam) {
        List<XeMay> xeMays = new ArrayList<>();
        String sqlGetAllXeMayByNam = "SELECT * FROM PTGT WHERE loaiPhuongTien = N'Xe máy' AND namSanXuat = ?";
        try {
            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAllXeMayByNam);
            preparedStatement.setString(1, nam);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                XeMay xeMay = new XeMay(
                        resultSet.getInt(9),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6)
                );
                xeMays.add(xeMay);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return xeMays;
    }
    
    public List<XeMay> getXeMayByGiaBan(String giaBan) {
        List<XeMay> xeMays = new ArrayList<>();
        String sqlGetAll = "SELECT * FROM PTGT WHERE loaiPhuongTien = N'Xe máy' AND giaBan = ?";
        try {
            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            preparedStatement.setString(1, giaBan);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                XeMay xeMay = new XeMay(
                        resultSet.getInt(9),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6)
                );
                xeMays.add(xeMay);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return xeMays;
    }
    
    public List<XeMay> getXeMayByMau(String mau) {
        List<XeMay> xeMays = new ArrayList<>();
        String sqlGetAll = "SELECT * FROM PTGT WHERE loaiPhuongTien = N'Xe máy' AND mau LIKE ?";
        try {
            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            preparedStatement.setString(1, "%" + mau + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                XeMay xeMay = new XeMay(
                        resultSet.getInt(9),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6)
                );
                xeMays.add(xeMay);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return xeMays;
    }
    
    public List<XeMay> getXeMayByCongSuat(String congSuat) {
        List<XeMay> xeMays = new ArrayList<>();
        String sqlGetAll = "SELECT * FROM PTGT WHERE loaiPhuongTien = N'Xe máy' AND congSuat = ?";
        try {
            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            preparedStatement.setString(1, congSuat);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                XeMay xeMay = new XeMay(
                        resultSet.getInt(9),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6)
                );
                xeMays.add(xeMay);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return xeMays;
    }
}

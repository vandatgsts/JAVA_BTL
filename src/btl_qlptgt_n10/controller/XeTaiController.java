/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_qlptgt_n10.controller;

import btl_qlptgt_n10.model.XeTai;
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
public class XeTaiController {
    public Boolean createNewXeTai(XeTai xeTai) {
        String sqlCreateNewTransport = "INSERT INTO PTGT (trongTai, loaiPhuongTien ,hangSanXuat, namSanXuat, giaBan, mau) VALUES(?, N'Xe tải', ?, ?, ?, ?)";
        try {
            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateNewTransport);
            preparedStatement.setFloat(1, xeTai.getTrongTai());
            preparedStatement.setString(2, xeTai.getHangSanXuat());
            preparedStatement.setInt(3, xeTai.getNamSanXuat());
            preparedStatement.setFloat(4, (float) xeTai.getGiaBan());
            preparedStatement.setString(5, xeTai.getMau());
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
    
    public List<XeTai> getAllXeTai() throws SQLException {
        List<XeTai> xeTais = new ArrayList<>();
        String sqlGetAllXeTai = "SELECT * FROM PTGT WHERE loaiPhuongTien = N'Xe tải'";
        try {
            Connection connection = CSDL.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlGetAllXeTai);
            while (resultSet.next()) {
                XeTai xeTai = new XeTai(
                        resultSet.getFloat(10),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6)
                );
                xeTais.add(xeTai);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return xeTais;
    }
    
    public Boolean updateXeTaiById(XeTai xeTai) {
        String sqlUpdate = "UPDATE PTGT SET trongTai = ?, hangSanXuat = ?, namSanXuat = ?, giaBan = ?, mau = ? WHERE id = ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);

            preparedStatement.setFloat(1, xeTai.getTrongTai());
            preparedStatement.setString(2, xeTai.getHangSanXuat());
            preparedStatement.setInt(3, xeTai.getNamSanXuat());
            preparedStatement.setFloat(4, xeTai.getGiaBan());
            preparedStatement.setString(5, xeTai.getMau());
            preparedStatement.setInt(6, xeTai.getId());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean deleteXeTaiById(int id) {
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
    
    public List<XeTai> getXeTaiByHangSanXuat(String hangSanXuat) {
        List<XeTai> xeTais = new ArrayList<>();
        String sqlGetAllXeTaiByHSX = "SELECT * FROM PTGT WHERE loaiPhuongTien = N'Xe tải' AND hangSanXuat = ?";
        try {
            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAllXeTaiByHSX);
            preparedStatement.setString(1, hangSanXuat);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                XeTai xeTai = new XeTai(
                        resultSet.getFloat(10),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6)
                );
                xeTais.add(xeTai);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return xeTais;
    }
    
    public List<XeTai> getXeTaiByNam(String nam) {
        List<XeTai> xeTais = new ArrayList<>();
        String sqlGetAllXeTaiByNam = "SELECT * FROM PTGT WHERE loaiPhuongTien = N'Xe tải' AND namSanXuat = ?";
        try {
            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAllXeTaiByNam);
            preparedStatement.setString(1, nam);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                XeTai xeTai = new XeTai(
                        resultSet.getFloat(10),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6)
                );
                xeTais.add(xeTai);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return xeTais;
    }
    
    public List<XeTai> getXeTaiByGiaBan(String giaBan) {
        List<XeTai> xeTais = new ArrayList<>();
        String sqlGetAll = "SELECT * FROM PTGT WHERE loaiPhuongTien = N'Xe tải' AND giaBan = ?";
        try {
            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            preparedStatement.setString(1, giaBan);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                XeTai xeTai = new XeTai(
                        resultSet.getFloat(10),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6)
                );
                xeTais.add(xeTai);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return xeTais;
    }
    
    public List<XeTai> getXeTaiByMau(String mau) {
        List<XeTai> xeTais = new ArrayList<>();
        String sqlGetAll = "SELECT * FROM PTGT WHERE loaiPhuongTien = N'Xe tải' AND mau LIKE ?";
        try {
            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            preparedStatement.setString(1, "%" + mau + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                XeTai xeTai = new XeTai(
                        resultSet.getFloat(10),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6)
                );
                xeTais.add(xeTai);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return xeTais;
    }
    
    public List<XeTai> getXeTaiByTrongTai(String trongTai) {
        List<XeTai> xeTais = new ArrayList<>();
        String sqlGetAll = "SELECT * FROM PTGT WHERE loaiPhuongTien = N'Xe tải' AND trongTai = ?";
        try {
            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            preparedStatement.setString(1, trongTai);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                XeTai xeTai = new XeTai(
                        resultSet.getFloat(10),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6)
                );
                xeTais.add(xeTai);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return xeTais;
    }
}

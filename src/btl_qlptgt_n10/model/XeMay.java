/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_qlptgt_n10.model;

/**
 *
 * @author naman
 */
public class XeMay extends PTGT{
    private int congSuat;

    public XeMay() {
    }

    public XeMay(int congSuat, String hangSanXuat, int namSanXuat, float giaBan, String mau) {
        super(hangSanXuat, namSanXuat, giaBan, mau);
        this.congSuat = congSuat;
    }

    public XeMay(int congSuat, int id, String hangSanXuat, int namSanXuat, float giaBan, String mau) {
        super(id, hangSanXuat, namSanXuat, giaBan, mau);
        this.congSuat = congSuat;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }
}

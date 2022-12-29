/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_qlptgt_n10.model;

/**
 *
 * @author naman
 */
public class XeTai extends PTGT{
    private float trongTai;

    public XeTai() {
    }

    public XeTai(float trongTai, String hangSanXuat, int namSanXuat, float giaBan, String mau) {
        super(hangSanXuat, namSanXuat, giaBan, mau);
        this.trongTai = trongTai;
    }
    
    public XeTai(float trongTai, int id, String hangSanXuat, int namSanXuat, float giaBan, String mau) {
        super(id, hangSanXuat, namSanXuat, giaBan, mau);
        this.trongTai = trongTai;
    }

    public float getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(float trongTai) {
        this.trongTai = trongTai;
    }
}

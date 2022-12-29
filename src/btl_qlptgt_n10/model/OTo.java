/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_qlptgt_n10.model;

/**
 *
 * @author naman
 */
public class OTo extends PTGT{
    private String kieuDongCo;
    private int soChoNgoi;

    public OTo() {
    }

    public OTo(String kieuDongCo, int soChoNgoi, String hangSanXuat, int namSanXuat, float giaBan, String mau) {
        super(hangSanXuat, namSanXuat, giaBan, mau);
        this.kieuDongCo = kieuDongCo;
        this.soChoNgoi = soChoNgoi;
    }

    public OTo(String kieuDongCo, int soChoNgoi, int id, String hangSanXuat, int namSanXuat, float giaBan, String mau) {
        super(id, hangSanXuat, namSanXuat, giaBan, mau);
        this.kieuDongCo = kieuDongCo;
        this.soChoNgoi = soChoNgoi;
    }

    public String getKieuDongCo() {
        return kieuDongCo;
    }

    public void setKieuDongCo(String kieuDongCo) {
        this.kieuDongCo = kieuDongCo;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }
}

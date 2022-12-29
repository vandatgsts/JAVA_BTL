/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package btl_qlptgt_n10;

import btl_qlptgt_n10.controller.AccountController;
import btl_qlptgt_n10.view.SignIn;

/**
 *
 * @author naman
 */
public class BTL_QLPTGT_N10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        AccountController ac = new AccountController();
        ac.createAdminAccount();
        SignIn signIn = new SignIn();
        signIn.setLocationRelativeTo(null);
        signIn.setVisible(true);
    }
    
}

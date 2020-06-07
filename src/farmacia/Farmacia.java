/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import com.sun.awt.AWTUtilities;


public class Farmacia {

    
    public static void main(String[] args) {
        presentacion.UILogin i;
        i=new presentacion.UILogin();
        //Fade.JFrameFadeIn(0f, 1f, 0.1f, 50, i);
        //AWTUtilities.setWindowOpaque(i, false);
        i.setVisible(true);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.dso.ii;

import Autenticacao.TelaLogin;

/**
 *
 * @author Allan
 */
public class TrabalhoDSOII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TelaLogin login = new TelaLogin();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        login.setTitle("Gym Tech - Academia");

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Autenticacao;

import Persistencia.MapeamentoBD;
import Persistencia.SQLite;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Allan
 */
public class ControladorLogin {
    
    private static ControladorLogin instance = null;
    
     public static synchronized ControladorLogin getInstance() throws SQLException {
        if (instance == null) {
            instance = new ControladorLogin();
        }
        return instance;
    }

    public ControladorLogin() throws SQLException {

    }
    
    public boolean getSenhaBoolean(String login, String senha) throws SQLException {
        boolean aux = false;
        String aux2 = "";
        String query = "SELECT login, senha FROM login "
                + "WHERE login = '" + login + "'";
        try {
            ResultSet rs = SQLite.getInstancia().getConsulta(query);
            while (rs.next()) {
                aux2 = rs.getString("senha");
                if (aux2.equals(senha)) {
                    aux = true;
                }
            }
            return aux;
        } catch (SQLException e) {
            throw e;
        }
    }

    public void insereLogin(String loginFunc, String senhaFunc) throws SQLException {
        MapeamentoBD.getInstance().insereSenha(loginFunc, senhaFunc);
    }
    
}

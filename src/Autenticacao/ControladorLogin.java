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
        return MapeamentoBD.getInstance().getSenhaBoolean(login, senha);
    }

    public void insereLogin(String loginFunc, String senhaFunc, String tipoLogin) throws SQLException {
        MapeamentoBD.getInstance().insereSenha(loginFunc, senhaFunc, tipoLogin);
    }

    public boolean verificaTipoAdm(String login) throws SQLException {
        return MapeamentoBD.getInstance().verificaTipoAdm(login);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Aluno;
import Modelo.Funcionario;
import Persistencia.MapeamentoBD;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Allan
 */
public class ControladorPrincipal {

    private static ControladorPrincipal instance = null;

    public static synchronized ControladorPrincipal getInstance() throws SQLException {
        if (instance == null) {
            instance = new ControladorPrincipal();
        }
        return instance;
    }

    public void insereFuncionario(Funcionario f) throws SQLException {
        MapeamentoBD.getInstance().insereFuncionario(f);
    }

    public void insereAluno(Aluno a) throws SQLException {
        MapeamentoBD.getInstance().insereAluno(a);
    }

    public ArrayList<Aluno> getTodosAlunos() throws SQLException {
        return MapeamentoBD.getInstance().getTodosAlunos();
    }

    public ArrayList<Funcionario> getTodosFuncionarios() throws SQLException {
        return MapeamentoBD.getInstance().getTodosFuncionarios();
    }

    public int getUltimoIdAluno() throws SQLException {
        return MapeamentoBD.getInstance().getIdAluno();
    }

    public int getUltimoIdFuncionario() throws SQLException {
        return MapeamentoBD.getInstance().getIdFuncionario();
    }

    public ArrayList<Aluno> getAlunoPorNome(String nome) throws SQLException {
        return MapeamentoBD.getInstance().getAlunoPorNome(nome);
    }

    public ArrayList<Aluno> getAlunoPorId(int id) throws SQLException {
        return MapeamentoBD.getInstance().getAlunoPorId(id);
    }

    public ArrayList<Funcionario> getFuncionarioPorNome(String nome) throws SQLException {
        return MapeamentoBD.getInstance().getFuncionarioPorNome(nome);
    }

    public ArrayList<Funcionario> getFuncionarioPorId(int id) throws SQLException {
        return MapeamentoBD.getInstance().getFuncionarioPorId(id);
    }

}

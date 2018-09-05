/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Aluno;
import java.sql.SQLException;
import Modelo.Funcionario;
import Modelo.Login;
import Modelo.Treino;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Allan
 */
public class MapeamentoBD {

    private static MapeamentoBD instance = null;

    public static synchronized MapeamentoBD getInstance() throws SQLException {
        if (instance == null) {
            instance = new MapeamentoBD();
        }
        return instance;
    }

    public void insereFuncionario(Funcionario f) throws SQLException {
        String query = "INSERT INTO funcionario(nome, cpf, rg, nascimento, telefone, endereco, cargo, salario, login, senha) "
                + "VALUES('" + f.getNome() + "',"
                + "'" + f.getCpf() + "',"
                + "'" + f.getRg() + "',"
                + "'" + f.getNascimento() + "',"
                + "'" + f.getTelefone() + "',"
                + "'" + f.getEndereco() + "',"
                + "'" + f.getCargo() + "',"
                + "'" + f.getSalario() + "',"
                + "'" + f.getLogin() + "',"
                + "'" + f.getSenha() + "')";

        try {
            SQLite.getInstancia().update(query);
        } catch (SQLException e) {
            throw e;
        }

    }

    public void insereAluno(Aluno a) throws SQLException {
        String query = "INSERT INTO aluno(nome, cpf, rg, nascimento, telefone, endereco) "
                + "VALUES('" + a.getNome() + "',"
                + "'" + a.getCpf() + "',"
                + "'" + a.getRg() + "',"
                + "'" + a.getNascimento() + "',"
                + "'" + a.getTelefone() + "',"
                + "'" + a.getEndereco() + "')";

        try {
            SQLite.getInstancia().update(query);
        } catch (SQLException e) {
            throw e;
        }
    }

    public void insereSenha(String login, String senha, String tipoLogin) throws SQLException {
        String query = "INSERT INTO login(login, senha, tipo) "
                + "VALUES('" + login + "',"
                + "'" + senha + "',"
                + "'" + tipoLogin + "')";
        try {
            SQLite.getInstancia().update(query);
        } catch (SQLException e) {
            throw e;
        }
    }

    public boolean verificaTipoAdm(String login) throws SQLException {
        boolean aux = false;
        String aux2 = "";
        String query = "SELECT login, senha, tipo FROM login "
                + "WHERE login = '" + login + "'";
        try {
            ResultSet rs = SQLite.getInstancia().getConsulta(query);
            while (rs.next()) {
                aux2 = rs.getString("tipo");
                if (aux2.equals("adm")) {
                    aux = true;
                }
            }
            return aux;
        } catch (SQLException e) {
            throw e;
        }
    }

    public ArrayList<Aluno> getTodosAlunos() throws SQLException {
        String query = "SELECT id, nome, cpf, rg, nascimento, telefone, endereco FROM aluno";

        try {
            ResultSet rs = SQLite.getInstancia().getConsulta(query);
            ArrayList<Aluno> result = new ArrayList<Aluno>();
            while (rs.next()) {

                Aluno a = new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), rs.getString("nascimento"), rs.getString("telefone"), rs.getString("endereco"));
                result.add(a);
            }
            return result;
        } catch (SQLException e) {
            throw e;
        }
    }

    public ArrayList<Funcionario> getTodosFuncionarios() throws SQLException {
        String query = "SELECT id, nome, cpf, rg, nascimento, telefone, endereco, cargo, salario, login, senha FROM funcionario";

        try {
            ResultSet rs = SQLite.getInstancia().getConsulta(query);
            ArrayList<Funcionario> result = new ArrayList<Funcionario>();
            while (rs.next()) {

                Funcionario f = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), rs.getString("nascimento"), rs.getString("telefone"),
                        rs.getString("endereco"), rs.getString("cargo"), rs.getDouble("salario"), rs.getString("login"), rs.getString("senha"));
                result.add(f);
            }
            return result;
        } catch (SQLException e) {
            throw e;
        }
    }

    public ArrayList<Aluno> getAlunoPorNome(String nome) throws SQLException {
        String query = "SELECT id, nome, cpf, rg, nascimento, telefone, endereco FROM aluno "
                + "WHERE nome LIKE '" + nome + "'";
        try {
            ResultSet rs = SQLite.getInstancia().getConsulta(query);
            ArrayList<Aluno> result = new ArrayList<Aluno>();
            while (rs.next()) {

                Aluno a = new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), rs.getString("nascimento"), rs.getString("telefone"), rs.getString("endereco"));
                result.add(a);
            }
            return result;
        } catch (SQLException e) {
            throw e;
        }
    }

    public ArrayList<Aluno> getAlunoPorId(int id) throws SQLException {
        try {
            String query = "SELECT id, nome, cpf, rg, nascimento, telefone, endereco FROM aluno "
                    + "WHERE id = '" + id + "'";

            ResultSet rs = SQLite.getInstancia().getConsulta(query);
            ArrayList<Aluno> result = new ArrayList<Aluno>();
            while (rs.next()) {

                Aluno a = new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), rs.getString("nascimento"), rs.getString("telefone"), rs.getString("endereco"));
                result.add(a);
            }
            return result;
        } catch (SQLException e) {
            throw e;
        }
    }

    public int getIdAluno() throws SQLException {
        String query = "SELECT MAX(id) AS Id from aluno";
        int result = 0;
        try {
            ResultSet rs = SQLite.getInstancia().getConsulta(query);
            //while (rs.next()) {
            rs.next();
            result = rs.getInt("Id");
            System.out.println(result);
            //}
            return result;
        } catch (Exception e) {
            throw e;
        }
    }

    public int getIdFuncionario() throws SQLException {
        String query = "SELECT MAX(id) AS Id from funcionario";
        int result = 0;
        try {
            ResultSet rs = SQLite.getInstancia().getConsulta(query);
            //while (rs.next()) {
            rs.next();
            result = rs.getInt("Id");
            System.out.println(result);
            //}
            return result;
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Funcionario> getFuncionarioPorNome(String nome) throws SQLException {
        String query = "SELECT id, nome, cpf, rg, nascimento, telefone, endereco, cargo, salario, login, senha FROM funcionario "
                + "WHERE nome LIKE '" + nome + "'";
        try {
            ResultSet rs = SQLite.getInstancia().getConsulta(query);
            ArrayList<Funcionario> result = new ArrayList<Funcionario>();
            while (rs.next()) {

                Funcionario f = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), rs.getString("nascimento"), rs.getString("telefone"),
                        rs.getString("endereco"), rs.getString("cargo"), rs.getDouble("salario"), rs.getString("login"), rs.getString("senha"));
                result.add(f);
            }
            return result;
        } catch (SQLException e) {
            throw e;
        }
    }

    public ArrayList<Funcionario> getFuncionarioPorId(int id) throws SQLException {
        String query = "SELECT id, nome, cpf, rg, nascimento, telefone, endereco, cargo, salario, login, senha FROM funcionario "
                + "WHERE id = '" + id + "'";
        try {
            ResultSet rs = SQLite.getInstancia().getConsulta(query);
            ArrayList<Funcionario> result = new ArrayList<Funcionario>();
            while (rs.next()) {

                Funcionario f = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), rs.getString("nascimento"), rs.getString("telefone"),
                        rs.getString("endereco"), rs.getString("cargo"), rs.getDouble("salario"), rs.getString("login"), rs.getString("senha"));
                result.add(f);
            }
            return result;
        } catch (SQLException e) {
            throw e;
        }
    }

    public void insereTreino(Treino t) throws SQLException {
        String query = "INSERT INTO treino(id, nome, biceps, triceps, perna, abdominal, flexao, corrida, jump, supino, gluteos, costas ) "
                + "VALUES('" + t.getId() + "',"
                + "'" + t.getNome() + "',"
                + "'" + t.getBiceps() + "',"
                + "'" + t.getTriceps() + "',"
                + "'" + t.getPerna() + "',"
                + "'" + t.getAbdominal() + "',"
                + "'" + t.getFlexao() + "',"
                + "'" + t.getCorrida() + "',"
                + "'" + t.getJump() + "',"
                + "'" + t.getSupino() + "',"
                + "'" + t.getGluteos() + "',"
                + "'" + t.getCostas() + "')";

        try {
            SQLite.getInstancia().update(query);
        } catch (SQLException e) {
            throw e;
        }
    }

    public void AtualizaTreino(Treino t, int id) throws SQLException {
        String query = "UPDATE treino SET id = '" + id + "', nome='" + t.getNome() + "', "
                + "biceps='" + t.getBiceps() + "', "
                + "triceps='" + t.getTriceps() + "', "
                + "perna='" + t.getPerna() + "', "
                + "abdominal='" + t.getAbdominal() + "', "
                + "flexao='" + t.getFlexao() + "', "
                + "corrida='" + t.getCorrida() + "', "
                + "jump='" + t.getJump() + "', "
                + "supino='" + t.getSupino() + "', "
                + "gluteos='" + t.getGluteos() + "', "
                + "costas='" + t.getCostas() + "' "
                + "WHERE id = '" + id + "'";

        try {
            SQLite.getInstancia().update(query);
        } catch (SQLException e) {
            throw e;
        }
    }

    public ArrayList<Treino> getTreinoPorId(int id) throws SQLException {
        try {
            String query = "SELECT id, nome, biceps, triceps, perna, abdominal, flexao, corrida, jump, supino, gluteos, costas FROM treino "
                    + "WHERE id = '" + id + "'";

            ResultSet rs = SQLite.getInstancia().getConsulta(query);
            ArrayList<Treino> result = new ArrayList<Treino>();
            while (rs.next()) {

                Treino t = new Treino(rs.getInt("id"), rs.getString("nome"), rs.getString("biceps"), rs.getString("triceps"),
                        rs.getString("perna"), rs.getString("abdominal"), rs.getString("flexao"), rs.getString("corrida"),
                        rs.getString("jump"), rs.getString("supino"), rs.getString("gluteos"), rs.getString("costas"));
                result.add(t);
            }
            return result;
        } catch (SQLException e) {
            throw e;
        }
    }

    public ArrayList<Treino> getTreinoPorNome(String nome) throws SQLException {
        try {
            String query = "SELECT id, nome, biceps, triceps, perna, abdominal, flexao, corrida, jump, supino, gluteos, costas FROM treino "
                    + "WHERE nome LIKE '" + nome + "'";

            ResultSet rs = SQLite.getInstancia().getConsulta(query);
            ArrayList<Treino> result = new ArrayList<Treino>();
            while (rs.next()) {

                Treino t = new Treino(rs.getInt("id"), rs.getString("nome"), rs.getString("biceps"), rs.getString("triceps"),
                        rs.getString("perna"), rs.getString("abdominal"), rs.getString("flexao"), rs.getString("corrida"),
                        rs.getString("jump"), rs.getString("supino"), rs.getString("gluteos"), rs.getString("costas"));
                result.add(t);
            }
            return result;
        } catch (SQLException e) {
            throw e;
        }
    }

    public boolean getIdTreinoBoolean(int id) throws SQLException {
        boolean aux = false;
        int aux2 = 0;
        String query = "SELECT id, nome FROM treino "
                + "WHERE id = '" + id + "'";
        try {
            ResultSet rs = SQLite.getInstancia().getConsulta(query);
            while (rs.next()) {
                aux2 = rs.getInt("id");
                if (id == aux2) {
                    aux = true;
                }
            }
            return aux;
        } catch (SQLException e) {
            throw e;
        }
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
}

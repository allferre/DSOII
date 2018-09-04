/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Allan
 */
public class SQLite {

    private Connection conn = null;
    private static SQLite instancia;

    public SQLite() throws SQLException {
        conecta();
    }

    public static SQLite getInstancia() throws SQLException {
        if (instancia == null) {
            try {
                instancia = new SQLite();
            } catch (SQLException e) {
                throw e;
            }
        }
        return instancia;
    }

    /**
     * Método para conectar a uma base de dados SQLite via JDBC.
     */
    public void conecta() throws SQLException {
        try {
            // parâmetros da base de dados
            String url = "jdbc:sqlite:academia.db";
            // cria a conexão à base de dadosc
            conn = DriverManager.getConnection(url);
            System.out.println("Conexão ao SQLite foi estabelecida.");
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println("Uma nova base de dados foi criada.");
        } catch (SQLException e) {
            throw e;
        }
    }

    public void desconecta() throws SQLException {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Conexão ao SQLite foi fechada.");
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Executa e retorna o resultado da consulta contida no parâmetro "query" no
     * banco de dados.
     *
     * @param query
     * @return
     * @throws SQLException
     */
    public ResultSet getConsulta(String query) throws SQLException {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Faz o update da instrução contida no parâmetro query no banco de dados.
     *
     * @param query
     * @return
     * @throws SQLException
     */
    public boolean update(String query) throws SQLException {
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }  finally { //liberar recursos de banco de dados
            pstmt = null;
            System.gc();
        }
    }

    /**
     * Faz o commit das operações realizadas no banco de dados.
     *
     */
    public void commit() throws SQLException {
        try {
            conn.commit();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void setAutoCommit(boolean autoCommit) throws SQLException {
        conn.setAutoCommit(autoCommit);
    }
}

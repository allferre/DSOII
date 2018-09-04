/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Allan
 */
public class AlunoTableModel extends AbstractTableModel {

    public List<Aluno> dados = new ArrayList<>();
    public String[] colunas = {"Id", "Nome", "CPF", "RG", "Nascimento", "Telefone", "Endereco"};

    @Override
    public String getColumnName(int i) {
        return colunas[i];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    /*
    public void setRowCount(int rowCount) {
        this.setRowCount(rowCount);
        this.fireTableDataChanged();
    } */
    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dados.get(linha).getId();
            case 1:
                return dados.get(linha).getNome();
            case 2:
                return dados.get(linha).getCpf();
            case 3:
                return dados.get(linha).getRg();
            case 4:
                return dados.get(linha).getNascimento();
            case 5:
                return dados.get(linha).getTelefone();
            case 6:
                return dados.get(linha).getEndereco();
        }
        return null;
    }

    public void addRow(Aluno a) {
        this.dados.add(a);
        this.fireTableDataChanged();
    }

    public void removeRow(int linha) {
        int i = dados.size();
        this.fireTableRowsDeleted(0, i);

    }

    public void limpaTabela() {
        dados.clear();
    }

}

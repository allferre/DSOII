/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Allan
 */
public class Treino {

    int id;
    String nome;
    String biceps;
    String triceps;
    String perna;
    String abdominal;
    String flexao;
    String corrida;
    String jump;
    String supino;
    String gluteos;
    String costas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBiceps() {
        return biceps;
    }

    public void setBiceps(String biceps) {
        this.biceps = biceps;
    }

    public String getTriceps() {
        return triceps;
    }

    public void setTriceps(String triceps) {
        this.triceps = triceps;
    }

    public String getPerna() {
        return perna;
    }

    public void setPerna(String perna) {
        this.perna = perna;
    }

    public String getAbdominal() {
        return abdominal;
    }

    public void setAbdominal(String abdominal) {
        this.abdominal = abdominal;
    }

    public String getFlexao() {
        return flexao;
    }

    public void setFlexao(String flexao) {
        this.flexao = flexao;
    }

    public String getCorrida() {
        return corrida;
    }

    public void setCorrida(String corrida) {
        this.corrida = corrida;
    }

    public String getJump() {
        return jump;
    }

    public void setJump(String jump) {
        this.jump = jump;
    }

    public String getSupino() {
        return supino;
    }

    public void setSupino(String supino) {
        this.supino = supino;
    }

    public String getGluteos() {
        return gluteos;
    }

    public void setGluteos(String gluteos) {
        this.gluteos = gluteos;
    }

    public String getCostas() {
        return costas;
    }

    public void setCostas(String costas) {
        this.costas = costas;
    }

    public Treino(int id, String nome, String biceps, String triceps, String perna, String abdominal, String flexao, String corrida, String jump, String supino, String gluteos, String costas) {
        this.id = id;
        this.nome = nome;
        this.biceps = biceps;
        this.triceps = triceps;
        this.perna = perna;
        this.abdominal = abdominal;
        this.flexao = flexao;
        this.corrida = corrida;
        this.jump = jump;
        this.supino = supino;
        this.gluteos = gluteos;
        this.costas = costas;
    }

}

package com.areaCurva;

import javax.swing.JOptionPane;

public class AreaDeCurva {
    
    private double A;
    private double B;
    private int Particoes;
    private int i;
    double TotArea = 0;
    
    public AreaDeCurva(double A, double B, int Particoes){ //método construtor
        this.A = A;
        this.B = B;
        this.Particoes = Particoes;
    }
    
    public void showAreaTotal(){ //calcula e mostra a área total aproximada
        
        for(setI(0); getI() < getParticoes(); setI(getI() + 1)){
           PosicaoAtual();
           ProxPosicao();
           Altura();
           AreaRetangulo();
           
           TotArea += AreaRetangulo();
        }
        JOptionPane.showMessageDialog(null, "A área total aproximada é: "+TotArea, "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public double Intervalo(){ //calcula o valor do intervalo (final - inicial)
        return getB() - getA();
    }
    
    public double Base(){ //calcula a base (intervalo / número de partições desejadas)
        return Intervalo() / getParticoes();
    }
    
    public double Altura(){ //calcula a altura de acordo com a posição atual f(x)
        if(PosicaoAtual() <= getA() && ProxPosicao() >= getA() || PosicaoAtual() <= getB() && ProxPosicao() >= getB()){
            return 0;
        } else if((Intervalo() / 2) + getA() <= PosicaoAtual()){
            return (-(ProxPosicao() * ProxPosicao()) + 4);
        } else {
            return (- (PosicaoAtual() * PosicaoAtual()) + 4);
        }
    }
    
    public double AreaRetangulo(){ //calcula a área individual de cada retangulo
        if(Altura() < 0)
            return (Base() * Altura()) * (-1);
        else
            return Base() * Altura();
    }
    
    public double PosicaoAtual(){ //mostra a posição atual f(x)
        return getA() + (Base() * getI());
    }
    
    public double ProxPosicao(){ //mostra a posição seguinte a f(x)
        return getA() + (Base() * (getI() + 1));
    }

    public double getA() {
        return A;
    }

    public void setA(double A) {
        this.A = A;
    }

    public double getB() {
        return B;
    }

    public void setB(double B) {
        this.B = B;
    }

    public int getParticoes() {
        return Particoes;
    }

    public void setParticoes(int Particoes) {
        this.Particoes = Particoes;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

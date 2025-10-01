package iftm.poov;
public class Porta {
    private Material material;
    private double largura;
    private boolean fechada; 
    private boolean trancada;

    
    public Porta() {
        System.out.println("Contrutor padrao da porta");
        material = Material.MADEIRA;
        largura = 60;
        fechada = true;
        trancada = true;
    }

    public Porta(String m, double l, boolean f, boolean t){
        System.out.println("Construtor de inicialização 1 da porta executado");
        setMaterial(m);
        setLargura(l);
        setFechar();
        setTrancar();
    }

    public void setMaterial(String m){
        if(m.equals("aço"))
            material = Material.ACO;
        else if(m.equals("madeira"))
            material = Material.MADEIRA;
        else if(m.equals("PVC"))
            material = Material.PVC;
        else if(m.equals("alumínio"))
            material = Material.ALUMINIO;
        else{ 
            System.out.println("Valor inválido de material. Usando valor padrão madeira");
            material = Material.MADEIRA;
        }
    }

    public void setLargura(double l){
        if(l == 60)
            largura = 60;
        else if(l == 70)
            largura = 70;
        else if(l == 80)
            largura = 80;
        else if(l == 90)
            largura = 90;
        else if(l == 100)
            largura = 100;
        else if(l == 110)
            largura = 120;
        else{ 
            System.out.println("Valor inválido de material. Usando valor padrão 60");
            largura = 60;
        }
    }

    public void setFechar(){
        fechada = true;
    }

    public void setAbrir(){
        if(trancada)
            System.out.println("IMPOSSIVEL ABRIR, PORTA TRANCADA");
        else
            fechada = false;
    }

    public void setTrancar(){
        if(fechada)
            trancada = true;
        else //ta aberta
            System.out.println("IMPOSSIVEL TRANCAR, PORTA ABERTA");
    }

    public void setDestrancar(){
        trancada = false;
    }

    public String getMaterial(){
        return material.getDescricao();
    }

    public double getLargura(){
        return largura;
    }

    public boolean isFechada(){
        return fechada;
    }
    
    public boolean isTrancada(){
        return trancada;
    }
}

// Classe Porta: material(madeira, aço, vidro, PVC, alumínio), largura(60, 70, 80, 90, 100, 110, 120), fechada e trancada; 
// -atributos privados
// -construtores: padrão e de inicialização
// -sets/gets
// -mostrarNaTela
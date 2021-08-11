package br.vianna.aula.appteatro.domain.entities.dto.relatorios;

public class RelatorioDTO {
    
    private String nomeEvento;
    private double valorLimpeza;
    private double valorLuz;
    private String nomeSalao; 
    private double valorAluguel; 
    private double somatorioIngresso;

    public RelatorioDTO() {
    }

    public RelatorioDTO(String nomeEvento, double valorLimpeza, double valorLuz, String nomeSalao, double valorAluguel, double somatorioIngresso) {
        this.nomeEvento = nomeEvento;
        this.valorLimpeza = valorLimpeza;
        this.valorLuz = valorLuz;
        this.nomeSalao = nomeSalao;
        this.valorAluguel = valorAluguel;
        this.somatorioIngresso = somatorioIngresso;
    }

    public double entrada(){
        if (this.valorAluguel != 0){
        return this.valorAluguel + this.valorLuz + this.valorLimpeza;
        } else {
        return this.somatorioIngresso;
        }
    }
    
    public double saida(){
        return this.valorAluguel != 0? 0 : this.valorLimpeza + this.valorLuz; 
    }
    
    public double total(){
        return this.entrada() - this.saida();
    }
    
    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public double getValorLimpeza() {
        return valorLimpeza;
    }

    public void setValorLimpeza(double valorLimpeza) {
        this.valorLimpeza = valorLimpeza;
    }

    public double getValorLuz() {
        return valorLuz;
    }

    public void setValorLuz(double valorLuz) {
        this.valorLuz = valorLuz;
    }

    public String getNomeSalao() {
        return nomeSalao;
    }

    public void setNomeSalao(String nomeSalao) {
        this.nomeSalao = nomeSalao;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public double getSomatorioIngresso() {
        return somatorioIngresso;
    }

    public void setSomatorioIngresso(double somatorioIngresso) {
        this.somatorioIngresso = somatorioIngresso;
    }
            
    
    
    
}

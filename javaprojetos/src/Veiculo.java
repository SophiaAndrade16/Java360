
public abstract class Veiculo {

    private String placa;
    private String velocidadeMax;
    private String tipoCombustivel;
    private String cor;

    public Veiculo() {
        super();
    }

    public Veiculo(String cor, String placa, String tipoCombustivel, String velocidadeMax) {
        this.cor = cor;
        this.placa = placa;
        this.tipoCombustivel = tipoCombustivel;
        this.velocidadeMax = velocidadeMax;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getVelocidadeMax() {
        return velocidadeMax;
    }

    public void setVelocidadeMax(String velocidadeMax) {
        this.velocidadeMax = velocidadeMax;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public abstract void mover();

}

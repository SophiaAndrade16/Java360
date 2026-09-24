public class Moto extends Veiculo implements IManutencao,IMeusimpostos{
    private Boolean temBau;

    public Moto(String cor, String placa, String tipoCombustivel, String velocidadeMax, Boolean temBau) {
        super(cor, placa, tipoCombustivel, velocidadeMax);
        this.temBau = temBau;
    }

    public Boolean getTemBau() {
        return temBau;
    }

    public void setTemBau(Boolean temBau) {
        this.temBau = temBau;
    }
    @Override
    public void mover(){
        IO.print("a moto se moveu!");
    }

    @Override
    public void adicionar() {
        // TODO Auto-generated method stub
        IO.print("Impostos adicionados");
    }

    @Override
    public void revisaoProgramada() {
        // TODO Auto-generated method stub
        IO.print("Faça a Revisão com a taxa:"+IManutencao.TAXA);
    }
    
}

public class Algoritmo34{
    //Encapsulamento
    //Se for publico todo mundo acessa
    //Public-privado-protected-packge
    //Private-apenas a classes autorizadas podem acessar
    //Packge-apenas no pacote

    private int PrimeiroNumero;//Atributo
    private int SegundoNumero;//Atributo

    public void setPrimeiroNumero(int PrimeiroNumero){
        /*atribuir-receber-guardar"=" */
        this.PrimeiroNumero=PrimeiroNumero;
    }
    public int getPrimeiroNumero(){
        return PrimeiroNumero;
    }
    public void setSegundoNumero(int SegundoNumero){

        this.SegundoNumero=SegundoNumero;
    }
    public int getSegundoNumero(){
        return SegundoNumero;
    }
}
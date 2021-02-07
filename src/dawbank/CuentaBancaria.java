/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dawbank;

/**
 *
 * @author Fatima
 */
public class CuentaBancaria {

    //Definimos los atributos requeridos. 
    private int [] iban;
    private String titular;
    private float saldo;
    private float[] movimientos;

    //Creamos el constructor requerido para poder acceder a las variables
    public CuentaBancaria(int [] iban, String titular) {
        this.iban = new int [22];
        this.titular = titular;
        this.saldo = saldo;
        this.movimientos = new float[100];
    }

    /*Añadimos getters para poder acceder a los atributos que son privados, mediante refactor -> encapsulated fields.
      No añadimos setters de los atributos que no queremos que sean modificados.
     */
    /**
     * @return the iban
     */
    public int[] getIban() {
        return iban;
    }

    /**
     * @return the titular
     */
    public String getTitular() {
        return titular;
    }

    /**
     * @return the saldo
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the movimientos
     */
    public float[] getMovimientos() {
        return movimientos;
    }

    /**
     * @param movimientos the movimientos to set
     */
    public void setMovimientos(float[] movimientos) {
        this.movimientos = movimientos;
    }

    //Creamos las funciones que van a ser usadas en el espacio de DawBank.
    
   
         
    public void registroMovimientos(float importe) {
        for (int i = 0; i < this.movimientos.length; i++){
            if (this.movimientos[i] == 0){
                this.movimientos[i] = importe;
                break;
            }
        }
    }    
    
    
    public void ingreso(float importe) {
        if (importe > 3000) {
            System.out.println("AVISO: Notificar a Hacienda");
        }else {
            setSaldo(this.saldo + importe);
            registroMovimientos(importe);
        }

    }

    public void retirada(float importe) {
        if (importe <= -50) {
            System.out.println("AVISO: Saldo negativo");
        }
        if (importe > 3000){
            System.out.println("AVISO: Notificar a Hacienda");
        }
        else {
            setSaldo(this.saldo - importe);
            registroMovimientos(importe);
        }
    }

}

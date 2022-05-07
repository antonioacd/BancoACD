package Cuentas;

import Banco_clases.Operaciones;
import Persona_Generica.Persona;

import java.io.Serializable;
import java.util.Calendar;

/**
 * La clase CuentaBonus nos permitira diferenciar entre otro tipo de cuenta, en este caso
 * no se podrá sacar dinero por debajo del límite establecido por el atributo LowerBound
 */

public class CuentaProtegida extends Cuenta implements Serializable {

    /**
     * Declaramos las variables de la Clase CuentaProtegida
     * <ul>
     *     <li>lowerBound: sera el limite establecido para sacar dinero</li>
     * </ul>
     */

    private float lowerBound;

    /**
     * Constructor de CuentaProtegida con los siguientes parametros
     *
     * @param owner Es de tipo Persona, por lo que tendra un Nombre, una Edad y Sexo
     * @param number Es de tipo String y sera el numero de la cuenta
     * @param lowerBound Es de tipo float y sera el limite establecido
     */

    public CuentaProtegida(Persona owner, String number, float lowerBound) {
        super(owner, number);
        this.lowerBound = lowerBound;
    }

    /**
     * Constructor de CuentaProtegida al que se le pasan los siguientes parametros
     *
     * @param owner Es de tipo Persona, por lo que tendra un Nombre, una Edad y Sexo
     * @param number Es de tipo String y sera el numero de la cuenta
     * @param balance Es de tipo float y sera la cantidad de dinero de la cuenta
     * @param lowerBound Es de tipo float y sera el limite aplicable
     */

    public CuentaProtegida(Persona owner, String number, float balance, float lowerBound) {
        super(owner, number, balance);
        this.lowerBound = lowerBound;
    }

    /**
     * <h1>Metodo withdraw de la clase CuentaProtegida</h1>
     *
     * Si la cantidad dada es positiva, menor o igual al saldo disponible y mayor o igual al limite establecido,
     * se retirara dicha cantidad, de no ser asi, mantendra el saldo de la cuenta igual y enviara un mensaje de error.
     *
     * @param amount Es la cantidad dada para realizar la operación
     * @author Antonio C.
     * @version 3.0
     * @since 17/04/2022
     */

    public void withdraw(float amount) {

        if(getBalance() > amount && amount > 0 && amount >= lowerBound){

            setBalance(getBalance()-amount);
            Operaciones op = new Operaciones("Retiro", amount, Calendar.getInstance());
            theOperations.add(op);
            writeFile(op.toString2());

        }else{

            System.out.println("Debe sacar un minimo de "+lowerBound+" Euros");
            setBalance(getBalance());
        }

    }

    /**
     * <h1>Metodo toString de CuentaProtegida</h1>
     *
     * @return valores de la clase Cuenta, pero indicando que es la clase CuentaProtegida
     * <ul>
     *     <li>Titular de la cuenta</li>
     *     <li>Numero de cuenta</li>
     *     <li>Balance o saldo de la cuenta</li>
     * </ul>
     * @author Antonio.C
     * @version 1.0
     * @since 09/04/2022
     */

    @Override
    public String toString() {
        return "CuentaProtegida:\n" + super.toString();
    }
}

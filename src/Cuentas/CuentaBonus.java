package Cuentas;

import Banco_clases.Operaciones;
import Persona_Generica.Persona;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;

/**
 * La clase CuentaBonus nos permitira diferenciar entre otro tipo de cuenta, en este caso
 * a la hora de dar un crédito, el titular será beneficiado por  un interés a favor marcado por el atributo BonusRate
 */

public class CuentaBonus extends Cuenta implements Serializable {

    /**
     * <h1>Declaramos las variables de la Clase Persona</h1>
     *
     * <ul>
     *     <li>bonusRate: Sera el interes que se aplicaraa la hora de dar un credito</li>
     * </ul>
     */

    private float bonusRate;

    /**
     * <h1>Constructor de CuentaBonus con los siguientes parametros</h1>
     *
     * @param bonusRate Es de tipo float y sera el interes aplicable
     * @param owner Es de tipo Persona, por lo que tendra un Nombre, una Edad y Sexo
     * @param number Es de tipo String y sera el numero de la cuenta
     */

    public CuentaBonus(float bonusRate, Persona owner, String number) {
        super(owner, number);
        this.bonusRate = bonusRate;
    }

    /**
     * <h1>Constructor de CuentaBonus al que se le pasan los siguientes parametros</h1>
     *
     * @param bonusRate Es de tipo float y sera el interes aplicable
     * @param owner Es de tipo Persona, por lo que tendra un Nombre, una Edad y Sexo
     * @param number Es de tipo String y sera el numero de la cuenta
     * @param balance Es de tipo float y sera la cantidad de dinero de la cuenta
     */

    public CuentaBonus(float bonusRate ,Persona owner, String number, float balance) {
        super(owner, number, balance);
        this.bonusRate = bonusRate;
    }

    /**
     * <h1>Metodo credit de la clase CuentaBonus</h1>
     *
     * Si la cantidad dada es positiva, se añadira a la cuenta la dicha cantidad mas el interes añadido, de no ser asi,
     * mantendra el saldo de la cuenta igual y enviara un mensaje de error.
     *
     * @param amount Es la cantidad dada para realizar la operación
     * @author Antonio C.
     * @version 3.0
     * @since 17/04/2022
     */

    public void credit(float amount) {

        try{

            if(amount > 0){

                setBalance(getBalance()+amount+(amount*bonusRate));
                Operaciones op = new Operaciones("Credito", amount+(amount*bonusRate), Calendar.getInstance());
                theOperations.add(op);
                writeFile(op.toString2());

            }else{

                System.out.println("El valor debe ser positivo");
                setBalance(getBalance());
            }

        }catch (NullPointerException e){

            System.out.println("1"+e.getMessage());

        }



    }

    /**
     * <h1>Metodo toString de CuentaBonus</h1>
     *
     * @return valores de la clase Cuenta, pero indicando que es la clase CuentaBonus
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
        return "CuentaBonus:\n" + super.toString();
    }
}

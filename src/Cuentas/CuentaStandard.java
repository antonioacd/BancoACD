package Cuentas;

import Banco_clases.Operaciones;
import Persona_Generica.Persona;

import java.io.Serializable;
import java.util.Calendar;

/**
 * La clase CuentaBonus nos permitira diferenciar entre otro tipo de cuenta, en este caso
 * a la hora de sacar dinero se le aplicará el interés correspondiente, por tanto, además de la cantidad a sacar,
 * se le restará al balance una pequeña cantidad dada por el interés aplicable
 */

public class CuentaStandard extends Cuenta implements Serializable {

    /**
     * <h1>Declaramos las variables de la clase CuentaStandard</h1>
     * <ul>
     *     <li>openDate: sera la fecha de la cuenta</li>
     *     <li>interest: sera el interes que se aplicara al sacar dinero</li>
     * </ul>
     */

    private Calendar openDate;
    private float interest;

    /**
     * <h1>Constructor de CuentaStandard con los siguientes parametros</h1>
     *
     * @param owner Es de tipo Persona, por lo que tendra un Nombre, una Edad y Sexo
     * @param number Es de tipo String y sera el numero de la cuenta
     * @param interest Es de tipo float y sera el interes establecido
     */

    public CuentaStandard(Persona owner, String number, float interest) {
        super(owner, number);
        this.openDate = openDate;
        this.interest = 0.02f;
    }

    /**
     * <h1>Constructor de CuentaStandard con los siguientes parametros</h1>
     *
     * @param owner Es de tipo Persona, por lo que tendra un Nombre, una Edad y Sexo
     * @param number Es de tipo String y sera el numero de la cuenta
     * @param openDate Es de tipo Calendar y sera la fecha de la cuenta
     * @param interest Es de tipo float y sera el interes establecido
     */

    public CuentaStandard(Persona owner, String number, float balance, Calendar openDate, float interest) {
        super(owner, number, balance);
        this.openDate = openDate;
        this.interest = 0.02f;
    }

    /**
     * <h1>Metodo withdraw de la clase CuentaStandard</h1>
     *
     * Si la cantidad dada es positiva y menor o igual al saldo disponible,
     * se retirara dicha cantidad menos un porcentaje añadido, de no ser asi,
     * mantendra el saldo de la cuenta igual y enviara un mensaje de error.
     *
     * @param amount Es la cantidad dada para realizar la operación
     * @author Antonio C.
     * @version 3.0
     * @since 17/04/2022
     */

    public void withdraw(float amount) {

        if(getBalance() > amount && amount > 0){

            setBalance(getBalance() - amount - (amount*interest));
            Operaciones op = new Operaciones("Retiro", amount-(amount*interest), Calendar.getInstance());
            theOperations.add(op);
            writeFile(op.toString2());

        }else{

            System.out.println("No dispone de suficiente cantidad");
            setBalance(getBalance());
        }

    }

    /**
     * <h1>Metodo toString de CuentaStandard</h1>
     *
     * @return valores de la clase Cuenta, pero indicando que es la clase CuentaStandard
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
        return "CuentaStandard:\n" + super.toString();
    }
}

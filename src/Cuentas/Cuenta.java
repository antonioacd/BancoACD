package Cuentas;

import Banco_clases.Operaciones;
import Interfaz.CuentaBanco;
import Persona_Generica.Persona;

import java.io.*;
import java.util.*;

/**
 * Clase Cuenta que se implementa los metodos de la interfaz CuentaBanco,
 * estos metodos seran las operaciones a realizar
 *
 * @see Interfaz.CuentaBanco
 */

public class Cuenta implements CuentaBanco{

    public static Scanner sc = new Scanner(System.in);

    /**
     * <h1>Declaramos las variables de la Clase Cuenta</h1>
     * <ul>
     *     <li>owner: sera la persona titular de la cuenta</li>
     *     <li>number: sera el numero de cuenta</li>
     *     <li>balance: cantidad de la que dispone la cuenta</li>
     *     <li>theOperations: es de tipo lista y sirve para guardar posteriormente las operaciones</li>
     * </ul>
     */

    private Persona owner;
    private String number;
    private float balance;
    protected List <Operaciones> theOperations;

    /**
     * <h1>Constructor de Cuenta con los siguientes parametros</h1>
     *
     * @param owner Es de tipo Persona, por lo que tendra un Nombre, una Edad y Sexo
     * @param number Es de tipo String y sera el numero de la cuenta
     */

    public Cuenta(Persona owner, String number) {
        this.owner = owner;
        this.number = number;
        this.balance = 0;
        this.theOperations = new ArrayList<>();
    }

    /**
     * <h1>Constructor de Cuenta al que se le pasan los siguientes parametros</h1>
     *
     * @param owner Es de tipo Persona, por lo que tendra un Nombre, una Edad y Sexo
     * @param number Es de tipo String y sera el numero de la cuenta
     * @param balance Es de tipo float y sera la cantidad de dinero de la cuenta
     */

    public Cuenta(Persona owner, String number, float balance) {
        this.owner = owner;
        this.number = number;
        this.balance = 0;
        this.theOperations = new ArrayList<>();
    }

    public void writeFile(String operacion){

        FileWriter file = null;
        PrintWriter pw = null;

        try {

            file = new FileWriter("COMPROBANTE.txt");
            pw = new PrintWriter(file);

            String texto_dentro = operacion + "" +
                    "\n      Cuenta: "+getNumber();

            pw.println(texto_dentro);

        } catch (Exception e) {

            System.err.println(e.getMessage()+"\n"+e.getCause());

        }finally {

            try {
                pw.close();
                file.close();
            }catch (Exception e){

                System.err.println(e.getMessage()+"\n"+e.getCause());

            }
        }
    }


    /**
     * <h1>Metodo credit de la clase Cuenta</h1>
     *
     * Si la cantidad dada es positiva, se añadira a la cuenta, de no ser asi,
     * mantendra el saldo de la cuenta igual y enviara un mensaje de error.
     *
     * @param amount Es la cantidad dada para realizar la operación
     * @author Antonio C.
     * @version 3.0
     * @since 17/04/2022
     */

    @Override
    public void credit(float amount) {

        if(amount > 0){

            setBalance(getBalance()+amount);
            Operaciones op = new Operaciones("Credito",amount,Calendar.getInstance());
            theOperations.add(op);
            System.out.println(op.toString());
            writeFile(op.toString2());

        }else{

            System.out.println("El valor debe ser positivo");
            setBalance(getBalance());
        }

    }

    /**
     * <h1>Metodo withdraw de la clase Cuenta</h1>
     *
     * Si la cantidad dada es positiva y menor o igual al saldo disponible, se retirara dicha cantidad, de no ser asi,
     * mantendra el saldo de la cuenta igual y enviara un mensaje de error.
     *
     * @param amount Es la cantidad dada para realizar la operación
     * @author Antonio C.
     * @version 3.0
     * @since 17/04/2022
     */

    @Override
    public void withdraw(float amount) {

        if(getBalance() >= amount && amount > 0){

            setBalance(getBalance()-amount);
            Operaciones op = new Operaciones("Retiro", amount, Calendar.getInstance());
            theOperations.add(op);
            writeFile(op.toString2());

        }else{

            System.out.println("No dispone de suficiente cantidad");
            setBalance(getBalance());
        }

    }

    /**
     * <h1>Metodo deposit de la clase Cuenta</h1>
     *
     * Si la cantidad dada es positiva, se depositara a la cuenta, de no ser asi,
     * mantendra el saldo de la cuenta igual y enviara un mensaje de error.
     *
     * @param amount Es la cantidad dada para realizar la operación
     * @author Antonio C.
     * @version 3.0
     * @since 17/04/2022
     */

    @Override
    public void deposit(float amount) {

        if(amount > 0){

            this.setBalance(this.getBalance()+amount);
            Operaciones op = new Operaciones("Deposito",amount,Calendar.getInstance());
            theOperations.add(op);
            writeFile(op.toString2());

        }else{

            System.out.println("El valor debe ser positivo");
            this.setBalance(this.getBalance());
        }

    }

    /**
     * <h1>Setter de Owner</h1>
     * Sirve para cambiar el parametro anterior por el que se le pasa
     * @param owner Persona titular de la cuenta
     */

    public void setOwner(Persona owner) {
        this.owner = owner;
    }

    /**
     * <h1>Setter de Number</h1>
     * Sirve para cambiar el parametro anterior por el que se le pasa
     * @param number Numero de cuenta
     */

    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * <h1>Setter de Balance</h1>
     * Sirve para cambiar el parametro anterior por el que se le pasa
     * @param balance Saldo de la cuenta
     */

    public void setBalance(float balance) {
        this.balance = balance;
    }

    /**
     * <h1>Getter de Owner</h1>
     * @return owner: Persona titular de la cuenta
     */

    @Override
    public Persona getOwner() {
        return owner;
    }

    /**
     * <h1>Getter de Number</h1>
     * @return number: Numero de cuenta
     */

    @Override
    public String getNumber() {
        return number;
    }

    /**
     * <h1>Getter de Balance</h1>
     * @return balance: Saldo de la cuenta
     */

    @Override
    public float getBalance() {
        return balance;
    }

    /**
     * <h1>Metodo displayOperations de la clase Cuenta</h1>
     *
     * @return tmp: variable de tipo string en la que se va almacenando la informacion del ArrayList theOperations
     * @author Antonio C.
     * @version 3.0
     * @since 18/04/2022
     */

    public String displayOperations(){

        Iterator<Operaciones> itr=theOperations.iterator();
        String tmp=" ";
        while(itr.hasNext()){

            Operaciones e=(Operaciones) itr.next();
            tmp = tmp.concat(e.toString());
        }

        return tmp;

    }

    /**
     * <h1>Metodo getOperationsAfter de la clase Cuenta</h1>
     *
     * @param time: tiempo que le pasamos
     * @return las operaciones que se han realizado posteriormente a la fecha introducida
     * @author Antonio C.
     * @version 4.0
     * @since 19/04/2022
     */

    @Override
    public List<Operaciones> getOperationsAfter(Calendar time) {

        List<Operaciones> theOperationsFecha = new ArrayList<>();

        for (Operaciones operation: this.theOperations) {
            if(time.getTimeInMillis() < operation.getDate().getTimeInMillis()) {
                theOperationsFecha.add(operation);
            }
        }
        return theOperationsFecha;
    }

    /**
     * <h1>Metodo toString de Cuenta</h1>
     *
     * @return valores de la clase Cuenta
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
        return "Titular: " + owner +
                "\nNº Cuenta: " + number +
                "\nBalance: " + balance + "\n";
    }
}

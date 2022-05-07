package Banco_clases;

import Cuentas.Cuenta;
import Interfaz.CuentaBanco;

import java.io.Serializable;
import java.util.*;

/**
 * Clase Banco que guardara las <b>cuentas y operaciones</b> en un HashMap,
 * y llamara a la clase Cuenta para realizar las operaciones
 */

public class Banco implements Serializable {

    /**
     * <h1>Declaramos las variables de la Clase Banco</h1>
     *
     * <ul>
     *     <li>listaCuentas: sera el HashMap para almacenar los datos de la cuenta Banco</li>
     * </ul>
     */

    Map<String, CuentaBanco> listaCuentas;


    /**
     * <h1>Constructor de la clase Banco vacio</h1>
     *
     * Sirve para atribuir el HashMap a un atributo
     */

    public Banco() {

        this.listaCuentas = new HashMap<>();

    }

    public Banco(Map<String, CuentaBanco> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    /**
     * <h1>Metodo addAccount de la clase Banco</h1>
     *
     * Añade una cuenta creada al HashMap creado
     *
     * @param account es de tipo CuentaBanco y sera la cuenta añadida
     * @author Antonio C.
     * @version 3.0
     * @since 19/04/2022
     */

    public void addAccount(CuentaBanco account){

        listaCuentas.put(account.getNumber(), account);

    }

    /**
     * <h1>Metodo removeAccount de la clase cuenta banco</h1>
     *
     * Elimina una cuenta del HashMap creado
     *
     * @author Antonio C.
     * @version 3.0
     * @since 19/04/2022
     */

    public void removeAccount(String accountNumber){

        listaCuentas.remove(accountNumber);

    }

    /**
     * <h1>Metodo displayBalance de la clase Banco</h1>
     *
     * @param accountNumber es de tipo Sring y sera el identificador unico de cada cuenta
     * @return balance_final, sera el saldo de la cuenta en tipo String
     * @author Antonio C.
     * @version 3.0
     * @since 19/04/2022
     */

    public String displayBalance(String accountNumber){

        String balance_final = "";

        balance_final.valueOf(listaCuentas.get(accountNumber).getBalance());

        return balance_final;
    }

    /**
     * <h1>Metodo creditAccount de la clase Banco</h1>
     *
     * El metodo se encarga de seleccionar la cuenta correcta dentro del HashMap mediante el identificador unico,
     * que es el numero de cuenta y de llamar al metodo correspondiente de la clase Cuenta
     *
     * @param accountNumber es de tipo Sring y sera el identificador unico de cada cuenta
     * @param amount es la cantidad pasada para realizar la operacion
     * @author Antonio C.
     * @version 3.0
     * @since 19/04/2022
     * @see Cuentas.Cuenta
     */

    public void creditAccount(String accountNumber, float amount) throws Exception {

        listaCuentas.get(accountNumber).credit(amount);

    }

    /**
     * <h1>Metodo withdraw de la clase Banco</h1>
     *
     * El metodo se encarga de seleccionar la cuenta correcta dentro del HashMap mediante el identificador unico,
     * que es el numero de cuenta y de llamar al metodo correspondiente de la clase Cuenta
     *
     * @param accountNumber es de tipo Sring y sera el identificador unico de cada cuenta
     * @param amount es la cantidad pasada para realizar la operacion
     * @author Antonio C.
     * @version 3.0
     * @since 19/04/2022
     * @see Cuentas.Cuenta
     */


    //para sacar dinero de una cuenta
    public void withdraw(String accountNumber, float amount){

        listaCuentas.get(accountNumber).withdraw(amount);

    }

    /**
     * <h1>Metodo displayAccount de la clase Banco</h1>
     *
     * El metodo se encarga de seleccionar la cuenta correcta dentro del HashMap mediante el identificador unico,
     * que es el numero de cuenta y de llamar al metodo correspondiente de la clase Cuenta
     *
     * @param accountNumber es de tipo Sring y sera el identificador unico de cada cuenta
     * @author Antonio C.
     * @version 3.0
     * @since 19/04/2022
     * @see Cuentas.Cuenta
     */

    public void displayAccount(String accountNumber){

        System.out.print(listaCuentas.get(accountNumber).toString());

    }

    public void displayAccounts_corto(){

        for (Map.Entry<String,CuentaBanco>entrada:listaCuentas.entrySet()){

            System.out.println(entrada.getKey()+"->"+entrada.getValue().getOwner());

        }

    }


    public void displayAccounts(){

        for (Map.Entry<String,CuentaBanco>entrada:listaCuentas.entrySet()){

            System.out.println(entrada.getKey()+"->"+entrada.getValue());

        }

    }

    /**
     * <h1>Metodo creditAccount de la clase Banco</h1>
     *
     * El metodo se encarga de retirar dinero de una cuenta y añadirle a otra llamando los metodos creados anteriormente
     *
     * @param from es de tipo Sring y sera el identificador unico de la primera cuenta
     * @param to es de tipo Sring y sera el identificador unico de la segunda cuenta
     * @param amount es la cantidad pasada para realizar la operacion
     * @author Antonio C.
     * @version 3.0
     * @since 19/04/2022
     */

    public void transfer(String from, String to, float amount){

        float balance_anterior = listaCuentas.get(from).getBalance();

        listaCuentas.get(from).withdraw(amount);

        if(listaCuentas.get(from).getBalance() != balance_anterior){

            listaCuentas.get(to).deposit(amount);

        }

    }

    /**
     * <h1>Metodo deposit de la clase Banco</h1>
     *
     * El metodo se encarga de seleccionar la cuenta correcta dentro del HashMap mediante el identificador unico,
     * que es el numero de cuenta y de llamar al metodo correspondiente de la clase Cuenta
     *
     * @param accountNumber es de tipo Sring y sera el identificador unico de cada cuenta
     * @param amount es la cantidad pasada para realizar la operacion
     * @author Antonio C.
     * @version 3.0
     * @since 19/04/2022
     * @see Cuentas.Cuenta
     */

    public void deposit(String accountNumber, float amount){

        listaCuentas.get(accountNumber).deposit(amount);

    }

    public void cambiar_nombre(String accountNumber, String nombre){

        listaCuentas.get(accountNumber).getOwner().setNombre(nombre);

    }

    public void cambiar_edad(String accountNumber, int edad){

        listaCuentas.get(accountNumber).getOwner().setEdad(edad);

    }

    public void cambiar_nombre(String accountNumber, char sexo){

        listaCuentas.get(accountNumber).getOwner().setSexo(sexo);

    }

    /**
     * <h1>Metodo listOperationsAccount de la clase Banco</h1>
     *
     * El metodo se encarga de seleccionar la cuenta correcta dentro del HashMap mediante el identificador unico,
     * que es el numero de cuenta y de llamar al metodo correspondiente de la clase Cuenta
     *
     * @param accountNumber es de tipo Sring y sera el identificador unico de cada cuenta
     * @param time es de tipo Calendar y sera la fecha a partir de la cual se listaran las operaciones de cada cuenta
     * @author Antonio C.
     * @version 3.0
     * @since 19/04/2022
     * @see Cuentas.Cuenta
     */

    public List<Operaciones> listOperationsAccount(String accountNumber, Calendar time){

        return listaCuentas.get(accountNumber).getOperationsAfter(time);

    }

}

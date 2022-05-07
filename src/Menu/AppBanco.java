package Menu;

import Banco_clases.Banco;
import Banco_clases.Operaciones;
import Cuentas.CuentaBonus;
import Cuentas.CuentaProtegida;
import Cuentas.CuentaStandard;
import Persona_Generica.Persona;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AppBanco implements Serializable{

    Scanner sc = new Scanner(System.in);

    Banco bank = new Banco();


    /**
     * <h1>Metodo writeFile de la clase AppBanco</h1>
     *
     * Este metodo nos permite guardar nuestra operacion, escribiendola en un archivo txt
     *
     * @param operacion es de tipo String y seria lo que se introduciria en nuestro comprobante
     * @author Antonio C.
     * @version 3.0
     * @since 28/04/2022
     */

    public void writeFile(String operacion){

        FileWriter file = null;
        PrintWriter pw = null;

        try {

            file = new FileWriter("COMPROBANTE.txt");
            pw = new PrintWriter(file);

            sc.nextLine();
            String texto_dentro = operacion;

            pw.println(operacion);

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

    public String generar_num(){

        String numero = "number-" + (int)Math.floor(Math.random()*(100-999)+999);

        return numero;

    }

    public void crear_c_protegida(){

        System.out.println("Introduzca su nombre: ");
        sc.nextLine();
        String nombre = sc.nextLine();

        System.out.println("Introduzca su edad: ");
        int edad = sc.nextInt();

        System.out.println("Introduzca su sexo: ");
        char sexo = sc.next().charAt(0);

        System.out.println("Introduzca el limite minimo: ");
        float lowerBound = sc.nextFloat();

        bank.addAccount(new CuentaProtegida(new Persona(nombre,edad,sexo),generar_num(),lowerBound));

    }

    public void crear_c_bonus(){

        System.out.println("Introduzca su nombre: ");
        sc.nextLine();
        String nombre = sc.nextLine();

        System.out.println("Introduzca su edad: ");
        int edad = sc.nextInt();

        System.out.println("Introduzca su sexo: ");
        char sexo = sc.next().charAt(0);

        System.out.println("Introduzca el bonus Rate: ");
        float bonusRate = sc.nextFloat();

        bank.addAccount(new CuentaBonus(bonusRate,new Persona(nombre,edad,sexo),generar_num()));

    }

    public void crear_c_standard(){

        System.out.println("Introduzca su nombre: ");
        sc.nextLine();
        String nombre = sc.nextLine();

        System.out.println("Introduzca su edad: ");
        int edad = sc.nextInt();

        System.out.println("Introduzca su sexo: ");
        char sexo = sc.next().charAt(0);

        System.out.println("Introduzca el interes: ");
        float interest = sc.nextFloat();

        bank.addAccount(new CuentaStandard(new Persona(nombre,edad,sexo),generar_num(),interest));

    }

    public void ingresar(){

        bank.displayAccounts_corto();

        System.out.println("Indique el numero de cuenta: ");
        sc.nextLine();
        String accountNumber = sc.nextLine();
        System.out.println("Indique la cantidad a ingresar: ");
        float amount = sc.nextFloat();
        sc.nextLine();

        bank.deposit(accountNumber,amount);


        System.out.println("Operacion realizada:\n");
        bank.displayAccount(accountNumber);

    }

    public void retirar(){

        bank.displayAccounts_corto();

        System.out.println("Indique el numero de cuenta: ");
        sc.nextLine();
        String accountNumber = sc.nextLine();
        System.out.println("Indique la cantidad a retirar: ");
        float amount = sc.nextFloat();
        sc.nextLine();

        bank.withdraw(accountNumber, amount);

        System.out.println("Operacion realizada:\n");
        bank.displayAccount(accountNumber);

    }

    public void credito() throws Exception {

        bank.displayAccounts();

        System.out.println("Indique el numero de cuenta: ");
        sc.nextLine();
        String accountNumber = sc.nextLine();
        System.out.println("Indique el credito que desea: ");
        float amount = sc.nextFloat();
        sc.nextLine();

        bank.creditAccount(accountNumber, amount);

        System.out.println("Operacion realizada:\n");
        bank.displayAccount(accountNumber);

    }

    public void transferencia(){

        bank.displayAccounts_corto();

        System.out.println("Desde que cuenta desea hacer la transferencia: ");
        sc.nextLine();
        String from = sc.nextLine();
        System.out.println("A que cuenta desea hacer la transferencia: ");
        String to = sc.nextLine();
        System.out.println("Indique el credito que desea: ");
        float amount = sc.nextFloat();
        sc.nextLine();

        bank.transfer(from, to, amount);

        System.out.println("Operacion realizada:\n");
        bank.displayAccount(from);
        bank.displayAccount(to);

    }

    public void listar_cuentas(){

        bank.displayAccounts();

    }

    public void mostrar_cuenta(){

        bank.displayAccounts_corto();

        System.out.println("Indique el numero de cuenta: ");
        sc.nextLine();
        String accountNumber = sc.nextLine();

        bank.displayAccount(accountNumber);

    }

    public void mostrar_balance(){

        bank.displayAccounts_corto();

        System.out.println("Indique el numero de cuenta: ");
        sc.nextLine();
        String accountNumber = sc.nextLine();
        bank.displayBalance(accountNumber);

    }

    public void listar_desde_fecha(){

        bank.displayAccounts_corto();

        Calendar time = Calendar.getInstance();

        System.out.println("Indique el numero de cuenta: ");
        sc.nextLine();
        String accountNumber = sc.nextLine();
        System.out.println("Indique la fecha en el siguiente formato (dd/mm/aa)");
        String fecha = sc.nextLine();

        int dia = Integer.parseInt(fecha.substring(0,2));

        int mes = Integer.parseInt(fecha.substring(4,5))-1;

        int anio = Integer.parseInt(fecha.substring(6));

        System.out.println(dia+" "+mes+" "+anio);

        time.set(Calendar.DAY_OF_MONTH,+dia);
        time.set(Calendar.MONTH,+mes);
        time.set(Calendar.YEAR,+anio);

        System.out.println(time.getTime());

        for(Operaciones o: bank.listOperationsAccount(accountNumber, time)){
            System.out.print(o);
        }

    }

    public void modificar_datos(){

        bank.displayAccounts_corto();

        System.out.println("Indique el numero de cuenta: ");
        sc.nextLine();
        String accountNumber = sc.nextLine();

        System.out.println(
                "   \n1- Cambiar nombre\n" +
                "   2- Cambiar edad\n" +
                "   3- Cambiar sexo\n" +
                "   ¿Que desea realizar?\n");

        int op = sc.nextInt();

        switch(op){

            case 1:

                System.out.println("Introduzca el nuevo nombre: ");
                sc.nextLine();
                String nombre = sc.nextLine();

                bank.cambiar_nombre(accountNumber, nombre);

                break;

            case 2:

                System.out.println("Introduzca la nueva edad: ");
                sc.nextLine();
                int edad = sc.nextInt();

                bank.cambiar_edad(accountNumber, edad);

                break;

            case 3:

                System.out.println("Introduzca el nuevo sexo: ");
                sc.nextLine();
                char sexo = sc.next().charAt(0);

                bank.cambiar_nombre(accountNumber, sexo);

                break;

            case 4:

                ingresar();
                break;

        }

        System.out.println("Cambio realizado:\n");
        bank.displayAccount(accountNumber);

    }

    public void borrar_cuenta(){

        bank.displayAccounts_corto();

        System.out.println("Indique el numero de cuenta: ");
        sc.nextLine();
        String accountNumber = sc.nextLine();

        bank.removeAccount(accountNumber);

        System.out.println("Cambio realizado:");
        bank.displayAccounts_corto();

    }

    public void guardarFichero(){

        System.out.println("Con que nombre quieres guardarlo: ");
        sc.nextLine();
        String fichero = sc.nextLine();

        FileOutputStream fos = null;
        ObjectOutputStream ops = null;

        try {

            fos = new FileOutputStream(fichero+".txt");
            ops = new ObjectOutputStream(fos);

            ops.writeObject(bank);

            System.out.println("Guardado en "+fichero);

        } catch (FileNotFoundException ex) {

            System.err.print("1"+ex.getMessage());

        } catch (IOException ex) {

            System.err.print("2"+ex.getMessage()+" Causa: "+ex.getCause());
            ex.getStackTrace();
            ex.printStackTrace();

        } finally {

            try {
                if (fos != null) fos.close();
                if (ops != null) ops.close();

            } catch (IOException ex) {

                System.out.println("3" + ex.getMessage());

            }
        }
    }

    public void cargarFichero() throws IOException {

        System.out.println("Que archivo desea cargar: ");
        sc.nextLine();
        String fichero = sc.nextLine();

        FileInputStream fi=null;
        ObjectInputStream entrada=null;

        try {

            fi = new FileInputStream(fichero+".txt");
            entrada = new ObjectInputStream(fi);

            System.out.println("Se ha cargado el fichero: "+fichero);

            bank = (Banco) entrada.readObject();

        } catch (EOFException e) {

            System.out.println("Fin del archivo");

        }catch (IOException | ClassNotFoundException e) {

            System.err.println("Ocurrio un error..."+e.getMessage());
            e.printStackTrace();

        }finally{

            if (entrada!=null) {
                entrada.close();
                fi.close();
            }

        }

    }

    public void menu() throws Exception {

        boolean elegir = true;

        do{

            System.out.println(
                    "   \n1- Crear Cuenta Protegida\n" +
                    "   2- Crear Cuenta Bonus\n" +
                    "   3- Crear Cuenta Standard\n" +
                    "   4- Ingresar Dinero en Cuenta\n" +
                    "   5- Sacar Dinero de Cuenta\n" +
                    "   7- Conceder Crédito a Cuenta\n" +
                    "   8- Hacer Transferencia entre Cuentas\n" +
                    "   9- Listar Cuentas del Banco\n" +
                    "   10- Mostrar Cuenta\n" +
                    "   11- Mostrar Balance De Cuenta\n" +
                    "   12- Listar Operaciones de Cuenta desde Fecha\n" +
                    "   13- Modificar datos titular\n" +
                    "   14- Borrar Cuenta\n" +
                    "   15- Guardar Banco en Fichero\n" +
                    "   16- Cargar Banco desde Fichero\n" +
                    "   0 - Salir\n\n" +
                    "¿Que desea realizar?\n");

            int op = sc.nextInt();

            switch(op){

                case 0:

                    elegir=false;
                    break;

                case 1:

                    crear_c_protegida();

                    break;

                case 2:

                    crear_c_bonus();

                    break;

                case 3:

                    crear_c_standard();

                    break;

                case 4:

                    ingresar();
                    break;

                case 5:

                    retirar();

                    break;

                case 7:

                    credito();

                    break;

                case 8:

                    transferencia();

                    break;

                case 9:

                    listar_cuentas();

                    break;

                case 10:

                    mostrar_cuenta();

                    break;

                case 11:

                    mostrar_balance();

                    break;

                case 12:

                    listar_desde_fecha();

                    break;

                case 13:

                    modificar_datos();

                    break;

                case 14:

                    borrar_cuenta();

                    break;

                case 15:
                    guardarFichero();
                    break;

                case 16:
                    cargarFichero();
                    break;

            }

        }while(elegir);			//Final del programa//

    }





}

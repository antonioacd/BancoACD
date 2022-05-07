package Start;

import Banco_clases.Banco;
import Menu.AppBanco;

import java.io.IOException;

public class Launch {

    public static void main(String[] args) throws Exception {

        AppBanco menu = new AppBanco();

        menu.menu();
/*
        Banco bank = new Banco();
        Calendar time;
        //creamos tres cuentas diferentes
        bank.addAccount(new CuentaProtegida(new Persona("Jose",40,'H'),"number1",100));
        bank.addAccount(new CuentaBonus(0.01f,new Persona("Maria",35,'F'),"number2"));
        bank.addAccount(new CuentaStandard(new Persona("Jose",33,'H'),"number3",1500));
        //variable para mostrar operaciones desde una fecha
        time=Calendar.getInstance();
        time.set(Calendar.HOUR,-2);
        //diferentes operaciones
        bank.creditAccount("number1", 1000);
        bank.deposit("number1", 100);
        bank.creditAccount("number2", 500);
        bank.withdraw("number3", 100);
        bank.transfer("number1", "number3", 100);
        //mostramos las cuentas
        System.out.println(bank.displayAccount("number1"));
        System.out.println(bank.displayAccount("number2"));
        System.out.println(bank.displayAccount("number3"));
        //mostrar operaciones desde fecha para una cuenta
        System.out.print("\nOperaciones de number1 desde "+time.getTime());
        for(Operaciones o: bank.listOperationsAccount("number1", time)){
            System.out.print(o);
        }*/
    }
}

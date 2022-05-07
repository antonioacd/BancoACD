package Interfaz;

import Banco_clases.Operaciones;
import Persona_Generica.Persona;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

/**
 * Interfaz CuentaBanco a la que añadimos los metodos vacios de la clse Cuenta que despues implementaremos
 */

public interface CuentaBanco extends Serializable {

    public void credit(float amount);
    public void withdraw(float amount);
    public void deposit(float amount);
    public Persona getOwner();
    public String getNumber();
    public float getBalance();
    public List<Operaciones> getOperationsAfter(Calendar time);

}
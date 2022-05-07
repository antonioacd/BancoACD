package Persona_Generica;

import java.io.Serializable;

/**
 * La clase persona nos va a servir para identificar al titular de las cuentas de banco
 */

public class Persona implements Serializable {

    /**
     * <h1>Declaramos las variables de la Clase Persona</h1>
     *
     * <ul>
     *     <li>nombre: Sera una cadena de letras, nombre de la persona</li>
     *     <li>edad: sera un numero de dos cifras, la edad de la persona</li>
     *     <li>sexo: sera o una F o una M y sera el sexo de la persona</li>
     * </ul>
     */

    private String nombre;
    private int edad;
    private char sexo;

    /**
     * <h1>Creamos un constructor y le pasamos los siguientes parametros</h1>
     *
     * @param nombre : es de tipo String, y sera el nombre de la persona.
     * @param edad : es de tipo Int y seran los años de la persona.
     * @param sexo : es de tipo char e indicara si la persona es hombre o mujer.
     */

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * <h1>Metodo toString de Persona</h1>
     *
     * @return valores de la clase Persona
     * <ul>
     *     <li>nombre</li>
     *     <li>edad</li>
     *     <li>sexo</li>
     * </ul>
     * @author Antonio.C
     * @version 1.0
     * @since 06/04/2022
     */

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", sexo=" + sexo +
                '}';
    }
}

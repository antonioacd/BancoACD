package Banco_clases;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Con la clase operaciones vamos a darle valores unos atributos a las operaciones que realicemos
 */

public class Operaciones implements Serializable {

    /**
     * <h1>Declaramos las variables de la Clase Operaciones</h1>
     *
     * <ul>
     *     <li>date: sera una fecha</li>
     *     <li>amount: sera una cantidad, ya sea para introducir o sacar dinero</li>
     *     <li>type: nos indicara el tipo de operacion que se ha relizado</li>
     * </ul>
     */

    private Calendar date;
    private float amount;
    private String type;

    /**
     * <h1>Creamos un constructor al que hay que pasarle los siguientes parametros:</h1>
     *
     * @param type : es de tipo String y sera una descripcion del tipo de operacion
     * @param amount : es de tipo float y sera una cantidad con la que se trabaja en la operacion
     * @param date : es de tipo Calendar y sera la fecha en la que se realiza la operacion
     */

    public Operaciones(String type, float amount, Calendar date) {
        this.type = type;
        this.date = Calendar.getInstance();
        this.amount = amount;
    }

    /**
     * <h1>Metodo changeCalendar que va a modificar la fecha anterior por una nueva que le introducimos</h1>
     *
     * @param date : fecha que se modifica
     */

    public void changeCalendar(Calendar date) {
        this.date = date;
    }

    /**
     * <h1>Getter de Date</h1>
     * @return la fecha de la operacion
     */

    public Calendar getDate() {
        return date;
    }

    /**
     * <h1>Metodo toString de Operaciones</h1>
     *
     * @return valores de la clase Operaciones
     * <ul>
     *     <li>Tipo de operación</li>
     *     <li>Cantidad de la operación</li>
     *     <li>Fecha de la operación</li>
     * </ul>
     * @author Antonio.C
     * @version 1.0
     * @since 07/04/2022
     */

    @Override
    public String toString() {
        return "\nOperaciones: "+"{ Tipo: " + type + "  Cantidad: " + amount + "    Fecha: "+date.getTime()+" }";
    }

    public String toString2() {
        return "\n              MI BANCO    "+
                "\nFecha: "+date.getTime()+
                "\nOperacion: "+type+"  de  "+amount+" euros";
    }
}

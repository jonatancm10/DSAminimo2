package DAO;


import Entity.Etakemons;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hicham.az on 12/12/2016.
 */
public class QueryBuilderEtakemon {


    private static List<Etakemons> miLista = new ArrayList<Etakemons>();

    public static Etakemons montarRegistro(ResultSet res) throws SQLException
    {
        Etakemons miEta = new Etakemons();
        if ((res != null)  && res.next())
        {
            miEta.setName(res.getString("nombre"));
            miEta.setPuntos(res.getString("puntos"));
            miEta.setTipo(res.getString("tipo"));
        }
        return miEta;
    }

    public static List<Etakemons> montarLista(Etakemons miEta)
    {
        if(miEta!=null)
            miLista.add(miEta);
        return miLista;
    }

    public static String obtenWhere(Etakemons miEta) {
        String out = obtenLista(miEta, "AND"); // " WHERE " ;
        if (out.length() > 0)
            out = "WHERE " + out;
        return out;
    }

    public static String obtenInsert(Etakemons miEta)
    {
        String res ="";
        if(miEta!=null)
            res= miEta.getId()+",'"+ miEta.getName() +"','"+ miEta.getPuntos()+"','" + miEta.getTipo()+"'";
        return res;
    }

    public static String obtenSet(Etakemons miEta)
    {
        String out = obtenLista(miEta, ",");
        if (out.length() > 0)
            out = "SET " + out;
        return out;
    }

    private static String obtenLista(Etakemons miEta, String separador) {
        String salida = "";
        if (miEta != null) {
            salida = addCampo(salida, "nombre", miEta.getName(), separador);
            salida = addCampo(salida, "puntos", miEta.getPuntos(), separador);
            salida = addCampo(salida, "tipo", miEta.getPuntos(), separador);
        }
        return salida;
    }

    public static String addCampo(String salida, String nombreCampo, double valor, String separador) {
        if (valor != 0)
            salida = addSalidaSencilla(salida, nombreCampo, "" + (int) valor, separador);
        return salida;
    }

    public static String addCampo(String salida, String nombreCampo, String valor, String separador) {
        if (valor.length() > 0 && valor.compareTo("") != 0)
            salida = addSalidaSencilla(salida, nombreCampo, "'" + valor + "'", separador);
        return salida;

    }

    public static String addSalidaSencilla(String salida, String nombreCampo, String valor, String separador) {
        if (salida.length() > 0)
            salida += " " + separador + " ";
        if (nombreCampo != null && nombreCampo.compareTo("") > 0)
            salida += nombreCampo + " = ";

        salida += valor;

        return salida;
    }

}

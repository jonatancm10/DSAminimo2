package logica;

import DAO.DAOBrain;
import Entity.Etakemons;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "GOT it!";
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   // @Produces("List<String>")
    @Path("/postear")
    public String Algo(@FormParam("name ") String name,@FormParam("tipo ") String tipo, @FormParam("puntos") int puntos)
    {
        String[] miLista = new String[2];
        miLista[0]="1";
        Etakemons e = new Etakemons();
        e.setName("pikachu");
        e.setPuntos("500");
        e.insert();
        miLista[1]="2";
        e.setName("charmander");
        e.setPuntos("700");
        e.insert();
        miLista[2]="3";
        e.setName("raichu");
        e.setTipo("electrico");
        e.setPuntos("900");
        e.insert();


        return name +" tiene " + puntos +  " puntos y es de tipo " + tipo + e.getId();
    }
}

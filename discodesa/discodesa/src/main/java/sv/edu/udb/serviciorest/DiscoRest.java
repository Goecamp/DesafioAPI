package sv.edu.udb.serviciorest;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sv.edu.udb.model.disco;
import sv.edu.udb.model.DiscoDAO;

@Path("disco")
public class DiscoRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDisco() throws SQLException {
        DiscoDAO discoDAO = new DiscoDAO();
        List<disco> disco = discoDAO.findAll();

        return Response.status(200).entity(disco).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByDiscoId(@PathParam("id") int id) throws SQLException {
        DiscoDAO discoDAO = new DiscoDAO();
        disco disco = discoDAO.findById(id);

        if (disco == null) {
            return Response.status(404).build();
        }

        return Response.status(200).entity(disco).build();
    }
}


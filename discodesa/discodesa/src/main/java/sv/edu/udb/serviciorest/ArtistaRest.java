package sv.edu.udb.serviciorest;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import sv.edu.udb.model.artista;
import sv.edu.udb.model.ArtistaDAO;

@Path("artista")
public class ArtistaRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArtista() throws SQLException {
        ArtistaDAO artistaDAO = new ArtistaDAO();
        List<artista> artista = artistaDAO.findAll();

        return Response.status(200).entity(artista).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByArtistaId(@PathParam("id") int id) throws SQLException {
        ArtistaDAO artistaDAO = new ArtistaDAO();
        artista artista = artistaDAO.findById(id);

        if (artista == null) {
            return Response.status(404).build();
        }

        return Response.status(200).entity(artista).build();
    }
}


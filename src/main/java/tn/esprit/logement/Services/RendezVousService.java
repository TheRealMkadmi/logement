package tn.esprit.logement.Services;

import io.swagger.annotations.Api;
import tn.esprit.logement.DAL.RendezVousRepository;
import tn.esprit.logement.Entities.RendezVous;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

@Path("rendezvous")
@Api(value = "RendezVous Service", produces = MediaType.APPLICATION_JSON)
public class RendezVousService {
    public static RendezVousRepository R = new RendezVousRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRdv(RendezVous rdv) {
        if (!R.addRendezVous(rdv)) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.status(Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCountry(@PathParam("id") int id) {

        R.deleteRendezVous(id);
        if (!R.deleteRendezVous(id)) {
            return Response.status(Status.CREATED).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List getListeRendezVous() {
        List ListeRendezVous = R.getListeRendezVous();
        return ListeRendezVous;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RendezVous getRendezVous(@PathParam("id") int id) {
        RendezVous rdv = R.getRendezVousById(id);
        return rdv;
    }

    @GET
    @Path("/log/{ref}")
    @Produces(MediaType.APPLICATION_JSON)
    public List ListeRendezVousByLogementReference(@PathParam("ref") int ref) {
        List rdv = R.getListeRendezVousByLogementReference(ref);
        return rdv;
    }
}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	



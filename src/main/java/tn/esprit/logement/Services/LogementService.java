package tn.esprit.logement.Services;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.logement.DAL.LogementRepository;
import tn.esprit.logement.Entities.Logement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("logement")
@Api(value = "Logement Service", produces = MediaType.APPLICATION_JSON)
public class LogementService {

    public static LogementRepository R = new LogementRepository();

    @GET
    @ApiOperation(value = "Get all logements", notes = "Get all logements")
    @Produces(MediaType.APPLICATION_JSON)
    public List getListeLogements() {
        List ListeLogements = R.getLogements();
        return ListeLogements;
    }

    @GET
    @Path("/delegation/{delegation}")
    @ApiOperation(value = "Get logements by delegation", notes = "Get logements by delegation")
    @Produces(MediaType.APPLICATION_JSON)
    public List LogementsByDeleguation(@PathParam("delegation") String delegation) {
        List ListeLogements = R.getLogementsByDeleguation(delegation);
        return ListeLogements;
    }


    @GET
    @Path("/gouvernorat/{gouvernorat}")
    @ApiOperation(value = "Get logements by gouvernorat", notes = "Get logements by gouvernorat")
    @Produces(MediaType.APPLICATION_JSON)
    public List LogementsByGouvernorat(@PathParam("gouvernorat") String gouvernorat) {
        List ListeLogements = R.getLogementsByGouvernorat(gouvernorat);
        return ListeLogements;
    }


    @GET
    @Path("/type/{type}")
    @ApiOperation(value = "Get logements by type", notes = "Get logements by type")
    @Produces(MediaType.APPLICATION_JSON)
    public List LogementsByGouvernorat(@PathParam("type") Logement.Type type) {
        List ListeLogements = R.getLogementsByType(type);
        return ListeLogements;
    }

    @GET
    @Path("/prix/{prix}")
    @ApiOperation(value = "Get logements by prix", notes = "Get logements by prix")
    @Produces(MediaType.APPLICATION_JSON)
    public List LogementsByPrix(@PathParam("prix") float prix) {
        List ListeLogements = R.getLogementsByPrix(prix);
        return ListeLogements;
    }
}
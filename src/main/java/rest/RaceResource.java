/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.Race.RaceDTO;
import entities.Race;
import facades.RaceFacade;
import facades.UserFacade;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rest.provider.Provider;
import static rest.provider.Provider.EMF;

/**
 * REST Web Service
 *
 * @author PC
 */
@Path("race")
public class RaceResource extends Provider {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();  
    private static final RaceFacade REPO =  RaceFacade.getRaceFacade(EMF); 
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RaceResource
     */
    public RaceResource() {
    }

    /**
     * Retrieves representation of an instance of entities.RaceResource
     * @return an instance of java.lang.String
     */
    
    @GET
    @Path("all")
    public Response getAll(){
        List<RaceDTO> races=REPO.getAll();
        return Response.ok(GSON.toJson(races)).build();
    }
    
     @POST
     public Response create(String race) {
        RaceDTO raceDTO = GSON.fromJson(race, RaceDTO.class);
        RaceDTO newRaceDTO = REPO.createRace(raceDTO);
        return Response.ok(GSON.toJson(newRaceDTO)).build();
     }
    
}

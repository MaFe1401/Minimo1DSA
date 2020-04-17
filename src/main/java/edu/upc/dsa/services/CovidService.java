package edu.upc.dsa.services;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.models.Brote;
import edu.upc.dsa.Caso;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
@Api(value = "/brotes", description = "Endpoint al servicio de adopcion de mascotas")
@Path("/brotes")
public class CovidService {
    private Covid19ManagerImpl manager;
    public CovidService(){
        this.manager=Covid19ManagerImpl.getInstance();
        if (this.manager.size()==0){
            String x=this.manager.AddBrote();
            manager.AddCaso(x, new Caso("Marc","Ferre Mancebo", "14/01/2000", "17/4/2020", "alto", "Hombre","marcf@gmail.com", 655042343,"mi casa", "sospechoso"));
        }
    }
    @POST
    @ApiOperation(value = "Añadir brote", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Brote.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/addBrote/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response nuevoBrote(){
        Brote c = new Brote();
        String id= c.GetIdentificador();
        this.manager.AddBrote(c);
        return Response.status(201).entity(manager.GetBrote(id)).build();
    }
    @PUT
    @ApiOperation(value = "Add caso a brote", notes = "Asv")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Brote.class),
            @ApiResponse(code = 404, message = "Brote no encontrado")
    })
    @Path("/addCaso/{BroteId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response AddCaso(@PathParam("BroteId")String BroteId, Caso c){
        this.manager.AddCaso(BroteId,c);
        return Response.status(201).entity(manager.GetBrote(BroteId)).build();
    }




}

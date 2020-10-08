package fr.insa.soa.RestProject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("etudiants")
public class EtudiantRessource {

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTest() {
        return "TEST";
    }
    
    
    //GET http://localhost:8080/RestProject/webapi/etudiants
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant getEtudiants(@Context UriInfo uriInfo) {
		Etudiant etudiant = new Etudiant();
		etudiant.setNom("N");
		etudiant.setPrenom("G");
		etudiant.setID(01);
		etudiant.addLink(getUriforSelf(uriInfo,etudiant), "self", "GET");
		etudiant.addLink(getUriforStage(uriInfo), "Stage", "GET");
		return etudiant;
	}
	
	private String getUriforStage(UriInfo uriInfo) {
		String url = uriInfo.getBaseUriBuilder()
				.path(StageRessource.class)
				.build().toString();
		return url;
	}
	
	private String getUriforSelf(UriInfo uriInfo, Etudiant etudiant) {
		String url = uriInfo.getBaseUriBuilder()
				.path(EtudiantRessource.class)
				.path(Long.toString(etudiant.getID()))
				.build().toString();
		return url;
	}
	
	@GET
	@Path("/{idEtudiant}")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant getEtudiant(@PathParam("idEtudiant") int id) {
		Etudiant etudiant = new Etudiant();
		etudiant.setNom("A");
		etudiant.setPrenom("B");
		return etudiant;
	}
	
    //POST http://localhost:8080/RestProject/webapi/etudiants
	/*
	{
    "binome" : {
        "nom" : "A",
        "prenom" : "B",
    	},
    "nom" : "N",
    "prenom" : "G"
	}
	*/
	 
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addEtudiant(Etudiant etudNouv) {
		System.out.println("Ajout de l'étudiant "  + etudNouv.getNom() + " " + etudNouv.getPrenom() + " réussie!");
	}
}

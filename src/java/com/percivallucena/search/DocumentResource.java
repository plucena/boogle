package com.percivallucena.search;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author percivallucena
 */
@Path("index")
public class DocumentResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DocumentResource
     */
    public DocumentResource() {
    }

    /**
     *  RETURNS A LIST OF ALL DOCUMENTS STORED IN THE INDEX
     */
    @GET
    @Produces("application/json")
    public List<Document> getJson(@Context ServletContext servletContext) {
         
         if(servletContext.getAttribute("index") != null) {
                 Index index = (Index) servletContext.getAttribute("index");
                 return index.ListAllDocs();
          }
         else {
             System.out.println("NO INDEX");
             return new LinkedList<Document>();
         }     
    }

    /**
     * ADDS A NEW DOCUMENT TO THE INDEX
     */
    @PUT
    @Consumes("application/json")     
    public Response putJson(@Context ServletContext servletContext, Document content) {
        Index index;
        
        if(content!=null) {
             if(servletContext.getAttribute("index") == null)  {
                 System.out.println("Initiating index");
                 index = new Index();
                 
             }
             else
                index = (Index) servletContext.getAttribute("index"); 
                
             index.addDocument(content);
             servletContext.setAttribute("index", index);
             return Response.ok().build();  
         }
        return Response.noContent().build();
    }   
}

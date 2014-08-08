/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.percivallucena.search;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author percivallucena
 */
@Path("search")
public class SearchResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SearchResource
     */
    public SearchResource() {
    }

    /**
     * Retrieves representation of an instance of com.percivallucena.search.SearchResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public List<Result> getJson(@QueryParam("query") String query, @Context ServletContext servletContext) {
         List<Result> results = new LinkedList<Result>() ; 
         if(servletContext.getAttribute("index") != null) {
                 Index index = (Index) servletContext.getAttribute("index");
                 Score score = Search.Search(index,query);
                 results = score.calculateScore();
            
         }
         return results;
     }

}

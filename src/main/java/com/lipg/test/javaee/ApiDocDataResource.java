/*
 * Class: GbmsOpenApiResource
 * Description:
 * Version: 1.0
 * Author: nick
 * Creation date: Jan 6, 2018
 * (C) Copyright 2018 IBM Corporation. All rights reserved.
 */
package com.lipg.test.javaee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import io.swagger.v3.jaxrs2.integration.resources.BaseOpenApiResource;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * 
 * @author nick
 *
 */
@Path("/apidocdata.{type:json|yaml}")
public class ApiDocDataResource extends BaseOpenApiResource {
    
    //

    @GET
    @Produces({ MediaType.APPLICATION_JSON, "application/yaml" })
    public Response getOpenApi(@Context Application app, @Context HttpHeaders headers,
            @Context UriInfo uriInfo, @PathParam("type") String type) throws Exception {
     
         SwaggerConfiguration oasConfig = new SwaggerConfiguration().openAPI(new OpenAPI().info(new Info().title("GBMS rest api doc")
                 .description("This is a test doc data ")
                 .termsOfService("test term")
                 .contact(new Contact().email("lipg@test.com"))
                 .license(new License().name("TODO 2.0")).version("1.0")));
    	
        this.setOpenApiConfiguration(oasConfig);

        return super.getOpenApi(headers, null, app, uriInfo, type);
    }
}

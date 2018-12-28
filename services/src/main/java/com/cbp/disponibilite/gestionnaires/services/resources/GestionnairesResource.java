package com.cbp.disponibilite.gestionnaires.services.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Path("/")
public class GestionnairesResource {

    @GET
    public Response findAll() {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            input = classLoader.getResourceAsStream("custom.properties");

            // load a properties file
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return Response.status(200).entity("hellooo " + prop.getProperty("JDBC_CONNDDECTION_STRING") + " " + prop.getProperty("JDBC_USER") + " " + prop.getProperty("JDBC_PASSWORD")).build();
    }

}

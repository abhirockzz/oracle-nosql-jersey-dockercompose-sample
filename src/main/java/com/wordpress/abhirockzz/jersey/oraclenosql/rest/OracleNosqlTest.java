
package com.wordpress.abhirockzz.jersey.oraclenosql.rest;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author agupgupt
 */
public class OracleNosqlTest {

    public static final String BASE_URI = "http://0.0.0.0:8080/";

    public static void main(String[] args) throws IOException, InterruptedException {
        final ResourceConfig rc = new ResourceConfig().packages("com.wordpress.abhirockzz.jersey.oraclenosql.rest");
        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
        
        System.out.println("Jersey app running...");
        new CountDownLatch(1).await();
        server.stop();
    }

}

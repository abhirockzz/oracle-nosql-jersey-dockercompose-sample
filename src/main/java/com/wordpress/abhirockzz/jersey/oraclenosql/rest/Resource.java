package com.wordpress.abhirockzz.jersey.oraclenosql.rest;

import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import oracle.kv.KVStore;
import oracle.kv.KVStoreConfig;
import oracle.kv.KVStoreFactory;
import oracle.kv.Key;
import oracle.kv.Value;

/**
 *
 * @author agupgupt
 */
@Path("")
public class Resource {

    @Path("{key}")
    @GET
    public Response get(@PathParam("key") String key) {
        System.out.println("Searching for key --- " + key);
        String storeName = "kvstore";
        String hostName = "localhost";
        //String hostName = "kvlite1";
        String hostPort = "5000";

        KVStoreConfig config = new KVStoreConfig(storeName, System.getenv("ORANOSQL_DOCKER_HOST") + ":" + hostPort);
        //KVStoreConfig config = new KVStoreConfig(storeName, "localhost" + ":" + hostPort);

        KVStore kvstore = KVStoreFactory.getStore(config);
        System.out.println("Connected");
        //kvstore.put(Key.fromString("/1"), Value.createValue(new Date().toString().getBytes()));
        String value = new String(kvstore.get(Key.fromString("/" + key)).getValue().toByteArray());
        System.out.println("Value ---> " + value);
        kvstore.close();
        System.out.println("Disconnected");
        return Response.ok(value).build();
    }

    @POST
    public void put(String key) {
        System.out.println("Pushing key --- " + key);
        String storeName = "kvstore";
        String hostName = "localhost";
        //String hostName = "kvlite1";
        String hostPort = "5000";

        KVStoreConfig config = new KVStoreConfig(storeName, System.getenv("ORANOSQL_DOCKER_HOST") + ":" + hostPort);
        //KVStoreConfig config = new KVStoreConfig(storeName, "localhost" + ":" + hostPort);

        KVStore kvstore = KVStoreFactory.getStore(config);
        System.out.println("Connected");
        kvstore.put(Key.fromString("/" + key), Value.createValue(new Date().toString().getBytes()));

        System.out.println("POST completed");
        kvstore.close();
        System.out.println("Disconnected");

    }
}

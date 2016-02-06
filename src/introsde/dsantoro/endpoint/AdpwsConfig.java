package introsde.dsantoro.endpoint;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("ws/adpws")
public class AdpwsConfig extends ResourceConfig {
	public AdpwsConfig () {
		packages("introsde.dsantoro.resources"); // Jersey will load all the resources under this package
	}
}


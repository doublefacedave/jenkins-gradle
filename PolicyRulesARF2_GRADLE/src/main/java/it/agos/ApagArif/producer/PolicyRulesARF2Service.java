package it.agos.ApagArif.producer;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.ProxyBuilder;
import org.jboss.resteasy.logging.Logger;



@Path("/gestione-clienti/prevendita/risk-management/v0.1")
public class PolicyRulesARF2Service implements PolicyRulesARF2ServiceInterface {

	@Resource(lookup = "java:jboss/camel/context/policy-rules-arf2-spring-context")
	private CamelContext camelContext;
	
	// uncomment to inject the Java DSL based Camel context using Camel CDI. 
	//@ContextName("camel-context")
	//private CamelContext camelContext;
	
	private PolicyRulesARF2ServiceInterface myServiceProxy;
			
	@PostConstruct
	private void construct() {
		try {
			// camel proxy creation
			myServiceProxy = new ProxyBuilder(camelContext)
					.endpoint("direct:start")
					.binding(false)
					.build(PolicyRulesARF2ServiceInterface.class);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	@GET
	@Path("/PolicyRule-ARF2")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response invokeService( @HeaderParam("Authorization") String authorization,
										@QueryParam("cod_istituto") String cod_istituto,
										@QueryParam("cod_programma_elab") String cod_programma_elab,
										@QueryParam("cod_user_lab") String cod_user_lab,
										@QueryParam("cod_pratica") double cod_pratica,
										@QueryParam("cod_contesto") String cod_contesto) throws IOException
	{
		Logger logger = Logger.getLogger(PolicyRulesARF2Service.class);
		logger.info("invocando la servlet ...");
		return myServiceProxy.invokeService(authorization, cod_istituto, cod_programma_elab, cod_user_lab, cod_pratica, cod_contesto);
	}

}


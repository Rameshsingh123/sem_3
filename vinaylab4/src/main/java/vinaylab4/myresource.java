package vinaylab4;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class myresource extends CoapResource{

	public myresource(String name) {
		super(name);
	}
	int i=0;
	public void handleGET(CoapExchange exchange)
	{
		exchange.respond("temperature"+(i++));
	}
	public static void main(String args[]) {
	CoapServer c =new CoapServer();
	c.add(new myresource("humidity"));
	
	c.start();
	}	
	}



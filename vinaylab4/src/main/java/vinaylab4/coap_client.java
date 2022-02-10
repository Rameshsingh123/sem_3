package vinaylab4;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.elements.exception.ConnectorException;
import java.net.http.HttpClient;

public class coap_client {

	public static void main(String[] args) {
		
		CoapClient cl=new CoapClient("coap://127.0.0.1/humidity");
		for(int i=0;i<30;i++) {
			String text;
			try
			{
				text=cl.get().getResponseText();
				System.out.println("humidity"+text);
				Thread.sleep(100);
			}
			catch(ConnectorException c) {
				System.out.println(c);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	
	
	}
}
	

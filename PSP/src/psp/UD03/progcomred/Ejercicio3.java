/**
 * 
 */
package psp.UD03.progcomred;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @author JESUS
 *
 */
public class Ejercicio3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		URL url = null;
		URLConnection urlCon = null;
		try {
			url = new URL("http://www.iescristobaldemonroy.es/wordpress");
			urlCon = url.openConnection();
			
			Map<String, List<String>> headers = urlCon.getHeaderFields();			
			headers.forEach((k, v) -> System.out.println("Cabecera: " + k + ", valor: "  + v));			

		} catch (MalformedURLException e) {
				e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}

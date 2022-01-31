/**
 * 
 */
package psp.UD03.progcomred.utilidades;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author JESUS
 *
 */
public class ClienteTuTiempo {
	private static final String urlEndPoint = "https://api.tutiempo.net/xml/";
	private static final String language = "es";
	private static final String apid = "zwDX4azaz4X4Xqs";
	private static final String lid = "3768";
	
	private URLConnection urlCon;
	
	public ClienteTuTiempo(){
		conecta();
	}
	
	private String generaURL() {
		String url = urlEndPoint;
		url += "?lan=" + language;
		url += "&apid=" + apid;
		url += "&lid=" + lid;
		return url;
	}
	
	public void conecta() {		
		String informacion = "";
		
		URL url = null;		
		try {
			url = new URL(generaURL());
			urlCon = url.openConnection();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public String obtenerTiempo() {
		String inputLine, salida = "";
		
		BufferedReader in;
		InputStream inputStream;
		try {
			inputStream = urlCon.getInputStream();
			in = new BufferedReader(new InputStreamReader(inputStream));
			
			while ((inputLine = in.readLine()) != null) {
				salida += inputLine;
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return salida;
	}	
	
	public void leerXML() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document document;
			document = builder.parse(urlCon.getInputStream());
			document.getDocumentElement().normalize();			
			Node raiz = document.getDocumentElement();
			
			for(int i=1; i<24; i++) {
				NodeList horas = ((Element)raiz).getElementsByTagName("hour"+i);
				Node nodoHorai = horas.item(0);
				String fecha = ((Element)nodoHorai).getElementsByTagName("date").item(0).getTextContent();
				String hora = ((Element)nodoHorai).getElementsByTagName("hour_data").item(0).getTextContent();
				String temperatura = ((Element)nodoHorai).getElementsByTagName("temperature").item(0).getTextContent();
				System.out.println(fecha + " --> " + hora + ": " + temperatura + "ºC");
			}			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
}
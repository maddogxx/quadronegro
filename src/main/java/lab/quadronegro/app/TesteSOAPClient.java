package lab.quadronegro.app;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

public class TesteSOAPClient {
	private static final String URL = "http://www.dneonline.com/calculator.asmx";

	private static final String SERVER_URI = "http://tempuri.org/";
	private static final String PREFIXO_NAMESPACE = "tem";
	
	public static void main(String[] args) {
		String intA = "2";
		String intB = "3";
		
		try {
			MessageFactory factory = MessageFactory.newInstance();
			SOAPMessage message = factory.createMessage();
			
			SOAPPart part = message.getSOAPPart();
			SOAPEnvelope envelope = part.getEnvelope();
			envelope.addNamespaceDeclaration(PREFIXO_NAMESPACE, SERVER_URI);
			
			// Remover header
//			message.getSOAPHeader().detachNode();
			SOAPBody corpo = envelope.getBody();
			
			MimeHeaders cabecalhos = message.getMimeHeaders();
			cabecalhos.addHeader("SOAPAction", SERVER_URI + "Add");
			
			SOAPElement elemento = corpo.addChildElement("Add", PREFIXO_NAMESPACE);
			
			elemento.addChildElement("intA", PREFIXO_NAMESPACE).addTextNode(intA);
			elemento.addChildElement("intB", PREFIXO_NAMESPACE).addTextNode(intB);
			
			message.saveChanges();
			
			System.out.print("Request SOAP Message = ");
			message.writeTo(System.out);
			System.out.println();
			
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			
			SOAPMessage soapResponse = soapConnection.call(message, URL);
			
			String response = soapResponse.getSOAPBody().extractContentAsDocument().getDocumentElement().getTextContent();
			
			soapConnection.close();
			
			System.out.println(response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
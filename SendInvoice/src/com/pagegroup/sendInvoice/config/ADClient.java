package com.pagegroup.sendInvoice.config;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;


import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;

import org.apache.struts.util.MessageResources;
import org.apache.struts.util.MessageResourcesFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class ADClient {
	private URLStreamHandler handler; 
	private  MessageResources adClient;

	
	public ADClient(final int timeOut) {
    	
		//Definir Timeout 
    	handler = new URLStreamHandler() {
            @Override
            protected URLConnection openConnection(URL url) throws IOException {
               URL clone_url = new URL(url.toString());
               HttpURLConnection clone_urlconnection = (HttpURLConnection) clone_url.openConnection();
               clone_urlconnection.setConnectTimeout(timeOut);
               clone_urlconnection.setReadTimeout(timeOut);
               return(clone_urlconnection); 
        }};
        
		try {
			
            MessageResourcesFactory factory = MessageResourcesFactory.createFactory();
            adClient = factory.createResources("adclient");
            
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	
	}	
	
	  private  SOAPMessage autheticationRequest(String user, String password) throws Exception {
	        MessageFactory messageFactory = MessageFactory.newInstance();
	        SOAPMessage soapMessage = messageFactory.createMessage();
	        SOAPPart soapPart = soapMessage.getSOAPPart();
	        SOAPEnvelope envelope = soapPart.getEnvelope();
	        
	        try {	        
	        	
	        	MimeHeaders headers =soapMessage.getMimeHeaders();
	        	 headers.addHeader("SOAPAction", "http://tempuri.org/IPermission/AuthenticateUser");
	        	envelope.addNamespaceDeclaration("tem", "http://tempuri.org/");
	        	SOAPBody soapBody = envelope.getBody();
	        	SOAPElement soapBodyElemA = soapBody.addChildElement("AuthenticateUser"  , "tem");
	        	SOAPElement soapBodyElem1 = soapBodyElemA.addChildElement("userName", "tem");
	        	soapBodyElem1.addTextNode(user);
	        	SOAPElement soapBodyElem2 = soapBodyElemA.addChildElement("password", "tem");
	        	soapBodyElem2.addTextNode(password);
	        	SOAPElement soapBodyElem3 = soapBodyElemA.addChildElement("systemId", "tem");
	        	soapBodyElem3.addTextNode(adClient.getMessage("adclient.systemid"));
	        	soapMessage.saveChanges();
	        	
	        	//soapMessage.writeTo(System.out);
	        }
	        catch (Exception ex) {
	        	System.out.println(ex.getStackTrace());
	        	throw ex;
	        }

	        return soapMessage;
	    }	

		public boolean login(String user, String password)  throws Exception {

			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			SOAPMessage soapResponse;
			
	        try {	        
	 	      		   

	 	        URL endpoint = new URL(null, adClient.getMessage("adclient.url"), handler) ;
		        soapResponse = soapConnection.call(autheticationRequest(user, password), endpoint);
	            soapConnection.close();
	            //soapResponse.writeTo(System.out);

	            Element  docElem = ((Document) getDocumentFromSoapMessage(soapResponse)).getDocumentElement();
	            
	            if ( docElem.getElementsByTagName("AuthenticateUserResponse").getLength() == 0) {
	            	return false;
	            }

	            return true;
	        } 
	        catch (Exception e) {
	        	System.out.println(e.getStackTrace());
	        	throw e;
	        }
		}	 
		
		
		private Document getDocumentFromSoapMessage(SOAPMessage message)  throws Exception {
			
			try
			{
		      	TransformerFactory transformerFactory =	TransformerFactory.newInstance();
		    	Transformer transformer = transformerFactory.newTransformer();
		        Source sourceContent = message.getSOAPPart().getContent();
		        DOMResult result = new DOMResult();
		        transformer.transform(sourceContent, result);
		        org.w3c.dom.Node domSOAPMessageRoot = result.getNode();
		
		        return (org.w3c.dom.Document)domSOAPMessageRoot;
			}
			catch (Exception ex) {
			 	System.out.println(ex.getStackTrace());
	        	throw ex;
			}
		}
	  
	
}

package es.projecto.config;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.projecto.facebook.conection.FacebookConection;
import es.projecto.twitter.conection.TwitterMain;

public class ReadXML {


	public static void main(String[] args) {
		
		
		try {

			File fXmlFile = new File("src/BDA/es/projecto/config/NewFile.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("name");
			
			System.out.println("----------------------------");

				for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
						
						
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;
						
						
						FacebookConection fc = new FacebookConection(eElement.getElementsByTagName("accessToken").item(0)
								.getTextContent());
						
						System.out.println(fc);
						
							
						TwitterMain tw = new TwitterMain(eElement.getElementsByTagName("consumerKey").item(0).getTextContent(),
								eElement.getElementsByTagName("consumerSecret").item(0).getTextContent(),
								eElement.getElementsByTagName("AccessToken").item(0).getTextContent(),
								eElement.getElementsByTagName("AccessTokenSecret").item(0).getTextContent());
						
						System.out.println(tw.getStatuses());
						
					}
			
				}
			
		 } catch (Exception e) {
				e.printStackTrace();
			    }
	}
}

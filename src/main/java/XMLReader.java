import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;


public class XMLReader {
    public static void parse(String rec) throws ParserConfigurationException, IOException, SAXException {
        TimeParser y = new TimeParser();
        System.out.println("Root element: ");
        System.out.print(rec);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(rec));
        Document doc = db.parse(is);
        String str_chances_of_rain = ", chance of rain is ";
        doc.getDocumentElement().normalize();
        NodeList latLonList = doc.getElementsByTagName("request");
        NodeList nodeListTemperature = doc.getElementsByTagName("current_condition");
        NodeList nodeListRain = doc.getElementsByTagName("chanceofrain");
        NodeList nodeListDesc = doc.getElementsByTagName("weatherDesc");
        NodeList nodeListTime = doc.getElementsByTagName("time");
        NodeList nodeListTemp = doc.getElementsByTagName("tempC");

        for (int i = 0; i < latLonList.getLength(); i++) {
            Node node = latLonList.item(i);
            System.out.println("\nNode Name :" + node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                System.out.println(eElement.getElementsByTagName("query").item(0).getTextContent());
            }
        }
        for (int i = 0; i < nodeListTemperature.getLength(); i++) {
            Node node = nodeListTemperature.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                String x = eElement.getElementsByTagName("temp_C").item(0).getTextContent();
                System.out.println("Current temperature is " + x + "C");
            }
        }
        for (int i = 0; i < nodeListRain.getLength(); i++) {
            Element elementRain = (Element) nodeListRain.item(i);
            Element elementDescription = (Element) nodeListDesc.item(i + 1);
            Element elementTime = (Element) nodeListTime.item(i);
            Element elementTemp = (Element) nodeListTemp.item(i);
            System.out.print("\n");
            y.parseFromXML(elementTime.getTextContent());
            System.out.print(" " + elementTemp.getTextContent() + "°C" + str_chances_of_rain);
            System.out.print(elementRain.getTextContent() + "%, " + elementDescription.getTextContent());
        }
    }
}

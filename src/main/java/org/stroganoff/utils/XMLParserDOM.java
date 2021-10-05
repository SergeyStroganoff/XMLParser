package org.stroganoff.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParserDOM {

    /**
     * @param fileXMLPathName pathName fo xml data file;
     * @return NodeList
     * @throws ParserConfigurationException, IOException, SAXException
     */
    public Document getXMLDocument(String fileXMLPathName) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new File(fileXMLPathName));
    }

    public NodeList getNodeListByElementName(Document document, String elementTagName) {
        return document.getDocumentElement().getElementsByTagName(elementTagName);
    }

    public <T> List<T> elementCollect(NodeList nodeList) {
        List<T> tList = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println(node.getNodeValue());
            System.out.println(node.getNodeName());
            String content = node.getTextContent().replace("\n"," ").trim();
            System.out.println(content.replaceAll("\\s{2,}","^"));
        }
        return tList;
    }
}

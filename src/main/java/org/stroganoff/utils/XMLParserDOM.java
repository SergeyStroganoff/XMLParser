package org.stroganoff.utils;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLParserDOM {

    /**
     * @param elementTagName  element we adding to nodelist
     * @param fileXMLPathName pathName fo xml data file;
     * @return NodeList
     * @exception  ParserConfigurationException, IOException, SAXException
     */
    public NodeList getNodeList(String fileXMLPathName, String elementTagName) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(fileXMLPathName));
        return document.getDocumentElement().getElementsByTagName(elementTagName);
    }
}

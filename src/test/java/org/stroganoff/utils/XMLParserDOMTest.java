package org.stroganoff.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class XMLParserDOMTest {
    String xmlFilePath = "src/main/resources/stones.xml";
    String element = "gem";
    @InjectMocks
    XMLParserDOM xmlParserDOM;

    @Test
    void getDocumentTest_NOT_ThrowAnyException() {
        // GIVEN
        // WHEN
        // THEN
        Assertions.assertDoesNotThrow(() -> xmlParserDOM.getXMLDocument(xmlFilePath));
    }

    @Test
    void getDocumentTest_ReturnNotNulDocument() throws ParserConfigurationException, IOException, SAXException {
        // GIVEN
        // WHEN
        Document document = xmlParserDOM.getXMLDocument(xmlFilePath);
        // THEN
        Assertions.assertDoesNotThrow(() -> xmlParserDOM.getXMLDocument(xmlFilePath));
    }

    @Test
    void getNodeListByElementName_ReturnNotEmptyNodeList() throws ParserConfigurationException, IOException, SAXException {
        // GIVEN
        int expectedLength = 4;
        Document document = xmlParserDOM.getXMLDocument(xmlFilePath);
        // WHEN
        NodeList nodeList = xmlParserDOM.getNodeListByElementName(document, element);
        // THEN
        Assertions.assertEquals(expectedLength, nodeList.getLength());
    }

    @Test
    void elementCollect() {
    }

    @Test
    void testElementCollect() throws ParserConfigurationException, IOException, SAXException {
        // GIVEN
        int expectedLength = 4;
        Document document = xmlParserDOM.getXMLDocument(xmlFilePath);
        NodeList nodeList = xmlParserDOM.getNodeListByElementName(document, element);
        // WHEN
        List<Object> list = xmlParserDOM.elementCollect(nodeList);

        // THEN
        Assertions.assertNotNull(list);
    }
}
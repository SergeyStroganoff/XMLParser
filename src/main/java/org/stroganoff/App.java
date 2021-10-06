package org.stroganoff;

import org.apache.log4j.Logger;
import org.stroganoff.entities.Gem;
import org.stroganoff.exceptions.UserInterfaceException;
import org.stroganoff.utils.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * XML Consumer
 *
 * @author Sergey Stroganov
 */
public class App {

    public static final String INPUT_USER_MESSAGE = "Введите путь к файлу xml данных и путь к файлу xsd схемы";
    public static final String VERIFIED_SUCCESSFUL = "XML file verified successful";
    public static final String NOT_VERIFIED = "XML file not verified, exit";
    public static final String ERROR_INPUT_MESSAGE = "Ошибка при получении данных с консоли, программа будет завершена";


    public static void main(String[] args) throws UserInterfaceException {
        Logger logger = Logger.getLogger(App.class);
        String xmlFileName;
        String xsdFileName;
        UserInterface userInterface = new UserInterface();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        userInterface.showMessage(INPUT_USER_MESSAGE);
        try {
            xmlFileName = userInterface.getStringFromUser(reader);
            xsdFileName = userInterface.getStringFromUser(reader);
        } catch (UserInterfaceException e) {
            logger.error(e.getMessage());
            userInterface.showMessage(ERROR_INPUT_MESSAGE);
            throw e;
        }

        XMLVerification xmlVerification = new XMLVerifier("xmlVerification.log");
        if (xmlVerification.verificationToXSD(xmlFileName, xsdFileName)) {
            userInterface.showMessage(VERIFIED_SUCCESSFUL);
            logger.info( xmlFileName +" - " + VERIFIED_SUCCESSFUL );
        } else {
            userInterface.showMessage(NOT_VERIFIED);
            logger.error(NOT_VERIFIED);
            System.exit(1);
        }

        XMLParserDOM xmlParserDOM = new XMLParserDOM();
        Document document = null;
        try {
            document = xmlParserDOM.getXMLDocument(xmlFileName);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error(e.getMessage());
            userInterface.showMessage(e.getMessage());
        }

        String element = "gem";
        assert document != null;
        NodeList nodeList = xmlParserDOM.getNodeListByElementName(document, element);
        IEntityBuilder builder = new GemBuilder();
        List<Gem> list = xmlParserDOM.gemCollect(nodeList, builder);
        list.forEach(System.out::println);

    }
}

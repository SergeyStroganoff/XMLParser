package org.stroganoff;

import org.stroganoff.exceptions.UserInterfaceException;
import org.stroganoff.utils.XMLVerification;
import org.stroganoff.utils.XMLVerifier;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * XML Consumer
 * @author Sergey Stroganov
 */
public class App {
    public static void main(String[] args) {

        String xmlFileName = null;
        String xsdFileName = null;
        final String VERIFIED_SUCCESSFUL = "XML file verified successful";
        final String NOT_VERIFIED = "XML file not verified";

        UserInterface userInterface = new UserInterface();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        userInterface.showMessage("Введите путь к файлу xml данных и путь к файлу xsd схемы");
        try {
            xmlFileName = userInterface.getStringFromUser(reader);
            xsdFileName = userInterface.getStringFromUser(reader);
        } catch (UserInterfaceException e) {
            e.printStackTrace();
        }

        XMLVerification xmlVerification = new XMLVerifier("xmlVerification.log");
        if (xmlVerification.verificationToXSD(xmlFileName, xsdFileName)) {
            userInterface.showMessage(VERIFIED_SUCCESSFUL);
        } else {
            userInterface.showMessage(NOT_VERIFIED);
            System.exit(1);
        }

    }
}

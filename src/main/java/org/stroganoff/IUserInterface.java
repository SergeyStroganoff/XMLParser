package org.stroganoff;

import org.stroganoff.exceptions.UserInterfaceException;

import java.io.BufferedReader;

public interface IUserInterface {

    String getStringFromUser(BufferedReader reader) throws UserInterfaceException;
    void showMessage(String inputMessage);


}

package org.stroganoff;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.stroganoff.exceptions.UserInterfaceException;

import java.io.BufferedReader;
import java.io.IOException;

public class UserInterface implements IUserInterface {
    private static final Logger logger = Logger.getLogger(UserInterface.class);

    @Override
    public String getStringFromUser(BufferedReader reader) throws UserInterfaceException {
        logger.setLevel(Level.ERROR);
        String expressionString;
        try {
            expressionString = reader.readLine();
        } catch (IOException e) {
            logger.error("Input String Error in " + UserInterface.class, e);
            throw new UserInterfaceException(e);
        }
        return expressionString;
    }

    @Override
    public void showMessage(String inputMessagePartTwo) {
        System.out.println(inputMessagePartTwo);
    }
}

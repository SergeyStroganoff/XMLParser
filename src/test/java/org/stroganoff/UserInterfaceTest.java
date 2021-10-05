package org.stroganoff;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.stroganoff.exceptions.UserInterfaceException;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserInterfaceTest {

    public static final String TEST_STRING = "test";
    @InjectMocks
    UserInterface userInterface;

    @Test
    void getStringFromUser() throws IOException, UserInterfaceException {
        // GIVEN
        BufferedReader reader = Mockito.mock(BufferedReader.class);
        Mockito.when(reader.readLine()).thenReturn(TEST_STRING);
        // WHEN
        String actualString = userInterface.getStringFromUser(reader);
        // THEN
        assertEquals(TEST_STRING, actualString);
    }

    @Test
    void showMessage() {
        // GIVEN
        String expected = TEST_STRING + "\r\n";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(bos, true);
        PrintStream oldStream = System.out;
        System.setOut(printStream);
        // WHEN
        userInterface.showMessage("");
        String actual = bos.toString(StandardCharsets.UTF_8);
        System.setOut(oldStream);
        // THEN
        assertEquals(expected, actual);
    }
}
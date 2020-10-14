package andreitam.com;

import java.util.List;
import java.util.Map;

/**
 * Phone interface
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-10-04
 */
public interface Phone {
    void addContact(String currentNumber, String phoneNumber, String firstName, String lastName);
    List listContacts();
    void sendMessage(String phoneNumber, String message);
    List listMessages(String phoneNumber);
    void call(String phoneNumber);
    Map viewHistory();
}

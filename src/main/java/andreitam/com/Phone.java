package andreitam.com;
/**
 * Phone interface
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-10-04
 */
public interface Phone {
    void addContact(String currentNumber, String phoneNumber, String firstName, String lastName);
    void listContacts();
    void sendMessage(String phoneNumber, String message);
    void listMessages(String phoneNumber);
    void call(String phoneNumber);
    void viewHistory();
}

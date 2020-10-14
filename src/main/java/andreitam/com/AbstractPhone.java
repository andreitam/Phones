package andreitam.com;

import java.util.*;
/**
 * Abstract class with concrete implementations of Phone interface,
 * to be inherited.
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-10-04
 */
public abstract class AbstractPhone implements Phone {
    private final Integer BATTERY_LIFE; //int number of hours
    private Color color;
    private Material material;
    private final String IMEI;
    private List<Contact> contacts = new ArrayList<>();
    private Integer remainingBatteryLife;
    private Map<String, Integer> callHistory = new HashMap<>();

    AbstractPhone(Integer battery_life, Color color, Material material, String imei) {
        this.BATTERY_LIFE = battery_life;
        this.color = color;
        this.material = material;
        this.IMEI = imei;
        remainingBatteryLife = BATTERY_LIFE;
    }

    @Override
    public void addContact(String currentNumber, String phoneNumber, String firstName, String lastName) {
        contacts.add(new Contact(currentNumber, phoneNumber, firstName, lastName));
    }

    @Override
    public List<Contact> listContacts() {
        List<Contact> contactsList = new ArrayList<>(this.contacts);
        return contactsList;
    }

    @Override
    public void sendMessage(String phoneNumber, String message) {
        if (remainingBatteryLife >= 1) {
            remainingBatteryLife -= 1; //substarct 1hour of battery life
        }
        else {
            throw new IllegalArgumentException("Not enough battery");
        }
        if (message.length() > 501) {
            message = message.substring(0,500); // cut message if bigger than 500 characters
        }
        addMessageToHistory(phoneNumber, message, this.contacts);
    }

    private void addMessageToHistory(String phoneNumber, String message, List<Contact> contacts) {
        boolean found = false;
        for(Contact contact: contacts) {
            if (contact.phoneNumber.equals(phoneNumber)) {
                contact.contactMessageHistory.add(message);
                found=true;
            }
        }
        if (!found) { //if does not exists than create a new contact and add message
            contacts.add(new Contact(" ", phoneNumber, " ", " "));
            for(Contact contact: contacts) {
                if (contact.phoneNumber.equals(phoneNumber)) {
                    contact.contactMessageHistory.add(message);
                }
            }
        }
    }

    @Override
    public List<String> listMessages(String phoneNumber) {
        List<String> listMessages = new ArrayList<>();
        //System.out.println("You sent the following mesages to " + phoneNumber+" :");
            for(Contact contact: contacts) {
                if (contact.phoneNumber.equals(phoneNumber)) {//search for contact
                    for (String s: contact.contactMessageHistory ) {
                        //System.out.println(s);//print list
                        listMessages.add(s);
                    }
                }
            }
         return listMessages;
    }

    @Override
    public void call(String phoneNumber) {
        if (remainingBatteryLife >= 1) {
            remainingBatteryLife -=2; //substarct 2hour of battery life
        }
        else {
            throw new IllegalArgumentException("Not enough battery");
        }
        if (!callHistory.containsKey(phoneNumber)) {
            callHistory.put(phoneNumber,1); // if phoneNumber does not exist in map create entry
        }
        else if (callHistory.containsKey(phoneNumber)) {
            int updateHistory = callHistory.get(phoneNumber) + 1; // if phoneNumber exist in map incremente value with 1;
            callHistory.put(phoneNumber, updateHistory);
        }
    }

    @Override
    public Map<String,Integer> viewHistory() {
        Map<String,Integer> historyMap = new HashMap<>(callHistory);
        return historyMap;
    }

    public Integer getRemainingBatteryLife() {
        return remainingBatteryLife;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "BATTERY_LIFE=" + BATTERY_LIFE +
                ", color=" + color +
                ", material=" + material +
                ", IMEI='" + IMEI + '\'' +
                '}';
    }
}
/**
 * Class models phone contacts.
 * Should not be accessible from outside the package.
 * Contacts should be instatiated only by AbstarctPhone class.
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-10-04
 */
class Contact {
    private String currentNumber;
    String phoneNumber;
    private String firstName;
    private String lastName;
    List<String> contactMessageHistory;

    Contact(String currentNumber, String phoneNumber, String firstName, String lastName) {
        this.currentNumber = currentNumber;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactMessageHistory = new ArrayList<String>();
    }

    @Override
    public String toString() {
        return "Contact{" +
                "currentNumber=" + currentNumber +
                ", phoneNumber=" + phoneNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(phoneNumber, contact.phoneNumber) &&
                Objects.equals(firstName, contact.firstName) &&
                Objects.equals(lastName, contact.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, firstName, lastName);
    }
}


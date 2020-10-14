package andreitam.com;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SamsungA51Test {
    Phone phone=new SamsungA51();


    @Test
    void phoneTestSamsung() {
        //TEST adding and listing contacts

        phone.addContact("1", "0720111111", "Andrei", "Tamasanu");
        phone.addContact("2", "0725222222", "AnaMaria", "Tamasanu");
        List<Contact> contactList = new ArrayList<>(phone.listContacts());
        for (Contact c: contactList) {
            System.out.println(c);
        }
        assertEquals(contactList.size(),2);
        System.out.println(" ");

        //TEST sending messages and listing messages
        // send a message to the first contact from the previous listed
        // max number of characters - 100
        phone.sendMessage("0725222222", "Nu uita sa-mi cumperi niste baterii.");
        phone.sendMessage("0725222222", "Si scutece pentru astia mici, ca nu mai gasesc in casa.");
        List<String> messagesList = new ArrayList<>(phone.listMessages("0725222222"));
        for (String s: messagesList) {
            System.out.println(s);
        }
        assertEquals(messagesList.size(),2);
        System.out.println(" ");

        //TEST calling and view history
        // send a message to the second contact from the previous listed
        phone.call("0720111111");
        phone.call("0720111111");
        Map<String,Integer> historyMap = new HashMap<>(phone.viewHistory());
        System.out.println("Call history:");
        for (Map.Entry<String,Integer> entry : historyMap.entrySet())
            assertEquals("You called " + entry.getKey() + ", " +
                    entry.getValue()+" times.","You called 0720111111, 2 times.");
    }
}
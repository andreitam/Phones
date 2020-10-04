package andreitam.com;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Phone phone=new SamsungA51();
        System.out.println(phone);

        phone.addContact("1", "0720111111", "Andrei", "Tamasanu");
        phone.addContact("2", "0725222222", "AnaMaria", "Tamasanu");
        phone.listContacts();

        // send a message to the first contact from the previous listed
        // max number of characters - 100
        phone.sendMessage("0725222222", "Nu uita sa-mi cumperi niste baterii.");
        phone.sendMessage("0725222222", "Si scutece pentru astia mici, ca nu mai gasesc in casa.");
        phone.listMessages("0725222222");

        // send a message to the second contact from the previous listed
        phone.call("0720111111");
        phone.call("0720111111");
        phone.viewHistory();

    }
}

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*pseudocode
1. print out the options available for the user
2. Use scanner to get the option that the user choose
3. Create a condition if the option user choose is not 1 or 2
4. Create a class for username and phone number and also make it public
5. Create a method to receive user input for name and phone number, the method will also
check if the phoneNumber provided is not up to 11 and also insert the public class created into the method
6. Call a HashMap before the while loop

*/

        //Call a HashMap before the while loop
        HashMap<String, String> userMap = new HashMap<>();
        while(true){
            //print out the options available for the user
            System.out.println("""
            A. What will you like to do?:
            B. Choose 1 to save contacts
            C. Choose 2 to search contacts
            D. To end the programme, input any other number.""");

            //Use scanner to get the option that the user choose
            Scanner option = new Scanner(System.in);
            System.out.println("Choose your options: ");
            int chooseOptions = option.nextInt();

            //instantiate Contacts and assign the object to getUserContacts

            Contacts contacts = getUserContacts();

            //Create a condition if the option user choose is not 1 or 2
            if(chooseOptions != 1 && chooseOptions != 2) {
                break;
            }
            if(chooseOptions == 1){
                //Save the user input into the hashmap
                userMap.put(contacts.userName, contacts.userPhoneNumber);
            }
            else if(chooseOptions == 2){
                //check if the input provided exist in the hash map
                if(userMap.containsKey(contacts.userName) && userMap.get(contacts.userName).equals(contacts.userPhoneNumber)){
                    System.out.println("user exist");
                }
                else{
                    System.out.println("use does not exist");
                }
            }



        }
    }

    public static Contacts getUserContacts() {
        //Use scanner to get user input for name and phone number
        Scanner user = new Scanner(System.in);
        System.out.println("Enter name: ");
        String userName = user.nextLine();
        String userPhoneNumber;

        //check if the phoneNumber provided is not up to 11
        do {
            System.out.println("Enter phone number: ");
            userPhoneNumber = user.nextLine();
        } while (userPhoneNumber.length() < 11);


        return new Contacts(userName, userPhoneNumber);
    }
}

class Contacts
{
    String userName;
    String userPhoneNumber;

    public Contacts (String userName, String userPhoneNumber) {
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
    }
}

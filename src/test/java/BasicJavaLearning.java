import org.junit.Test;

import java.util.*;

public class BasicJavaLearning {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    ArrayList<String> names = new ArrayList<String>();
    System.out.println("Enter first guest's name: ");
    names.add(input.nextLine());
    System.out.println("Would you like to enter another guest's name? (yes/no)");
    String nextGuestDesicion = input.nextLine();
    switch (nextGuestDesicion) {
      case "yes":
        System.out.println("Please enter next guest's name: ");
        names.add(input.nextLine());
        break;
      case "no":
        System.out.println("All the spots are booked" + "\n");
        for (String guestList:names)
          System.out.println("Registered guests are: " + guestList);

    }

    System.out.println("Would you like to enter another guest's name? (yes/no)");
    String nextGuestDesicion2 = input.nextLine();
    switch (nextGuestDesicion2) {
      case "yes":
        System.out.println("Please enter duplicate guest's name: ");
        names.add(input.nextLine());
        break;
      case "no":
        System.out.println("Registration complete" + "\n");
        for (String guestList : names)
          System.out.println("Registered guests are: " + guestList);
    }
    System.out.println(" ");

        System.out.println("Wait! Here showed up one missing guest, please register" +
                " and re-count" +
                "(Enter guest's name)");
        names.add(2, input.nextLine());
    System.out.println("Registration is over" + "\n");
//    for (String guestList : names)
//      System.out.println("Registered guests are: " + guestList);

    Set<String>uniqueGuests = new LinkedHashSet<String>(names);
    names.clear();
    names.addAll(uniqueGuests);
    Collections.sort(names);
    for(String guest : names) {
      System.out.println("The unique guests are: " + guest);
    }



  }
}


package clubMembers;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;

public class NewMember


{
	public static void main(String [] args)
	{
/*			String nameIn, streetIn, townIn, countyIn, eircodeIn, subscriptionIn, roleInClubIn;
		int ageIn;
		List<Members> club = new LinkedList<Members>();
		
		ListIterator<Members> e;
		Members newMember; 
		int choice; 
		boolean there; 

		do
		{
			System.out.println("\nplease choose your menu choice\n");
			System.out.println("add a rectangle \t 1");
			System.out.println("list rectangles \t 2");
			System.out.println("remove a rectangle \t 3");
			System.out.println("quit \t\t\t 0");
		System.out.println("\n");
			choice = input.nextInt();
			if(choice == 1) 
			{
					
				System.out.println("\nPlease type in values for Club Member");
				System.out.println("name.");
				nameIn = input.next();
				System.out.println("street.");
				streetIn = input.next();
				System.out.println("town.");
				townIn = input.next();
				System.out.println("county.");
				countyIn = input.next();
				System.out.println("eircode.");
				eircodeIn = input.next();
				System.out.println("subscription.");
				subscriptionIn = input.next();
				System.out.println("club position.");
				roleInClubIn = input.next();
				System.out.println("age.");
				ageIn = input.nextInt();
				
				
				newMember = new Members(nameIn, streetIn, townIn, countyIn, eircodeIn, subscriptionIn, roleInClubIn, ageIn);
				// check to see if the new rectangle is already there
				there = false; // assume at first that it won’t be
				e = club.listIterator();
				while(e.hasNext())
				{
					// ask the next rectangle in the list if it’s equal
					// to the one we plan to add:
					if(e.next().equals(newMember))
						there = true; // ah! it’s there already.

				}
				// add it if it's not there already
				if(there == false)
					club.add(newMember);
				
				
				
				
				
			
				
				
				 try {

			         // create a new file with an ObjectOutputStream
			         FileOutputStream out = new FileOutputStream(in);
			         ObjectOutputStream oout = new ObjectOutputStream(out);

			         // write something in the file
			         oout.writeObject(newMember);
			         oout.close();
				
				
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(“myClub.txt”));
				out.writeObject(club);
				}
				 catch (Exception ex) {
			         ex.printStackTrace();
			      }

			}
			else if (choice == 2) // 2. print out the list
				// code for printing out the list of rectangles
				System.out.println(club);
			else if (choice == 3) // 3. remove a rectangle
			{
				// ask the user for the length and the breadth of the Rectangle
				System.out.println("\nPlease type in values for club to be removed n: ");
				System.out.println("name.");
				nameIn = input.next();
				System.out.println("street.");
				streetIn = input.next();
				System.out.println("town.");
				townIn = input.next();
				System.out.println("county.");
				countyIn = input.next();
				System.out.println("eircode.");
				eircodeIn = input.next();
				System.out.println("subscription.");
				subscriptionIn = input.next();
				System.out.println("club position.");
				roleInClubIn = input.next();
				System.out.println("age.");
				ageIn = input.nextInt();
				e = club.listIterator();
				there = false; // assume at first it won’t be there.
				while(e.hasNext())
				{
					if(e.next().equals(new Members(nameIn, streetIn, townIn, countyIn, eircodeIn, subscriptionIn, roleInClubIn, ageIn)))
					{
						there = true; // Ah, it is there! So let’s remove it:
						e.previous(); // oops! gone too far; go back one
						e.remove(); // now remove the appropriate one
						// the job’s been done! Cool!
					}
				}
				if(there == false)
				{
					System.out.println("\nThe rectangle you want ");
					System.out.println("removed isn’t in the list! \n");
				}
			}
		}while(choice != 0); // while user hasn’t yet chosen to quit.
		System.out.println("\n\nthank you for using this program.\n\n");*/
	}
}

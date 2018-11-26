package clubMembers;

//import java.util.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListTester
{
	public static void main(String [] args)
	{
		List<String> staff = new LinkedList<String>();
		
		staff.add("Fidelma"); // for Fidelma
		staff.add("Bernard"); // for Bernard
		staff.add("Zacahiah"); // for Zacahiah
		staff.add("Larry"); // for Larry
	
		ListIterator<String> pointer = staff.listIterator();
		// cursor at its originating position, that is before F

		pointer.next(); // asks the iterator to move along to the right
		
		pointer.next();
		// as a result of the last message the cursor is after B
		pointer.add("N");
		// N gets put into the list after B, i.e. at the position of the cursor;
		
		pointer.add("P");
		// P gets put into the list after N
		
		pointer.next();
		// cursor now after Z
		pointer.remove();
		// due to the last message the element before the cursor is now removed, i.e. Z
	
		for(String name : staff)
			System.out.println(name);
		System.out.println(staff);
	}
}


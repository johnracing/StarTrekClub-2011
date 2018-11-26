package clubMembers;

import java.io.Serializable;
import java.util.ListIterator;

class Members implements Serializable{


	private static final long serialVersionUID = 1L;
	private String name, street, town, county, eircode, subscription, roleInClub;
	int age;

	public Members(String nameIn, String streetIn, String townIn, String countyIn, String eircodeIn, 
			String subscriptionIn, String roleInClubIn, int ageIn)
	{
		this.name = nameIn;
		this.street = streetIn;
		this.town = townIn;
		this.county = countyIn;
		this.eircode = eircodeIn;
		this.subscription = subscriptionIn;
		this.roleInClub = roleInClubIn;
		this.age = ageIn;
	}

	public void setName(String nameIn)
	{
		name = nameIn;
	}

	public String getName()
	{
		return name;
	}

	public void setStreet(String streetIn)
	{
		street = streetIn;
	}
	
	public String getStreet()
	{
		return street;
	}
	
	public void setTown(String townIn)
	{
		town = townIn;
	}
	
	public String getTown()
	{
		return town;
	}
	
	public void setCounty(String countyIn)
	{
		county = countyIn;
	}
	
	public String getCounty()
	{
		return county;
	}
	
	public void setEircode(String eircodeIn)
	{
		eircode = eircodeIn;
	}
	
	public String getEircode()
	{
		
		return eircode;
	}
	
	public String getAddress()
	{
		String address  ="\t" +street+ ",\n\t" +town+ ",\n\t" +county+ ",\n\t " +eircode;
		return address;
	}

	public void setSubscription(String subscriptionIn)
	{
		subscription = subscriptionIn;
	}

	public String getSubscription()
	{
		return subscription;
	}

	public void setRoleInClub(String roleInClubIn)
	{
		roleInClub =roleInClubIn;
	}

	public String getRoleInClub()
	{
		return roleInClub;
	}

	public void setAge(int ageIn)
	{
		age = ageIn;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String toString() 
	{
		String person = "\n name:\t" +name+ "\n address:    " +getAddress()+ "\n Subscription :\t" +subscription+ 
				"\n Role in Club :\t" +roleInClub+ "\n Age:\t" +age+ "\n";
		
		return person;
	}

	
	
}
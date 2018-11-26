package clubMembers;

import java.io.Serializable;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.ListIterator;


public class EditDetails extends JFrame  implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private JLabel memberValue = new JLabel("Enter ID : ");
	private JPanel menuPanel = new JPanel();
	private JPanel resultPanel = new JPanel();
	private JLabel newMember = new JLabel("Edit or Delete :");
	private JLabel memberDetailsTitle = new JLabel("Member Details");
	private JLabel blankJLabel1 = new JLabel("");
	private JLabel blankJLabel2 = new JLabel(" ");
	private JLabel nameLabel = new JLabel("Name : ");
	private JLabel streetLabel = new JLabel("Street : ");
	private JLabel townLabel = new JLabel("Town : ");
	private JLabel countyLabel = new JLabel("County : ");
	private JLabel eircodeLabel = new JLabel("Eircode : ");
	private JLabel subscriptionLabel = new JLabel("Paid Member : ");
	private JLabel ageLabel = new JLabel("Age : ");

	private JTextField memberNameField = new JTextField(15);
	private JTextField memberStreetField = new JTextField(15);
	private JTextField memberTownField = new JTextField(15);
	private JTextField memberCountyField = new JTextField(15);
	private JTextField memberEircodeField = new JTextField(10);
	private JTextField memberSubscriptionField = new JTextField(3);
	private JTextField memberAgeField = new JTextField(5);

	Font fontForQuestion = new Font("Verdana", Font.BOLD,  16);
	Font fontForOptions = new Font("Verdana", Font.BOLD,  14);
	private JTextField memberInputField = new JTextField();
	private JButton memberMenuButton, memberBackButton, memberChangeButton, memberDeleteButton;
	private LinkedList<Members> TrekClub, getMembersFromDocument;
	private String arrayNameReturned, arrayStreetReturned, arrayTownReturned, arrayCountyReturned, 
	arrayEircodeReturned, arraySubscriptionReturned, arrayRoleInClubReturned, arrayAgeReturned;
	int placeInArrayList, testIntegerInput, arrayAgeReturnedAsInt, memberInputSearchAsInt;
	private Members returnedMember;





	public EditDetails()
	{
		super("Waterford Star Trek Fan-Club- View Details");
		setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("images/stbg-find.jpg"))));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(460, 480);
		setLocation(300, 300);
		this.setVisible(true);
		this.setResizable(true);
		Container myWindow = this.getContentPane();

		search();

		this.setContentPane(myWindow);
	}




	public void search()
	{
		menuPanel.setLayout(null);
		menuPanel.setBounds(100, 30, 300, 120);
		GridLayout menuPane = new GridLayout(0,2,5,8);
		menuPanel.setBackground(new Color(0, 0, 0));
		menuPanel.setLayout(menuPane);
		newMember.setForeground(Color.red);
		newMember.setFont(fontForQuestion);
		menuPanel.add(newMember);
		menuPanel.add(blankJLabel1);


		memberValue.setForeground(Color.white);
		memberValue.setFont(fontForOptions);
		menuPanel.add(memberValue);
		menuPanel.add(memberInputField);

		memberBackButton = new JButton("BACK");
		memberBackButton.setForeground(Color.yellow);
		memberBackButton.setBackground(Color.blue);
		memberBackButton.setFont(fontForQuestion);
		menuPanel.add(memberBackButton);
		memberBackButton.addActionListener(this);

		memberMenuButton = new JButton("SUBMIT");
		memberMenuButton.setForeground(Color.yellow);
		memberMenuButton.setBackground(Color.blue);
		memberMenuButton.setFont(fontForQuestion);
		menuPanel.add(memberMenuButton);	
		memberMenuButton.addActionListener(this);

		memberDetailsTitle.setForeground(Color.white);
		memberDetailsTitle.setFont(fontForQuestion);
		menuPanel.add(memberDetailsTitle);
		menuPanel.add(blankJLabel2);


		resultPanel.setBounds(100, 160, 300, 255);
		GridLayout memberResultPanel = new GridLayout(0,2,2,5);
		resultPanel.setLayout(memberResultPanel);
		resultPanel.setOpaque(false);
		nameLabel.setForeground(Color.white);
		nameLabel.setFont(fontForQuestion);
		resultPanel.add(nameLabel);
		memberNameField.setFont(fontForQuestion);
		resultPanel.add(memberNameField);

		streetLabel.setForeground(Color.white);
		streetLabel.setFont(fontForQuestion);
		resultPanel.add(streetLabel);
		memberStreetField.setFont(fontForQuestion);
		resultPanel.add(memberStreetField);

		townLabel.setForeground(Color.white);
		townLabel.setFont(fontForQuestion);
		resultPanel.add(townLabel);
		memberTownField.setFont(fontForQuestion);
		resultPanel.add(memberTownField);

		countyLabel.setForeground(Color.white);
		countyLabel.setFont(fontForQuestion);
		resultPanel.add(countyLabel);
		memberCountyField.setFont(fontForQuestion);
		resultPanel.add(memberCountyField);

		eircodeLabel.setForeground(Color.white);
		eircodeLabel.setFont(fontForQuestion);
		resultPanel.add(eircodeLabel);
		memberEircodeField.setFont(fontForQuestion);
		resultPanel.add(memberEircodeField);

		subscriptionLabel.setForeground(Color.white);
		subscriptionLabel.setFont(fontForQuestion);
		resultPanel.add(subscriptionLabel);
		memberSubscriptionField.setFont(fontForQuestion);
		resultPanel.add(memberSubscriptionField);

		ageLabel.setForeground(Color.white);
		ageLabel.setFont(fontForQuestion);
		resultPanel.add(ageLabel);
		memberAgeField.setFont(fontForQuestion);
		resultPanel.add(memberAgeField);

		memberChangeButton = new JButton("CHANGE");
		memberChangeButton.setForeground(Color.yellow);
		memberChangeButton.setBackground(Color.red);
		memberChangeButton.setFont(fontForQuestion);
		resultPanel.add(memberChangeButton);
		memberChangeButton.addActionListener(this);

		memberDeleteButton = new JButton("DELETE");
		memberDeleteButton.setForeground(Color.yellow);
		memberDeleteButton.setBackground(Color.red);
		memberDeleteButton.setFont(fontForQuestion);
		resultPanel.add(memberDeleteButton);	
		memberDeleteButton.addActionListener(this);

		add(menuPanel);
		add(resultPanel);
	}


	// search through list and find result
	public void actionPerformed(ActionEvent event) 
	{ 

		if (event.getSource() == memberMenuButton)	
		{		
			try 
			{
				AudioInputStream  audioInputForError = AudioSystem.getAudioInputStream(new File("gui/clubMembers/sounds/submit.wav"));
				Clip clip = AudioSystem.getClip(); 
				clip.open(audioInputForError);
				clip.start();
			}
			catch(Exception ex)
			{
				System.out.println("Error with playing sound.");
				ex.printStackTrace( );
			}

			try
			{
				ObjectInputStream loadInMembersFromDocument = new ObjectInputStream(new FileInputStream("myList.txt")); 					
				TrekClub = (LinkedList<Members>) loadInMembersFromDocument.readObject();
			//	System.out.println("document loaded");
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Error Loading File.", "FILE ERROR", JOptionPane.WARNING_MESSAGE);
			}

			
			// TODO   not working, supposed to populate the fields, so i can edit, save and delete it.
			
			
			memberInputSearchAsInt = (Integer.parseInt(memberInputField.getText()));
			ListIterator<Members> iterator = TrekClub.listIterator();
			placeInArrayList = (TrekClub.indexOf(iterator.next()));
				while (iterator.hasNext())

				{					
					if (placeInArrayList == memberInputSearchAsInt)
					{
						
						placeInArrayList = TrekClub.indexOf(iterator.next());

						iterator.previous();
						arrayNameReturned = iterator.next().getName();
						iterator.previous();
						arrayStreetReturned = iterator.next().getStreet();
						iterator.previous();
						arrayTownReturned = iterator.next().getTown();
						iterator.previous();
						arrayCountyReturned = iterator.next().getCounty();
						iterator.previous();
						arrayEircodeReturned = iterator.next().getEircode();
						iterator.previous();
						arraySubscriptionReturned = iterator.next().getSubscription();
						iterator.previous();
						arrayRoleInClubReturned = iterator.next().getRoleInClub();
						iterator.previous();
						arrayAgeReturnedAsInt = iterator.next().getAge();
						System.out.println("input: "+memberInputSearchAsInt);
						System.out.println("place in list : "+placeInArrayList);
						
						
						memberNameField.setText(arrayNameReturned);
						memberStreetField.setText(arrayStreetReturned);
						memberTownField.setText(arrayTownReturned);
						memberCountyField.setText(arrayCountyReturned);
						memberEircodeField.setText(arrayEircodeReturned);
						memberSubscriptionField.setText(arraySubscriptionReturned);
						memberSubscriptionField.setText(arrayRoleInClubReturned);
						memberAgeField.setText(""+arrayAgeReturnedAsInt);
						
					}
					
				}
				return;
			}
	


		if (event.getSource() == memberBackButton)
		{
			try 
			{
				AudioInputStream  audioInputForBack = AudioSystem.getAudioInputStream(new File("gui/clubMembers/sounds/beep.wav"));
				Clip clip = AudioSystem.getClip(); 
				clip.open(audioInputForBack);
				clip.start();
			}
			catch(Exception ex)
			{
				System.out.println("Error with playing sound.");
				ex.printStackTrace( );
			}
			this.setVisible(false);
			new MainMenu();
		}

		if (event.getSource() == memberChangeButton)
		{
			
			memberNameField.setText(arrayNameReturned);
			memberStreetField.setText(arrayStreetReturned);
			memberTownField.setText(arrayTownReturned);
			memberCountyField.setText(arrayCountyReturned);
			memberEircodeField.setText(arrayEircodeReturned);
			memberSubscriptionField.setText(arraySubscriptionReturned);
			memberSubscriptionField.setText(arrayRoleInClubReturned);
			memberAgeField.setText(""+arrayAgeReturnedAsInt);
			
			
			try 
			{
				ObjectOutputStream saveMembersToDocument = new ObjectOutputStream(new FileOutputStream("myList.txt"));
				saveMembersToDocument.writeObject(TrekClub);
			} 
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(null, "Could Not Save File.", "SAVING ISSUE", JOptionPane.WARNING_MESSAGE);
			}
		}

		
		
		
		if (event.getSource() == memberDeleteButton)	// not working right
		{
			ListIterator<Members> iterator = TrekClub.listIterator();
			placeInArrayList = (TrekClub.indexOf(iterator.next())+1);
			memberInputSearchAsInt = (Integer.parseInt(memberInputField.getText()));
			while (iterator.hasNext())
			{					
				if (memberInputSearchAsInt == placeInArrayList)
				{
					iterator.next();
					System.out.println("member input is "+memberInputSearchAsInt);
					System.out.println("place in list is "+placeInArrayList);
					System.out.println(iterator.next());
					iterator.remove();
					return;
				}
				else
				{
					System.out.println("member input is "+memberInputSearchAsInt);
					System.out.println("place in list is "+placeInArrayList);
					return;
				}
			}
			try 
			{
				ObjectOutputStream saveMembersToDocument = new ObjectOutputStream(new FileOutputStream("myList.txt"));
				saveMembersToDocument.writeObject(TrekClub);
			} 
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(null, "Could Not Save File.", "SAVING ISSUE", JOptionPane.WARNING_MESSAGE);
			}
			
			try
			{
				ObjectInputStream loadInMembersFromDocument = new ObjectInputStream(new FileInputStream("myList.txt")); 					
				getMembersFromDocument = (LinkedList<Members>) loadInMembersFromDocument.readObject();
				TrekClub.addAll(getMembersFromDocument);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Error Loading File.", "FILE ERROR", JOptionPane.WARNING_MESSAGE);
			}
			
		}

	}
}

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
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.ListIterator;


public class ViewListTest extends JFrame  implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private JLabel memberPosition = new JLabel("Select field : ");
	private JLabel memberValue = new JLabel("Enter Value : ");
	private JPanel menuPanel = new JPanel();
	private JPanel resultPanel = new JPanel();
	private JLabel newMember = new JLabel("View Member");
	private JLabel memberResult = new JLabel("Member Details");
	private JLabel blank = new JLabel(" ");
	Font fontForQuestion = new Font("Verdana", Font.BOLD,  16);
	Font fontForOptions = new Font("Verdana", Font.BOLD,  14);
	private JTextField memberInputField = new JTextField();
	private JTextArea  memberDetailsField = new JTextArea ( 16, 58);
	private JButton memberMenuButton, memberBackButton;
	private JComboBox<String> memberField;
	private LinkedList<Members> TrekClub;
	private String memberDetailsReturned;
	private String  multipleMemberDetailsReturned = "";
	
	
	public ViewListTest()
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
		menuPanel.add(blank);


		memberPosition.setForeground(Color.white);
		memberPosition.setFont(fontForOptions);
		menuPanel.add(memberPosition);
		memberField = new JComboBox<String>();
		memberField.addItem("Name");
		memberField.addItem("Position");
		memberField.addItem("Eircode");
		menuPanel.add(memberField);

		memberValue.setForeground(Color.white);
		memberValue.setFont(fontForOptions);
		menuPanel.add(memberValue);
		menuPanel.add(memberInputField);

		memberBackButton = new JButton("BACK");
		memberBackButton.setForeground(Color.red);
		memberBackButton.setBackground(Color.green);
		memberBackButton.setFont(fontForQuestion);
		menuPanel.add(memberBackButton);
		memberBackButton.addActionListener(this);

		memberMenuButton = new JButton("SUBMIT");
		memberMenuButton.setForeground(Color.red);
		memberMenuButton.setBackground(Color.green);
		memberMenuButton.setFont(fontForQuestion);
		menuPanel.add(memberMenuButton);	
		memberMenuButton.addActionListener(this);

		resultPanel.setBounds(100, 90, 300, 330);
		GridLayout memberResultPanel = new GridLayout(2,1,2,0);
		resultPanel.setOpaque(false);
		resultPanel.setLayout(memberResultPanel);
		memberResult.setForeground(Color.white);
		memberResult.setFont(fontForQuestion);
		resultPanel.add(memberResult);
		memberDetailsField.setBackground(new Color(0, 0, 0));
		memberDetailsField.setForeground(Color.white);
		memberDetailsField.setFont(fontForQuestion);
		memberDetailsField.setEditable(false);
		memberDetailsField.setLineWrap(true);
		memberDetailsField.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(memberDetailsField);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		resultPanel.add(scroll);

		add(menuPanel);
		add(resultPanel);
	}


	// search through list and find result
	public void actionPerformed(ActionEvent event) 
	{ 
		
		if (event.getSource() == memberMenuButton)	
		{
			multipleMemberDetailsReturned = "";
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
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Error Loading File.", "FILE ERROR", JOptionPane.WARNING_MESSAGE);
			}

			ListIterator<Members> iterator = TrekClub.listIterator();
			
			
			
			if (memberField.getSelectedItem().equals("Name"))
			{
				while (iterator.hasNext())
				{					
					if (iterator.next().getName().equals(memberInputField.getText()))
					{
						iterator.previous();
						memberDetailsReturned = iterator.next().toString();
						int placeInList = TrekClub.indexOf(iterator.next());
						
						if (multipleMemberDetailsReturned.equals (""))
						{
							multipleMemberDetailsReturned = "Club ID : " + placeInList +memberDetailsReturned + "\n";				
						}
						else  
						{
							multipleMemberDetailsReturned = multipleMemberDetailsReturned +  "Club ID : " + placeInList + memberDetailsReturned + "\n";		
						}
					}
				}
				memberDetailsField.setText(multipleMemberDetailsReturned);
				return;
			}

			if (memberField.getSelectedItem().equals("Position"))
			{
				while (iterator.hasNext())
				{					
					if (iterator.next().getRoleInClub().equals(memberInputField.getText()))
					{
						iterator.previous();
						memberDetailsReturned = iterator.next().toString();
						int placeInList = TrekClub.indexOf(iterator.next());
						
						if (multipleMemberDetailsReturned.equals (""))
						{
							multipleMemberDetailsReturned = "Club ID : " + placeInList +memberDetailsReturned + "\n";				
						}
						else  
						{
							multipleMemberDetailsReturned = multipleMemberDetailsReturned +  "Club ID : " + placeInList + memberDetailsReturned + "\n";		
						}
					}
				}
				memberDetailsField.setText(multipleMemberDetailsReturned);
				return;
			}
			
			if (memberField.getSelectedItem().equals("Eircode"))
			{
				while (iterator.hasNext())
				{
				if (iterator.next().getEircode().equals(memberInputField.getText()))
				{
					iterator.previous();
					memberDetailsReturned = iterator.next().toString();
					int placeInList = TrekClub.indexOf(iterator.next());
					
					if (multipleMemberDetailsReturned.equals (""))
					{
						multipleMemberDetailsReturned = "Club ID : " + placeInList +memberDetailsReturned + "\n";				
					}
					else  
					{
						multipleMemberDetailsReturned = multipleMemberDetailsReturned +  "Club ID : " + placeInList + memberDetailsReturned + "\n";		
					}
				}
				memberDetailsField.setText(multipleMemberDetailsReturned);
				return;
				}
			}
			
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
	}
}

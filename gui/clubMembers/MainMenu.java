package clubMembers;

import javax.swing.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame  implements  ItemListener
{

	private static final long serialVersionUID = 1L;
	JLabel forImage;
	private JPanel menuPanel = new JPanel();
	private JLabel welcome = new JLabel("          \n          ");
	private JLabel selectQuestion = new JLabel("Select from the following:");
	private JLabel blank5 = new JLabel("\n\n\n");
	private JLabel blank1 = new JLabel(" ");
	//	private buttons
	private JRadioButton buttonNewMember = new JRadioButton("  Add New Member ");
	private JRadioButton buttonViewMember = new JRadioButton("  View Member Details ");
	private JRadioButton buttonViewStats = new JRadioButton("  View Age Statistics ");
	private JRadioButton buttonEditMember = new JRadioButton("  Edit Member Details ");
	private JRadioButton buttonDeleteMember = new JRadioButton("  Delete Member ");
	private JRadioButton buttonExit = new JRadioButton("  Exit ");

	Font fontForWelcome = new Font("Monospaced", Font.BOLD,  30);
	Font fontForQuestion = new Font("Verdana", Font.BOLD,  16);
	Font fontForOptions = new Font("Verdana", Font.BOLD,  14);

	NewMembers newMemberWindow = new NewMembers();
	ViewDetails viewOneMember;
	ViewStats viewClubStats;
	EditDetails editMemberDetails;
	DeleteMembers deleteMember;
	ViewListTest viewListTest;
	public MainMenu()
	{
		super("Waterford Star Trek Fan-Club");
		setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("images/stbg.jpg"))));

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(460, 480);
		setLocation(300, 300);
		this.setVisible(true); 
		this.setResizable(false);
		newMemberWindow.setVisible(false);
		viewOneMember = new ViewDetails();
		viewOneMember.setVisible(false);

		viewListTest = new ViewListTest();
		viewListTest.setVisible(false);
		viewClubStats = new ViewStats();
		viewClubStats.setVisible(false);
		editMemberDetails = new EditDetails();
		editMemberDetails.setVisible(false);

		deleteMember = new DeleteMembers();
		deleteMember.setVisible(false);
		Container myWindow = this.getContentPane();

		setLayout(new FlowLayout());
		welcome.setFont(fontForWelcome);
		myWindow.add(welcome);

		menu();	

		this.setContentPane(myWindow);
	}



	public void itemStateChanged(ItemEvent event)
	{
		if (event.getItem() != null)
			playSelectSound();

		if(event.getItem() == buttonNewMember)
		{
			this.setVisible(false);
			newMemberWindow.setVisible(true); 
		}	

		if(event.getItem() == buttonViewMember)
		{
			this.setVisible(false);
			viewOneMember.setVisible(true);	
		}

		if(event.getItem() == buttonViewStats)
		{
			this.setVisible(false);
			viewListTest.setVisible(true);
		//	viewClubStats.setVisible(true);
		}

		if(event.getItem() == buttonEditMember)
		{
			this.setVisible(false);
			editMemberDetails.setVisible(true);
		}

		if(event.getItem() == buttonDeleteMember)
		{
			this.setVisible(false);
			deleteMember.setVisible(true);
		}


		if(event.getItem() == buttonExit)
		{
			playExitSound();

			try {
				Thread.sleep(2500);
			} 
			catch (InterruptedException e1)
			{
				e1.printStackTrace();
			}
			System.exit(0);
		}


	}



	public void playSelectSound()
	{
		try 
		{
			AudioInputStream  audioClickOnButton = AudioSystem.getAudioInputStream(new File("gui/clubMembers/sounds/beep02.wav"));
			Clip clip = AudioSystem.getClip(); 
			clip.open(audioClickOnButton);
			clip.start();
		}
		catch(Exception ex)
		{
			System.out.println("Error with playing sound.");
			ex.printStackTrace( );
		}
	}

	public void playExitSound()
	{
		try 
		{
			AudioInputStream  audioOnExit = AudioSystem.getAudioInputStream(new File("gui/clubMembers/sounds/exit.wav"));
			Clip clip = AudioSystem.getClip(); 
			clip.open(audioOnExit);
			clip.start();
		}
		catch(Exception ex)
		{
			System.out.println("Error with playing sound.");
			ex.printStackTrace( );
		}
	}


	public void menu()
	{
		BoxLayout menuPane = new BoxLayout(menuPanel, BoxLayout.Y_AXIS);
		menuPanel.setBackground(new Color(0, 0, 0));
		menuPanel.setLayout(menuPane);

		selectQuestion.setFont(fontForQuestion);
		selectQuestion.setForeground(Color.white);
		menuPanel.add(blank5);
		menuPanel.add(selectQuestion);
		menuPanel.add(blank1);

		buttonNewMember.addItemListener(this);
		buttonViewMember.addItemListener(this);
		buttonViewStats.addItemListener(this);
		buttonEditMember.addItemListener(this);
		buttonDeleteMember.addItemListener(this);
		buttonExit.addItemListener(this);

		ButtonGroup mainButtonGroup = new ButtonGroup();
		//	 new member etc buttons
		buttonNewMember.setOpaque(false);
		buttonNewMember.setFont(fontForOptions);
		buttonNewMember.setForeground(Color.white);
		mainButtonGroup.add(buttonNewMember);
		menuPanel.add(buttonNewMember);

		buttonViewMember.setOpaque(false);
		buttonViewMember.setFont(fontForOptions);
		buttonViewMember.setForeground(Color.white);
		mainButtonGroup.add(buttonViewMember);
		menuPanel.add(buttonViewMember);

		buttonViewStats.setOpaque(false);
		buttonViewStats.setFont(fontForOptions);
		buttonViewStats.setForeground(Color.white);
		mainButtonGroup.add(buttonViewStats);
		menuPanel.add(buttonViewStats);

		buttonEditMember.setOpaque(false);
		buttonEditMember.setFont(fontForOptions);
		buttonEditMember.setForeground(Color.white);
		mainButtonGroup.add(buttonEditMember);
		menuPanel.add(buttonEditMember);	

		buttonDeleteMember.setOpaque(false);
		buttonDeleteMember.setFont(fontForOptions);
		buttonDeleteMember.setForeground(Color.white);
		mainButtonGroup.add(buttonDeleteMember);
		menuPanel.add(buttonDeleteMember);

		buttonExit.setOpaque(false);
		buttonExit.setFont(fontForOptions);
		buttonExit.setForeground(Color.white);
		mainButtonGroup.add(buttonExit);
		menuPanel.add(buttonExit);


		add(menuPanel);	

	}
}


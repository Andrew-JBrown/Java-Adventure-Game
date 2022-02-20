import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	String position;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();



	public static void main(String[] args) {

		new Game();
	}
	
	public Game(){
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("ADVENTURE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);	
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		
		window.setVisible(true);
	}
	
	public void createGameScreen(){
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);		
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true); 
		mainTextArea.setEditable(false); 	
		
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler); 
		choice1.setActionCommand("c1"); 
		choiceButtonPanel.add(choice1);
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		townGate();
	}
	
	public void townGate(){
		position = "townGate";
		mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n\nWhat do you do?");
		
		choice1.setText("Talk to the guard");
		choice2.setText("Leave");
		choice3.setText("");
		choice4.setText("");
	}
	public void talkGuard(){
		position = "talkGuard";
		mainTextArea.setText("Guard: Hello stranger. I have never seen your face. \nI'm sorry but we cannot let a stranger enter our town.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void crossRoad(){
		position = "crossRoad";
		mainTextArea.setText("You are at a crossroad.\nIf you go south, you will go back to the town.");
		choice1.setText("Go north");
		choice2.setText("Go east");
		choice3.setText("Go south");
		choice4.setText("Go west");
	}
	public void north(){
		position = "north";
		mainTextArea.setText("There is a river. \nYou chill and rest at the riverside.");
		choice1.setText("Go back");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	public void east(){
		position = "east";
		mainTextArea.setText("You walked into a forest and found a Long Sword!");
		choice1.setText("Go back");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	public void west(){
		position = "west";
		mainTextArea.setText("You encounter a goblin!");
		
		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	public void fight(){
		position = "fight";
		mainTextArea.setText("You want to fight the goblin but, he is much to strong for you.");
		
		choice1.setText("Run");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	//End of Choices//

	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			createGameScreen();
		}
	}
	

	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand();
			
			switch(position){
			
			case "townGate":
				switch(yourChoice){
				case "c1": talkGuard();break;
				case "c2": crossRoad();break;
				}
				break;
				
			case "talkGuard":
				switch(yourChoice){
				case "c1": townGate(); break;
				}
				break;
				
			case "crossRoad":
				switch(yourChoice){
				case "c1": north(); break;
				case "c2": east();break;
				case "c3": townGate(); break;
				case "c4": west();break;
				}
				break;
				
			case "north":
				switch(yourChoice){
				case "c1": crossRoad(); break;
				}
				break;
				
			case "east":
				switch(yourChoice){
				case "c1": crossRoad(); break;
				}
				break;
				
			case "south":
				switch(yourChoice){
				case "c1": crossRoad(); break;
				}
				break;
				
			case "west":
				switch(yourChoice){
				case "c1": fight(); break;
				case "c2": crossRoad(); break;
				}
				break;
				
			case "fight":
				switch(yourChoice){
				case "c1": crossRoad();break;
				
			case "win":
				switch(yourChoice){
				case "c1": crossRoad();break;
				
				}
				}
			}
		}
	}
}
				
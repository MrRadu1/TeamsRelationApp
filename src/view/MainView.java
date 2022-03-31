package view;
import java.awt.*;
import javax.swing.*;

import enums.Stadion;

import java.awt.event.*;

public class MainView {
	private JLabel teamLabel;
	private JTextField teamTextField;
	
	private JLabel stadiumLabel;
	private JComboBox<Stadion> stadiumComboBox;
	
	private JLabel yearLabel;
	private JTextField yearTextField;
	
	private JButton addTeamButton;
	private JButton manageButton;
	private JLabel manageLabel;
	private JFrame frame;
	
	public MainView() {
		frame = new JFrame("Football Teams Database");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		
		teamLabel = new JLabel("Team Name:");
		stadiumLabel = new JLabel("Stadion:");
		yearLabel = new JLabel("Year:");
		manageLabel= new JLabel("Enter management system where u can add and view bussines relationships");
		manageLabel.setVisible(false);
		
		teamTextField = new JTextField();
		teamTextField.setPreferredSize(new Dimension(100, 20));
		stadiumComboBox = new JComboBox<>();
		yearTextField = new JTextField();
		
		Stadion[] stadioane = new Stadion[] {  Stadion.Allianz_Arena,
				 Stadion.Santiago_Bernabeu, 
				 Stadion.Camp_Nou,
				 Stadion.Anfield,
				 Stadion.Old_Trafford };
		
		stadiumComboBox = new JComboBox<>(stadioane);
		
		addTeamButton = new JButton("Add Team");
		manageButton = new JButton("Management");
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(3, 2, 20, 20));
		leftPanel.add(teamLabel);
		leftPanel.add(teamTextField);
		leftPanel.add(stadiumLabel);
		leftPanel.add(stadiumComboBox);
		leftPanel.add(yearLabel);
		leftPanel.add(yearTextField);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.add(addTeamButton);
		bottomPanel.add(manageButton);

		JPanel upperHalfPanel = new JPanel();
		upperHalfPanel.setLayout(new FlowLayout());
		upperHalfPanel.add(leftPanel);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(upperHalfPanel);
		mainPanel.add(manageLabel);
		mainPanel.add(bottomPanel);
		
		frame.setContentPane(mainPanel);
		frame.setVisible(true);	
	}
	
	public String getTeamText() {
		return this.teamTextField.getText();
	}
	
	public String getYearText() {
		return this.yearTextField.getText();
	}
	
	public Stadion getStadiumEnumElement() {
		return (Stadion) this.stadiumComboBox.getSelectedItem();
	}
	
	public void addBtnListener(ActionListener x) {
		addTeamButton.addActionListener(x);
	}
	
	public void manageBtnListener(ActionListener x) {
		manageButton.addActionListener(x);
	}
	
	public void showMsj(String msj) {
		JOptionPane.showMessageDialog(frame, msj);
	}
	
	public void showManangeBtnListener (MouseListener x) {
		manageButton.addMouseListener(x);
	}
	
	public JLabel showManageMsj() {
		return this.manageLabel;
	}
	
}

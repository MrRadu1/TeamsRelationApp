package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enums.Stadion;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BusinessView extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboBox_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lbEchipa2;
	private JLabel lbEchipa1;
	private JComboBox<String> comboBox;
	
	public BusinessView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 582, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(248, 41, 155, 21);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(248, 155, 155, 21);
		contentPane.add(comboBox_1);
		
		btnNewButton = new JButton("Add Business Relation");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(137, 277, 173, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("View Relations");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBounds(320, 277, 131, 21);
		contentPane.add(btnNewButton_1);
		
		lbEchipa2 = new JLabel("Echipa 2:");
		lbEchipa2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbEchipa2.setBounds(154, 159, 84, 13);
		contentPane.add(lbEchipa2);
		
		lbEchipa1 = new JLabel("Echipa 1:");
		lbEchipa1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbEchipa1.setBounds(154, 44, 84, 13);
		contentPane.add(lbEchipa1);
		
		this.setVisible(true);
	}
	
	public JComboBox comboBox1 () {
		return this.comboBox;
	}
	
	public JComboBox comboBox2 () {
		return this.comboBox_1;
	}
	
	public String getTeam1Element() {
		return (String) this.comboBox.getSelectedItem();
	}
	
	public String getTeam2Element() {
		return (String) this.comboBox_1.getSelectedItem();
	}
	
	public void addBtnListener(ActionListener x) {
		btnNewButton.addActionListener(x);
	}
	
	public void viewBtnListener(ActionListener x) {
		btnNewButton_1.addActionListener(x);
	}
	
	public void showMsj(String msj) {
		JOptionPane.showMessageDialog(this, msj);
	}
}

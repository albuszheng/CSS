package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class register extends JPanel {
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Create the panel.
	 */
	public register() {
		setLayout(null);
		
		JLabel lblcss = new JLabel("\u4F20\u8BF4\u4E2D\u7684CSS");
		lblcss.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblcss.setBounds(10, 10, 95, 15);
		add(lblcss);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setBounds(386, 10, 54, 15);
		add(lblWelcome);
		
		JLabel label = new JLabel("\u6CE8\u518C\u65B0\u7528\u6237");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 16));
		label.setBounds(20, 35, 119, 27);
		add(label);
		
		JLabel lblid = new JLabel("\u7528\u6237ID\uFF1A");
		lblid.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		lblid.setBounds(30, 72, 54, 15);
		add(lblid);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label_1.setBounds(30, 140, 54, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label_2.setBounds(30, 165, 75, 15);
		add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 69, 119, 21);
		add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(133, 137, 119, 21);
		add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(133, 162, 119, 21);
		add(passwordField_2);
		
		JCheckBox chckbxStudent = new JCheckBox("Student");
		chckbxStudent.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		chckbxStudent.setSelected(true);
		chckbxStudent.setBounds(40, 96, 75, 23);
		add(chckbxStudent);
		
		JCheckBox chckbxTeacher = new JCheckBox("Teacher");
		chckbxTeacher.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		chckbxTeacher.setBounds(143, 96, 103, 23);
		add(chckbxTeacher);
		
		JButton button = new JButton("\u53D6\u6D88");
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		button.setBounds(347, 267, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("\u786E\u8BA4");
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		button_1.setBounds(244, 267, 93, 23);
		add(button_1);

	}
}

package UI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Button;

public class showGrades extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public showGrades() {
		setLayout(null);
		
		JButton button = new JButton("\u53D6\u6D88");
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		button.setBounds(347, 255, 93, 23);
		add(button);
		
		JLabel lblcss = new JLabel("\u4F20\u8BF4\u4E2D\u7684CSS");
		lblcss.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblcss.setBounds(10, 10, 93, 15);
		add(lblcss);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setBounds(386, 10, 54, 15);
		add(lblWelcome);
		
		JLabel label = new JLabel("\u67E5\u770B\u6210\u7EE9");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 16));
		label.setBounds(20, 35, 83, 23);
		add(label);
		
		JLabel label_1 = new JLabel("\u8BFE\u7A0B\u53F7\uFF1A");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label_1.setBounds(30, 79, 54, 15);
		add(label_1);
		
		textField = new JTextField();
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		textField.setText("\u8BF7\u8F93\u5165\u6240\u8981\u67E5\u8BE2\u7684\u8BFE\u7A0B\u53F7");
		textField.setBounds(116, 76, 173, 21);
		add(textField);
		textField.setColumns(10);
		
		JButton button_1 = new JButton("\u67E5\u770B\u5168\u90E8\u8BFE\u7A0B\u6210\u7EE9");
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		button_1.setBounds(193, 255, 144, 23);
		add(button_1);
		
		JButton button_2 = new JButton("\u786E\u5B9A");
		button_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		button_2.setBounds(299, 75, 93, 23);
		add(button_2);

	}
}

package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.TextArea;
import java.awt.Button;

public class chooseCourse extends JPanel {

	/**
	 * Create the panel.
	 */
	public chooseCourse() {
		setLayout(null);
		
		JLabel lblcss = new JLabel("\u4F20\u8BF4\u4E2D\u7684CSS");
		lblcss.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblcss.setBounds(10, 10, 83, 15);
		add(lblcss);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setBounds(386, 10, 54, 15);
		add(lblWelcome);
		
		JLabel label = new JLabel("\u9009\u8BFE");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 16));
		label.setBounds(20, 33, 73, 22);
		add(label);
		
		JList list = new JList();
		list.setBounds(30, 65, 203, 193);
		add(list);
		
		JLabel label_1 = new JLabel("\u5DF2\u9009\u8BFE\u7A0B\uFF1A");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label_1.setBounds(262, 66, 73, 15);
		add(label_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(272, 88, 141, 90);
		add(textArea);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		button.setBounds(242, 267, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		button_1.setBounds(347, 267, 93, 23);
		add(button_1);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(262, 87, 158, 98);
		add(textArea_1);

	}
}

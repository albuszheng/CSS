package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class appointTA extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public appointTA() {
		setLayout(null);
		
		JLabel lblcss = new JLabel("\u4F20\u8BF4\u4E2D\u7684CSS");
		lblcss.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblcss.setBounds(10, 10, 83, 15);
		add(lblcss);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setBounds(386, 10, 54, 15);
		add(lblWelcome);
		
		JLabel label = new JLabel("\u4EFB\u547D\u52A9\u6559");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 16));
		label.setBounds(20, 35, 113, 22);
		add(label);
		
		JLabel label_1 = new JLabel("\u52A9\u6559\u7684\u5B66\u53F7\uFF1A");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label_1.setBounds(20, 106, 102, 22);
		add(label_1);
		
		textField = new JTextField();
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		textField.setText("\u8BF7\u8F93\u5165\u52A9\u6559\u7684\u5B66\u53F7");
		textField.setBounds(132, 107, 164, 21);
		add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u53D6\u6D88");
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		button.setBounds(347, 253, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("\u5B8C\u6210");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		button_1.setBounds(244, 253, 93, 23);
		add(button_1);
		
		JButton button_2 = new JButton("\u4E0B\u4E00\u4F4D");
		button_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		button_2.setBounds(306, 106, 93, 23);
		add(button_2);

	}
}

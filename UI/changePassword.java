package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTree;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class changePassword extends JPanel {
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Create the panel.
	 */
	public changePassword() {
		setLayout(null);
		
		JLabel lblcss = new JLabel("\u4F20\u8BF4\u4E2D\u7684CSS");
		lblcss.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblcss.setBounds(10, 10, 96, 15);
		add(lblcss);
		
		JLabel lblWelcom = new JLabel("Welcome!");
		lblWelcom.setBounds(386, 10, 54, 15);
		add(lblWelcom);
		
		JLabel label = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 16));
		label.setBounds(20, 35, 86, 22);
		add(label);
		
		JLabel label_1 = new JLabel("\u65E7\u5BC6\u7801\uFF1A\r\n");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label_1.setBounds(20, 81, 54, 15);
		add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(108, 78, 120, 21);
		add(passwordField);
		
		JLabel label_2 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label_2.setForeground(new Color(0, 0, 0));
		label_2.setBounds(20, 120, 54, 15);
		add(label_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(108, 117, 120, 21);
		add(passwordField_1);
		
		JLabel label_3 = new JLabel("\u786E\u8BA4\u65B0\u5BC6\u7801\uFF1A");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label_3.setBounds(20, 161, 86, 15);
		add(label_3);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(108, 158, 120, 21);
		add(passwordField_2);
		
		JButton button_1 = new JButton("\u786E\u8BA4");
		button_1.setBounds(244, 254, 93, 23);
		add(button_1);
		
		JButton button_2 = new JButton("\u53D6\u6D88");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		button_2.setBounds(347, 254, 93, 23);
		add(button_2);

	}
}

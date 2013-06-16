package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import contrillor.LoginService;

public class loginFrame extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JPasswordField pwdEnterYourPassword;
	private JTextField textField;
	private JButton btnSignIn, btnRegister;
	JRadioButton rdbtnAdministrator,rdbtnStudent,rdbtnTeacher;

	private Listener listener=new Listener();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame frame = new loginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblUserID = new JLabel("UserID:");
		lblUserID.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblUserID.setBounds(83, 76, 60, 23);
		add(lblUserID);

		JLabel lblPasswords = new JLabel("Passwords:");
		lblPasswords.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblPasswords.setBounds(83, 126, 76, 23);
		add(lblPasswords);

		pwdEnterYourPassword = new JPasswordField();
		pwdEnterYourPassword.setToolTipText("Enter your Password");
		pwdEnterYourPassword.setBounds(169, 127, 125, 21);
		pwdEnterYourPassword.addKeyListener(listener);
		add(pwdEnterYourPassword);

		JLabel lblCourseSelectSystem = new JLabel("Course Selecting System");
		lblCourseSelectSystem.setForeground(Color.BLUE);
		lblCourseSelectSystem.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblCourseSelectSystem.setBounds(83, 10, 247, 44);
		add(lblCourseSelectSystem);

		btnSignIn = new JButton("sign in");
		btnSignIn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnSignIn.setBounds(332, 213, 93, 23);
		add(btnSignIn);
		btnSignIn.addKeyListener(listener);
		btnSignIn.addActionListener(listener);

		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnRegister.setBounds(229, 213, 93, 23);
		add(btnRegister);
		btnRegister.addKeyListener(listener);
		btnRegister.addActionListener(listener);

		textField = new JTextField();
		textField.setBounds(169, 76, 125, 23);
		add(textField);
		textField.addKeyListener(listener);
		textField.setColumns(10);

		rdbtnTeacher = new JRadioButton("Teacher");
		rdbtnTeacher.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		rdbtnTeacher.setBounds(83, 170, 76, 23);
		addKeyListener(listener);
		add(rdbtnTeacher);

		rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setSelected(true);
		rdbtnStudent.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		rdbtnStudent.setBounds(169, 170, 76, 23);
		addKeyListener(listener);
		add(rdbtnStudent);

		rdbtnAdministrator = new JRadioButton("Administrator");
		rdbtnAdministrator.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		rdbtnAdministrator.setBounds(247, 170, 121, 23);
		addKeyListener(listener);
		add(rdbtnAdministrator);

	}

	private class Listener implements ActionListener, KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int KC = e.getKeyCode();
			if (KeyEvent.VK_ENTER == KC) {
				Login();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自动生成的方法存根

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO 自动生成的方法存根

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSignIn) {
				Login();
			} else {
				if (e.getSource() == btnRegister) {
					register();
				}
			}
		}

	}

	private void Login() {
		LoginService loginService = new LoginService();
		String id = textField.getText();
		char[] password = pwdEnterYourPassword.getPassword();
		if (id == null || id.trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "请输入登录用户名");
			return;
		}
		if (password.length == 0) {
			JOptionPane.showMessageDialog(this, "请输入密码");
			return;
		}
		if (rdbtnStudent.isSelected() && !rdbtnTeacher.isSelected() && !rdbtnAdministrator.isSelected()){//students
			loginService.login("Students", Integer.parseInt(id), password.toString());
		}else if(!rdbtnStudent.isSelected() && rdbtnTeacher.isSelected() && !rdbtnAdministrator.isSelected()){//teachers
			
		}else if(!rdbtnStudent.isSelected() && !rdbtnTeacher.isSelected() && rdbtnAdministrator.isSelected()){//admin
			
		}else{
			JOptionPane.showMessageDialog(this, "请正确选择用户类型");
			return;
		}
		dispose();
	}

	private void register() {
		LoginService loginService=new LoginService();
		
	}
}

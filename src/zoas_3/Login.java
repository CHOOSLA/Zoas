package zoas_3;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.lang.invoke.StringConcatFactory;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	JPanel panel = new JPanel();
	
	JTextField txtId= new JTextField();
	JTextField txtPassword=new JTextField();
	
	ImageIcon icon= new ImageIcon("image/login.png");
	
	JLabel lb_1 = new JLabel("");
	JButton btnNewButton = new JButton("New button");
	JButton loginButton = new JButton("\uB85C\uADF8\uC778");

	/**
	 * Create the panel.
	 */
	public Login() {
		setBackground(SystemColor.activeCaption);
		setBounds(0, 0, 744, 411);
		setLayout(null);
		
		panel.setBackground(Color.WHITE);
		panel.setBounds(200, 81, 350, 250);
		add(panel);
		panel.setLayout(null);
		
		txtId.setText("ID");
		txtId.setBounds(98, 70, 116, 21);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtPassword.setText("PASSWORD");
		txtPassword.setBounds(98, 114, 116, 21);
		panel.add(txtPassword);
		txtPassword.setColumns(10);
		
		icon=Zoas.imageSetSize(icon, 49, 49);
		lb_1.setIcon(icon);
		lb_1.setBounds(150, 10, 50, 50);
		panel.add(lb_1);
		btnNewButton.setBounds(26, 196, 97, 23);
		
		panel.add(btnNewButton);
		loginButton.setBounds(195, 196, 108, 23);
		panel.add(loginButton);
	}
}

package zoas_4;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

import zoas_4.DataClass.NoteInfo;
import zoas_4.DataClass.User;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	User user=new User();
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
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setID(txtId.getText());
				user.setPW(txtPassword.getText());
				Zoas.json.createJsonData(user);
				//파일을 보내서 로그인정보가 맞는지 확인 후 맞으면 밑에 수행
				String jsontext=null;
				Zoas.user=Zoas.json.parseJsonData(jsontext);	//user 데이터 갱신
				Zoas.json.createJsonData(Zoas.user);
				Zoas.mainCard.show(Zoas.frame.getContentPane(),"Main");
				
			}
		});
		
		loginButton.setBounds(195, 196, 108, 23);
		panel.add(loginButton);
	}
}

package zoas_5;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import zoas_5.DataClass.NoteInfo;
import zoas_5.DataClass.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.CardLayout;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;

public class Login extends JPanel {
	String pwPattern = "^(?=.*[a-z])(?=.*[A-Z]).{8,}$"; //��й�ȣ ����
	User tempUser=new User();	//�ӽ� ����� ȸ������, �α����� �����ϸ� ���� ������ Zoas ���� �������ش�
	
	static CardLayout Card=new CardLayout();
	JPanel panel = new JPanel();	//�α���â
	JPanel panel_2 = new JPanel();	//ȸ������â
	JPanel cardpanel = new JPanel();//ī�� ���̾ƿ��� ���� �г�
	JPanel Btnpanel = new JPanel();
	JPanel Btnpanel_1 = new JPanel();
	
	//�α���â �ؽ�Ʈ�ʵ�
	JTextField txtId= new JTextField() { 
		@Override public void setBorder(Border border) {
        // �ؽ�Ʈ�ʵ� �ܰ��� ����
    }};
	private JPasswordField passwordField=new JPasswordField() {
		 @Override public void setBorder(Border border) {
		        // �ؽ�Ʈ�ʵ� �ܰ��� ����
		    }
	};
	
	//ȸ������ â �ؽ�Ʈ�ʵ�
	JTextField txtF_username = new JTextField() {
		 @Override public void setBorder(Border border) {
		}
	};
	private JPasswordField passwordField_1 = new JPasswordField() {
		 @Override public void setBorder(Border border) {
		}
	};
	private JPasswordField passwordField_2=new JPasswordField() {
		 @Override public void setBorder(Border border) {
		}
	};
	
	//�α��� â ���� ��ư
	JButton signupButton = new JButton("Sign Up");
	JButton loginButton = new JButton("Login");
	
	//ȸ������ â ���� ��ư
	JButton signupButton_1 = new JButton("Sign Up");
	JButton backButton = new JButton("�ڷΰ���");
	
	JLabel lb_1 = new JLabel("");	//��� �̹����� ���� ���̺�
	JLabel lb_1_1 = new JLabel("");//��� �̹����� ���� ���̺�
	
	ImageIcon icon= new ImageIcon("image/login.png");
	
	/**
	 * Create the panel.
	 */
	public Login() {
		setBackground(SystemColor.inactiveCaption);
		setBounds(0, 0, 1000, 650);
		setLayout(null);
		
		//ī�� ���̾ƿ�
		cardpanel.setBounds(215, 81, 550, 400);
		add(cardpanel);
		cardpanel.setLayout(Card);	
		cardpanel.add(panel, "Login");
		cardpanel.add(panel_2, "SignUp");
		Card.show(cardpanel, "Login");
		
/*							�α��� â ����								*/
		panel.setBackground(Color.WHITE);
		panel.setBounds(215, 81, 550, 400);
		panel.setLayout(null);
		
		icon=Zoas.imageSetSize(icon, 49, 49);
		lb_1.setIcon(icon);
		lb_1_1.setIcon(icon);
		lb_1.setBounds(250, 40, 50, 50);
		panel.add(lb_1);
		
		//�α���â�� ȸ������ ��ư
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card.show(cardpanel, "SignUp");
			}
		});
		signupButton.setForeground(SystemColor.activeCaption);
		signupButton.setFont(new Font("���� ���", Font.PLAIN, 11));
		signupButton.setBounds(167, 262, 211, 23);
		
		//�α��� ��ư
		loginButton.setForeground(Color.WHITE);
		loginButton.setFont(new Font("���� ���", Font.PLAIN, 15));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tempUser.setusername(txtId.getText());
				String pwString= new String(passwordField.getPassword());
				tempUser.setpassword(pwString);
				
				/*�α����� ���� ���� ���*/
				String strUrl="http://zoas.sch.ac.kr:8000/rest-auth/login/";
				String jsonStr= Zoas.json.loginJsonstr(tempUser);
				
				String responseString =Zoas.httpUtil.postRequest(strUrl,jsonStr);	//������� ���� JSON ������ ����
				if(responseString=="Error!") {	
					JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� �ٽ� �Է��ϼ���.", "�α��� ����!", JOptionPane.ERROR_MESSAGE);
					txtId.setText("");
					passwordField.setText("");
				}
				else {//���� ������ �ƴ� ��쿡�� �α���
					Zoas.user.setusername(tempUser.getusername());
					Zoas.user.setpassword(tempUser.getpassword());
					
					// ���� ���ڿ� parsing & ���� Ű ����
					JsonElement element = JsonParser.parseString(responseString);
					Zoas.user.setkey(element.getAsJsonObject().get("key").getAsString());

					Zoas.Home_p.noteupdate();	//�ֱ� ��Ʈ ����
					Zoas.mainCard.show(Zoas.frame.getContentPane(),"Main");
				}
				
			}
		});
		loginButton.setBounds(0, -1, 211, 28);
		loginButton.setBorderPainted(false); // ��ư �׵θ� ��������
		loginButton.setContentAreaFilled(false);	// ��ư ä��� ��������
		loginButton.setFocusPainted(false);	// ��ư ��Ŀ�� ��������
		Btnpanel.setBackground(SystemColor.textHighlight);
		Btnpanel.setLayout(null);
		Btnpanel.add(loginButton);
		txtId.setFont(new Font("���� ���", Font.PLAIN, 12));
		
		signupButton.setBorderPainted(false); // ��ư �׵θ� ��������
		signupButton.setContentAreaFilled(false);	// ��ư ä��� ��������
		signupButton.setFocusPainted(false);	// ��ư ��Ŀ�� ��������
		panel.add(signupButton);
		
		//���̵�
		txtId.setBackground(Color.LIGHT_GRAY);
		txtId.setBounds(220, 146, 160, 21);
		panel.add(txtId);
		txtId.setColumns(10);
		passwordField.setFont(new Font("���� ���", Font.PLAIN, 12));
		
		//��й�ȣ
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setBounds(220, 181, 160, 21);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		lblNewLabel.setBounds(173, 149, 17, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PW");
		lblNewLabel_1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		lblNewLabel_1.setBounds(173, 185, 27, 15);
		panel.add(lblNewLabel_1);
		Btnpanel.setBounds(170, 222, 211, 29);
		panel.add(Btnpanel);
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		
/*							ȸ������ â ����								*/
		
		lb_1_1.setBounds(250, 40, 50, 50);
		panel_2.add(lb_1_1);
		
		txtF_username.setFont(new Font("���� ���", Font.PLAIN, 12));
		txtF_username.setColumns(10);
		txtF_username.setBackground(Color.LIGHT_GRAY);
		txtF_username.setBounds(241, 137, 150, 21);
		panel_2.add(txtF_username);
		passwordField_1.setDragEnabled(true);
		
		passwordField_1.setFont(new Font("���� ���", Font.PLAIN, 12));
		passwordField_1.setBackground(Color.LIGHT_GRAY);
		passwordField_1.setBounds(241, 168, 150, 21);
		panel_2.add(passwordField_1);
		passwordField_2.setDragEnabled(true);
		
		passwordField_2.setFont(new Font("���� ���", Font.PLAIN, 12));
		passwordField_2.setBackground(Color.LIGHT_GRAY);
		passwordField_2.setBounds(241, 202, 150, 21);
		panel_2.add(passwordField_2);
		
		//ȸ������â�� sign up ��ư
		Btnpanel_1.setLayout(null);
		Btnpanel_1.setBackground(SystemColor.textHighlight);
		Btnpanel_1.setBounds(162, 254, 211, 29);
		panel_2.add(Btnpanel_1);		
		signupButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idString= new String(txtF_username.getText());
				String pw1String= new String(passwordField_1.getPassword());
				String pw2String= new String(passwordField_2.getPassword());
				
				if(!pw1String.equals(pw2String)) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.", "����!", JOptionPane.ERROR_MESSAGE);
					passwordField_2.setText("");
				}
				else if(idString.equals("")) {
					JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���.", "����!", JOptionPane.ERROR_MESSAGE);
				}
				else if(pw1String.equals("")) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է����ּ���.", "����!", JOptionPane.ERROR_MESSAGE);
				}
				else if(!pw1String.matches(pwPattern)) {
					JOptionPane.showMessageDialog(null, "�ʹ� �ϻ����̰ų� ª���ϴ�.\n��ҹ��� ���� �ּ� 8�� �̻� �Է����ּ���.", "����!", JOptionPane.ERROR_MESSAGE);
					passwordField_1.setText("");
					passwordField_2.setText("");
				}
				else {
					tempUser.setusername(idString);
					tempUser.setpassword(pw2String);
					
					/*ȸ�������� ���� ���� ���*/
					String strUrl="http://zoas.sch.ac.kr:8000/rest-auth/signup/";
					String jsonStr= Zoas.json.signupJsonstr(tempUser);
					String responseString =Zoas.httpUtil.postRequest(strUrl,jsonStr);
					if(responseString=="Error!") {	
						JOptionPane.showMessageDialog(null, "�ߺ��� ���̵��Դϴ�.", "����!", JOptionPane.ERROR_MESSAGE);
						txtF_username.setText("");
						passwordField_1.setText("");
						passwordField_2.setText("");
					}
					else {//���� ������ �ƴ� ��쿡�� ȸ������ ó��
						Zoas.user.setusername(tempUser.getusername());
						Zoas.user.setpassword(tempUser.getpassword());
						// ���ڿ� parsing & ���� Ű ���� �� �ڵ� �α���					
						JsonElement element = JsonParser.parseString(responseString);
						Zoas.user.setkey(element.getAsJsonObject().get("key").getAsString());
						JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�.", "ȸ������ �Ϸ�", JOptionPane.INFORMATION_MESSAGE);
						Zoas.Home_p.noteupdate();	//�ֱ� ��Ʈ ����
						Zoas.mainCard.show(Zoas.frame.getContentPane(),"Main");
					}					
				}
			}
		});
		
		signupButton_1.setForeground(Color.WHITE);
		signupButton_1.setFont(new Font("���� ���", Font.PLAIN, 15));
		signupButton_1.setFocusPainted(false);
		signupButton_1.setContentAreaFilled(false);
		signupButton_1.setBorderPainted(false);
		signupButton_1.setBounds(0, -1, 211, 28);
		Btnpanel_1.add(signupButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("���̵�");
		lblNewLabel_2.setFont(new Font("���� ���", Font.BOLD, 14));
		lblNewLabel_2.setBounds(152, 137, 57, 15);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("��й�ȣ");
		lblNewLabel_4.setFont(new Font("���� ���", Font.BOLD, 13));
		lblNewLabel_4.setBounds(152, 173, 57, 15);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("��й�ȣ Ȯ��");
		lblNewLabel_5.setFont(new Font("���� ���", Font.BOLD, 13));
		lblNewLabel_5.setBounds(152, 205, 89, 15);
		panel_2.add(lblNewLabel_5);
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card.show(cardpanel, "Login");
			}
		});
		backButton.setForeground(SystemColor.activeCaption);
		backButton.setFont(new Font("���� ���", Font.PLAIN, 11));
		backButton.setFocusPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setBounds(162, 291, 211, 23);
		panel_2.add(backButton);
	}
}

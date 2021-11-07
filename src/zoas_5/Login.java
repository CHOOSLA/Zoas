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
	String pwPattern = "^(?=.*[a-z])(?=.*[A-Z]).{8,}$"; //비밀번호 형식
	User tempUser=new User();	//임시 사용자 회원가입, 로그인이 성공하면 메인 유저인 Zoas 유저 갱신해준다
	
	static CardLayout Card=new CardLayout();
	JPanel panel = new JPanel();	//로그인창
	JPanel panel_2 = new JPanel();	//회원가입창
	JPanel cardpanel = new JPanel();//카드 레이아웃을 위한 패널
	JPanel Btnpanel = new JPanel();
	JPanel Btnpanel_1 = new JPanel();
	
	//로그인창 텍스트필드
	JTextField txtId= new JTextField() { 
		@Override public void setBorder(Border border) {
        // 텍스트필드 외곽선 제거
    }};
	private JPasswordField passwordField=new JPasswordField() {
		 @Override public void setBorder(Border border) {
		        // 텍스트필드 외곽선 제거
		    }
	};
	
	//회원가입 창 텍스트필드
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
	
	//로그인 창 내부 버튼
	JButton signupButton = new JButton("Sign Up");
	JButton loginButton = new JButton("Login");
	
	//회원가입 창 내부 버튼
	JButton signupButton_1 = new JButton("Sign Up");
	JButton backButton = new JButton("뒤로가기");
	
	JLabel lb_1 = new JLabel("");	//사람 이미지를 위한 레이블
	JLabel lb_1_1 = new JLabel("");//사람 이미지를 위한 레이블
	
	ImageIcon icon= new ImageIcon("image/login.png");
	
	/**
	 * Create the panel.
	 */
	public Login() {
		setBackground(SystemColor.inactiveCaption);
		setBounds(0, 0, 1000, 650);
		setLayout(null);
		
		//카드 레이아웃
		cardpanel.setBounds(215, 81, 550, 400);
		add(cardpanel);
		cardpanel.setLayout(Card);	
		cardpanel.add(panel, "Login");
		cardpanel.add(panel_2, "SignUp");
		Card.show(cardpanel, "Login");
		
/*							로그인 창 관련								*/
		panel.setBackground(Color.WHITE);
		panel.setBounds(215, 81, 550, 400);
		panel.setLayout(null);
		
		icon=Zoas.imageSetSize(icon, 49, 49);
		lb_1.setIcon(icon);
		lb_1_1.setIcon(icon);
		lb_1.setBounds(250, 40, 50, 50);
		panel.add(lb_1);
		
		//로그인창의 회원가입 버튼
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card.show(cardpanel, "SignUp");
			}
		});
		signupButton.setForeground(SystemColor.activeCaption);
		signupButton.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		signupButton.setBounds(167, 262, 211, 23);
		
		//로그인 버튼
		loginButton.setForeground(Color.WHITE);
		loginButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tempUser.setusername(txtId.getText());
				String pwString= new String(passwordField.getPassword());
				tempUser.setpassword(pwString);
				
				/*로그인을 위한 서버 통신*/
				String strUrl="http://zoas.sch.ac.kr:8000/rest-auth/login/";
				String jsonStr= Zoas.json.loginJsonstr(tempUser);
				
				String responseString =Zoas.httpUtil.postRequest(strUrl,jsonStr);	//응답받은 문장 JSON 형태일 것임
				if(responseString=="Error!") {	
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 다시 입력하세요.", "로그인 오류!", JOptionPane.ERROR_MESSAGE);
					txtId.setText("");
					passwordField.setText("");
				}
				else {//응답 오류가 아닌 경우에만 로그인
					Zoas.user.setusername(tempUser.getusername());
					Zoas.user.setpassword(tempUser.getpassword());
					
					// 응답 문자열 parsing & 유저 키 저장
					JsonElement element = JsonParser.parseString(responseString);
					Zoas.user.setkey(element.getAsJsonObject().get("key").getAsString());

					Zoas.Home_p.noteupdate();	//최근 노트 설정
					Zoas.mainCard.show(Zoas.frame.getContentPane(),"Main");
				}
				
			}
		});
		loginButton.setBounds(0, -1, 211, 28);
		loginButton.setBorderPainted(false); // 버튼 테두리 설정해제
		loginButton.setContentAreaFilled(false);	// 버튼 채우기 설정해제
		loginButton.setFocusPainted(false);	// 버튼 포커스 설정해제
		Btnpanel.setBackground(SystemColor.textHighlight);
		Btnpanel.setLayout(null);
		Btnpanel.add(loginButton);
		txtId.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		signupButton.setBorderPainted(false); // 버튼 테두리 설정해제
		signupButton.setContentAreaFilled(false);	// 버튼 채우기 설정해제
		signupButton.setFocusPainted(false);	// 버튼 포커스 설정해제
		panel.add(signupButton);
		
		//아이디
		txtId.setBackground(Color.LIGHT_GRAY);
		txtId.setBounds(220, 146, 160, 21);
		panel.add(txtId);
		txtId.setColumns(10);
		passwordField.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		//비밀번호
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
		
/*							회원가입 창 관련								*/
		
		lb_1_1.setBounds(250, 40, 50, 50);
		panel_2.add(lb_1_1);
		
		txtF_username.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txtF_username.setColumns(10);
		txtF_username.setBackground(Color.LIGHT_GRAY);
		txtF_username.setBounds(241, 137, 150, 21);
		panel_2.add(txtF_username);
		passwordField_1.setDragEnabled(true);
		
		passwordField_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		passwordField_1.setBackground(Color.LIGHT_GRAY);
		passwordField_1.setBounds(241, 168, 150, 21);
		panel_2.add(passwordField_1);
		passwordField_2.setDragEnabled(true);
		
		passwordField_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		passwordField_2.setBackground(Color.LIGHT_GRAY);
		passwordField_2.setBounds(241, 202, 150, 21);
		panel_2.add(passwordField_2);
		
		//회원가입창의 sign up 버튼
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
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "오류!", JOptionPane.ERROR_MESSAGE);
					passwordField_2.setText("");
				}
				else if(idString.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.", "오류!", JOptionPane.ERROR_MESSAGE);
				}
				else if(pw1String.equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.", "오류!", JOptionPane.ERROR_MESSAGE);
				}
				else if(!pw1String.matches(pwPattern)) {
					JOptionPane.showMessageDialog(null, "너무 일상적이거나 짧습니다.\n대소문자 포함 최소 8자 이상 입력해주세요.", "오류!", JOptionPane.ERROR_MESSAGE);
					passwordField_1.setText("");
					passwordField_2.setText("");
				}
				else {
					tempUser.setusername(idString);
					tempUser.setpassword(pw2String);
					
					/*회원가입을 위한 서버 통신*/
					String strUrl="http://zoas.sch.ac.kr:8000/rest-auth/signup/";
					String jsonStr= Zoas.json.signupJsonstr(tempUser);
					String responseString =Zoas.httpUtil.postRequest(strUrl,jsonStr);
					if(responseString=="Error!") {	
						JOptionPane.showMessageDialog(null, "중복된 아이디입니다.", "오류!", JOptionPane.ERROR_MESSAGE);
						txtF_username.setText("");
						passwordField_1.setText("");
						passwordField_2.setText("");
					}
					else {//응답 오류가 아닌 경우에만 회원가입 처리
						Zoas.user.setusername(tempUser.getusername());
						Zoas.user.setpassword(tempUser.getpassword());
						// 문자열 parsing & 유저 키 저장 후 자동 로그인					
						JsonElement element = JsonParser.parseString(responseString);
						Zoas.user.setkey(element.getAsJsonObject().get("key").getAsString());
						JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.", "회원가입 완료", JOptionPane.INFORMATION_MESSAGE);
						Zoas.Home_p.noteupdate();	//최근 노트 설정
						Zoas.mainCard.show(Zoas.frame.getContentPane(),"Main");
					}					
				}
			}
		});
		
		signupButton_1.setForeground(Color.WHITE);
		signupButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		signupButton_1.setFocusPainted(false);
		signupButton_1.setContentAreaFilled(false);
		signupButton_1.setBorderPainted(false);
		signupButton_1.setBounds(0, -1, 211, 28);
		Btnpanel_1.add(signupButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("아이디");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_2.setBounds(152, 137, 57, 15);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("비밀번호");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_4.setBounds(152, 173, 57, 15);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("비밀번호 확인");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_5.setBounds(152, 205, 89, 15);
		panel_2.add(lblNewLabel_5);
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card.show(cardpanel, "Login");
			}
		});
		backButton.setForeground(SystemColor.activeCaption);
		backButton.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		backButton.setFocusPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setBounds(162, 291, 211, 23);
		panel_2.add(backButton);
	}
}

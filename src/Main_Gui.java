/*
 * 
 * */


import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main_Gui extends JFrame {

	private JFrame frame;
	//JInternalFrame noteFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Gui window = new Main_Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 760, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/*--------------------메뉴 패널--------------------*/
		JPanel Manu_panel = new JPanel();
		Manu_panel.setBackground(Color.LIGHT_GRAY);
		Manu_panel.setBounds(0, 0, 144, 411);
		frame.getContentPane().add(Manu_panel);
		Manu_panel.setLayout(null);
		
		/*--------------------최근 노트 패널--------------------*/
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(144, 0, 600, 411);
		frame.getContentPane().add(panel_1);
		
		/*----------메뉴 패널 관련 컴포넌트--------------------*/
		JButton NewnButton = new JButton("새 노트 만들기");
		NewnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				JPanel panel_2=new newnote(frame);
			}
		});
		NewnButton.setBounds(16, 70, 116, 36);
		NewnButton.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		NewnButton.setBackground(Color.WHITE);
		NewnButton.setBorderPainted(false); // 버튼 테두리 설정해제
		NewnButton.setFocusPainted(false);	// 버튼 포커스 설정해제
		Manu_panel.add(NewnButton);
		
			//이미지 크기 설정
		ImageIcon icon1= new ImageIcon("image/note.png");
		Image img1=icon1.getImage();
		Image changeimg1=img1.getScaledInstance(17,17,Image.SCALE_SMOOTH);
		ImageIcon noteicon=new ImageIcon(changeimg1);
		
		JLabel NoteIcon = new JLabel("",noteicon,JLabel.CENTER);
		NoteIcon.setBounds(22, 126, 15, 15);
		Manu_panel.add(NoteIcon);
		
		JButton btnNewButton_1 = new JButton("ZOAS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				//panel_2.setVisible(false);
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 21));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(16, 20, 109, 32);
		btnNewButton_1.setBorderPainted(false); // 버튼 테두리 설정해제
		btnNewButton_1.setContentAreaFilled(false);	// 버튼 채우기 설정해제
		btnNewButton_1.setFocusPainted(false);	// 버튼 포커스 설정해제
		Manu_panel.add(btnNewButton_1);
		
		
		/*----------최근 노트 패널 관련 컴포넌트----------*/
		JButton AllnButton = new JButton("전체노트");
		AllnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AllnButton.setBackground(Color.LIGHT_GRAY);
		AllnButton.setBounds(28, 122, 90, 25);
		AllnButton.setBorderPainted(false); // 버튼 테두리 설정해제
		//btnNewButton_2.setOpaque(false); 투명하게(버튼 클릭 시 뒤에 파란색이 뜨긴 함)
		AllnButton.setContentAreaFilled(false);	// 버튼 채우기 설정해제
		AllnButton.setFocusPainted(false);	// 버튼 포커스 설정해제
		Manu_panel.add(AllnButton);
		panel_1.setLayout(null);
		
		JLabel p1_lb1 = new JLabel("최근노트");
		p1_lb1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		p1_lb1.setBounds(20, 15, 68, 24);
		panel_1.add(p1_lb1);
		
		JLabel p1_lb2 = new JLabel("이름");
		p1_lb2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		p1_lb2.setBounds(20, 49, 57, 15);
		panel_1.add(p1_lb2);
		
		JLabel p1_lb3 = new JLabel("마지막 수정 일자");
		p1_lb3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		p1_lb3.setBounds(450, 49, 115, 15);
		panel_1.add(p1_lb3);
		
		JPanel linepanel = new JPanel();
		linepanel.setBackground(Color.LIGHT_GRAY);
		linepanel.setBounds(15, 71, 565, 2);
		panel_1.add(linepanel);
		
		JLabel p1_lb4 = new JLabel("조아스, 이렇게 사용해 보세요");
		p1_lb4.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		p1_lb4.setBounds(21, 83, 199, 15);
		panel_1.add(p1_lb4);
		
		JLabel p1_lb5 = new JLabel("2021-10-26 오후 7시 38분");
		p1_lb5.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		p1_lb5.setBounds(425, 83, 137, 15);
		panel_1.add(p1_lb5);
		
		JButton p1_Button1 = new JButton("");
		p1_Button1.setBounds(15, 81, 560, 23);
		p1_Button1.setBorderPainted(false); // 버튼 테두리 설정해제
		p1_Button1.setContentAreaFilled(false);	// 버튼 채우기 설정해제
		p1_Button1.setFocusPainted(false);	// 버튼 포커스 설정해제
		panel_1.add(p1_Button1);
		
	}
	
	
}

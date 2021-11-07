package zoas_1;
/*
 * 
 * */


import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Zoas extends JFrame {

	private JFrame frame;
	//JInternalFrame noteFrame;
	
	JPanel Manu_panel = new JPanel();
	JPanel panel_1 = new JPanel();	// 최근 노트 패널
	JPanel panel_2 = new JPanel();	// 새 노트 패널
	JPanel linepanel = new JPanel();
	
	JButton newNoteBtn = new JButton("새 노트 만들기");
	JButton zoasBtn = new JButton("ZOAS");	//홈 이동 버튼
	JButton allNoteBtn = new JButton("전체노트");	//??
	JButton myNotesBtn = new JButton("");	//각 노트들의 버튼 
	JButton ZoomBtn = new JButton("강의 연결하기");
	
	JLabel NoteIcon = new JLabel("",JLabel.CENTER);
	JLabel p1_lb1 = new JLabel("최근노트");
	JLabel p1_lb2 = new JLabel("이름");
	JLabel p1_lb3 = new JLabel("마지막 수정 일자");
	JLabel p1_lb4 = new JLabel("조아스, 이렇게 사용해 보세요");	//노트 이름
	JLabel p1_lb5 = new JLabel("2021-10-26 오후 7시 38분");	//노트 수정 날짜
	
	ImageIcon noteicon= new ImageIcon("image/note.png");
	public void setPanel() {
		Manu_panel.setBackground(Color.LIGHT_GRAY);
		Manu_panel.setBounds(0, 0, 144, 411);
		frame.getContentPane().add(Manu_panel);
		Manu_panel.setLayout(null);
		
		//최근 노트 패널
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(144, 0, 600, 411);
		frame.getContentPane().add(panel_1);
		
		//새 노트 생성 패널
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(144, 0, 600, 411);
		panel_2.setVisible(false);
		Manu_panel.add(panel_2);
		
		
		linepanel.setBackground(Color.LIGHT_GRAY);
		linepanel.setBounds(15, 71, 565, 2);
		panel_1.add(linepanel);
	}
	
	public void setBtn() {
		//새 노트 만들기 버튼 설정
		newNoteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				makeNewnote(panel_2);
			}
		});
		newNoteBtn.setBounds(16, 70, 116, 36);
		newNoteBtn.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		newNoteBtn.setBackground(Color.WHITE);
		newNoteBtn.setBorderPainted(false); // 버튼 테두리 설정해제
		newNoteBtn.setFocusPainted(false);	// 버튼 포커스 설정해제
		Manu_panel.add(newNoteBtn);
		
		//ZOAS 버튼 설정
		zoasBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				frame.getContentPane().remove(panel_2);
			}
		});
		zoasBtn.setForeground(Color.BLACK);
		zoasBtn.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 21));
		zoasBtn.setBackground(Color.LIGHT_GRAY);
		zoasBtn.setBounds(16, 20, 109, 32);
		zoasBtn.setBorderPainted(false); // 버튼 테두리 설정해제
		zoasBtn.setContentAreaFilled(false);	// 버튼 채우기 설정해제
		zoasBtn.setFocusPainted(false);	// 버튼 포커스 설정해제
		Manu_panel.add(zoasBtn);
		
		//전체노트 버튼 설정
		allNoteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		allNoteBtn.setBackground(Color.LIGHT_GRAY);
		allNoteBtn.setBounds(28, 122, 90, 25);
		allNoteBtn.setBorderPainted(false); // 버튼 테두리 설정해제
		//btnNewButton_2.setOpaque(false); 투명하게(버튼 클릭 시 뒤에 파란색이 뜨긴 함)
		allNoteBtn.setContentAreaFilled(false);	// 버튼 채우기 설정해제
		allNoteBtn.setFocusPainted(false);	// 버튼 포커스 설정해제
		Manu_panel.add(allNoteBtn);
		panel_1.setLayout(null);
		
		//생성된 노트 버튼 **라벨이랑 묶어서 여러개 생성되어야 하는데...??**
		myNotesBtn.setBounds(15, 81, 560, 23);
		myNotesBtn.setBorderPainted(false); // 버튼 테두리 설정해제
		myNotesBtn.setContentAreaFilled(false);	// 버튼 채우기 설정해제
		myNotesBtn.setFocusPainted(false);	// 버튼 포커스 설정해제
		panel_1.add(myNotesBtn);
		
		//강의 연결하기 버튼 설정
		ZoomBtn.setForeground(Color.WHITE);
		ZoomBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		ZoomBtn.setBorderPainted(false);
		ZoomBtn.setBackground(SystemColor.textHighlight);
		ZoomBtn.setBounds(220, 206, 150, 60);
		panel_2.add(ZoomBtn);
	}
	
	public void setLabel() {
		//노트 아이콘 
		Image img=noteicon.getImage();
		Image changedimg=img.getScaledInstance(17,17,Image.SCALE_DEFAULT);
		noteicon=new ImageIcon(changedimg);
		NoteIcon.setIcon(noteicon);
		NoteIcon.setBounds(22, 126, 15, 15);
		Manu_panel.add(NoteIcon);
				
		//'최근노트'
		p1_lb1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		p1_lb1.setBounds(20, 15, 68, 24);
		panel_1.add(p1_lb1);
		
		//'이름'
		p1_lb2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		p1_lb2.setBounds(20, 49, 57, 15);
		panel_1.add(p1_lb2);
		
		//'마지막 수정 일자'
		p1_lb3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		p1_lb3.setBounds(450, 49, 115, 15);
		panel_1.add(p1_lb3);
		
		//노트 이름
		p1_lb4.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		p1_lb4.setBounds(21, 83, 199, 15);
		panel_1.add(p1_lb4);
		
		//노트 수정 날짜
		p1_lb5.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		p1_lb5.setBounds(430, 83, 137, 15);
		panel_1.add(p1_lb5);
	}
	
	public void removePanel(JPanel panel) {
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
	}
	public void makeNewnote(JPanel panel) {
		removePanel(panel);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(144, 0, 600, 411);
		panel.setVisible(true);
		frame.getContentPane().add(panel);
		
		/*----------새 노트 생성 패널 관련 컴포넌트----------*/
		JTextField noteNameField = new JTextField("새노트"){
			 @Override public void setBorder(Border border) {
			        // 텍스트필드 외곽선 제거
			    }
		};
		noteNameField.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		noteNameField.setBounds(20, 23, 200, 22);
		panel.add(noteNameField);
		noteNameField.setColumns(10);
		
		JPanel linepanel_1 = new JPanel();
		linepanel_1.setBackground(Color.LIGHT_GRAY);
		linepanel_1.setBounds(15, 71, 565, 2);
		panel.add(linepanel_1);
		
		JLabel p2_lb2 = new JLabel("2021-10-26 오후 7시 38분");
		p2_lb2.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		p2_lb2.setBounds(20, 43, 137, 15);
		panel.add(p2_lb2);
		
		JButton ZoomBtn = new JButton("강의 연결하기");
		ZoomBtn.setForeground(Color.WHITE);
		ZoomBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		ZoomBtn.setBorderPainted(false);
		ZoomBtn.setBackground(SystemColor.textHighlight);
		ZoomBtn.setBounds(220, 206, 150, 60);
		panel.add(ZoomBtn);
		
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zoas window = new Zoas();
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
	public Zoas() {
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
		
		setPanel();
		setBtn();
		setLabel();
		
		

		
		
		
		
		

	
	}
	
	
}

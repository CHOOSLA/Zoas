package zoas_2;

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Home extends JPanel {
	JLabel lb1 = new JLabel("최근노트");
	JLabel lb2 = new JLabel("이름");
	JLabel lb3 = new JLabel("마지막 수정 일자");
	JLabel lb4 = new JLabel("조아스, 이렇게 사용해 보세요");	//노트 이름
	JLabel lb4_icon = new JLabel("");	
	JLabel lb5 = new JLabel("2021-10-26 오후 7시 38분");	//노트 수정 날짜
	
	JButton myNotesBtn = new JButton("");	//각 노트들의 버튼 
	
	JPanel linepanel = new JPanel();
	JPanel notepanel = new JPanel();
	
	ImageIcon noteicon= new ImageIcon("image/note.png");
	
	/**
	 * Create the panel.
	 */
	public Home() {
		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(144, 0, 600, 411);
		
		notepanel.addMouseListener(new ManuPanelListener() {
			@Override//마우스가 버튼 안으로 들어오면
		    public void mouseEntered(MouseEvent e) {
		    	JPanel p = (JPanel)e.getSource();
		        p.setBackground(SystemColor.inactiveCaptionBorder);
		    }

		    @Override//마우스가 버튼 밖으로 나가면 
		    public void mouseExited(MouseEvent e) {
		    	JPanel p = (JPanel)e.getSource();        
		    	p.setBackground(Color.WHITE);
		    }
			
		});
		notepanel.setLayout(null);
		notepanel.setBackground(Color.WHITE);
		notepanel.setBounds(15, 77, 568, 30);
		add(notepanel);
		
		linepanel.setBackground(Color.LIGHT_GRAY);
		linepanel.setBounds(15, 71, 565, 2);
		add(linepanel);
		
		//생성된 노트 버튼 **라벨이랑 묶어서 여러개 생성되어야 하는데...??**
		myNotesBtn.setBounds(15, 81, 560, 23);
		myNotesBtn.setBorderPainted(false); // 버튼 테두리 설정해제
		myNotesBtn.setContentAreaFilled(false);	// 버튼 채우기 설정해제
		myNotesBtn.setFocusPainted(false);	// 버튼 포커스 설정해제
		add(myNotesBtn);
				
		//'최근노트'
		lb1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		lb1.setBounds(20, 15, 68, 24);
		add(lb1);
				
		//'이름'
		lb2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb2.setBounds(20, 49, 57, 15);
		add(lb2);
				
		//'마지막 수정 일자'
		lb3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb3.setBounds(450, 49, 115, 15);
		add(lb3);
				
		//노트 이름
		lb4.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lb4.setBounds(10, 7, 199, 15);
		notepanel.add(lb4);
		
		//노트 아이콘
		//noteicon=imageSetSize(noteicon, 19, 19);
		lb4_icon.setBounds(5, 9, 10, 10);
		lb4_icon.setIcon(noteicon);
		notepanel.add(lb4_icon);
				
		//노트 수정 날짜
		lb5.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		lb5.setBounds(430, 8, 150, 15);
		notepanel.add(lb5);
		
	}

}

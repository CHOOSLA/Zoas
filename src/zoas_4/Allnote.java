package zoas_4;

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Allnote extends JPanel {
	JLabel lb1 = new JLabel("전체 노트");
	JLabel lb2 = new JLabel("이름");
	JLabel lb3 = new JLabel("마지막 수정 일자");
	JLabel lb4 = new JLabel("조아스, 이렇게 사용해 보세요");	//노트 이름
	JLabel lb4_icon = new JLabel("");					//노트 아이콘
	JLabel lb5 = new JLabel("2021-10-26 오후 7시 38분");	//노트 수정 날짜
	
	JPanel linepanel = new JPanel();
	JPanel notepanel = new JPanel();
	
	ImageIcon noteicon= new ImageIcon("image/sticky-note.png");
	
	/**
	 * Create the panel.
	 */
	public Allnote() {
		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(144, 0, 600, 411);
		
		notepanel.addMouseListener(new MyMouseListener() {
			@Override	//마우스 누를 때
		    public void mouseClicked(MouseEvent e) {
				
		    }
			
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
				
		//'최근노트'
		lb1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		lb1.setBounds(20, 15, 74, 24);
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
		lb4.setBounds(26, 6, 400, 15);
		notepanel.add(lb4);
		
		//노트 아이콘
		noteicon=Zoas.imageSetSize(noteicon, 20, 20);
		lb4_icon.setBounds(4, 5, 19, 19);
		lb4_icon.setIcon(noteicon);
		notepanel.add(lb4_icon);
				
		//노트 수정 날짜
		lb5.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		lb5.setBounds(430, 8, 150, 15);
		notepanel.add(lb5);
		
		
	}

}

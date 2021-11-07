package zoas_5;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import zoas_5.DataClass.NoteInfo;

public class Home extends JPanel {
	JLabel lb1 = new JLabel("최근 노트");
	JLabel lb2 = new JLabel("이름");
	JLabel lb3 = new JLabel("마지막 수정 일자");
	JLabel lb4 = new JLabel();	//노트 이름
	JLabel lb4_icon = new JLabel("");	
	JLabel lb5 = new JLabel();	//노트 수정 날짜
	
	JPanel linepanel = new JPanel();
	JPanel notepanel = new JPanel();
	
	ImageIcon noteicon= new ImageIcon("image/sticky-note.png");
	
	public void noteupdate() {
		ArrayList<NoteInfo> notelist=Zoas.user.getNoteList();
		int notes=notelist.size();	//노트 배열의 개수
		if(notes>0) {
			lb4.setText(notelist.get(notes-1).getName());
			lb5.setText(notelist.get(notes-1).getEditDate());
			lb4_icon.setIcon(noteicon);
			add(notepanel);
		}
	}
	
	/**
	 * Create the panel.
	 */
	public Home() {
		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(144, 0, 840, 611);
		
		notepanel.addMouseListener(new MouseListener() {
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

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				Zoas.laftCard.show(Zoas.left_panel, "NoteForm");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		notepanel.setLayout(null);
		notepanel.setBackground(Color.WHITE);
		notepanel.setBounds(12, 87, 815, 35);

		linepanel.setBackground(Color.GRAY);
		linepanel.setBounds(12, 81, 815, 2);
		add(linepanel);
		
		lb1.setForeground(Color.GRAY);
		lb1.setBackground(Color.BLACK);
				
		//'최근노트'
		lb1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		lb1.setBounds(15, 20, 81, 24);
		add(lb1);
				
		//'이름'
		lb2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lb2.setBounds(15, 60, 57, 15);
		add(lb2);
				
		//'마지막 수정 일자'
		lb3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lb3.setBounds(701, 60, 115, 15);
		add(lb3);
				
		//노트 이름
		lb4.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lb4.setBounds(29, 1, 400, 30);
		notepanel.add(lb4);
		
		//노트 아이콘
		noteicon=Zoas.imageSetSize(noteicon, 20, 20);
		lb4_icon.setBounds(6, 5, 25, 25);
		notepanel.add(lb4_icon);
				
		//노트 수정 날짜
		lb5.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lb5.setBounds(640, 2, 170, 30);
		notepanel.add(lb5);
		
	}
}

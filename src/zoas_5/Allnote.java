package zoas_5;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

import zoas_5.DataClass.NoteInfo;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class Allnote extends JPanel implements MouseListener {
	
	JLabel lb1 = new JLabel("전체 노트");
	JLabel lb2 = new JLabel("이름");
	JLabel lb3 = new JLabel("마지막 수정 일자");
	
	JPanel panel = new JPanel();
	JScrollPane scrollPane = new JScrollPane(panel);
	JPanel linepanel = new JPanel();

	ImageIcon noteicon= new ImageIcon("image/sticky-note.png");
	
	public void noteupdate() {
		ArrayList<NoteInfo> notelist=Zoas.user.getNoteList();
		int notes=notelist.size();	//노트 배열의 개수
		
		JLabel[] lb4=new JLabel[notes];	//노트 이름
		JLabel[] lb4_icon=new JLabel[notes] ;			//노트 아이콘
		JLabel[] lb5=new JLabel[notes];	//노트 수정 날짜
		JPanel[] notepanel=new JPanel[notes];	//각 노트 패널
		
		for(int i=0;i<notes;i++) {
			notepanel[i]=new JPanel(); 
			notepanel[i].setLayout(null);
			notepanel[i].setBackground(Color.WHITE);
			notepanel[i].setBounds(0, 0+30*i, 815, 35);
			panel.add(notepanel[i]);
			notepanel[i].addMouseListener(this);
			
			//노트 이름
			lb4[i]=new JLabel(notelist.get(i).getName());
			lb4[i].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			lb4[i].setBounds(29, 1, 400, 30);
			notepanel[i].add(lb4[i]);
			
			//노트 아이콘
			lb4_icon[i]=new JLabel();
			lb4_icon[i].setBounds(6, 5, 25, 25);
			lb4_icon[i].setIcon(noteicon);
			notepanel[i].add(lb4_icon[i]);
			
			//노트 수정 날짜
			lb5[i]=new JLabel(notelist.get(i).getEditDate());
			lb5[i].setFont(new Font("맑은 고딕", Font.PLAIN, 13));
			lb5[i].setBounds(630, 2, 170, 30);
			notepanel[i].add(lb5[i]);
		}
	}
	/**
	 * Create the panel.
	 */
	public Allnote() {
		setBackground(Color.WHITE);
		setBounds(144, 0, 840, 611);
		setLayout(null);
		linepanel.setBounds(12, 81, 815, 2);
		
		linepanel.setBackground(Color.LIGHT_GRAY);
		add(linepanel);
		lb1.setForeground(Color.GRAY);
		lb1.setBounds(15, 20, 81, 24);
				
		//'최근노트'
		lb1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		add(lb1);
		lb2.setBounds(15, 60, 57, 15);
				
		//'이름'
		lb2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		add(lb2);
		lb3.setBounds(710, 60, 115, 15);
				
		//'마지막 수정 일자'
		lb3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		add(lb3);
		panel.setBackground(Color.WHITE);
		
		panel.setPreferredSize(new Dimension(812, 511));
		
		panel.setLayout(null);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(15, 90, 812, 511);
		add(scrollPane);
		
		noteicon=Zoas.imageSetSize(noteicon, 20, 20);
		
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
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JPanel p = (JPanel)e.getSource();
        p.setBackground(SystemColor.inactiveCaptionBorder);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JPanel p = (JPanel)e.getSource();        
    	p.setBackground(Color.WHITE);
	}
}

package zoas_5;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import zoas_5.DataClass.NoteInfo;

public class Home extends JPanel {
	JLabel lb1 = new JLabel("�ֱ� ��Ʈ");
	JLabel lb2 = new JLabel("�̸�");
	JLabel lb3 = new JLabel("������ ���� ����");
	JLabel lb4 = new JLabel();	//��Ʈ �̸�
	JLabel lb4_icon = new JLabel("");	
	JLabel lb5 = new JLabel();	//��Ʈ ���� ��¥
	
	JPanel linepanel = new JPanel();
	JPanel notepanel = new JPanel();
	
	ImageIcon noteicon= new ImageIcon("image/sticky-note.png");
	
	public void noteupdate() {
		ArrayList<NoteInfo> notelist=Zoas.user.getNoteList();
		int notes=notelist.size();	//��Ʈ �迭�� ����
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
			@Override//���콺�� ��ư ������ ������
		    public void mouseEntered(MouseEvent e) {
		    	JPanel p = (JPanel)e.getSource();
		        p.setBackground(SystemColor.inactiveCaptionBorder);
		    }

		    @Override//���콺�� ��ư ������ ������ 
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
				
		//'�ֱٳ�Ʈ'
		lb1.setFont(new Font("���� ���", Font.BOLD, 17));
		lb1.setBounds(15, 20, 81, 24);
		add(lb1);
				
		//'�̸�'
		lb2.setFont(new Font("���� ���", Font.BOLD, 14));
		lb2.setBounds(15, 60, 57, 15);
		add(lb2);
				
		//'������ ���� ����'
		lb3.setFont(new Font("���� ���", Font.BOLD, 14));
		lb3.setBounds(701, 60, 115, 15);
		add(lb3);
				
		//��Ʈ �̸�
		lb4.setFont(new Font("���� ���", Font.PLAIN, 14));
		lb4.setBounds(29, 1, 400, 30);
		notepanel.add(lb4);
		
		//��Ʈ ������
		noteicon=Zoas.imageSetSize(noteicon, 20, 20);
		lb4_icon.setBounds(6, 5, 25, 25);
		notepanel.add(lb4_icon);
				
		//��Ʈ ���� ��¥
		lb5.setFont(new Font("���� ���", Font.PLAIN, 13));
		lb5.setBounds(640, 2, 170, 30);
		notepanel.add(lb5);
		
	}
}

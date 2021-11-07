package zoas_2;

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Home extends JPanel {
	JLabel lb1 = new JLabel("�ֱٳ�Ʈ");
	JLabel lb2 = new JLabel("�̸�");
	JLabel lb3 = new JLabel("������ ���� ����");
	JLabel lb4 = new JLabel("���ƽ�, �̷��� ����� ������");	//��Ʈ �̸�
	JLabel lb4_icon = new JLabel("");	
	JLabel lb5 = new JLabel("2021-10-26 ���� 7�� 38��");	//��Ʈ ���� ��¥
	
	JButton myNotesBtn = new JButton("");	//�� ��Ʈ���� ��ư 
	
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
			
		});
		notepanel.setLayout(null);
		notepanel.setBackground(Color.WHITE);
		notepanel.setBounds(15, 77, 568, 30);
		add(notepanel);
		
		linepanel.setBackground(Color.LIGHT_GRAY);
		linepanel.setBounds(15, 71, 565, 2);
		add(linepanel);
		
		//������ ��Ʈ ��ư **���̶� ��� ������ �����Ǿ�� �ϴµ�...??**
		myNotesBtn.setBounds(15, 81, 560, 23);
		myNotesBtn.setBorderPainted(false); // ��ư �׵θ� ��������
		myNotesBtn.setContentAreaFilled(false);	// ��ư ä��� ��������
		myNotesBtn.setFocusPainted(false);	// ��ư ��Ŀ�� ��������
		add(myNotesBtn);
				
		//'�ֱٳ�Ʈ'
		lb1.setFont(new Font("���� ���", Font.BOLD, 17));
		lb1.setBounds(20, 15, 68, 24);
		add(lb1);
				
		//'�̸�'
		lb2.setFont(new Font("���� ���", Font.BOLD, 15));
		lb2.setBounds(20, 49, 57, 15);
		add(lb2);
				
		//'������ ���� ����'
		lb3.setFont(new Font("���� ���", Font.BOLD, 15));
		lb3.setBounds(450, 49, 115, 15);
		add(lb3);
				
		//��Ʈ �̸�
		lb4.setFont(new Font("���� ���", Font.PLAIN, 13));
		lb4.setBounds(10, 7, 199, 15);
		notepanel.add(lb4);
		
		//��Ʈ ������
		//noteicon=imageSetSize(noteicon, 19, 19);
		lb4_icon.setBounds(5, 9, 10, 10);
		lb4_icon.setIcon(noteicon);
		notepanel.add(lb4_icon);
				
		//��Ʈ ���� ��¥
		lb5.setFont(new Font("���� ���", Font.PLAIN, 11));
		lb5.setBounds(430, 8, 150, 15);
		notepanel.add(lb5);
		
	}

}

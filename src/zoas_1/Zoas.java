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
	JPanel panel_1 = new JPanel();	// �ֱ� ��Ʈ �г�
	JPanel panel_2 = new JPanel();	// �� ��Ʈ �г�
	JPanel linepanel = new JPanel();
	
	JButton newNoteBtn = new JButton("�� ��Ʈ �����");
	JButton zoasBtn = new JButton("ZOAS");	//Ȩ �̵� ��ư
	JButton allNoteBtn = new JButton("��ü��Ʈ");	//??
	JButton myNotesBtn = new JButton("");	//�� ��Ʈ���� ��ư 
	JButton ZoomBtn = new JButton("���� �����ϱ�");
	
	JLabel NoteIcon = new JLabel("",JLabel.CENTER);
	JLabel p1_lb1 = new JLabel("�ֱٳ�Ʈ");
	JLabel p1_lb2 = new JLabel("�̸�");
	JLabel p1_lb3 = new JLabel("������ ���� ����");
	JLabel p1_lb4 = new JLabel("���ƽ�, �̷��� ����� ������");	//��Ʈ �̸�
	JLabel p1_lb5 = new JLabel("2021-10-26 ���� 7�� 38��");	//��Ʈ ���� ��¥
	
	ImageIcon noteicon= new ImageIcon("image/note.png");
	public void setPanel() {
		Manu_panel.setBackground(Color.LIGHT_GRAY);
		Manu_panel.setBounds(0, 0, 144, 411);
		frame.getContentPane().add(Manu_panel);
		Manu_panel.setLayout(null);
		
		//�ֱ� ��Ʈ �г�
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(144, 0, 600, 411);
		frame.getContentPane().add(panel_1);
		
		//�� ��Ʈ ���� �г�
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
		//�� ��Ʈ ����� ��ư ����
		newNoteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				makeNewnote(panel_2);
			}
		});
		newNoteBtn.setBounds(16, 70, 116, 36);
		newNoteBtn.setFont(new Font("���� ��� Semilight", Font.PLAIN, 12));
		newNoteBtn.setBackground(Color.WHITE);
		newNoteBtn.setBorderPainted(false); // ��ư �׵θ� ��������
		newNoteBtn.setFocusPainted(false);	// ��ư ��Ŀ�� ��������
		Manu_panel.add(newNoteBtn);
		
		//ZOAS ��ư ����
		zoasBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				frame.getContentPane().remove(panel_2);
			}
		});
		zoasBtn.setForeground(Color.BLACK);
		zoasBtn.setFont(new Font("�޸յձ�������", Font.BOLD, 21));
		zoasBtn.setBackground(Color.LIGHT_GRAY);
		zoasBtn.setBounds(16, 20, 109, 32);
		zoasBtn.setBorderPainted(false); // ��ư �׵θ� ��������
		zoasBtn.setContentAreaFilled(false);	// ��ư ä��� ��������
		zoasBtn.setFocusPainted(false);	// ��ư ��Ŀ�� ��������
		Manu_panel.add(zoasBtn);
		
		//��ü��Ʈ ��ư ����
		allNoteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		allNoteBtn.setBackground(Color.LIGHT_GRAY);
		allNoteBtn.setBounds(28, 122, 90, 25);
		allNoteBtn.setBorderPainted(false); // ��ư �׵θ� ��������
		//btnNewButton_2.setOpaque(false); �����ϰ�(��ư Ŭ�� �� �ڿ� �Ķ����� �߱� ��)
		allNoteBtn.setContentAreaFilled(false);	// ��ư ä��� ��������
		allNoteBtn.setFocusPainted(false);	// ��ư ��Ŀ�� ��������
		Manu_panel.add(allNoteBtn);
		panel_1.setLayout(null);
		
		//������ ��Ʈ ��ư **���̶� ��� ������ �����Ǿ�� �ϴµ�...??**
		myNotesBtn.setBounds(15, 81, 560, 23);
		myNotesBtn.setBorderPainted(false); // ��ư �׵θ� ��������
		myNotesBtn.setContentAreaFilled(false);	// ��ư ä��� ��������
		myNotesBtn.setFocusPainted(false);	// ��ư ��Ŀ�� ��������
		panel_1.add(myNotesBtn);
		
		//���� �����ϱ� ��ư ����
		ZoomBtn.setForeground(Color.WHITE);
		ZoomBtn.setFont(new Font("���� ���", Font.PLAIN, 14));
		ZoomBtn.setBorderPainted(false);
		ZoomBtn.setBackground(SystemColor.textHighlight);
		ZoomBtn.setBounds(220, 206, 150, 60);
		panel_2.add(ZoomBtn);
	}
	
	public void setLabel() {
		//��Ʈ ������ 
		Image img=noteicon.getImage();
		Image changedimg=img.getScaledInstance(17,17,Image.SCALE_DEFAULT);
		noteicon=new ImageIcon(changedimg);
		NoteIcon.setIcon(noteicon);
		NoteIcon.setBounds(22, 126, 15, 15);
		Manu_panel.add(NoteIcon);
				
		//'�ֱٳ�Ʈ'
		p1_lb1.setFont(new Font("���� ���", Font.BOLD, 17));
		p1_lb1.setBounds(20, 15, 68, 24);
		panel_1.add(p1_lb1);
		
		//'�̸�'
		p1_lb2.setFont(new Font("���� ���", Font.BOLD, 15));
		p1_lb2.setBounds(20, 49, 57, 15);
		panel_1.add(p1_lb2);
		
		//'������ ���� ����'
		p1_lb3.setFont(new Font("���� ���", Font.BOLD, 15));
		p1_lb3.setBounds(450, 49, 115, 15);
		panel_1.add(p1_lb3);
		
		//��Ʈ �̸�
		p1_lb4.setFont(new Font("���� ���", Font.PLAIN, 13));
		p1_lb4.setBounds(21, 83, 199, 15);
		panel_1.add(p1_lb4);
		
		//��Ʈ ���� ��¥
		p1_lb5.setFont(new Font("���� ���", Font.PLAIN, 11));
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
		
		/*----------�� ��Ʈ ���� �г� ���� ������Ʈ----------*/
		JTextField noteNameField = new JTextField("����Ʈ"){
			 @Override public void setBorder(Border border) {
			        // �ؽ�Ʈ�ʵ� �ܰ��� ����
			    }
		};
		noteNameField.setFont(new Font("���� ���", Font.BOLD, 17));
		noteNameField.setBounds(20, 23, 200, 22);
		panel.add(noteNameField);
		noteNameField.setColumns(10);
		
		JPanel linepanel_1 = new JPanel();
		linepanel_1.setBackground(Color.LIGHT_GRAY);
		linepanel_1.setBounds(15, 71, 565, 2);
		panel.add(linepanel_1);
		
		JLabel p2_lb2 = new JLabel("2021-10-26 ���� 7�� 38��");
		p2_lb2.setFont(new Font("���� ���", Font.PLAIN, 11));
		p2_lb2.setBounds(20, 43, 137, 15);
		panel.add(p2_lb2);
		
		JButton ZoomBtn = new JButton("���� �����ϱ�");
		ZoomBtn.setForeground(Color.WHITE);
		ZoomBtn.setFont(new Font("���� ���", Font.PLAIN, 14));
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

package zoas_4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import zoas_4.DataClass.JsonConverter;
import zoas_4.DataClass.NoteInfo;
import zoas_4.DataClass.User;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

class MyMouseListener implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override 
    public void mouseExited(MouseEvent e) {
    }
    
}

public class Zoas extends JFrame  {
	static public User user=new User();
	static public NoteInfo noteinfo=new NoteInfo();
	static public JsonConverter json =new JsonConverter();
	
	static public JFrame frame;
	static CardLayout mainCard=new CardLayout();
	CardLayout laftCard=new CardLayout();
	
	Login Login_p= new Login();	
	JPanel Main_panel = new JPanel();
	JPanel Manu_p = new JPanel();
	JPanel M_panel1 = new JPanel();	//�޴��� ���� ��ư
	
	static public JPanel left_panel = new JPanel();
	Home Home_p= new Home();	// �ֱ� ��Ʈ �г�
	Newnote Newnote_p = new Newnote();	// �� ��Ʈ �г�
	Record Record_p = new Record();	// ��� �г�
	Allnote Allnote_p=new Allnote();	//��ü ��Ʈ �г�
	
	JButton newNoteBtn = new JButton("�� ��Ʈ �����");
	JButton zoasBtn = new JButton("ZOAS");	//Ȩ �̵� ��ư
	
	JLabel label1 = new JLabel("��ü ��Ʈ");	
	JLabel label1_Icon = new JLabel("",JLabel.CENTER);
	
	ImageIcon allnoteicon= new ImageIcon("image/note.png");
	

	public void setPanel() {
		//�����г�
		Main_panel.setBounds(0, 0, 744, 411);
		Main_panel.setLayout(null);
		Main_panel.setBackground(Color.WHITE);
		
		//�޴� �г�
		Manu_p.setBackground(Color.LIGHT_GRAY);
		Manu_p.setBounds(0, 0, 144, 411);
		Main_panel.add(Manu_p);
		Manu_p.setLayout(null);
	
		//�޴��� ��ü��Ʈ �г�(��ư)
		M_panel1.addMouseListener(new MyMouseListener() {
			@Override	//���콺 ���� ��
		    public void mouseClicked(MouseEvent e) {
				laftCard.show(left_panel, "AllNote");
		    }
			@Override//���콺�� ��ư ������ ������
		    public void mouseEntered(MouseEvent e) {
		    	JPanel p = (JPanel)e.getSource();
		        p.setBackground(Color.WHITE);
		    }

		    @Override//���콺�� ��ư ������ ������ 
		    public void mouseExited(MouseEvent e) {
		    	JPanel p = (JPanel)e.getSource();        
		    	p.setBackground(Color.LIGHT_GRAY);
		    }
		});
		M_panel1.setBackground(Color.LIGHT_GRAY);
		M_panel1.setLayout(null);
		M_panel1.setBounds(0, 121, 144, 27);
		Manu_p.add(M_panel1);
		
		//���� �г�(��Ʈ ���̴� ��)
		left_panel.setBackground(Color.WHITE);
		left_panel.setBounds(144, 0, 600, 411);
		Main_panel.add(left_panel);
		left_panel.setLayout(laftCard);
		
		//card layout�� ���� ����
		frame.getContentPane().add("Main",Main_panel);
		frame.getContentPane().add("Login",Login_p);
		mainCard.show(frame.getContentPane(),"Login");
		
		left_panel.add("Home",Home_p);
		left_panel.add("NewNote",Newnote_p);
		left_panel.add("Record",Record_p);
		left_panel.add("AllNote",Allnote_p);
		laftCard.show(left_panel, "NoteList");
	}
	
	public void setBtn() {
		//�� ��Ʈ ����� ��ư ����
		newNoteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ȭ�� ��ȯ�ϱ� ���� �ʱ�ȭ
				Newnote_p.set();	
				laftCard.show(left_panel, "NewNote");
			}
		});
		newNoteBtn.setBounds(16, 70, 116, 36);
		newNoteBtn.setFont(new Font("���� ��� Semilight", Font.PLAIN, 12));
		newNoteBtn.setBackground(Color.WHITE);
		newNoteBtn.setBorderPainted(false); // ��ư �׵θ� ��������
		newNoteBtn.setFocusPainted(false);	// ��ư ��Ŀ�� ��������
		Manu_p.add(newNoteBtn);
		
		//ZOAS ��ư ����
		zoasBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				laftCard.show(left_panel, "Home");
			}
		});
		zoasBtn.setForeground(Color.BLACK);
		zoasBtn.setFont(new Font("�޸յձ�������", Font.BOLD, 21));
		zoasBtn.setBackground(Color.LIGHT_GRAY);
		zoasBtn.setBounds(16, 20, 109, 32);
		zoasBtn.setBorderPainted(false); // ��ư �׵θ� ��������
		zoasBtn.setContentAreaFilled(false);	// ��ư ä��� ��������
		zoasBtn.setFocusPainted(false);	// ��ư ��Ŀ�� ��������
		Manu_p.add(zoasBtn);
				
		//���� �����ϱ� ��ư
		Newnote_p.ZoomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Record_p.set();
				laftCard.show(Zoas.left_panel, "Record");
			}
		});
		
	}
	public void setLabel() {
		//��Ʈ ������ 
		allnoteicon=imageSetSize(allnoteicon, 15, 15);
		label1_Icon.setIcon(allnoteicon);
		label1_Icon.setBounds(17, 4, 19, 19);
		M_panel1.add(label1_Icon);
		
		//'��ü��Ʈ'
		label1.setFont(new Font("���� ���", Font.PLAIN, 14));
		label1.setBackground(Color.LIGHT_GRAY);
		label1.setBounds(40, 1, 90, 24);
		M_panel1.add(label1);		
	}
	
	//�̹��� ũ�� ��ȯ �Լ�
	public static ImageIcon imageSetSize(ImageIcon icon, int w, int h) {
		Image img=icon.getImage();	
		Image changedimg=img.getScaledInstance(w,h,Image.SCALE_DEFAULT);
		ImageIcon changedicon=new ImageIcon(changedimg);
		
		return changedicon;
	}
	
//	public void removePanel(JPanel panel) {
//		panel.removeAll();
//		panel.revalidate();
//		panel.repaint();
//	}
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
	 * Initialize the contents of the .
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("image/letter-z.png"));
		frame.setTitle("ZOAS Note");
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 760, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(mainCard);
		
		setPanel();
		setBtn();
		setLabel();

	}
	
}

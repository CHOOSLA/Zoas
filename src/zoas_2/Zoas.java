package zoas_2;
/*
 * 
 * */


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

class ManuPanelListener implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
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
    
}


public class Zoas extends JFrame  {
	static public String noteName="";
	static public String noteCreateDate="";
	static public String noteEditDate="";
	DateTimeFormatter datetimeformat = DateTimeFormatter.ofPattern("yyyy-MM-dd a h�� mm��");
	
	private JFrame frame;
	static public CardLayout card=new CardLayout();
	
	JPanel Manu_panel = new JPanel();
	JPanel Allnote_panel = new JPanel();
	static public JPanel left_panel = new JPanel();
	Home Home_panel= new Home();	// �ֱ� ��Ʈ �г�
	Newnote Newnote_panel = new Newnote();	// �� ��Ʈ �г�
	Record Record_panel = new Record();	// ��� �г�
	
	JButton newNoteBtn = new JButton("�� ��Ʈ �����");
	JButton zoasBtn = new JButton("ZOAS");	//Ȩ �̵� ��ư
	
	JLabel label1 = new JLabel("��ü ��Ʈ");	
	JLabel label1_Icon = new JLabel("",JLabel.CENTER);
	
	ImageIcon allnoteicon= new ImageIcon("image/allnote.png");
	
	ImageIcon imageSetSize(ImageIcon icon, int w, int h) {
		Image img=icon.getImage();	
		Image changedimg=img.getScaledInstance(w,h,Image.SCALE_DEFAULT);
		ImageIcon changedicon=new ImageIcon(changedimg);
		
		return changedicon;
	}
	
	public void setPanel() {
		//�޴� �г�
		Manu_panel.setBackground(Color.LIGHT_GRAY);
		Manu_panel.setBounds(0, 0, 144, 411);
		frame.getContentPane().add(Manu_panel);
		Manu_panel.setLayout(null);
	
		//��ü��Ʈ �г�
		Allnote_panel.addMouseListener(new ManuPanelListener());
		Allnote_panel.setBackground(Color.LIGHT_GRAY);
		Allnote_panel.setLayout(null);
		Allnote_panel.setBounds(0, 121, 144, 27);
		Manu_panel.add(Allnote_panel);
		
		//���� �г�(��Ʈ ���̴� ��)
		left_panel.setBackground(Color.WHITE);
		left_panel.setBounds(144, 0, 600, 411);
		frame.getContentPane().add(left_panel);
		left_panel.setLayout(card);
		//card layout�� ���� ����
		left_panel.add("Home",Home_panel);
		left_panel.add("NewNote",Newnote_panel);
		left_panel.add("Record",Record_panel);
		card.show(left_panel, "NoteList");	//�⺻���� ���̴� ī��
	}
	
	public void setBtn() {
		//�� ��Ʈ ����� ��ư ����
		newNoteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDateTime time =LocalDateTime.now();		
				String DateTime =  datetimeformat.format(time);
				noteName="����Ʈ";
				noteCreateDate=DateTime;	//���� ��¥ ���ؼ� �ִ°ɷ� �����ؾ���;
				Newnote_panel.set();
				Record_panel.set();
				card.show(left_panel, "NewNote");
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
				card.show(left_panel, "Home");
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
				
		//���� �����ϱ� ��ư
		Newnote_panel.ZoomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Record_panel.set();
				card.show(Zoas.left_panel, "Record");
			}
		});
		
	}

	public void setLabel() {
		//��Ʈ ������ 
		allnoteicon=imageSetSize(allnoteicon, 19, 19);
		label1_Icon.setIcon(allnoteicon);
		label1_Icon.setBounds(17, 5, 19, 19);
		Allnote_panel.add(label1_Icon);
		
		//'��ü��Ʈ'
		label1.setFont(new Font("���� ���", Font.PLAIN, 14));
		label1.setBackground(Color.LIGHT_GRAY);
		label1.setBounds(43, 1, 90, 24);
		Allnote_panel.add(label1);

				
	}
	
	public void removePanel(JPanel panel) {
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
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
		frame.getContentPane().setLayout(null);
		
		setPanel();
		setBtn();
		setLabel();

	}
	
}

package zoas_5;
/*�߰��� �͵�
 * 1. ���� �����ϱ� ��ư ������ �� ������ �ؾ��ϴµ�  json ����� �� �ٿ��� ������ ���������
 * 2. ������ â ����
 * 3. ��Ʈ�� ������ ������ ���� ���̵�(���� ��ȣ,��Ʈ�̸�...?)�� ������ text������ �޴´�. �̰� �޾Ƽ� ��Ʈ�� �Է������ ��
 * 		�ؽ�Ʈ ���� �д°� ã�ƺ�����
 * 4. ��Ʈ �����ð� ,�����ð��� ������ ����Ǵ°� �ƴϹǷλ���Ʈ �����ÿ� �� �����صξ���ҵ�?�ƴϸ� DB�� ������ �� �ֳ�??*/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import zoas_5.DataClass.JsonConverter;
import zoas_5.DataClass.NoteInfo;
import zoas_5.DataClass.User;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;


public class Zoas extends JFrame  {
	static HttpUtil httpUtil =new HttpUtil();
	static public User user=new User();
	static public NoteInfo noteinfo=new NoteInfo();
	static public JsonConverter json =new JsonConverter();
	
	static public JFrame frame=new JFrame();;
	static CardLayout mainCard=new CardLayout();
	static CardLayout laftCard=new CardLayout();
	
	JPanel Main_panel = new JPanel();	//Ȩȭ��(�ֱٳ�Ʈ)
	Login Login_p= new Login();	
	JPanel Manu_p = new JPanel();
	JPanel M_panel1 = new JPanel();	//�޴��� ���� ��ư
	
	static public JPanel left_panel = new JPanel();
	static Home Home_p= new Home();	// �ֱ� ��Ʈ �г�
	static Newnote Newnote_p = new Newnote();	// �� ��Ʈ �г�
	static Record Record_p = new Record();	// ��� �г�
	static Allnote Allnote_p=new Allnote();	// ��ü ��Ʈ �г�
	static NoteForm noteform_p=new NoteForm();	// ��Ʈ �⺻ ���(?)
	
	JButton newNoteBtn = new JButton("�� ��Ʈ �����");
	JButton zoasBtn = new JButton("ZOAS");	//Ȩ �̵� ��ư
	
	JLabel label1 = new JLabel("��ü ��Ʈ");	
	JLabel label1_Icon = new JLabel("",JLabel.CENTER);
	
	ImageIcon allnoteicon= new ImageIcon("image/note.png");
	
	
	public void setPanel() {
		//�����г�
		Main_panel.setBounds(0, 0, 984, 611);
		Main_panel.setLayout(null);
		Main_panel.setBackground(Color.WHITE);
		
		//���� �޴� �г�
		Manu_p.setBackground(SystemColor.activeCaption);
		Manu_p.setBounds(0, 0, 144, 611);
		Main_panel.add(Manu_p);
		Manu_p.setLayout(null);
	
		//�޴��� ��ü��Ʈ(��ưó�� ���)
		M_panel1.addMouseListener(new MouseListener() {
			@Override//���콺 ���� ��
		    public void mouseClicked(MouseEvent e) {
				String strUrl="http://zoas.sch.ac.kr:8000/zoas-api/participation/";
				String jsonStr= Zoas.json.particiJsonstr(user);
				String responseString=Zoas.httpUtil.postRequest(strUrl,jsonStr);
				
//				JsonElement element = JsonParser.parseString(responseString);
//				Zoas.user.setkey(element.getAsJsonObject().get("key").getAsString());
				
				Allnote_p.noteupdate();	//��Ʈ ����Ʈ ������Ʈ
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
		    	p.setBackground(SystemColor.activeCaption);
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
		M_panel1.setBackground(SystemColor.activeCaption);
		M_panel1.setLayout(null);
		M_panel1.setBounds(0, 135, 144, 27);
		Manu_p.add(M_panel1);
		
		//���� �г�(��Ʈ ���̴� ��)
		left_panel.setBackground(Color.WHITE);
		left_panel.setBounds(144, 0, 840, 611);
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
		left_panel.add("NoteForm",noteform_p);
		laftCard.show(left_panel, "Home");
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
		newNoteBtn.setBounds(16, 80, 116, 36);
		newNoteBtn.setFont(new Font("���� ��� Semilight", Font.PLAIN, 12));
		newNoteBtn.setBackground(Color.WHITE);
		newNoteBtn.setBorderPainted(false); // ��ư �׵θ� ��������
		newNoteBtn.setFocusPainted(false);	// ��ư ��Ŀ�� ��������
		Manu_p.add(newNoteBtn);
		
		//ZOAS ��ư ����
		zoasBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_p.noteupdate();
				laftCard.show(left_panel, "Home");
			}
		});
		zoasBtn.setForeground(Color.WHITE);
		zoasBtn.setFont(new Font("�޸յձ�������", Font.BOLD, 25));
		zoasBtn.setBackground(Color.LIGHT_GRAY);
		zoasBtn.setBounds(7, 20, 128, 50);
		zoasBtn.setBorderPainted(false); // ��ư �׵θ� ��������
		zoasBtn.setContentAreaFilled(false);	// ��ư ä��� ��������
		zoasBtn.setFocusPainted(false);	// ��ư ��Ŀ�� ��������
		Manu_p.add(zoasBtn);
				
		//���� �����ϱ� ��ư
		Newnote_p.ZoomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�� �����ϱ� â ��
				zoomConnect zoom=new zoomConnect();
				zoom.main(null);
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
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("image/letter-z.png"));
		frame.setTitle("ZOAS Note");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1000, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(mainCard);
		frame.setLocationRelativeTo(null);
		
		setPanel();
		setBtn();
		setLabel();

	}
}

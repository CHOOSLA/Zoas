package zoas_5;
/*추가할 것들
 * 1. 강의 연결하기 버튼 누르면 줌 연결을 해야하는데  json 헤더에 뭘 붙여서 서버에 보내줘야함
 * 2. 동영상 창 연결
 * 3. 노트를 누르면 서버에 강의 아이디(강의 번호,노트이름...?)를 보내서 text파일을 받는다. 이걸 받아서 노트에 입력해줘야 함
 * 		텍스트 파일 읽는거 찾아봐야함
 * 4. 노트 생성시간 ,수정시간은 서버에 저장되는게 아니므로새노트 생성시에 잘 저장해두어야할듯?아니면 DB에 저장할 수 있나??*/

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
	
	JPanel Main_panel = new JPanel();	//홈화면(최근노트)
	Login Login_p= new Login();	
	JPanel Manu_p = new JPanel();
	JPanel M_panel1 = new JPanel();	//메뉴에 붙은 버튼
	
	static public JPanel left_panel = new JPanel();
	static Home Home_p= new Home();	// 최근 노트 패널
	static Newnote Newnote_p = new Newnote();	// 새 노트 패널
	static Record Record_p = new Record();	// 기록 패널
	static Allnote Allnote_p=new Allnote();	// 전체 노트 패널
	static NoteForm noteform_p=new NoteForm();	// 노트 기본 배경(?)
	
	JButton newNoteBtn = new JButton("새 노트 만들기");
	JButton zoasBtn = new JButton("ZOAS");	//홈 이동 버튼
	
	JLabel label1 = new JLabel("전체 노트");	
	JLabel label1_Icon = new JLabel("",JLabel.CENTER);
	
	ImageIcon allnoteicon= new ImageIcon("image/note.png");
	
	
	public void setPanel() {
		//메인패널
		Main_panel.setBounds(0, 0, 984, 611);
		Main_panel.setLayout(null);
		Main_panel.setBackground(Color.WHITE);
		
		//왼쪽 메뉴 패널
		Manu_p.setBackground(SystemColor.activeCaption);
		Manu_p.setBounds(0, 0, 144, 611);
		Main_panel.add(Manu_p);
		Manu_p.setLayout(null);
	
		//메뉴의 전체노트(버튼처럼 사용)
		M_panel1.addMouseListener(new MouseListener() {
			@Override//마우스 누를 때
		    public void mouseClicked(MouseEvent e) {
				String strUrl="http://zoas.sch.ac.kr:8000/zoas-api/participation/";
				String jsonStr= Zoas.json.particiJsonstr(user);
				String responseString=Zoas.httpUtil.postRequest(strUrl,jsonStr);
				
//				JsonElement element = JsonParser.parseString(responseString);
//				Zoas.user.setkey(element.getAsJsonObject().get("key").getAsString());
				
				Allnote_p.noteupdate();	//노트 리스트 업데이트
				laftCard.show(left_panel, "AllNote");
		    }
			@Override//마우스가 버튼 안으로 들어오면
		    public void mouseEntered(MouseEvent e) {
		    	JPanel p = (JPanel)e.getSource();
		        p.setBackground(Color.WHITE);
		    }

		    @Override//마우스가 버튼 밖으로 나가면 
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
		
		//왼쪽 패널(노트 보이는 곳)
		left_panel.setBackground(Color.WHITE);
		left_panel.setBounds(144, 0, 840, 611);
		Main_panel.add(left_panel);
		left_panel.setLayout(laftCard);
		
			//card layout을 위한 설정
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
		//새 노트 만들기 버튼 설정
		newNoteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//화면 전환하기 전에 초기화
				Newnote_p.set();	
				laftCard.show(left_panel, "NewNote");
			}
		});
		newNoteBtn.setBounds(16, 80, 116, 36);
		newNoteBtn.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		newNoteBtn.setBackground(Color.WHITE);
		newNoteBtn.setBorderPainted(false); // 버튼 테두리 설정해제
		newNoteBtn.setFocusPainted(false);	// 버튼 포커스 설정해제
		Manu_p.add(newNoteBtn);
		
		//ZOAS 버튼 설정
		zoasBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_p.noteupdate();
				laftCard.show(left_panel, "Home");
			}
		});
		zoasBtn.setForeground(Color.WHITE);
		zoasBtn.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 25));
		zoasBtn.setBackground(Color.LIGHT_GRAY);
		zoasBtn.setBounds(7, 20, 128, 50);
		zoasBtn.setBorderPainted(false); // 버튼 테두리 설정해제
		zoasBtn.setContentAreaFilled(false);	// 버튼 채우기 설정해제
		zoasBtn.setFocusPainted(false);	// 버튼 포커스 설정해제
		Manu_p.add(zoasBtn);
				
		//강의 연결하기 버튼
		Newnote_p.ZoomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//줌 연결하기 창 뜸
				zoomConnect zoom=new zoomConnect();
				zoom.main(null);
			}
		});
		
	}
	
	public void setLabel() {
		//노트 아이콘 
		allnoteicon=imageSetSize(allnoteicon, 15, 15);
		label1_Icon.setIcon(allnoteicon);
		label1_Icon.setBounds(17, 4, 19, 19);
		M_panel1.add(label1_Icon);
		
		//'전체노트'
		label1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		label1.setBackground(Color.LIGHT_GRAY);
		label1.setBounds(40, 1, 90, 24);
		M_panel1.add(label1);		
	}
	
	//이미지 크기 변환 함수
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

package zoas_5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class zoomConnect {
	private String streamUrl="rtmp://zoas.sch.ac.kr:1935/live";
	private String pageUrl="https://jgtLjjljr.kkIZLoLe-0vaWsg078YX79oOSyf0G";
	
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					zoomConnect window = new zoomConnect();
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
	public zoomConnect() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		textField = new JTextField();
		textField.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		textField.setBounds(137, 104, 150, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(11);
		
		
		JButton btnNewButton = new JButton("연결하기");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Zoas.user.setclassid(textField.getText());	//회의 아이디 저장
				int ResponseCode1 = 0,ResponseCode2=0;
				//update a livestream
				String livestreamurl="https://api.zoom.us/v2/meetings/"+Zoas.user.getclassid()+"/livestream";
				String jsonStr=Zoas.json.zoomliveJsonStr(Zoas.user.getclassid(),streamUrl,pageUrl);
				System.out.println(jsonStr);
				try {
					ResponseCode1=Zoas.httpUtil.patchRequest(livestreamurl,jsonStr);
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//update a livestreamstatus
				String livestatus="https://api.zoom.us/v2/meetings/"+Zoas.user.getclassid()+"/livestream/status";
				String jsonStr2=Zoas.json.zoomlivestatusJsonStr();
				System.out.println(jsonStr2);
				try {
					ResponseCode2=Zoas.httpUtil.patchRequest(livestatus,jsonStr2);
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(ResponseCode1==204 && ResponseCode2==204) {
					String joinUrl="https://api.zoom.us/v2/meetings/"+Zoas.user.getclassid()+"/livestream/status";
					String jsonStr3=Zoas.json.joinJsonstr(Zoas.user);
					String ResponseCode3 =Zoas.httpUtil.postRequest(joinUrl,jsonStr3);
						
					//동영상 창 띄우는 부분
					String url = "http://zoas.sch.ac.kr:80/hls/"+Zoas.user.getclassid()+"/index.m3u8";
					String vlc = "C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe";
					try {
						ProcessBuilder pb = new ProcessBuilder(vlc,url,"--effect-width=900", "--effect-height=600");
						Process p = pb.start();
					} catch (Exception ee){ee.printStackTrace();}

				}
				
				
			}
		});
		btnNewButton.setBounds(147, 159, 125, 42);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC758 \uC544\uC774\uB514(11\uC790)");
		lblNewLabel.setBounds(164, 79, 103, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ZOOM\uC5D0 \uC5F0\uACB0\uD558\uAE30...");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		lblNewLabel_1.setBounds(137, 21, 155, 29);
		frame.getContentPane().add(lblNewLabel_1);
	}
}

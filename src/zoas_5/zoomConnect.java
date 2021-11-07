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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(172, 66, 116, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("연결하기");
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
//					VedioGui s=new VedioGui();
//					s.main(null);
					//Zoas.Record_p.set();
					//Zoas.laftCard.show(Zoas.left_panel, "NoteForm");
					HelloController.seekSentance = "";

					Thread t = new Thread(new Runnable() {
						@Override
						public void run() {
							HelloApplication yes = new HelloApplication();
							yes.openMediaPlayer("http://zoas.sch.ac.kr:80/hls/95384878370/index.m3u8"); // 계속 실행됨
						}
					});

					t.start();

					System.out.println("이것마진?");
				}
				
				
			}
		});
		btnNewButton.setBounds(171, 174, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC758 \uC544\uC774\uB514");
		lblNewLabel.setBounds(103, 69, 64, 15);
		frame.getContentPane().add(lblNewLabel);
	}
}

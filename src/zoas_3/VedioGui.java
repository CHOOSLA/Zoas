package zoas_3;
/*
 * JMF : 기존 자바 프로그래밍 중에서 멀티미디어 제어 관련 API(Application Programming Interface) 및 SDK(Software Development Kit)를 보강한 프로그래밍 인터페이스 혹은 패키지. 
 * 		오디오, 비디오와 같은 time-based media를 모두 다룰 수 있으며 비디오, 오디오의 캡처, 저장, 전송, 스트리밍 등을 처리할 수 있다.
 * OpenCV : 실시간 이미지 프로세싱에 중점을 둔 라이브러리.
 * */
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;

public class VedioGui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VedioGui window = new VedioGui();
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
	public VedioGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC601\uC0C1\uB098\uC624\uB294\uC911");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		lblNewLabel.setBounds(161, 118, 102, 15);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

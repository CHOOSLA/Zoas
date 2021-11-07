package zoas_4;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.DocumentListener;

import zoas_4.DataClass.NoteInfo;

import javax.swing.event.DocumentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Newnote extends JPanel {
	DateTimeFormatter datetimeformat = DateTimeFormatter.ofPattern("yyyy-MM-dd a h시 mm분");
	static public NoteInfo noteinfo;
	
	JPanel linepanel_1 = new JPanel();
	JButton ZoomBtn = new JButton("강의 연결하기");
	
	JLabel noteDateLabel = new JLabel();
	
	JTextField noteNameField = new JTextField(){
		 @Override public void setBorder(Border border) {
		        // 텍스트필드 외곽선 제거
		    }
	};
	public void note_init() {
		noteinfo=new NoteInfo();
		LocalDateTime time =LocalDateTime.now();		
		String DateTime = datetimeformat.format(time);
		noteinfo.setName("새노트");	//기본 이름
		noteinfo.setCreatDate(DateTime);	//생성 날짜
		noteinfo.setEditDate(DateTime);	//수정 날짜
		noteinfo.setRecordText(" ");	//음성 기록
		noteinfo.setSummaryText(" ");	//요약
	}
	public void set() {
		note_init();
		noteNameField.setText(noteinfo.getName());
		noteDateLabel.setText(noteinfo.getCreatDate());	
	}
	/**
	 * Create the panel.
	 */
	public Newnote() {
		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(144, 0, 600, 411);
		
		//가로선을 위한 패널(이미지로 바꿔도 될듯...?)
		linepanel_1.setBackground(Color.LIGHT_GRAY);
		linepanel_1.setBounds(15, 71, 565, 2);
		add(linepanel_1);
		
		//강의 연결하기 버튼
		ZoomBtn.setForeground(Color.WHITE);
		ZoomBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		ZoomBtn.setBorderPainted(false);
		ZoomBtn.setBackground(SystemColor.textHighlight);
		ZoomBtn.setBounds(210, 135, 150, 60);
		add(ZoomBtn);
		
		//노트 이름 
		noteNameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				JTextField textField = (JTextField)e.getSource();
				noteinfo.setName(textField.getText());
				noteNameField.setText(noteinfo.getName());
			}
		});
		noteNameField.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		noteNameField.setBounds(20, 23, 200, 22);
		add(noteNameField);
		noteNameField.setColumns(10);
				
		//날짜
		noteDateLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		noteDateLabel.setBounds(20, 43, 150, 15);
		add(noteDateLabel);
		
	}
	
	

}

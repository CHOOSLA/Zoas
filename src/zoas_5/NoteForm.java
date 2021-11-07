package zoas_5;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;

import zoas_5.DataClass.NoteInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//노트를 열면 뜨는 창 서버에서 텍스트를 불러옴
public class NoteForm extends JPanel {
	NoteInfo noteinfo;
	ArrayList<NoteInfo> notelist;
	ArrayList<String> keyword= new ArrayList<>();	//요약 키워드 저장	
	textHighlighter highlighter =new textHighlighter();

	JPanel linepanel_w = new JPanel();
	JPanel linepanel_h = new JPanel();
	
	JLabel lblNewLabel_3 = new JLabel("음성 기록");
	JLabel lblNewLabel_4 = new JLabel("요약");
	JLabel noteDateLabel = new JLabel();
	
	JTextField noteNameField = new JTextField(){
		 @Override public void setBorder(Border border) {
		        // 텍스트필드 외곽선 제거
		    }
	};
	
	JTextPane recordtextPane = new JTextPane();
	JTextPane summaryTextPane = new JTextPane();
	ImageIcon icon= new ImageIcon("");
	JLabel lblNewLabel = new JLabel("");
	
	public void set(){

		
	}
	/**
	 * Create the panel.
	 */
	public NoteForm() {
		setBackground(Color.WHITE);
		setBounds(144, 0, 840, 611);
		setLayout(null);
		setVisible(false);
		
		//노트 이름 
		noteNameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
//				int index=notelist.indexOf(noteinfo);
//				JTextField textField = (JTextField)e.getSource();
//				noteinfo.setName(textField.getText());
//				noteNameField.setText(noteinfo.getName());
//				
//				notelist.set(index,noteinfo);
//				Zoas.json.createJsonData(Zoas.user);				
				
			}
		});	
		noteNameField.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		noteNameField.setBounds(14, 25, 200, 22);
		add(noteNameField);
		noteNameField.setColumns(10);
				
		//날짜
		noteDateLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		noteDateLabel.setBounds(14, 46, 150, 15);
		add(noteDateLabel);
			
		//가로선을 위한 패널(이미지로 바꿔도 될듯...?)
		linepanel_w.setBackground(Color.LIGHT_GRAY);
		linepanel_w.setBounds(12, 71, 815, 2);
		add(linepanel_w);
		
		//세로선을 위한 패널(이미지로 바꿔도 될듯...?)
		linepanel_h.setBackground(Color.LIGHT_GRAY);
		linepanel_h.setBounds(458, 72, 2, 600);
		add(linepanel_h);
		
		//'음성 기록'
		lblNewLabel_3.setBounds(15, 79, 67, 15);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(lblNewLabel_3);
		
		//'요약'
		lblNewLabel_4.setBounds(470, 77, 45, 15);
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(lblNewLabel_4);
		
		//기록
		recordtextPane.setText("이 문서는 아직 요약하지 않은 문서이다. 이제부터 요약을 해보자! 어떤 문장을 요약할지는 내 맘이다. 배고프다.");
		recordtextPane.setBounds(15, 102, 435, 499);
		add(recordtextPane);
		
		//요약
		summaryTextPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String s=summaryTextPane.getSelectedText();	//TextArea상의 선택부분 텍스트를 얻어옴
				if(s!=null) {	
					keyword.add(s);
					highlighter.highlightKeyword(recordtextPane,keyword);
					System.out.println(s);
					keyword.remove(s);
					
				}
			}
		});
		summaryTextPane.setText("이제부터 요약을 해보자! 배고프다.");
		summaryTextPane.setBounds(470, 310, 356, 290);
		add(summaryTextPane);
		
		keyword.add("요약");
		keyword.add("배고프다");
		highlighter.highlightKeyword(recordtextPane,keyword);
		
		//요약 사진 넣을 레이블
		lblNewLabel.setBounds(468, 102, 200, 200);
		icon=Zoas.imageSetSize(icon, 49, 49);
		lblNewLabel.setIcon(icon);
		add(lblNewLabel);
		
	}
}

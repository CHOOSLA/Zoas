package zoas_5;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;

import zoas_5.DataClass.NoteInfo;
import zoas_5.DataClass.stringTokenize;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;

//노트를 열면 뜨는 창 서버에서 텍스트를 불러옴
public class NoteForm extends JPanel {
	NoteInfo noteinfo;
	ArrayList<NoteInfo> notelist;
	ArrayList<String> keywordList= new ArrayList<>();	//요약 키워드 저장
	ArrayList<String> timestampList = new ArrayList<>(); // 타임 스템프 저장
	ArrayList<String> recordTextList = new ArrayList<>(); // 레코드된 것 저장

	ArrayList<ArrayList<String>> tokenListOfrecordTextList = new ArrayList<>(); // 엔터별로 분리된 문장을 또 스페이스별로 나눔
	// seekTimeFromRecord 메소드의 연산 속도를 향상 하기 위해 미리 준비해 놓는 것

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
	JScrollPane scrollPane = new JScrollPane(recordtextPane);
	JTextPane summaryTextPane = new JTextPane();
	JScrollPane scrollPane_1 = new JScrollPane(summaryTextPane);
	JLabel lblNewLabel = new JLabel("");
	Runnable doScroll = new Runnable() {
		   public void run() {
				scrollPane.getVerticalScrollBar().setValue(0);
				scrollPane_1.getVerticalScrollBar().setValue(0);

		   }
	};
	
	public void set(){
		notelist=Zoas.user.getNoteList();
		noteinfo=notelist.remove(0);
		
		noteNameField.setText(noteinfo.getclass_id());
		recordtextPane.setText(noteinfo.getstt());
		summaryTextPane.setText(noteinfo.getsummary());
		stringTokenize tokenize= new stringTokenize();
		tokenize.main(noteinfo.getkeywords(), keywordList,"\n"); // 받아온 키워드 \n 기준으로 분리
		tokenize.main(noteinfo.gettimestamps(),timestampList,"\n");
		tokenize.main(noteinfo.getstt(),recordTextList,"\n");

		for (String sent:recordTextList){
			ArrayList<String> tmp = new ArrayList<String>();
			tokenize.main(sent,tmp," ");
			tokenListOfrecordTextList.add(tmp);
		}

		highlighter.highlightKeyword(recordtextPane,keywordList); // 하이라이팅
		highlighter.highlightKeyword(summaryTextPane,keywordList);
		try {
			URL url = new URL("http://zoas.sch.ac.kr:8000/media/image/"+noteinfo.getclass_id()+".png");
			ImageIcon icon= new ImageIcon(url);
			icon=Zoas.imageSetSize(icon, 200, 200);
			lblNewLabel.setIcon(icon);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Zoas.user.getNoteList().clear();
		SwingUtilities.invokeLater(doScroll);
	}


	public double seekTimeFromRecord(String sentence){
		stringTokenize tokenize= new stringTokenize();
		ArrayList<String> tmp = new ArrayList<>(); // 띄어쓰기 기준으로 분리된 단어들
		tokenize.main(sentence,tmp," ");
		// 일단 중복 단어가 있을 경우
		// stt에서 그게 몇번 째 인가 count하고
		// 그 count를 가지고 timestamp에서도 몇 번째 인 것을 확인 한다.

		int count = 0;
		String firstWord = tmp.get(0);

		int test1 = 0;
		int test2 = 0;
		// 본문에서 해당 단어를 포함하는 문장들을 찾음
		for(ArrayList<String> sent : tokenListOfrecordTextList){
			test1++;
			for(String token: sent){
				test2++;
				if(token.equals(firstWord)){
					count++;
				}
			}
			test2 = 0;
		}
		for(String s : timestampList){
			String[] splited = s.split(",");
			firstWord = firstWord.trim();
			if(splited[0].equals(firstWord)){
				count--;

				if(count==0){
					return Double.parseDouble(splited[1]);
				}
			}
		}

		return -1;


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
		recordtextPane.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		//기록
		recordtextPane.setBounds(15, 102, 435, 499);
		//add(recordtextPane);
		
		//요약
		recordtextPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String s=recordtextPane.getSelectedText();	//TextArea상의 선택부분 텍스트를 얻어옴
				System.out.println(s);
				seekTimeFromRecord(s);

			}
	});
		summaryTextPane.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		summaryTextPane.setBounds(470, 310, 356, 290);
		//add(summaryTextPane);
		
		
		//요약 사진 넣을 레이블
		lblNewLabel.setBounds(468, 102, 200, 200);
		add(lblNewLabel);
		
		
		scrollPane.setBounds(15, 102, 435, 499);
		add(scrollPane);
		
		scrollPane_1.setBounds(470, 310, 356, 290);
		add(scrollPane_1);

		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Desktop desktop = Desktop.getDesktop();
				try {
					URI uri = new URI("http://zoas.sch.ac.kr:8000/media/image/"+noteinfo.getclass_id()+".png");
					desktop.browse(uri);
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (URISyntaxException ex) {
					ex.printStackTrace();
				}
			}
		});
		
	}
}

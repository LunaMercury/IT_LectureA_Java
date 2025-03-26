package Ch37_MVC_Add_View_Socket_Thread.View.GUI.USER;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Ch37_MVC_Add_View_Socket_Thread.Socket.Type.Request;
import Ch37_MVC_Add_View_Socket_Thread.View.GUI.MainGUI;

public class UserUI  extends JFrame implements ActionListener{

	
	JButton 도서조회_btn;
	JButton 대여확인_btn;
	JButton 나의정보_btn;
	JButton 로그아웃_btn;

	MainGUI mainGUI;
	
	public UserUI(){
		super("USER UI");
		setBounds(10, 10, 250, 130);

		// 패널
		JPanel panel = new JPanel();
		panel.setLayout(null);

		
		// 
		도서조회_btn = new JButton("도서조회");
		대여확인_btn = new JButton("대여확인");
		나의정보_btn = new JButton("나의정보");
		로그아웃_btn = new JButton("로그아웃");
		
		//
		도서조회_btn.setBounds(10,10,100,30);
		대여확인_btn.setBounds(120,10,100,30);
		나의정보_btn.setBounds(10,50,100,30);
		로그아웃_btn.setBounds(120,50,100,30);

		
		//
		도서조회_btn.addActionListener(this);
		대여확인_btn.addActionListener(this);
		나의정보_btn.addActionListener(this);
		로그아웃_btn.addActionListener(this);
		
		//
		panel.add(도서조회_btn);
		panel.add(대여확인_btn);
		panel.add(나의정보_btn);
		panel.add(로그아웃_btn);
		
		
		
		add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(false);
		
		
		//x버튼에 대한 이벤트 처리
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	// 로그아웃 처리
            	// 메인 창 활성화
            	mainGUI.setVisible(true);
            }
        });
		
		
	}
	

	public void setMainUI(MainGUI mainGUI) {
		this.mainGUI = mainGUI;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		
		if(e.getSource()==로그아웃_btn) {
			Integer sessionId = mainGUI.mySessionId;
			Request request = new Request();
			Map<String,Object> body = new HashMap();
			body.put("uri", "/user");
			body.put("serviceNo", 7);	//Logout
			
			Map<String,Object> params = new HashMap();
			params.put("sessionId", sessionId);
			body.put("params", params);
			
			request.setBody(body);
			
			
			Map<String,Object> response = null;
			
			try {			
				mainGUI.clientBackground.requestServer(request);
				Thread.sleep(3000);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			response = mainGUI.clientBackground.receiveBody;
			
			if(response!=null) {
			
				System.out.println("UserUI logout's response : " + response);
			
				boolean isLogout =(boolean) response.get("response");
				String message = (String)response.get("msg");
				if(isLogout) {
					
					
					//로그아웃이후  sessionid 초기화
					mainGUI.mySessionId = 0;
					mainGUI.myRole=null;
					this.setVisible(false);
					mainGUI.setVisible(true);
					JOptionPane.showMessageDialog(null, message);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, message);
				}
				

			}
		}
		
		
	}
	
	
}

package Ch37_MVC_Add_View_Socket_Thread.View.GUI.AUTH;

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
import javax.swing.JTextField;

import Ch37_MVC_Add_View_Socket_Thread.Socket.ClientBackground;
import Ch37_MVC_Add_View_Socket_Thread.Socket.Type.Request;
import Ch37_MVC_Add_View_Socket_Thread.View.GUI.MainGUI;
import Ch37_MVC_Add_View_Socket_Thread.View.GUI.MEMBER.MemberUI;
import Ch37_MVC_Add_View_Socket_Thread.View.GUI.USER.UserUI;

public class LoginUI extends JFrame implements ActionListener{

	JTextField id_txt;
	JTextField pw_txt;
	JButton login_btn;
	
	//
	MainGUI mainGUI;
	MemberUI membergui;
	UserUI usergui;
	
	//
	ClientBackground clientBackground;
	
	public LoginUI(){
		super("MAIN MENU");
		setBounds(10, 10, 300, 150);

		// 패널
		JPanel panel = new JPanel();
		panel.setLayout(null);

		
		//
		id_txt = new JTextField();
		pw_txt = new JTextField();
		login_btn = new JButton("로그인");
		
		//
		id_txt.setBounds(10,10,150,30);
		pw_txt.setBounds(10,50,150,30);
		login_btn.setBounds(170,10,100,70);
		
		//EVENT
		login_btn.addActionListener(this);
		
		// 컴포넌트를 패널에 추가
		panel.add(id_txt);
		panel.add(pw_txt);
		panel.add(login_btn);
		 
		
		add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		
		membergui = new MemberUI();
		membergui.setMainUI(mainGUI);
		
		usergui = new UserUI();
		usergui.setMainUI(mainGUI);
		

		
		//X 버튼 이벤트 처리
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { 	
            	mainGUI.setVisible(true);
            }
        });
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login_btn) {
			System.out.println("LOGIN_BTN");
			
			//로그인 체크		
			Request request = new Request();
			Map<String,Object> body = new HashMap();
			body.put("uri","/user");
			body.put("serviceNo", 6);	//로그인 요청
			Map<String,Object> params = new HashMap();
			params.put("username", id_txt.getText());
			params.put("password", pw_txt.getText());
			params.put("sessionId", mainGUI.mySessionId);
			body.put("params", params);
			request.setBody(body);
	
			try {
				clientBackground.requestServer(request);
				Thread.sleep(3000);
			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Map<String,Object>response = null;
			response =  clientBackground.receiveBody;
			System.out.println("LoginUI response : " + response);
			if(response!=null) {
				
				boolean isLogined =  (Boolean)response.get("response");
				if(isLogined) {
					
					Integer sessionId = (Integer)response.get("sessionId");
					String role = (String)response.get("role");
					
					System.out.println("LoginUI SESSIONID : " + sessionId);
					mainGUI.mySessionId = sessionId;
					mainGUI.myRole = role;
					
					String message = (String)response.get("msg");
					JOptionPane.showMessageDialog(null, message);
					
					
					//역할별로 UI창 띄우기(ROLE_USER)
					if(mainGUI.myRole.equals("ROLE_USER")) {
						this.setVisible(false);
						usergui.setVisible(true);	
					}else if(mainGUI.myRole.equals("ROLE_MEMBER")) {
						this.setVisible(false);
						membergui.setVisible(true);					
					}
					
					
					
					
					
				}else {
					
					System.out.println("로그인 실패");
					String message = (String)response.get("msg");
					JOptionPane.showMessageDialog(null, "로그인실패 : " + message);
				}
		
			}

			
			
			
			
			
			
			//회원사서인지 판단해서 창띄우기
//			if(id_txt.getText().equals("1"))
//			{
//				this.setVisible(false);
//				membergui.setVisible(true);
//			}
//			else if(id_txt.getText().equals("2"))
//			{
//				this.setVisible(false);
//				usergui.setVisible(true);
//			}
			 
			
		}
		
	}
	
	//
	public void setMainUI(MainGUI mainGUI) {
		this.mainGUI = mainGUI;
		membergui.setMainUI(mainGUI);
		usergui.setMainUI(mainGUI);
	}

	public void setMVCClient(ClientBackground mvcClient) {
		this.clientBackground = mvcClient;
	}
	
	
}

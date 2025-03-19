package Ch26;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.swing.*;



import java.net.*;
public class ServerUI extends JFrame implements ActionListener{
	
	JTextArea area;
	JTextField txt;
	
	ServerBackground background;
	 
	TextField total;
	JButton btn;
	ServerUI(){
		super("Chat Server");
		
		//패널
		JPanel pan = new JPanel();
		pan.setLayout(null);
		
		//컴포넌트
		area = new JTextArea();
		txt = new JTextField();
		JScrollPane scroll = new JScrollPane(area);
		scroll.setBounds(10,10,550,550);
		//txt.setBounds(10,320,260,30);
		total = new TextField();
		total.setBounds(690,10,80,30);
		
		btn= new JButton("인원확인");
		btn.setBounds(580,10,100,30);
		
		
		//이벤트 추가
		btn.addActionListener(this);
	
		//패널에 추가
		pan.add(txt);
		pan.add(scroll);
		pan.add(btn);
		pan.add(total);
		//프레임에 추가
		add(pan);
		
		
		this.setBounds(100,100,800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		background = new ServerBackground(this);
		
	
	}
	
	



	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 클릭!");
		if(e.getSource()==btn)		
		{
			//인원수 출력
			
			int total = background.ClientList.size();
			System.out.println("접속수 : " + total);
			String t = String.valueOf(total);
			this.total.setText(t+" 명");
			
		}
	}
	
	
	public static void main(String[] args) {
		new ServerUI().background.Setting();

		
	}
	
	
}

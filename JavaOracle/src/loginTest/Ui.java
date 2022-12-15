package loginTest;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Ui extends WindowAdapter implements ActionListener {
	private Frame f;
	private Panel p1;
	private Label lid, lpwd;
	private TextField tid, tpwd, msg;
	private Button b1;

	public Ui() {
		f = new Frame("Login");
		f.setSize(500, 100);

		p1 = new Panel();
		p1.setLayout(new FlowLayout());
		p1.setBackground(Color.ORANGE);

		lid = new Label("ID : ", Label.RIGHT);
		lpwd = new Label("Password : ", Label.RIGHT);

		tid = new TextField(10);
		tpwd = new TextField(10);
		tpwd.setEchoChar('*');
		msg = new TextField(20);

		b1 = new Button("Login");
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void startFrame() {
		f.addWindowListener(this);
		f.add(p1, "Center");
		f.add(msg, "South");
		f.add(b1, "East");
		p1.add(lid);
		p1.add(tid);
		p1.add(lpwd);
		p1.add(tpwd);
		b1.addActionListener(this);
		msg.setText("ID와 PASSWORD를 입력하세요..");

		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("click!");
		msg.setText("ID를 확인하세요..");
		System.out.println("id : " + tid.getText());
		System.out.println("pwd : " + tpwd.getText());

		String id = tid.getText();
		String pwd = tpwd.getText();

		System.out.println("id : " + id);
		System.out.println("pwd : " + pwd);

		LoginDAO dao = new LoginDAO();
		ArrayList<LoginVo> list = dao.list(id);

		for (int i = 0; i < list.size(); i++) {
			LoginVo data = (LoginVo) list.get(i);
			String mem_id = data.getMemId();
			String mem_pwd = data.getMemPwd();

			System.out.println("mem_id : " + mem_id + " / mem_pwd : " + mem_pwd);

			if (pwd.equals(mem_pwd)) {
				msg.setText("로그인 성공!!");
				System.out.println("로그인 성공!!");
			} else if (!(pwd.equals(mem_pwd))) {
				msg.setText("로그인 실패!!");
				System.out.println("로그인 실패!!");
			}
		}
	}

	public static void main(String[] args) {
		Ui u = new Ui();
		u.startFrame();
	}
}
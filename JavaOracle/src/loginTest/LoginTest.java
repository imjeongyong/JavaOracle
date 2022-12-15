package loginTest;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginTest {
	public static void main(String[] args) {
		System.out.print("Id와 Password를 입력하세요...");
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		String pwd = sc.next();

		System.out.println(id);
		System.out.println(pwd);
		sc.close();

		LoginDAO dao = new LoginDAO();
		ArrayList<LoginVo> list = dao.list(id);

		for (int i = 0; i < list.size(); i++) {
			LoginVo data = (LoginVo) list.get(i);
			String mem_id = data.getMemId();
			String mem_pwd = data.getMemPwd();

			System.out.println("mem_id : " + mem_id + " / mem_pwd : " + mem_pwd);

			if (pwd.equals(mem_pwd)) {
				System.out.println("로그인 성공!!");
			} else {
				System.out.println("로그인 실패!!");
			}
		}
	}
}
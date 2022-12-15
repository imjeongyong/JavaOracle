package loginTest;

public class LoginVo {
	private String mem_id;
	private String mem_pwd;
	private String noId;

	public LoginVo(String noId) {
		this.noId = noId;
	}

	public LoginVo(String mem_id, String mem_pwd) {
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
	}

	public String getMemId() {
		return mem_id;
	}

	public String getMemPwd() {
		return mem_pwd;
	}

	public String getnoId() {
		return noId;
	}
}
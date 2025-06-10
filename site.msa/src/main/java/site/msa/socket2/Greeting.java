package site.msa.socket2;

//소켓통신시 송,수신 역활을 하는 class
public class Greeting {
	private String content;
	
	public Greeting(String content) {	//setter (즉시실행)
		this.content = content;
	}
	public String getContent() {		//getter
		return this.content;
	}
	
}


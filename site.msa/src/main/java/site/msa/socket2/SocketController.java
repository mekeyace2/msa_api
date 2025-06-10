package site.msa.socket2;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

import jakarta.annotation.Resource;

//Socket 전용 컨트롤러
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SocketController {
	
	@Resource(name="chatDTO")
	chatDTO dto;
	
	
	@MessageMapping("/conchat")	//메세지를 받는 API
	@SendTo("/room/geetings")	//소켓 API 주소	(Front 연결하는 경로)
	public Greeting greeting(chatDTO cdto) throws Exception{
		Thread.sleep(1000);		//접속 지연 (서버 소켓 통신에 대한 지연 시간)
		
		//HtmlUtils.htmlEscape : 특수문자에 대한 escape 발생을 하므로 정상적인 코드로 적용되도록 함
		//&lt : < &gt : >  %20 : space 띄워쓰기
		String mname = HtmlUtils.htmlEscape(cdto.getName());
		String msg = HtmlUtils.htmlEscape(cdto.getMsg());
		System.out.println(mname);
		System.out.println(msg);
		
		//Front에게 결과값을 return 
		return new Greeting(mname + ":" + msg);
	}
	
}

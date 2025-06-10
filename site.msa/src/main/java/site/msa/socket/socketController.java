package site.msa.socket;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.annotation.Resource;

@Controller
public class socketController {

		@Resource(name="userDTO")
		userDTO dto;
	
		//ws : @SendTo, @MessageMapping 로 접속을 해야하는 어노테이션
		@SendTo("/chat/rooms/{roomId}")
		public ResponseEntity<List<websocketconfig>> roomin(@PathVariable Long roomid){
			this.dto.setUname("에이핑크");
			System.out.println(roomid);
			return null;		
		}
	
}

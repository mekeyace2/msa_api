package site.msa.socket;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.WebSocketSession;

//session으로 방을 생성하는 class 
public class chat_room {
	private Long id;	//session으로 id를 생성 (예 : 1234567712245)
	private String name;	//방 주소 URL 이름
	
	private final Set<WebSocketSession> sessions = new HashSet<>();
	
	public static chat_room create(String name) {
		chat_room room = new chat_room();
		room.id = roomgen.createId();
		room.name = name;
		return room;
	}
	//getter
	public Long id() {
		return id;
	}
	public Set<WebSocketSession> sessions(){
		return sessions;
	}
}

//외부 클래스로 방 고유 id를 생성하는 class
class roomgen{
	private static Long id = 0L;
	public static Long createId() {
			id += 1;
			return id;
	}
}


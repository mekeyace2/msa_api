package site.msa.socket;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

//소켓으로 접속한 client에 대한 메세지를 출력하는 역활도 하게됨
//TextWebSocketHandler : 문자로 메세지를 전송하는 형태
public class sockethand extends TextWebSocketHandler {
	
	@Autowired
	public roomrepo roomrepo;
	
	//ws로 접속시 해당 세션을 uri에 있는 마지막 번호에 맞는 원시뱅열로 생성하여 클래스 배열로 전환
	public Long getRoomid(WebSocketSession session) {
		String uri = Objects.requireNonNull(session.getUri().toString());
		System.out.println(uri);
		String parts[] = uri.split("/");
		//chat/rooms/1 => rooms1
		String roomId = parts[parts.length-1];
		return Long.parseLong(roomId);
	}
	//클라이언트가 접속된 상황에서 메세지를 출력
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Long roomId = getRoomid(session);
		roomrepo.room(roomId).sessions().add(session);
		System.out.println("새 클라이언트에 연결 되었습니다.");
	}
	
	//클라이언트 접속 종료시 해당 배열값에 내용을 삭제 하면서 해제 되도록 함
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		Long roomId = getRoomid(session);
		roomrepo.room(roomId).sessions().remove(session);
		System.out.println("클라이언트 연결 해제 되었습니다.");
	}
	//채팅방에 있는 사용자에게 메세지를 전달
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		Long roomId = getRoomid(session);
		chat_room room = roomrepo.room(roomId);
		for(WebSocketSession con : room.sessions()) {
			con.sendMessage(message);
		}
	} 
	
	
	
}

package site.msa.socket;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

//room을 생성하는 class이며, 접속 상황을 확인함

public class chathandshake implements HandshakeInterceptor {
	
	//클라이언트가 room으로 입장 후 상황
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		//room으로 입장 후 대화 내용을 Database에 저장 할 수 있음 (Nosql)
	}
	
	//클라이언트가 room으로 입장하기 전 상황
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
				Map<String, Object> attributes) throws Exception {
			String path = request.getURI().getPath();
			String roomid = path.substring(path.lastIndexOf("/")+1);
			attributes.put("roomid", roomid);		
			return true;
	}
}

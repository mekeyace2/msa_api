package site.msa.socket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;

//서버에 웹 소켓 환경설정을 하는 class
@Configuration	//환경설정 (configure.xml)
@EnableWebSocket		//websocket을 라이브러리를 사용하기 위한 어노테이션
public class websocketconfig implements WebSocketConfigurer {

	//WebSocketConfigurer : socket에서 사용하는 interface 라이브러리
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		
		//ws://localhost:8080/chat
		//방 한개
		//registry.addHandler(sockethand(), "/chat").setAllowedOriginPatterns("*");
		
		//ws://localhost:8080/chat/rooms/1
		//각각의 room을 생성할 경우
		registry.addHandler(sockethand(), "/chat/rooms/{roomId}").setAllowedOriginPatterns("*");
	}
	
	//각 room마다 그룹을 생성하는 class를 로드하는 메소드 (room 1개)
	public HandshakeInterceptor handshake() {
		return new chathandshake();
	}
	
	//새로운 클라언트가 접속시 새로운 class를 생성하는 메소드 (room 여러개)
	@Bean
	public WebSocketHandler sockethand() {
		 return new sockethand();
	}
	
}

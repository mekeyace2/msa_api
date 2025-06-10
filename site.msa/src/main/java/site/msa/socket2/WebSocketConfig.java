package site.msa.socket2;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	
	//ws 주소를 셋팅하는 메소드
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		 registry.addEndpoint("/gs-websocket");
	}
	
	//소켓 방생성 역활을 하는 메소드
	@Override
	public void configureMessageBroker(MessageBrokerRegistry reg) {
		reg.enableSimpleBroker("/room");
		reg.setApplicationDestinationPrefixes("/app");
	}
}

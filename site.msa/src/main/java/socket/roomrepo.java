package socket;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

@Repository
public class roomrepo {
	//방을 생성한 리스트를 담고 있는 배열
	private final Map<Long, chat_room> rooms;
	
	//방번호 리스트를 출력할 때 사용하는 형태
	public roomrepo() {
		this.rooms = Stream.of(
				chat_room.create("room1 채팅"),
				chat_room.create("room2 채팅"),
				chat_room.create("room3 채팅"))
				.collect(Collectors.toMap(chat_room::id, room -> room));		
	}
	
	//고유방 id getter 형태로 입력시키는 메소드
	public chat_room room(Long id) {
		return this.rooms.get(id);
	}
}

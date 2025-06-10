package site.msa.socket2;

import org.springframework.stereotype.Repository;

import lombok.Data;

//채팅 사용자명, 메세지 (Front => Back(DTO) => Front)
@Data
@Repository("chatDTO")
public class chatDTO {
	public chatDTO() {
		
	}
	public String name, msg;
	
	public chatDTO(String name, String msg) {
		this.name = name;
		this.msg = msg;
	}
}

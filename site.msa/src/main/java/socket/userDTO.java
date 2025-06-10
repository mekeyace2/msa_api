package socket;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("userDTO")
public class userDTO {
	String uname;
}

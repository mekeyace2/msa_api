package site.msa;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("member_DTO")
public class member_DTO {
	Integer nidx;
	String role, userid, userpw, usernm, useremail;
}

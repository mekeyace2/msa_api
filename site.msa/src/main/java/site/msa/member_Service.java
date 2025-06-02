package site.msa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class member_Service {
	
	@Autowired
	mapper mp;
	
	public List<member_DTO> member_list(){
		List<member_DTO> all = this.mp.member_list();
		System.out.println(all.size());
		return all;
	}
	
}

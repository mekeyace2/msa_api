package site.msa;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class msa_controller {

	PrintWriter pw = null;
	
	@Resource(name="member_DTO")
	member_DTO dto;
	
	@Autowired
	member_Service service;
	
	/*
	 MSA API에서 두가지 방식 처리 :
	 1.  PrintWriter : api 페이지에서 웹에 출력 여부를 확인 하기 위함
	 2.  return 에 직접 배열 클래스를 적용하여 프론트에서 확인하는 사항 (Back-end console)
	 */
	
	
	//모든 데이터를 Front-end에서 데이터의 값을 전달시 JSON
	@GetMapping("/memberlist")
	public String memberlist() {
		System.out.println("api 통신체크");
		List<member_DTO> all = this.service.member_list();
		JSONArray ja = new JSONArray();
		int w=0;
		while(w < all.size()) {
		JSONObject jo = new JSONObject();
		jo.put("nidx", all.get(w).getNidx());
		jo.put("role", all.get(w).getRole());
		jo.put("userid", all.get(w).getUserid());
		jo.put("usernm", all.get(w).getUsernm());
		jo.put("useremail", all.get(w).getUseremail());
		ja.add(jo);
		w++;
		}
		JSONObject keys = new JSONObject();
		keys.put("member", ja);

		//System.out.println(keys.toString());
		return keys.toString();
	}
	
	
	@GetMapping("/index.do")
	public String index() {
		System.out.println("API Server ok!!");
		return null;
	}
	
}

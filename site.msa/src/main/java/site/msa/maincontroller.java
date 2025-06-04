package site.msa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.minidev.json.JSONArray;

@Controller
public class maincontroller {
	
	@GetMapping("/admin/product_list.do")
	public String product_list(Model m,
			@RequestParam(name="pnm", required = false)String pnm
			) {
		System.out.println(pnm);
		String data[] = {"선풍기","에어콘","모니터","키보드"};
		JSONArray ja = new JSONArray();
		for(String a : data) {
			ja.add(a);
		}
		m.addAttribute("product",ja);
		
		return null;
	}
	
	
	@GetMapping("/main.do")
	public String mains(Model m) {
		String user = "홍길동";
		m.addAttribute("user",user);
		System.out.println("main pages!!");
		return null;
	}
	
	
}

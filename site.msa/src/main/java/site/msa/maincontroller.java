package site.msa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class maincontroller {
	
	@GetMapping("/main.do")
	public String mains(Model m) {
		String user = "홍길동";
		m.addAttribute("user",user);
		System.out.println("main pages!!");
		return null;
	}
}

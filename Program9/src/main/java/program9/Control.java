package program9;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Control {
	
	@RequestMapping("/")
	public String Accept() {
		return "Accept";
	}
	
	String result;
	
	@RequestMapping("/Display")
	public String Display(@RequestParam String id, @RequestParam String name, @RequestParam String price, @RequestParam String qt,Model m) {
		
		if(id.matches("\\d{4}")) {
			m.addAttribute("id",id);
			if(name.length() <10) {
				m.addAttribute("name",name);
				if(price.matches("\\d+")) {
					m.addAttribute("price",price);
					if(qt.isBlank()) {
						m.addAttribute("qt",qt);
						result = "Display";
					}else {
						m.addAttribute("e_qt","Invalid value");
						result = "Accept";
					}
				}else {
					m.addAttribute("e_price","Invalid Price value");
					result = "Accept";
				}
			}else {
				m.addAttribute("e_name","name length exceeded");
				result = "Accept";
			}
			
		}else {
			m.addAttribute("e_id","invalid id number");
			result = "Accept";
		}
		return result;
		
	}

}

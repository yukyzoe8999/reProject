package pp.main;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class indexCtr {

	@Autowired
	private indexSvc indexSvc;
	
	@RequestMapping(value="index")
	public String Index(HttpServletRequest req, ModelMap modelMap) {
//		String userno = req.getSession().getAttribute("id").toString();
       
		
		List<?> plist = indexSvc.selectMainInfo();
		modelMap.addAttribute("plist",plist);
	
		return "main/index";
	}
}

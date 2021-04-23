package pp.TourDetail;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class TDCtr {

	@Autowired
	private TDSvc tdSvc;
	
	@RequestMapping(value="TourDetail")
	public String Index(HttpServletRequest req, ModelMap modelMap) {
		String checkin = req.getParameter("i");
		String checkout = req.getParameter("o");
		String rooms = req.getParameter("r");
       
		System.out.println("checkin : "+checkin + "checkout : "+ checkout);
		System.out.println("rooms : "+ rooms);
		
		List<?> plist = tdSvc.selectLocalName();
		modelMap.addAttribute("plist",plist);
	
		return "TourDetail/TourDetail";
	}
}

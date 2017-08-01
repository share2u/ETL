package site.share2u.etl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import site.share2u.etl.pojo.Staff;
import site.share2u.etl.service.StaffService;

@Controller
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@RequestMapping(value="/{staffId}")
	public String getStaff(@PathVariable("staffId") String staffId,Model model){
//		 Staff staff = staffService.selectByPrimaryKey(staffId);
//		 model.addAttribute("staff", staff);
		 return "hello";
	}
}

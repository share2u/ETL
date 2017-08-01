package site.share2u.etl.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class Upload {
	@RequestMapping(value="/uploadpicture")
	public String uploadPicture(@RequestParam("photo") MultipartFile photo,HttpSession session) throws IllegalStateException, IOException{
		String realPath = session.getServletContext().getRealPath("/images");
		String originalFilename = photo.getOriginalFilename();
		File file = new File(realPath,originalFilename);
		photo.transferTo(file);
		return "success";
	}
	
}

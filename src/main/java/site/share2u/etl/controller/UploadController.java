package site.share2u.etl.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import site.share2u.etl.pojo.ResponseBO;

@Controller
@RequestMapping("/upload")
public class UploadController {
	@RequestMapping(value = "/uploadpicture/file")
	public String uploadPictureByfile(@RequestParam("photo") MultipartFile photo, HttpSession session)
			throws IllegalStateException, IOException {
		String realPath = session.getServletContext().getRealPath("/images");
		String originalFilename = photo.getOriginalFilename();
		File file = new File(realPath, originalFilename);
		photo.transferTo(file);
		return "success";
	}
	@RequestMapping(value = "/uploadpicture/upload")
	public String uploadPictureByfile() {
		return "upload";
	}
/* jsonp方式
	@RequestMapping(value = "/uploadpicture/base64")
	public void uploadPictureBybase64(@RequestParam String base64Data, HttpSession session,String jsonpCallback,HttpServletResponse response) throws IOException {
		ResponseBO responseBO = new ResponseBO();
		String realPath = session.getServletContext().getRealPath("/images");
		System.out.println(base64Data);
		String dataPrix = "";
		String data = "";
		if (base64Data == null || "".equals(base64Data)) {
			responseBO.setCompleteCode(ResponseBO.ERROR);
			responseBO.setReasonMessage("上传失败，上传图片数据为空");
		} else {
			String[] d = base64Data.split("base64,");
			if (d != null && d.length == 2) {
				dataPrix = d[0];
				data = d[1];
			} else {
				responseBO.setCompleteCode(ResponseBO.ERROR);
				responseBO.setReasonMessage("上传失败，数据不合法");
			}
		}

		String suffix = "";
		if ("data:image/jpeg;".equalsIgnoreCase(dataPrix)) {// data:image/jpeg;base64,base64编码的jpeg图片数据
			suffix = ".jpg";
		} else if ("data:image/x-icon;".equalsIgnoreCase(dataPrix)) {// data:image/x-icon;base64,base64编码的icon图片数据
			suffix = ".ico";
		} else if ("data:image/gif;".equalsIgnoreCase(dataPrix)) {// data:image/gif;base64,base64编码的gif图片数据
			suffix = ".gif";
		} else if ("data:image/png;".equalsIgnoreCase(dataPrix)) {// data:image/png;base64,base64编码的png图片数据
			suffix = ".png";
		} else {
			responseBO.setCompleteCode(ResponseBO.ERROR);
			responseBO.setReasonMessage("上传图片格式不合法");
		}

		String formatDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		String tempFileName = formatDate + suffix;

		byte[] bs = Base64Utils.decodeFromString(data);
		try {
			FileCopyUtils.copy(bs, new File(realPath, tempFileName));
		} catch (Exception ee) {
			responseBO.setCompleteCode(ResponseBO.ERROR);
			responseBO.setReasonMessage("上传失败，写入文件失败，" + ee.getMessage());
		}
		responseBO.setCompleteCode(ResponseBO.SUCCESS);
		responseBO.setReasonMessage(tempFileName);
		response.getWriter().print(jsonpCallback+"("+JSON.toJSONString(responseBO).toString()+")");   ;
	}
	*/
	@RequestMapping(value = "/uploadpicture/base64")
	@ResponseBody
	public ResponseBO uploadPictureBybase64(@RequestParam String base64Data, HttpSession session) {
		ResponseBO responseBO = new ResponseBO();
		//String realPath = session.getServletContext().getRealPath("/images");
		String realPath = "F:/github/mypicture";
		System.out.println(base64Data);
		String dataPrix = "";
		String data = "";
		if (base64Data == null || "".equals(base64Data)) {
			responseBO.setCompleteCode(ResponseBO.ERROR);
			responseBO.setReasonMessage("上传失败，上传图片数据为空");
		} else {
			String[] d = base64Data.split("base64,");
			if (d != null && d.length == 2) {
				dataPrix = d[0];
				data = d[1];
			} else {
				responseBO.setCompleteCode(ResponseBO.ERROR);
				responseBO.setReasonMessage("上传失败，数据不合法");
			}
		}
		
		String suffix = "";
		if ("data:image/jpeg;".equalsIgnoreCase(dataPrix)) {// data:image/jpeg;base64,base64编码的jpeg图片数据
			suffix = ".jpg";
		} else if ("data:image/x-icon;".equalsIgnoreCase(dataPrix)) {// data:image/x-icon;base64,base64编码的icon图片数据
			suffix = ".ico";
		} else if ("data:image/gif;".equalsIgnoreCase(dataPrix)) {// data:image/gif;base64,base64编码的gif图片数据
			suffix = ".gif";
		} else if ("data:image/png;".equalsIgnoreCase(dataPrix)) {// data:image/png;base64,base64编码的png图片数据
			suffix = ".png";
		} else {
			responseBO.setCompleteCode(ResponseBO.ERROR);
			responseBO.setReasonMessage("上传图片格式不合法");
		}
		
		String formatDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		String tempFileName = formatDate + suffix;
		
		byte[] bs = Base64Utils.decodeFromString(data);
		try {
			FileCopyUtils.copy(bs, new File(realPath, tempFileName));
		} catch (Exception ee) {
			responseBO.setCompleteCode(ResponseBO.ERROR);
			responseBO.setReasonMessage("上传失败，写入文件失败，" + ee.getMessage());
		}
		
		try {
			Process process = Runtime.getRuntime().exec("cmd.exe /c start F:/github/mypicture/auto.bat");
			process.waitFor();
			responseBO.setCompleteCode(ResponseBO.SUCCESS);
			responseBO.setReasonMessage("https://github.com/share2u/mypicture/blob/master/"+tempFileName);
			
		} catch (IOException e) {
			e.printStackTrace();
			responseBO.setCompleteCode(ResponseBO.ERROR);
			responseBO.setReasonMessage("上传github io异常，" + e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
			responseBO.setCompleteCode(ResponseBO.ERROR);
			responseBO.setReasonMessage("上传github InterruptedException，" + e.getMessage());
		}
		
		
		
		return responseBO;
	}
public static void main(String[] args) throws IOException {
	Process process = Runtime.getRuntime().exec("cmd.exe /c start F:/github/mypicture/auto.bat");
}
}

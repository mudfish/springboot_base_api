package com.my.java.api;

import cn.hutool.core.io.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Api(tags = "文件上传")
@RestController
@RequestMapping("/file")
public class UploadController {
	@ApiOperation("多文件上传接口")
	@PostMapping("/upload")
	public String uploadFile(MultipartFile[] files, HttpServletRequest request) {
		String realPath = "d:/tmp/upload";
		System.out.println(realPath);
		if(!FileUtil.exist(realPath)){
			FileUtil.mkdir(realPath);
		}
		File folder = new File(realPath);
		for (MultipartFile file : files) {
			//获取上传文件的源文件名称
			String oldName = file.getOriginalFilename();
			String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
			//判断目录是否存在，不存在则创建目录
			if (!folder.exists()) {
				folder.mkdirs();
			}
			try {
				file.transferTo(new File(folder, newName));
				//打印上传文件的url
				System.out.println(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/" + newName);
			} catch (IOException e) {
				e.printStackTrace();
				return "上传文件失败";
			}
		}
		return "上传文件成功";
	}

}
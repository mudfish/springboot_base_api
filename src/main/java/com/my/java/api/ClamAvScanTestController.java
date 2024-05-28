package com.my.java.api;

import com.baomidou.mybatisplus.extension.api.R;
import com.my.java.common.ClamAVEnum;
import com.my.java.common.ResultUtil;
import fi.solita.clamav.ClamAVClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Description 病毒文件上传扫描测试接口
 * @Author xusucheng
 * @Date 2024/4/17
 */
@Slf4j
@RestController
@RequestMapping("/scan")
public class ClamAvScanTestController {
    @Autowired
    private ClamAVClient clamAVClient;

    @GetMapping("")
    public String test() throws IOException {
        boolean pong = clamAVClient.ping();
        if (pong){
            System.out.println("服务器连接成功");
            return "服务器连接成功";
        }
        System.out.println("服务器连接失败");
        return "服务器连接失败";
    }

    @PostMapping(value = "/uploadFile")
    public ResultUtil<?> uploadFile(@RequestParam("file") MultipartFile file) {
        // 判断文件是否存在病毒
        try {
            InputStream inputStream = file.getInputStream();
            byte[] scan = clamAVClient.scan(inputStream);
            String res = new String(scan, StandardCharsets.UTF_8);
            log.info("检测结果：{}",res);
            if(ClamAVEnum.OK.getCode().equals(res)){
                System.out.println(ClamAVEnum.OK.getDesc());
            }else if(ClamAVEnum.ALLOCATE_MEMORY.getCode().equals(res)){
                return ResultUtil.error(ClamAVEnum.ALLOCATE_MEMORY.getDesc());
            }else {
                return ResultUtil.error(ClamAVEnum.INFECTED.getDesc());
            }
        } catch (IOException e) {
            try {
                clamAVClient.ping();
            } catch (IOException ioException) {
                return ResultUtil.error("连接杀毒服务失败！");
            }
            return ResultUtil.error("连接杀毒服务异常或上传文件超过杀毒软件最大文件限制！");
        }

        return ResultUtil.ok("ok");
    }
}

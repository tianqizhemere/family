package top.tianqi.family.upload.service.impl;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.family.upload.vo.FileVO;
import top.tianqi.family.family.tools.upload.RemoteUploadConfig;
import top.tianqi.family.family.tools.utils.GenerateIdUtils;
import top.tianqi.family.family.tools.utils.JsonUtil;
import top.tianqi.family.upload.service.UploadService;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 文件上传服务层实现
 * @Author wkh
 * @Date 2020/7/30 15:49
 */
@Service(value = "uploadServiceImpl")
public class UploadServiceImpl implements UploadService {

    @Autowired
    private RemoteUploadConfig remoteUploadConfig;

    @Override
    public String uploadFile(MultipartFile multipartFile) throws IOException {
        String fileSuffix = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        String datePath = new SimpleDateFormat("yyyyMM").format(new Date());
        String newFileName = GenerateIdUtils.requestIdWithUUID() + "." + fileSuffix;
        String returnSourcePath = remoteUploadConfig.getUploadPathFile() + datePath + "/" + newFileName;

        File tempFile = new File(remoteUploadConfig.getUploadPath() + returnSourcePath);
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdirs();
        }
        multipartFile.transferTo(tempFile);
        List<FileVO> list = new ArrayList<>();
        list.add(new FileVO(multipartFile.getOriginalFilename(), returnSourcePath));
        return JsonUtil.toJsonString(list);
    }
}

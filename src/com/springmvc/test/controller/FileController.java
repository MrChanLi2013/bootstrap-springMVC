package com.springmvc.test.controller;

import com.springmvc.test.entity.FileMetadata;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

@Controller
@RequestMapping("/controller")
public class FileController {
    LinkedList<FileMetadata> fileMetadatas = new LinkedList<FileMetadata>();
    FileMetadata fileMetadata = null;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public
    @ResponseBody
    LinkedList<FileMetadata> upload(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException {
        Iterator<String> itr = request.getFileNames();
        MultipartFile multi = null;
        try {
            while (itr.hasNext()) {
                multi = request.getFile(itr.next());
                if (fileMetadatas.size() >= 10) {
                    fileMetadatas.pop();
                }
                setFileMetadata(multi);
                FileOutputStream fos = new FileOutputStream("" +
                        "C:\\Users\\Administrator\\Desktop\\"+multi.getOriginalFilename());
                InputStream in = multi.getInputStream();
                int len = 0;
                byte[] buf = new byte[1024];
                while ((len = in.read(buf)) > 0) {
                    fos.write(buf, 0, len);
                    fos.flush();
                }
//            fos.write(multi.getBytes());
                fos.close();
                fileMetadatas.add(fileMetadata);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileMetadatas;
    }

    private void setFileMetadata(MultipartFile multi) {
        fileMetadata = new FileMetadata();
        fileMetadata.setFileName(multi.getOriginalFilename());
        fileMetadata.setFileSize(multi.getSize() / 1024 + "kb");
        fileMetadata.setFileType(multi.getContentType());
//        try {
////            fileMetadata.setBytes(multi.getBytes());
////        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(HttpServletResponse res) throws IOException {
        OutputStream os = res.getOutputStream();
        try {
            res.reset();
            res.setHeader("Content-Disposition", "attachment; filename=李.jpg");
            res.setContentType("application/octet-stream; charset=utf-8");
            os.write(FileUtils.readFileToByteArray(getDictionaryFile()));
            os.flush();
        } finally {
            if (os != null) {
                os.close();
            }
        }

    }

    private File getDictionaryFile() {
        File file = new File("C:\\Users\\Administrator\\Desktop\\李.jpg");
        return file;
    }
}

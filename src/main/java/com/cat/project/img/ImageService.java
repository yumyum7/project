package com.cat.project.img;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ImageService {

	private final ImageRepository imageRepository;


	public void filesave(String name, String storename, String url, String Desc) {
		Image img = new Image();
		img.setImgOriName(name);
		img.setImgStoredName(storename);
		img.setImgLink(url);
		img.setImgDesc(Desc);

		imageRepository.save(img);
	}
	public String storedfile(String oriname) {
		String new_img_name = "img" + Long.toString(System.nanoTime()) + oriname;
		return new_img_name;
	}


	public String uploadfile(MultipartFile file) throws IOException{

        String path = "C:\\bootworkspace\\TumblCat\\src\\main\\resources\\static\\uploadfile\\";
		//String path="C:\\uploadfile\\";
        //개인 프로젝트 안에 이미지(Image) 폴더를 만들고 그 경로로 바꿔주세요.

        // 저장된 파일로 변경하여 이를 보여주기 위함
        String filepath = path + file.getOriginalFilename();
        file.transferTo(new File(filepath));

		return filepath;
	}


	public Image findImgid(String files) {
		 return this.imageRepository.findByImgStoredName(files);
	}
}
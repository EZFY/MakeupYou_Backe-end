package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.Image;
import com.ynu.makeup_you.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/5/29 0029
 * BY hujianlong
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Override
    public List<String> getAllImg(String postID) {
        List<Image> imgAndPostList = imageRepository.findByPostID(postID);
        List<String> imgList = new ArrayList<>();
        for(Image i:imgAndPostList){
            imgList.add(i.getImgID());
        }
        return imgList;
    }
}

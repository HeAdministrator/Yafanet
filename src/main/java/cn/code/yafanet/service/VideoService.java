package cn.code.yafanet.service;

import cn.code.yafanet.model.entity.Video;
import cn.code.yafanet.model.entity.VideoBanner;
import cn.code.yafanet.model.entity.VideoOrder;

import java.util.List;

public interface VideoService {

    List<Video> ListVideo();

    List<VideoBanner> listBanner();

    Video findDetailById(int videoId);


}

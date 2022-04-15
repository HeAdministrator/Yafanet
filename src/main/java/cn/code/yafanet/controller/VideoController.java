package cn.code.yafanet.controller;

import cn.code.yafanet.model.entity.VideoOrder;
import cn.code.yafanet.utils.JsonData;
import cn.code.yafanet.model.entity.Video;
import cn.code.yafanet.model.entity.VideoBanner;
import cn.code.yafanet.service.VideoService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 轮播图列表
     * @return
     */
    @GetMapping("list_banner")
    public JsonData indexBanner(){

        List<VideoBanner> bannerList =  videoService.listBanner();

        return JsonData.buildSuccess(bannerList);
    }

    /**
     * 视频列表
     * @return
     */
    @RequestMapping("list")
    public  JsonData ListVideo(){
        List<Video> videoList = videoService.ListVideo();
        return JsonData.buildSuccess(videoList);
    }

    @GetMapping("find_detail_by_id")
    public JsonData findDetailByID(@RequestParam(value = "video_id",required = true)int videoId){
        Video video =videoService.findDetailById(videoId);
        return JsonData.buildSuccess(video);
    }




}

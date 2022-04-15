package cn.code.yafanet.service.impl;

import cn.code.yafanet.config.CacheKeyManager;
import cn.code.yafanet.mapper.VideoMapper;
import cn.code.yafanet.model.entity.Video;
import cn.code.yafanet.model.entity.VideoBanner;
import cn.code.yafanet.model.entity.VideoOrder;
import cn.code.yafanet.service.VideoService;
import cn.code.yafanet.utils.BaseCashe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private BaseCashe baseCashe;

    @Override
    public List<Video> ListVideo() {
        try {
            Object cacheObj =  baseCashe.getTenMinuteCache().get(CacheKeyManager.INDEX_VIDEO_LIST, ()->{
                List<Video> videoList = videoMapper.ListVideo();

                return videoList;
            });
            if(cacheObj instanceof  List){
                List<Video> videoList = (List<Video>) cacheObj;
                return videoList;
            }
        }catch (Exception ignored){
            ignored.printStackTrace();
        }

        //可以返回兜底数据，业务系统降级
        return null;
    }

    @Override
    public List<VideoBanner> listBanner() {

        try {
            Object casheObject = baseCashe.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY, ()->{
                List<VideoBanner> bannerList = videoMapper.listVideoBanner();
                System.out.println("从数据库里面找轮播图列表");
                return bannerList;
            });
            if(casheObject instanceof  List){
                List<VideoBanner> bannerList =  (List<VideoBanner>)casheObject;
                return bannerList;
            }
        }catch (Exception ignored){
            ignored.printStackTrace();
        }

        return  null;
    }

    @Override
    public Video findDetailById(int videoId) {
        //TODO 使用mybatis关联复杂查询
        //单独构建一个缓存key，每个视频的key是不一样的
        String videoCacheKey = String.format(CacheKeyManager.VIDEO_DETAIL,videoId);
        try {

            Object cacheObject = baseCashe.getOneHourCache().get(videoCacheKey, ()->{
                Video video = videoMapper.findDetaileById(videoId);
                return video;
            });
            if(cacheObject instanceof  Video){
                Video video = (Video)cacheObject;
                return  video;
            }
        }catch (Exception ignored){
            ignored.printStackTrace();
        }
        return  null;

    }


}

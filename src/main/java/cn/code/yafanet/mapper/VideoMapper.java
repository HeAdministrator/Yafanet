package cn.code.yafanet.mapper;

import cn.code.yafanet.model.entity.Video;
import cn.code.yafanet.model.entity.VideoBanner;
import cn.code.yafanet.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoMapper {

    /**
     * 查询视频列表
     * @return
     */
    List<Video> ListVideo();

    /**
     * 首页轮播图列表
     * @return
     */
    List<VideoBanner> listVideoBanner();

    /**
     * 根据id查询视频详情
     * @param videoId
     * @return
     */
    Video findDetaileById(@Param("video_id") int videoId);

    /**
     *简单查询视频详情
     * @param videoId
     * @return
     */
    Video findById(@Param("video_id")int videoId);



}

package cn.code.yafanet.mapper;

import cn.code.yafanet.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author AllenHe
 * @date 2022/3/27
 * @apiNote
 */
public interface VideoOrderMapper {

    /**
     * 查询用户是否购买过此商品
     * @param userId
     * @param videoId
     * @param state
     * @return
     */
    VideoOrder findByUserIdAndVideoIdAndState(@Param("user_id") int userId,@Param("video_id") int videoId,@Param("state") int state);

    /**
     * 下单
     * @param videoOrder
     * @return
     */
    int saveOrder(VideoOrder videoOrder );

    /**
     * 用户订单列表
     * @param userId
     * @return
     */
    List<VideoOrder> listOrderByUserId(@Param("user_id") int userId);

    /**
     * 查询用户是否订阅该视频
     * @param videoId
     * @param userId
     * @return
     */
    VideoOrder findUserPayed(@Param("video_id") int videoId,@Param("user_id") Integer userId);
}

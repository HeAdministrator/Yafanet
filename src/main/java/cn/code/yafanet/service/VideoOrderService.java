package cn.code.yafanet.service;

import cn.code.yafanet.model.entity.VideoOrder;

import java.util.List;

/**
 * @author AllenHe
 * @date 2022/3/27
 * @apiNote 下单
 */
public interface VideoOrderService {

    /**
     * 保存订单
     * @param userId
     * @param videoId
     * @return
     */
    int save(int userId, int videoId);

    /**
     * 用户订单列表
     * @param userId
     * @return
     */
    List<VideoOrder> listOrderByUserId(int userId);

    VideoOrder findUserPayed(int videoId, Integer userId);
}

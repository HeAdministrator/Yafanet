package cn.code.yafanet.service.impl;

import cn.code.yafanet.exception.XDException;
import cn.code.yafanet.mapper.*;
import cn.code.yafanet.model.entity.Episode;
import cn.code.yafanet.model.entity.PlayRecord;
import cn.code.yafanet.model.entity.Video;
import cn.code.yafanet.model.entity.VideoOrder;
import cn.code.yafanet.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author AllenHe
 * @date 2022/3/27
 * @apiNote
 */

@Service
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private EpisodeMapper episodeMapper;

    @Autowired
    private PlayRecordMapper playRecordMapper;

    /**
     * 下单操作
     * 未来版本：优惠卷抵扣，风控用户检查，生产订单基础信息，生产支付信息
     * @param userId
     * @param videoId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(int userId, int videoId) {

        //判断是否已经购买
        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdAndState(userId,videoId,1);

        if(videoOrder!=null){ return  0;}

        Video video = videoMapper.findById(videoId);

        VideoOrder newVideoOrder = new VideoOrder();
        newVideoOrder.setCreateTime(new Date());
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
        newVideoOrder.setState(1);
        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setUserId(userId);
        newVideoOrder.setVideoId(videoId);
        newVideoOrder.setVideoImg(video.getCoverImg());
        newVideoOrder.setVideoTitle(video.getTitle());

        int rows = videoOrderMapper.saveOrder(newVideoOrder);

        //生成播放记录
        if( rows == 1){
            Episode episode = episodeMapper.findFristEpisodeByIdVideoId(videoId);
            if(episode == null){
                throw  new XDException(-1,"视频没有集信息,请运营人员检查。");
            }
            PlayRecord playRecord = new PlayRecord();
            playRecord.setCreateTime(new Date());
            playRecord.setEpisodeId(episode.getId());
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setVideoId(videoId);
            playRecord.setUserId(userId);
            playRecordMapper.saveRecord(playRecord);
        }

        return rows;

    }

    @Override
    public List<VideoOrder> listOrderByUserId(int userId) {
        return videoOrderMapper.listOrderByUserId(userId);
    }

    @Override
    public VideoOrder findUserPayed(int videoId, Integer userId) {
        return videoOrderMapper.findUserPayed(videoId,userId);
    }
}

package cn.code.yafanet.mapper;

import cn.code.yafanet.model.entity.Episode;
import cn.code.yafanet.model.entity.PlayRecord;
import org.apache.ibatis.annotations.Param;

/**
 * @author AllenHe
 * @date 2022/3/28
 * @apiNote 播放记录
 */
public interface PlayRecordMapper {

   int saveRecord(PlayRecord playRecord);

}

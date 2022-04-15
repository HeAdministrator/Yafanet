package cn.code.yafanet.mapper;

import cn.code.yafanet.model.entity.Episode;
import org.apache.ibatis.annotations.Param;

/**
 * @author AllenHe
 * @date 2022/3/28
 * @apiNote
 */
public interface EpisodeMapper {

    Episode findFristEpisodeByIdVideoId(@Param("video_id") int videoId);

}

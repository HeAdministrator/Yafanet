package cn.code.yafanet.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author AllenHe
 * @date 2022/3/27
 * @apiNote
 */
public class VideoOrderRequest {

    @JsonProperty("video_id")
    private int videoId;

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

}

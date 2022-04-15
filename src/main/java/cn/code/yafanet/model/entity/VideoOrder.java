package cn.code.yafanet.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author AllenCode
 * 视频订单
 */
public class VideoOrder {

    private  Integer id;
    /**
     * 订单唯一标识
     */
    @JsonProperty("out_trade_no")
    private  String outTradeNo;

    /**
     * 0表示未支付，1表示已支付
     */
    private  Integer state;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonProperty("total_fee")
    private Integer totalFee;

    @JsonProperty("video_id")
    private Integer videoId;

    @JsonProperty("video_title")
    private String videoTitle;

    @JsonProperty("video_img")
    private String videoImg;

    @JsonProperty("user_id")
    private Integer userId;

    public VideoOrder() {
    }

    public VideoOrder(Integer id, String outTradeNo, Integer state, Date createTime, Integer totalFee, Integer videoId, String videoTitle, String videoImg, Integer userId) {
        this.id = id;
        this.outTradeNo = outTradeNo;
        this.state = state;
        this.createTime = createTime;
        this.totalFee = totalFee;
        this.videoId = videoId;
        this.videoTitle = videoTitle;
        this.videoImg = videoImg;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "VideoOrder{" +
                "id=" + id +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", totalFee=" + totalFee +
                ", videoId=" + videoId +
                ", videoTitle='" + videoTitle + '\'' +
                ", videoImg='" + videoImg + '\'' +
                ", userId=" + userId +
                '}';
    }
}

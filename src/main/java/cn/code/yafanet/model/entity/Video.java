package cn.code.yafanet.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 * @author AllenCode
 * 视频对象
 */
public class Video {

    private Integer id;

    private  String title;

    private  String summary;

    private Integer price;

    private String type;

    @JsonProperty("cover_img")
    private String coverImg;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Double point;

    @JsonProperty("chapter_list")
    private  List<Chapter> chapterList;

    public Video() {
    }

    public Video(Integer id, String title, String summary, Integer price, String type, String coverImg, Date createTime, Double point, List<Chapter> chapterList) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.price = price;
        this.type = type;
        this.coverImg = coverImg;
        this.createTime = createTime;
        this.point = point;
        this.chapterList = chapterList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", createTime=" + createTime +
                ", point=" + point +
                ", chapterList=" + chapterList +
                '}';
    }
}

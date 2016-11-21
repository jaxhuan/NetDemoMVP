package com.skyzone.netdemomvp.data.bean;

import java.util.Date;

/**
 * Created by Skyzone on 11/4/2016.
 */
public class Video {


    /**
     * _id : 581a02fe421aa90e799ec260
     * createdAt : 2016-11-02T23:15:10.386Z
     * desc : 男友忠诚度测试[doge] 这是毁事的节奏啊！[偷笑]
     * publishedAt : 2016-11-04T11:48:56.654Z
     * source : chrome
     * type : 休息视频
     * url : http://www.miaopai.com/show/ZonudCUkw1bc2ozLS1umcQ__.htm
     * used : true
     * who : LHF
     */

    private String _id;
    private Date createdAt;
    private String desc;
    private Date publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}

package com.skyzone.netdemomvp.data.bean;

import java.util.Date;

/**
 * Created by Skyzone on 11/3/2016.
 */
public class MeiZi {

    /**
     * _id : 56cc6d29421aa95caa7082aa
     * createdAt : 2016-02-05T13:10:47.694Z
     * desc : 2.6
     * publishedAt : 2016-02-15T03:49:24.352Z
     * type : 福利
     * url : http://ww4.sinaimg.cn/large/7a8aed7bgw1f0orab74l4j20go0p0jw5.jpg
     * used : true
     * who : 张涵宇
     */

    private String _id;
    private Date createdAt;
    private String desc;
    private Date publishedAt;
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

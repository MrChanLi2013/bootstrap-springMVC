package com.springmvc.test.entity;


import com.springmvc.test.common.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_news")
public class News extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = true)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "content", length = 16777216)
    private String content;
    /**
     * 发布人
     */
    @Column(name = "publisher")
    private String publisher;
    /**
     * 所属院系
     */
    @Column(name = "orign",columnDefinition = "INT default 0" )
    private String orign;
    /**
     * 点击量
     */
    @Column(name = "hits")
    private int hits;
    @Column(name = "created_at")
    private Date createdAt;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getOrign() {
        return orign;
    }

    public void setOrign(String orign) {
        this.orign = orign;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}

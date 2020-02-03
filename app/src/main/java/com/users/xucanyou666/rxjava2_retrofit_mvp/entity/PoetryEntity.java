package com.users.xucanyou666.rxjava2_retrofit_mvp.entity;


/**
 * 诗歌的实体类
 * created by xucanyou666
 * on 2020/1/23 21:23
 * email：913710642@qq.com
 * API返回示例：
 * {
 * "content": "胡瓶落膊紫薄汗，碎叶城西秋月团。",
 * "origin": "从军行七首",
 * "author": "王昌龄",
 * "category": "古诗文-天气-月亮"
 * }
 */
public class PoetryEntity {
    private String content; //诗歌内容
    private String origin; //来源
    private String author; //作者
    private String category; //分类

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

package ru.nd.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity // Данный класс сохраняется в БД
public class Article implements Serializable, Comparable<Article> {
    @Id
    @GeneratedValue
    private Integer id;
    @Column // Данное значение мапиться в колонку. Без явного указания имени колонки, используется автоматически
    private String title;
    @Column(length = 1000000)
    @Lob
    private String content;
    @Column
    private long creationTimestamp;

    public Article() {}

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
        this.creationTimestamp = System.currentTimeMillis();
    }

    @Override
    public int compareTo(Article that) {
        return Long.compare(this.creationTimestamp, that.creationTimestamp);
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
}

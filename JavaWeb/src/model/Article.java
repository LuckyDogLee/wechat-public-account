package model;

/**
 * Created by Jack Lee on 2016/1/4.
 */
public class Article {
    private int id;
    private int topic;
    private String title;
    private String summary;
    private String content;
    private String img;


    public Article() {

    }

    public Article(int id, int topic, String title, String summary, String content, String img) {
        this.id = id;
        this.topic = topic;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.img = img;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getTopic() { return topic; }
    public void setTopic(int topic) { this.topic = topic; }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
}


package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack Lee on 2016/1/4.
 */
public class ArticleList {
    //文章集合
    private List<Article> articles;

    //文章数量
    private int articleNum;

    //文章列表类的构造函数
    public ArticleList() {
        articles = new ArrayList<Article>();
        articleNum = 0;
    }

    //封装articles
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    //封装articleNum
    public int getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }

    //添加文章到文章列表
    public boolean addArticle(Article article){
        articles.add(article);
        articleNum++;
        return true;
    }

    //从文章列表中删除某篇文章
    public boolean removeArticle(int index){
        articles.remove(index);
        articleNum--;
        return true;
    }

    //修改文章内容
    public boolean modifyArticle(int index, Article article){
        articles.set(index, article);
        return true;
    }

    //查找文章
    public Article searchArticle(int index){
        return articles.get(index);
    }

}
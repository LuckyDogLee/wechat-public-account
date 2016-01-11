package com.luckypanda.wechat.message.resp;

/**
 * Created by Jack Lee on 2015/12/17.
 */
public class TextMessage extends BaseMessage {
    //回复的文本消息内容
    private String Content;

    //封装回复的文本消息内容
    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}

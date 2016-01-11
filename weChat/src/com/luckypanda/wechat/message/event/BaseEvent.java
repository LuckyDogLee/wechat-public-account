package com.luckypanda.wechat.message.event;

/**
 * Created by Jack Lee on 2015/12/17.
 */
public class BaseEvent {
    //开发者微信号
    private String ToUserName;
    //发送方账号(一个OpenID)
    private String FromUserName;
    //消息创建时间(整形)
    private long CreateTime;
    //消息类型
    private String MsgType;
    //事件类型
    private String Event;


    //封装开发者微信号
    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }


    //封装发送方账号(一个OpenID)
    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }


    //封装消息创建时间(整形)
    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }


    //封装消息类型
    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }


    //封装事件类型
    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }
}

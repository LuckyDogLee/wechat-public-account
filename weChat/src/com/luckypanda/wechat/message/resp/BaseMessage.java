package com.luckypanda.wechat.message.resp;

/**
 * Created by Jack Lee on 2015/12/17.
 */
public class BaseMessage {
    //接收方账号(收到的OpenID)
    private String ToUserName;
    //开发者微信号
    private String FromUserName;
    //消息创建时间(整形)
    private long CreateTime;
    //消息类型
    private String MsgType;


    //封装接收方账号(收到的OpenID)
    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }


    //封装开发者微信号
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


}
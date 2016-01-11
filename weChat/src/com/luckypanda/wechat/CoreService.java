package com.luckypanda.wechat;

import com.luckypanda.wechat.message.resp.TextMessage;
import com.luckypanda.wechat.util.MessageUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by Jack Lee on 2015/12/17.
 */public class CoreService {

    //处理微信发来的请求
    public static String processRequest(HttpServletRequest request){
        //XML 格式的消息数据
        String respXml = null;
        //默认返回的文本消息内容
        String respContent = "未知的消息类型！";
        try {
            //调用 parseXml 方法解析请求消息
            Map<String, String> requestMap = MessageUtil.parseXML(request);
            //发送方账号
            String formUserName = requestMap.get("FromUserName");
            //开发者微信号
            String toUserName = requestMap.get("ToUserName");
            //消息类型
            String msgType = requestMap.get("MsgType");


            //回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(formUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)){
                //事件类型
                String eventType = requestMap.get("Event");

                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)){
                    //关注
                    respContent = "感谢您关注【法律网】," +
                            "我们在每天早上9~12点，将为您推送最热门的法制新闻，" +
                            "你的支持是我们不断进步的动力，谢谢！";
                }else {
                    //取消关注
                }
                //设置文本消息的内容
                textMessage.setContent(respContent);
                //将文本消息对象转换成 XML
                respXml = MessageUtil.messageToXml(textMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }
}




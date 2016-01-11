package com.luckypanda.wechat.util;

import com.luckypanda.wechat.message.resp.TextMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jack Lee on 2015/12/17.
 */
public class MessageUtil {
    //请求消息类型：事件推送
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    //事件类型：subscribe(订阅)
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
    //事件类型：unsubscribe(取消订阅)
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

    //响应消息类型：文本
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";

    //解析微信发来的请求(XML)
    public static Map<String, String> parseXML(HttpServletRequest request)
            throws Exception{
        //将解析结果存储在 HashMap 中
        Map<String, String> map = new HashMap<String, String>();

        //从 request 中取得输入流
        InputStream inputStream = request.getInputStream();
        //读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        //得到 XML 根元素
        Element root = document.getRootElement();
        //得到根元素的所有子节点
        List<Element> elementList = root.elements();

        //遍历所有子节点
        for (Element e : elementList){
            map.put(e.getName(), e.getText());
        }

        //释放资源
        inputStream.close();
        inputStream = null;

        return map;
    }


    //文本消息对象转换成 XML
    public static String messageToXml(TextMessage textMessage){
        XStream xstream = new XStream();
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }


}
package com.luckypanda.wechat.util;

/**
 * Created by Jack Lee on 2016/1/11.
 */
public class createMenu {
    public final static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    public final static String menu_get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    public final static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

    public final static String jsonMenuStr ="{\n" +
                "     \"button\":[\n" +
                "     {\t\"name\":\"焦点资讯\",\n" +
                "           \"sub_button\":[\n" +
                "           {\t\n" +
                "               \"type\":\"view\",\n" +
                "               \"name\":\"法制快讯\",\n" +
                "               \"url\":\"http://luckywechat.aliapp.com/html/topic1List.html\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"type\":\"view\",\n" +
                "               \"name\":\"焦点访谈\",\n" +
                "               \"url\":\"http://luckywechat.aliapp.com/html/topic2List.html\"\n" +
                "            }]\n" +
                "      },\n" +
                "      {\n" +
                "           \"name\":\"实例讲座\",\n" +
                "           \"sub_button\":[\n" +
                "           {\t\n" +
                "               \"type\":\"view\",\n" +
                "               \"name\":\"专题讲座\",\n" +
                "               \"url\":\"http://luckywechat.aliapp.com/html/topic3List.html\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"type\":\"view\",\n" +
                "               \"name\":\"成功案例\",\n" +
                "               \"url\":\"http://luckywechat.aliapp.com/html/topic4List.html\"\n" +
                "            }]\n" +
                "       },\n" +
                "\t{\n" +
                "           \"name\":\"关于我们\",\n" +
                "           \"sub_button\":[\n" +
                "           {\t\n" +
                "               \"type\":\"view\",\n" +
                "               \"name\":\"联系我们\",\n" +
                "               \"url\":\"http://luckywechat.aliapp.com/html/contactUs.html\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"type\":\"view\",\n" +
                "               \"name\":\"团队介绍\",\n" +
                "               \"url\":\"http://luckywechat.aliapp.com/html/teamIntro.html\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"type\":\"view\",\n" +
                "               \"name\":\"产品介绍\",\n" +
                "               \"url\":\"http://luckywechat.aliapp.com/html/productIntro.html\"\n" +
                "            }]\n" +
                "       }]\n" +
                " }";
    //Todo......
}



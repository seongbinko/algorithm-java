package com.crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
    public static void main(String[] args) {
        try {
            String URL = "";

            Connection conn = Jsoup.connect(URL);

            Document html = conn.get();

            System.out.println("\n[CSS Slector 탐색]");
            String userId = html.select(".cont_name").text();
            String recipeName = html.select(".view2_summary h3").text();
            String src = html.getElementById("main_thumbs").attr("src");
            Elements stepInfos = html.select("div[id^='stepDiv']");

            System.out.println("레시피 작성자 >> " + userId);
            System.out.println("레시피 제목 >> " + recipeName);
            System.out.println("레시피 대표사진 >> " + src);

            System.out.println("스텝 사이즈 >> " + stepInfos.size());
            for (Element stepInfo : stepInfos) {

                System.out.println(stepInfo.text());
                if(!stepInfo.select("img").attr("src").isEmpty()) {
                    System.out.println(stepInfo.select("img").attr("src"));
                } else {
                    System.out.println("null");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

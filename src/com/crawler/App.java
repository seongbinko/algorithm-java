package com.crawler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {
    public static void main(String[] args) {
        try {
            int count = 8;
            while(count < 9) {
                run("https://www.10000recipe.com/recipe/690426" + count);
                count++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void run(String URL) throws Exception {
        // 1. Crawler 옵션 설정
        Properties options = new Properties();
        options.put("Content-Type", "application/html;charset=UTF-8");
        options.put("downloads", "C:/work/crawler/downloads/");
        options.put("timeout", 30*1000);

        // 2. Crawler 생성
        Crawler2 crawler = new Crawler2(URL, options);

        // 3. HTML 파싱
        Document html = crawler.get();

        // 4. <a> 태그 추출.
        Elements files = html.select("div[id^='stepDiv']");
        System.out.println(files.size());
        // 5. File Download 정보 추출
        List<Map<String, String>> download_list = new ArrayList<Map<String, String>>();
        Map<String, String> download_info = null;
        for(Element file : files) {
            download_info = new HashMap<String, String>();

            String src = file.select("img").attr("src");
            String filename = System.currentTimeMillis() + src.substring(src.length()-20, src.length()) ;


            download_info.put("filename", filename);
            download_info.put("URL", src);

            download_list.add( download_info );

            // Download File
            //crawler.download( href, filename );
        }

        // 6. Download Files
        crawler.downloads( download_list );
    }
}

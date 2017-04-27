package com.joye.basedata.filter;

import com.joye.basedata.autoseo.UploadRowResourceEntity;
import com.joye.basedata.webcollector.WebCollectorDelegate;

import java.util.List;
import java.util.regex.Pattern;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.ram.RamCrawler;

/**
 * Created by joye on 2017/4/19.
 */

public class FailedCrawler extends RamCrawler {
    public static final Pattern IMAGE_EXTENSIONS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g|png|tiff?|mid|mp2|mp3|mp4|wav|avi|mov|mpeg|ram|m4v|pdf"
            + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");
//    private final WebCollectorDelegate.ICrawlerCallBack crawlerCallBack;

    private List<UploadRowResourceEntity> list;


    public FailedCrawler(String str){
        CrawlDatum datum = new CrawlDatum(str);
        setMaxExecuteCount(2);
        setAutoParse(false);
        addSeed(datum);
    }

    public FailedCrawler(List<UploadRowResourceEntity> list, WebCollectorDelegate.ICrawlerCallBack callBack) {
        this.list = list;
//        this.crawlerCallBack = callBack;
        for (int i = 0; i < list.size(); i++) {
            CrawlDatum datum = new CrawlDatum("http://"+list.get(i).getOldDomainStr()+"/");
            setMaxExecuteCount(2);
            setAutoParse(false);
            addSeed(datum);
        }
    }

    @Override
    public void visit(Page page, CrawlDatums next) {
        String html=page.getHtml();
        System.out.println(html);

    }

}


//    @Override
//    public void visit(Page page, CrawlDatums next) {
//        String url = page.getUrl();
//        String href = url.toLowerCase();
//        if (IMAGE_EXTENSIONS.matcher(href).matches()) {
//            return;
//        }
//        String keyword = page.getMetaData("keyword");
//        String pageType = page.getMetaData("pageType");
//        int depth = Integer.valueOf(page.getMetaData("depth"));
//        if (pageType.equals("searchEngine")) {
//            int pageNum = Integer.valueOf(page.getMetaData("pageNum"));
//            System.out.println("成功抓取关键词" + keyword + "的第" + pageNum + "页搜索结果");
//            Elements results = page.select("li.b_ans h2>a,li.b_algo h2>a");
//            for (int rank = 0; rank < results.size(); rank++) {
//                Element result = results.get(rank);
//
//                /*
//                我们希望继续爬取每条搜索结果指向的网页，这里统称为外链。
//                我们希望在访问外链时仍然能够知道外链处于搜索引擎的第几页、第几条，
//                所以将页号和排序信息放入后续的CrawlDatum中，为了能够区分外链和
//                搜索引擎结果页面，我们将其pageType设置为outlink，这里的值完全由
//                用户定义，可以设置一个任意的值
//
//                在经典爬虫中，每个网页都有一个refer信息，表示当前网页的链接来源。
//                例如我们首先访问新浪首页，然后从新浪首页中解析出了新的新闻链接，
//                则这些网页的refer值都是新浪首页。WebCollector不直接保存refer值，
//                但我们可以通过下面的方式，将refer信息保存在metaData中，达到同样的效果。
//                经典爬虫中锚文本的存储也可以通过下面方式实现。
//
//                在一些需求中，希望得到当前页面在遍历树中的深度，利用metaData很容易实现
//                这个功能，在将CrawlDatum添加到next中时，将其depth设置为当前访问页面
//                的depth+1即可。
//                */
//                CrawlDatum datum = new CrawlDatum(result.attr("abs:href"))
//                        .meta("keyword", keyword)
//                        .meta("pageNum", pageNum + "")
//                        .meta("rank", rank + "")
//                        .meta("pageType", "outlink")
//                        .meta("depth", (depth + 1) + "")
//                        .meta("refer", page.getUrl());
//                if (depth == 1) {
//                    next.add(datum);
//                } else {
//                    Matcher m = p.matcher(page.getUrl());
//                    if (m.matches()) {
//                        next.add(datum);
//                    }
//                }
//            }
//
//        } else if (pageType.equals("outlink")) {
//            int pageNum = Integer.valueOf(page.getMetaData("pageNum"));
//            int rank = Integer.valueOf(page.getMetaData("rank"));
//            String refer = page.getMetaData("refer");
//
////            String line = String.format("第%s页第%s个结果:%s(%s字节)\tdepth=%s\trefer=%s\turl=%s",
////                    pageNum, rank + 1, page.getDoc().title(), page.getContent().length, depth, refer, page.getUrl());
//            ;
//            Matcher m = p.matcher(page.getUrl());
//            if (m.matches()) {
//                System.out.println(page.getUrl());
//                crawlerCallBack.onValidateUrl(page.getUrl());
//            }
//
//        }
//    }





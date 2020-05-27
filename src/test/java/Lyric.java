import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 *
 * In pom.xml, I add the HtmlUnit dependency, a Java headless browser
 * which will allow me to perform HTTP requests on a website and parse
 * the HTML content.
 *
 * */

public class Lyric {
  public static void main(String[] args) throws IOException {

    String searchQuery = "Iphone 6s" ;

    WebClient client = new WebClient();
    client.getOptions().setCssEnabled(false);
    client.getOptions().setJavaScriptEnabled(false);
    try {
      String searchUrl = "https://newyork.craigslist.org/search/sss?sort=rel&query=" + URLEncoder.encode(searchQuery, "UTF-8");
      HtmlPage page = client.getPage(searchUrl);
    }catch(Exception e){
      e.printStackTrace();
    }

  List<HtmlElement> items = (List<HtmlElement>) page.getByXPath("//li[@class='result-row']") ;
if(items.isEmpty()){
    System.out.println("No items found !");
  }else{
    for(HtmlElement item : items){
      HtmlAnchor itemAnchor = ((HtmlAnchor) htmlItem.getFirstByXPath(".//p[@class='result-info']/a"));

      HtmlElement spanPrice = ((HtmlElement) htmlItem.getFirstByXPath(".//a/span[@class='result-price']")) ;

      String itemName = itemAnchor.asText();
      String itemUrl =  itemAnchor.getHrefAttribute();

      // It is possible that an item doesn't have any price
      String itemPrice = spanPrice == null ? "0.0" : spanPrice.asText() ;

      System.out.println( String.format("Name : %s Url : %s Price : %s", itemName, itemPrice, itemUrl));
    }
  }




    /*__________________________________________________________________________________________________________________________________________________
    /***
    String baseURL = "https://news.ycombinator.com/";

    //create web client to make a request
    WebClient client = new WebClient();
    client.getOptions().setCssEnabled(false);
    //disable javascript to make page run faster
    client.getOptions().setJavaScriptEnabled(false);

    //GET request to URL and print html content received from server
    try {
      //HtmlPage object contains HTML code
      HtmlPage page = client.getPage(baseURL);
      //asXml() method is used to access the HTML code
      System.out.println(page.asXml());
    } catch (Exception e) {
      e.printStackTrace();
    }

  /**
   * On the website when you inspect elements, you find that
   * there are HTML tags, with the HtmlUnit, this gives us several
   * options of tags to chose from
   *   - getHtmlElementById(String id)
   *   - getFirstByXPath(String Xpath)
   *   - getByXPath(String XPath) which returns a List
   *   - Many more can be found in the HtmlUnit Documentation
   *
   *  Since there is no ID to use, an Xpath expression
   *  can be used to select wanted tags.*/
/*
  HtmlPage page = client.getPage(baseURL);
    List<HtmlElement> itemList = page.getByXPath("//tr[@class='athing']");
    if(itemList.isEmpty()){
      System.out.println("No Item Found");
    } else{
      for(HtmlElement htmlItem : itemList){
        int position = Integer.parseInt(((HtmlElement)htmlItem.getFirstByXPath
                ("./td/span")).asText().replace(".",""));

        int id = Integer.parseInt(htmlItem.getAttribute("id"));

        String title = ((HtmlElement) htmlItem.getFirstByXPath("./td[not(@valign='top')][@class='title']"))
                .asText();

        String url = ((HtmlAnchor) htmlItem.getFirstByXPath("./td[not(@valign='top')][@class='title']/a"))
                .getHrefAttribute();

        String author = ((HtmlElement) htmlItem
                .getFirstByXPath("./followingsibling::tr/td[@class='subtext']/a[@class='hnuser']")).asText();

        int score = Integer.parseInt(
                ((HtmlElement) htmlItem.getFirstByXPath
                        ("./followingsibling::tr/td[@class='subtext']/span[@class='score']"))
                        .asText().replace(" points", ""));

        WebsiteObject hnItem = new WebsiteObject(title,
                url, author, score, position, id);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString =
                mapper.writeValueAsString(hnItem) ;
        System.out.println(jsonString);
      }
    }

      */}
}

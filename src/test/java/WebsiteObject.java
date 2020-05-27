public class WebsiteObject {
  private String title, url, author;
  private int score, position, id;

  public WebsiteObject(String title, String url, String author,
                       int score, int position, int id){
    super();
    this.title = title;
    this.url = url;
    this.author = author;
    this.score = score;
    this.position = position;
    this.id = id;
  }


  /**getters*/
  public String getTitle(){
    return title;
  }
  public String getUrl(){
    return url;
  }
  public String getAuthor(){
    return author;
  }
  public int getScore(){
    return score;
  }
  public int getPosition(){
    return position;
  }
  public int getId(){
    return id;
  }


  /**setter*/
  public void setTitle(String Title){
    title = Title;
  }
  public void setUrl(String URL){
    url = URL;
  }
  public void setAuthor(String Author){
    author = Author;
  }
  public void setScore(int Score){
    score = Score;
  }
  public void setPosition(int Position){
    position = Position;
  }
  public void setId(int ID){
    id = ID;
  }
}

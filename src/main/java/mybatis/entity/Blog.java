package mybatis.entity;

/**
 * Created by rod bate on 2016/1/21.
 */
public class Blog {

    private Integer id;
    private String titleS;
    private String content;
    private Author author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleS() {
        return titleS;
    }

    public void setTitleS(String titleS) {
        this.titleS = titleS;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}

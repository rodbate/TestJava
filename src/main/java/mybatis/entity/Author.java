package mybatis.entity;

import java.util.Set;

/**
 * Created by rod bate on 2016/1/22.
 */
public class Author {

    private Integer id;
    private String name;
    private Set<Blog> blogs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }

    public String displayBlogs(){
        StringBuilder sb = new StringBuilder();
        for (Blog b : blogs) {
            sb.append("{"+b.getId() + ", " +b.getTitleS()+ ", " + b.getContent()+"} \n");
        }
        return sb.toString();
    }
}

package mybatis;

import mybatis.entity.Blog;
import mybatis.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by rod bate on 2016/1/21.
 */
public class Test {

    public static void main(String[] args) throws IOException {

        String resource = "cfg.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = null;

        try{
            sqlSession = sqlSessionFactory.openSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = mapper.selectBlog(1);
            System.out.println(blog.getContent());
        } finally {
            sqlSession.close();
        }
    }
}

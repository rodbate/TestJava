package mybatis;

import mybatis.entity.Author;
import mybatis.entity.Blog;
import mybatis.mapper.AuthorMapper;
import mybatis.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by rod bate on 2016/1/22.
 */
public class MapperTest {

    private SqlSessionFactory factory;
    private Logger _log = Logger.getLogger(MapperTest.class);

    @Before
    public void setUp() throws IOException {
        factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("cfg.xml"));
    }

    @Test
    public void testSelect(){
        SqlSession session = null;
        try {
            session = factory.openSession();
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = mapper.selectBlog(9);
            _log.info("--------------" + blog.getContent() + " author: " + blog.getAuthor().getName() + blog.getAuthor().getBlogs());
            //assertTrue("mybatis".equals(mapper.selectBlog(4).getTitleS()));
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void testSelectAuthor(){
        SqlSession session = null;
        try {
            session = factory.openSession();
            AuthorMapper mapper = session.getMapper(AuthorMapper.class);
            Author blog = mapper.findById(1);
            _log.info("--------------" + blog.getName() + blog.displayBlogs());
            //assertTrue("mybatis".equals(mapper.selectBlog(4).getTitleS()));
            for(Blog b : blog.getBlogs()){
                _log.info(b.getId() + b.getContent());
            }
            //_log.info(blog.getBlogs().);
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /*@Test
    public void testCreate(){
        SqlSession session = null;
        try {
            session = factory.openSession();
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = new Blog();
            blog.setTitle("mybatis");
            blog.setContent("mybatis");
            int id = mapper.create(blog);
            _log.info("----------------" + id);
            session.commit();
            assertTrue("bbbb".equals(mapper.selectBlog(1).getContent()));
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void testUpdate(){
        SqlSession session = null;
        try {
            session = factory.openSession();
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = new Blog();
            blog.setId(4);
            blog.setTitle("mybatis");
            //blog.setContent("mybatis");
            int id = mapper.update(blog);
            assertEquals(1, id);
            _log.info("----------------" + id);
            session.commit();
            assertNull(mapper.selectBlog(4).getContent());
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }*/

    @Test
    public void testDelete(){
        SqlSession session = null;
        try {
            session = factory.openSession();
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            int id = mapper.deleteById(1);
            session.commit();
            assertEquals(1, id);
            assertEquals(null,mapper.selectBlog(1));
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

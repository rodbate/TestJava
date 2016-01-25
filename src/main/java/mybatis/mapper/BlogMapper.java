package mybatis.mapper;

import mybatis.entity.Blog;
import org.apache.ibatis.annotations.Select;

/**
 * Created by rod bate on 2016/1/21.
 */
public interface BlogMapper {
    //@Select("select * from t_blog where id = #{id}")
    Blog selectBlog(int id);

    int create(Blog blog);

    int deleteById(int id);

    int update(Blog blog);
}

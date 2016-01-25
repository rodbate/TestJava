package mybatis.mapper;

import mybatis.entity.Author;

/**
 * Created by rod bate on 2016/1/22.
 */
public interface AuthorMapper {

    Author findById(int id);
}

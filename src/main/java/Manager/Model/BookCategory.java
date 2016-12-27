package Manager.Model;

import Manager.ORMInterface;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by Iron on 2016/12/27.
 */
public class BookCategory {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<BookCategory> selectCategories() {
        try(SqlSession session = ORMInterface.getSession()) {
            BookCategoryMapper mapper = session.getMapper(BookCategoryMapper.class);
            return mapper.selectAllBookCategory();
        }
    }
}

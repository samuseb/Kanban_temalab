package Repository;

import Model.Category;

import java.util.List;

public interface CategoryRepository {

    public Category save(Category category);

    public void delete(Category task);

    public List findByName(String name);
}

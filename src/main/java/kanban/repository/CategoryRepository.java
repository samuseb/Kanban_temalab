package kanban.repository;

import kanban.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Category save(Category category);

    public void delete(Category task);

    public List<Category> findByName(String name);

    Category findFirstByName(String name);
}

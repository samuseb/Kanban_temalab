package kanban.Repository;

import kanban.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    public Task save(Task task);

    public void delete(Task task);

    public List findByName(String name);
}

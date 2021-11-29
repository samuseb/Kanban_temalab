package kanban.repository;

import kanban.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    public Project save(Project project);

    public void delete(Project project);

    public List<Project> findByName(String name);
}

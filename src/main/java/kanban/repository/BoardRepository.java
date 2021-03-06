package kanban.repository;

import kanban.model.Board;
import kanban.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    public Board save(Board board);

    public void delete(Board board);

    public List<Board> findByTitle(String title);

    public Board findFirstByTitle(String title);

    public List<Board> findByProjectId(long id);
}
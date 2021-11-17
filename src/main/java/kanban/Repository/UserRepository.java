package kanban.Repository;

import kanban.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findFirstByName(String name);
}

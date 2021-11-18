package kanban.repository;

import kanban.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findFirstByName(String name);
}

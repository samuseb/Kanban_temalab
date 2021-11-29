package kanban.repository;

import kanban.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long> {

    public Ad save(Ad ad);

    public void delete(Ad ad);

    public List<Ad> findByName(String name);
}

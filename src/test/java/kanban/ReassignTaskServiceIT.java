package kanban;


import kanban.repository.TaskRepository;
import kanban.repository.UserRepository;
import kanban.service.ReassignTaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase
public class ReassignTaskServiceIT {

    @Autowired
    ReassignTaskService reassignTaskService;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void init() {
        taskRepository.deleteAll();
        userRepository.deleteAll();
    }


    @Test
    public void testReassignTask(){
        //TODO
    }



}

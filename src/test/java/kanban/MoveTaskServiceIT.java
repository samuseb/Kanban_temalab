package kanban;

import kanban.repository.BoardRepository;
import kanban.repository.TaskRepository;
import kanban.service.MoveTaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@AutoConfigureTestDatabase
public class MoveTaskServiceIT {


    @Autowired
    MoveTaskService moveTaskService;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    BoardRepository boardRepository;

    @BeforeEach
    public void init() {
        taskRepository.deleteAll();
        boardRepository.deleteAll();
    }


    @Test
    public void testMoveTask(){
        //TODO
    }
}

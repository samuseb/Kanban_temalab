package kanban;

import kanban.Repository.BoardRepository;
import kanban.Repository.TaskRepository;
import kanban.Service.MoveTaskService;
import kanban.Service.ReassignTaskService;
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

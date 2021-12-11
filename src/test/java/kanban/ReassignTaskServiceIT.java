package kanban;


import kanban.model.Board;
import kanban.model.Category;
import kanban.model.Task;
import kanban.model.User;
import kanban.repository.BoardRepository;
import kanban.repository.CategoryRepository;
import kanban.repository.TaskRepository;
import kanban.repository.UserRepository;
import kanban.service.ReassignTaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase
public class ReassignTaskServiceIT {

    @Autowired
    ReassignTaskService reassignTaskService;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BoardRepository boardRepository;

    @BeforeEach
    public void init() {
        taskRepository.deleteAll();
        userRepository.deleteAll();
    }


    @Test
    public void testReassignTask(){

        //ARRANGE
        User user = new User("Dummy User");
        userRepository.save(user);

        Category category = new Category("Dummy Category");
        categoryRepository.save(category);

        Board board = new Board("Dummy Board");
        boardRepository.save(board);

        Task task = new Task("Dummy Task", "Dummy description", category, board);
        taskRepository.save(task);


        //ACT
        reassignTaskService.reassignTaskToAnotherUser(task.getId(), user.getName());


        //ASSERT
        List<Task> tasksFromDb = taskRepository.findByName(task.getName());
        User userFromDb = userRepository.findFirstByName(user.getName());
        assertThat(tasksFromDb.get(0).getUser().getName()).isEqualTo(userFromDb.getName());



    }



}

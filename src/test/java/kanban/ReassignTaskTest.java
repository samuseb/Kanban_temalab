package kanban;


import kanban.Model.Board;
import kanban.Model.Category;
import kanban.Model.Task;
import kanban.Model.User;
import kanban.Repository.TaskRepository;
import kanban.Repository.UserRepository;
import kanban.Service.ReassignTaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ReassignTaskTest {

    @InjectMocks
    ReassignTaskService reassignTaskService;

    @Mock
    TaskRepository taskRepository;

    @Mock
    UserRepository userRepository;

    @Test
    public void testReassignTask(){

        //ARRANGE
        User user = new User("Dummy user");
        Category category = new Category("Dummy Category");
        Board board = new Board("Dummy Board");
        Task task = new Task("Dummy Task", "Dummy description", category, board);
        category.addTask(task);
        board.addTask(task);

        //ACT
        reassignTaskService.reassignTaskToAnotherUser(task.getName(), user.getName());


        //ASSERT
        assertThat(task.getUser()).isEqualTo(user);



    }



}

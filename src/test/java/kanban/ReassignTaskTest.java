package kanban;


import kanban.model.Board;
import kanban.model.Category;
import kanban.model.Task;
import kanban.model.User;
import kanban.repository.TaskRepository;
import kanban.repository.UserRepository;
import kanban.service.ReassignTaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

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
        when(taskRepository.findByName(task.getName())).thenReturn(Arrays.asList(task));
        when(userRepository.findFirstByName(user.getName())).thenReturn(user);


        //ACT
        reassignTaskService.reassignTaskToAnotherUser(task.getName(), user.getName());


        //ASSERT
        assertThat(task.getUser()).isEqualTo(user);



    }



}

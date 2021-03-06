package kanban;


import kanban.model.Board;
import kanban.model.Category;
import kanban.model.Task;
import kanban.repository.BoardRepository;
import kanban.repository.TaskRepository;
import kanban.service.MoveTaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MoveTaskTest {

    @InjectMocks
    MoveTaskService moveTaskService;

    @Mock
    TaskRepository taskRepository;

    @Mock
    BoardRepository boardRepository;


    @Test
    public void testMoveTask(){

        //ARRANGE
        Board board1 = new Board("Dummy Board 1");
        Board board2 = new Board("Dummy Board 2");
        Category category = new Category("Dummy Category");
        Task task = new Task("Dummy Task", "Dummy description", category, board1);
        task.setId(0L);
        when(taskRepository.findById(task.getId())).thenReturn(java.util.Optional.of(task));
        when(boardRepository.findFirstByTitle(board2.getTitle())).thenReturn(board2);

        //ACT
        moveTaskService.moveTaskToAnotherBoard(task.getId(), board2.getTitle());


        //ASSERT
        assertThat(task.getBoard()).isEqualTo(board2);
    }

}

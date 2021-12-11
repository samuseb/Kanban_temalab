package kanban;

import kanban.model.Board;
import kanban.model.Category;
import kanban.model.Task;
import kanban.repository.BoardRepository;
import kanban.repository.CategoryRepository;
import kanban.repository.TaskRepository;
import kanban.service.MoveTaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@AutoConfigureTestDatabase
public class MoveTaskServiceIT {


    @Autowired
    MoveTaskService moveTaskService;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @BeforeEach
    public void init() {
        taskRepository.deleteAll();
        boardRepository.deleteAll();
    }


    @Test
    public void testMoveTask(){
        //ARRANGE
        Board board1 = new Board("Dummy Board 1");
        boardRepository.save(board1);
        Board board2 = new Board("Dummy Board 2");
        boardRepository.save(board2);

        Category category = new Category("Dummy category");
        categoryRepository.save(category);

        Task task = new Task("Dummy task", "Dummy description", category, board1);
        taskRepository.save(task);


        //ACT
        moveTaskService.moveTaskToAnotherBoard(task.getId(), board2.getTitle());


        //ASSERT
        List<Task> tasksFromDb = taskRepository.findByName(task.getName());
        Board boardFromDb = boardRepository.findFirstByTitle(board2.getTitle());

        assertThat(tasksFromDb.get(0).getBoard().getTitle()).isEqualTo(boardFromDb.getTitle());

    }
}

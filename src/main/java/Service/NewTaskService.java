package Service;


import Model.Board;
import Model.Category;
import Model.Task;
import Repository.BoardRepository;
import Repository.CategoryRepository;
import Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewTaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void CreateNewTask(String name, String description, String categoryName, String boardTitle){

        Category category = categoryRepository.findFirstByName(categoryName);
        Board board = boardRepository.findFirstByTitle(boardTitle);



        Task task = new Task(name, description, category, board);
        Task savedTask = taskRepository.save(task);

        category.addTask(savedTask);
        board.addTask(savedTask);

        categoryRepository.save(category);
        boardRepository.save(board);

    }

}

package kanban.Service;


import kanban.Model.*;
import kanban.Repository.*;
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

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void CreateNewTask(String name, String description, String categoryName, String boardTitle, String userName){

        Category category = categoryRepository.findFirstByName(categoryName);
        Board board = boardRepository.findFirstByTitle(boardTitle);
        User user = userRepository.findFirstByName(userName);



        Task task = new Task(name, description, category, board, user);
        Task savedTask = taskRepository.save(task);

        category.addTask(savedTask);
        board.addTask(savedTask);

        categoryRepository.save(category);
        boardRepository.save(board);

    }

}

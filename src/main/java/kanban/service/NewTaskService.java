package kanban.service;

import kanban.model.*;
import kanban.repository.*;
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
    public void createNewTask(String name, String description, String categoryName, String boardTitle, String userName){
        Category category = categoryRepository.findFirstByName(categoryName);
        Board board = boardRepository.findFirstByTitle(boardTitle);
        User user = userRepository.findFirstByName(userName);

        Task task = new Task(name, description, category, board, user);
    }
}

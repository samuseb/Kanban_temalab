package kanban.Service;


import kanban.Model.Board;
import kanban.Model.Category;
import kanban.Model.Task;
import kanban.Repository.BoardRepository;
import kanban.Repository.CategoryRepository;
import kanban.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeleteTaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    CategoryRepository categoryRepository;


    @Transactional
    public void DeleteTask(String taskName){

        List<Task> tasks = taskRepository.findByName(taskName);

        for (Task task: tasks){
            Board board = boardRepository.findFirstByTitle(task.getBoard().getTitle());
            Category category = categoryRepository.findFirstByName(task.getCategory().getName());

            board.removeTask(task);
            category.removeTask(task);
            taskRepository.delete(task);
        }
    }



}

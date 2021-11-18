package kanban.service;


import kanban.model.Board;
import kanban.model.Category;
import kanban.model.Task;
import kanban.repository.BoardRepository;
import kanban.repository.CategoryRepository;
import kanban.repository.TaskRepository;
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
    public void deleteTask(String taskName){

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

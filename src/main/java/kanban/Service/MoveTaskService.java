package kanban.Service;


import kanban.Model.Board;
import kanban.Model.Task;
import kanban.Repository.BoardRepository;
import kanban.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MoveTaskService {


    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void moveTaskToAnotherBoard(String taskName, String boardTitle){
        List<Task> tasks = taskRepository.findByName(taskName);
        Board board = boardRepository.findFirstByTitle(boardTitle);

        for (Task task: tasks) {
            task.setBoard(board);
            board.addTask(task);
            taskRepository.save(task);
            boardRepository.save(board);
        }
    }



}
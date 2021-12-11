package kanban.service;


import kanban.model.Board;
import kanban.model.Task;
import kanban.repository.BoardRepository;
import kanban.repository.TaskRepository;
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
    public void moveTaskToAnotherBoard(long taskId, String boardTitle){
        Task task = taskRepository.findById(taskId).get();
        Board board = boardRepository.findFirstByTitle(boardTitle);

        board.addTask(task);
    }



}

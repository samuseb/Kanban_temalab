package kanban.service;

import kanban.model.*;
import kanban.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReassignTaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void reassignTaskToAnotherUser(long taskId, String userName){
        Task task = taskRepository.findById(taskId).get();
        User user = userRepository.findFirstByName(userName);

        user.addTask(task);
    }
}

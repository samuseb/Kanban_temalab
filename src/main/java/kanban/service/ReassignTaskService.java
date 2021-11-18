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
    public void reassignTaskToAnotherUser(String taskName, String userName){
        List<Task> tasks = taskRepository.findByName(taskName);
        User user = userRepository.findFirstByName(userName);

        for (Task task: tasks) {
            user.addTask(task);
        }
    }


}

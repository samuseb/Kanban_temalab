package kanban.Service;


import kanban.Model.*;
import kanban.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
            task.setUser(user);
            user.addTask(task);
            taskRepository.save(task);
            userRepository.save(user);
        }
    }


}

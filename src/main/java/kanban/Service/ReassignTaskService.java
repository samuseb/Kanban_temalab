package kanban.Service;


import kanban.Model.Task;
import kanban.Model.User;
import kanban.Repository.TaskRepository;
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
            task.setAssignedTo(user);
            user.addTask(task);
            taskRepository.save(task);
            userRepository.save(user);
        }
    }


}

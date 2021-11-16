package Service;


import Model.Task;
import Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
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
        //TODO
    }


}

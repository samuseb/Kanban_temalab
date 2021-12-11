package kanban.web;


import kanban.model.Board;
import kanban.model.Project;
import kanban.model.Task;
import kanban.model.User;
import kanban.repository.BoardRepository;
import kanban.repository.TaskRepository;
import kanban.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ModifyTaskController {


    @Autowired
    TaskRepository taskRepository;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/task/modify/{id}")
    public String taskModification(@PathVariable("id") long id, Map<String, Object> model){

        Task task = taskRepository.findById(id).get();
        model.put("task", task);

        List<Board> boardList = boardRepository.findByProjectId(task.getBoardsProjectId());
        model.put("boards", boardList);

        List<User> usersList = userRepository.findAll();
        model.put("users", usersList);

        return ("modifyTaskPage");
    }


    @PostMapping("/modifyTask/{id}")
    public String modifyTask(@PathVariable("id") long id,Task helperTask){

        Task task = taskRepository.findById(id).get();
        task.setBoard(helperTask.getBoard());
        task.setUser(helperTask.getUser());
        task.setName(helperTask.getName());
        task.setDescription(helperTask.getDescription());
        taskRepository.save(task);

        return "redirect:/project/" + task.getBoardsProjectId();

    }


}

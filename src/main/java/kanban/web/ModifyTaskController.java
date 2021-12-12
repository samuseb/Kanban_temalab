package kanban.web;

import kanban.model.*;
import kanban.repository.BoardRepository;
import kanban.repository.CategoryRepository;
import kanban.repository.TaskRepository;
import kanban.repository.UserRepository;
import kanban.service.MoveTaskService;
import kanban.service.ReassignTaskService;
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

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/task/modify/{id}")
    public String taskModification(@PathVariable("id") long id, Map<String, Object> model){

        Task task = taskRepository.findById(id).get();
        model.put("task", task);

        List<Board> boardList = boardRepository.findByProjectId(task.getBoardsProjectId());
        model.put("boards", boardList);

        List<User> usersList = userRepository.findAll();
        model.put("users", usersList);

        List<Category> categoriesList = categoryRepository.findAll();
        model.put("categories", categoriesList);

        return ("modifyTaskPage");
    }

    @PostMapping("/modifyTask/{id}")
    public String modifyTask(@PathVariable("id") long id,Task helperTask){

        Task task = taskRepository.findById(id).get();

        task.setBoard(helperTask.getBoard());
        task.setUser(helperTask.getUser());
        task.setCategory(helperTask.getCategory());
        task.setName(helperTask.getName());
        task.setDescription(helperTask.getDescription());

        taskRepository.save(task);

        return "redirect:/project/" + task.getBoardsProjectId();
    }
}

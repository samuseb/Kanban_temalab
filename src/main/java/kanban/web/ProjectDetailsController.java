package kanban.web;

import kanban.model.*;
import kanban.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class ProjectDetailsController {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    private Project project;

    @GetMapping("/project/{id}")
    public String projectDetails(@PathVariable("id") long id, Map<String, Object> model){

        project = projectRepository.findById(id).get();
        List<Board> boardList = boardRepository.findByProjectId(project.getId());
        List<User> usersList = userRepository.findAll();
        List<Category> categoriesList = categoryRepository.findAll();

        model.put("project", project);
        model.put("boards", boardList);
        model.put("users", usersList);
        model.put("categories", categoriesList);
        model.put("board", new Board());
        model.put("task", new Task());

        return ("projectDetailsPage");
    }

    @GetMapping("/board/delete/{id}")
    public String deleteBoard(@PathVariable("id") long id, Map<String, Object> model){
        Board board = boardRepository.getById(id);
        List<Task> boardsTasks = taskRepository.findByBoardId(id);
        for(Task task: boardsTasks)
            taskRepository.delete(task);

        boardRepository.delete(board);

        return "redirect:/project/" + project.getId();
    }

    @GetMapping("/task/delete/{id}")
    public String deleteTask(@PathVariable("id") long id, Map<String, Object> model){
        Task task = taskRepository.getById(id);
        taskRepository.delete(task);

        return "redirect:/project/" + project.getId();
    }

    @PostMapping("/createBoard")
    public String createBoard(Board board){
        board.setProject(project);
        boardRepository.save(board);

        return "redirect:/project/" + project.getId();
    }

    @PostMapping("/createTask")
    public String createTask(Task task){
        taskRepository.save(task);

        return "redirect:/project/" + project.getId();
    }
}

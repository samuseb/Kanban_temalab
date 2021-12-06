package kanban.web;

import kanban.model.Board;
import kanban.model.Project;
import kanban.repository.BoardRepository;
import kanban.repository.ProjectRepository;
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

    private Project project;


    @GetMapping("/project/{id}")
    public String projectDetails(@PathVariable("id") long id, Map<String, Object> model){


        Project proj = projectRepository.findById(id).get();
        project = proj;
        model.put("project", project);

        List<Board> boardList = boardRepository.findByProjectId(project.getId());
        model.put("boards", boardList);

        model.put("board", new Board());

        return ("projectDetailsPage");

    }

    @PostMapping("/createBoard")
    public String createBoard(Board board){
        board.setProject(project);
        boardRepository.save(board);

        return "redirect:/project/" + project.getId();
    }



}

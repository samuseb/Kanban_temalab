package kanban.web;

import kanban.model.Project;
import kanban.repository.BoardRepository;
import kanban.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;
import java.util.Optional;


@Controller
public class ProjectDetailsController {


    @Autowired
    BoardRepository boardRepository;

    @Autowired
    ProjectRepository projectRepository;


    @GetMapping("/project/{id}")
    public String projectDetails(@PathVariable("id") long id, Map<String, Object> model){
        Project project = projectRepository.findById(id).get();
        model.put("project", project);

        return ("projectDetailsPage");

    }



}

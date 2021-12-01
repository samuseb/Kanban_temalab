package kanban.web;


import kanban.model.Project;
import kanban.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;




    @GetMapping("/")
    public String home(Map<String, Object> model) {
        List<Project> projects = projectRepository.findAll();
        model.put("projects", projects);
        model.put("project", new Project());

        return "projectPage";
    }

    @PostMapping("/createProject")
    public String createProject(Project project) {
        projectRepository.save(project);
        return "redirect:/";
    }


}

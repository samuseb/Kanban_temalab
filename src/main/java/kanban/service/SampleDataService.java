package kanban.service;


import kanban.model.*;
import kanban.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SampleDataService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    AdRepository adRepository;

    @Transactional
    public void addSampleData(){
        Project p1 = new Project("Project1");
        Project p2 = new Project("Project2");

        Project savedP1 = projectRepository.save(p1);
        Project savedP2 = projectRepository.save(p2);

        Board b1 = new Board("Board 1 on project1");
        Board b2 = new Board("Board 2 on project2");

        savedP1.addBoard(b1);
        savedP2.addBoard(b2);

        Board savedB1 = boardRepository.save(b1);
        Board savedB2 = boardRepository.save(b2);

        Category c1 = new Category("Category1");
        User u1 = new User("User1");

        Category savedC1 = categoryRepository.save(c1);
        User savedU1 = userRepository.save(u1);

        Task t1 = new Task("Task1 on Board1", "Description of task1", savedC1, savedB1, u1);
        Task t2 = new Task("Task2 on Board2", "Description of task2", savedC1, savedB2, u1);

        taskRepository.save(t1);
        taskRepository.save(t2);

    }


}

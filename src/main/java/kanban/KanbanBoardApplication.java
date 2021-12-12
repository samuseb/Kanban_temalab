package kanban;

import kanban.service.SampleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KanbanBoardApplication implements CommandLineRunner {

    @Autowired
    SampleDataService sampleDataService;

    public static void main(String[] args){
        SpringApplication.run(KanbanBoardApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        sampleDataService.addSampleData();
    }
}

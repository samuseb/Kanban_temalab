package kanban.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

    public User(String name){ this.name = name; }

    public void addTask(Task task){
        if (tasks == null){
            tasks = new ArrayList<Task>();
        }

        tasks.add(task);
        task.setUser(this);
    }
}

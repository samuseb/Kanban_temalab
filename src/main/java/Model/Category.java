package Model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Category {

    private long id;
    private String name;
    private List<Task> tasks;

    public Category(String name){ this.name = name; }

    public void addTask(Task task){
        if (tasks == null){
            tasks = new ArrayList<Task>();
        }

        tasks.add(task);
        task.setCategory(this);
    }

    public void removeTask(Task task){
        tasks.remove(task);
        task.setCategory(null);
    }
}

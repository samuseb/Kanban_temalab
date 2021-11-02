package Model;


import java.util.ArrayList;
import java.util.List;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Board {



    private long id;
    private String title;
    private List<Task> tasks;


    public Board(String title){ this.title = title; }



    public void addTask(Task task){
        if (tasks == null){
            tasks = new ArrayList<Task>();
        }

        tasks.add(task);
        task.setBoard(this);
    }

    public void removeTask(Task task){
        tasks.remove(task);
        task.setBoard(null);
    }



}

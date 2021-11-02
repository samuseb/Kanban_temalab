package Repository;

import Model.Task;

import java.util.List;

public interface TaskRepository {


    public Task save(Task task);

    public void delete(Task task);

    public List findByName(String name);


}

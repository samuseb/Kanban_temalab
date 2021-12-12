package kanban.web;

import kanban.model.User;
import kanban.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public String users(Map<String, Object> model) {
        List<User> users = userRepository.findAll();
        model.put("users", users);
        model.put("user", new User());

        return "usersPage";
    }

    @PostMapping("/createUser")
    public String createUser(User user) {
        userRepository.save(user);
        return "redirect:/users";
    }
}

package kanban.web;

import kanban.model.Category;
import kanban.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public String home(Map<String, Object> model) {
        List<Category> categories = categoryRepository.findAll();
        model.put("categories", categories);
        model.put("category", new Category());

        return "categoriesPage";
    }

    @PostMapping("/createCategory")
    public String createUser(Category category) {
        categoryRepository.save(category);
        return "redirect:/categories";
    }
}

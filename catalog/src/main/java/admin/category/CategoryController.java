package admin.category;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("category")
public class CategoryController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

}

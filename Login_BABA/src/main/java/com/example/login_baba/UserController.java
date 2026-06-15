package com.example.login_baba;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String login,
                        @RequestParam String password,
                        Model model) {
        User user = repository.findByLoginAndPassword(login, password);
        if (user != null) {
            return "redirect:/users";
        }
        model.addAttribute("error", "Login ou mot de passe incorrect");
        return "login";
    }

    @GetMapping("/users")
    public String list(Model model) {
        model.addAttribute("users", repository.findAll());
        return "users";
    }

    @GetMapping("/users/new")
    public String newForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @GetMapping("/users/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("user", repository.findById(id).orElseThrow());
        return "form";
    }

    @PostMapping("/users/save")
    public String save(@ModelAttribute User user) {
        repository.save(user);
        return "redirect:/users";
    }
    @GetMapping("/users/delete/{id}")
    public String delete(@PathVariable Integer id) {
        repository.deleteById(id);
        return "redirect:/users";
    }
}
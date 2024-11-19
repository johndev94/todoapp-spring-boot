package com.app.todoapp.controller;

import com.app.todoapp.models.Task;
import com.app.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping // Maps this method to the /tasks URL
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);

        return "tasks";
    }

    @PostMapping// Maps this method to the /tasks URL
    public String createTask(@RequestParam String title) {
        taskService.createTask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete") // Maps this method to the /tasks URL
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);

        return "redirect:/";
    }
    @GetMapping("/{id}/toggle") // Maps this method to the /tasks URL
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);

        return "redirect:/";
    }

}

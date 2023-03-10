package project_structure.servlets.tasks;

import project_structure.model.Task;
import project_structure.model.User;
import project_structure.service.TaskService;
import project_structure.service.UserService;
import project_structure.util.TaskUtils;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@WebServlet(urlPatterns = "/add-task")
public class AddTaskServlet extends HttpServlet {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private TaskService taskService;
    private UserService userService;

    @Override
    public void init() {
        this.taskService = (TaskService) getServletContext().getAttribute("taskService");
        this.userService = (UserService) getServletContext().getAttribute("userService");
    }


    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        Optional<User> optionalUserByUsername = userService.findByUsername(username);

        if (!TaskUtils.requestIsValid(request, optionalUserByUsername)){
            request.setAttribute("tasks", taskService.findAll());
            getServletContext().getRequestDispatcher("/WEB-INF/view/all-tasks-page.jsp").forward(request, response);
            return;
        }

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        LocalDate deadline_date = LocalDate.parse(request.getParameter("deadline_date"), formatter);
        boolean done = request.getParameter("done") != null;

        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadline_date(deadline_date);
        task.setDone(done);
        optionalUserByUsername.ifPresent(task::setExecutor);

        taskService.save(task);
        response.sendRedirect(request.getContextPath() + "/tasks-menu");
    }
}

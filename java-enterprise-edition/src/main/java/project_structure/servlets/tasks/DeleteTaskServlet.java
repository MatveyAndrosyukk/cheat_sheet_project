package project_structure.servlets.tasks;

import project_structure.service.TaskService;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/delete-task")
public class DeleteTaskServlet extends HttpServlet {
    private TaskService taskService;

    @Override
    public void init() {
        this.taskService = (TaskService) getServletContext().getAttribute("taskService");
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");

        taskService.deleteById(Long.parseLong(id));

        response.sendRedirect(request.getContextPath() + "/tasks-menu");
    }
}

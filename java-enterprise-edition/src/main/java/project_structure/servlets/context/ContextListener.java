package project_structure.servlets.context;

import project_structure.configuration.datasource.DataSourceMySQL;
import project_structure.configuration.sessionmanager.SessionManager;
import project_structure.configuration.sessionmanager.SessionManagerJDBC;
import project_structure.dao.TaskDAO;
import project_structure.dao.TaskDAOImpl;
import project_structure.dao.UserDAO;
import project_structure.dao.UserDAOImpl;
import project_structure.service.*;
import project_structure.service.rest_handlers.*;
import com.googlecode.flyway.core.Flyway;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class ContextListener implements ServletContextListener{
    private AuthenticationService authenticationService;
    private TaskService taskService;
    private UserService userService;
    private RestApiHandler restApiGetHandlerService;
    private RestApiHandler restApiPostHandlerService;
    private RestApiHandler restApiDeleteHandlerService;
    private RestApiHandler restApiPutHandlerService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final ServletContext servletContext = sce.getServletContext();

        DataSource dataSource = DataSourceMySQL.getDataSource();
        SessionManager sessionManager = new SessionManagerJDBC(dataSource);
        UserDAO userDAO = new UserDAOImpl(sessionManager);
        TaskDAO taskDAO = new TaskDAOImpl(sessionManager);
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.migrate();
        this.authenticationService = new AuthenticationServiceImpl(userDAO);
        this.taskService = new TaskServiceImpl(taskDAO);
        this.userService = new UserServiceImpl(userDAO);
        this.restApiGetHandlerService = new RestApiGetHandlerService(taskDAO, userDAO);
        this.restApiPostHandlerService = new RestApiPostHandlerService(taskDAO, userDAO);
        this.restApiPutHandlerService = new RestApiPutHandlerService(taskDAO, userDAO);
        this.restApiDeleteHandlerService = new RestApiDeleteHandlerService(taskDAO);


        servletContext.setAttribute("authenticationService", authenticationService);
        servletContext.setAttribute("taskService", taskService);
        servletContext.setAttribute("userService", userService);
        servletContext.setAttribute("restApiGetHandlerService", restApiGetHandlerService);
        servletContext.setAttribute("restApiPostHandlerService", restApiPostHandlerService);
        servletContext.setAttribute("restApiPutHandlerService", restApiPutHandlerService);
        servletContext.setAttribute("restApiDeleteHandlerService", restApiDeleteHandlerService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        this.authenticationService = null;
        this.taskService = null;
        this.userService = null;
        this.restApiGetHandlerService=null;
        this.restApiPostHandlerService=null;
        this.restApiPutHandlerService=null;
        this.restApiDeleteHandlerService=null;
    }
}

package project_structure.service;

import project_structure.model.Task;
import project_structure.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    void save(Task task) throws SQLException;

    Optional<Task> findById(Long id) throws SQLException;

    void update(Task task) throws SQLException;

    List<Task> findAll() throws SQLException;

    void deleteById(Long id) throws SQLException;

    List<Task> findByExecutor(User user) throws SQLException;
}

package project_structure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_structure.model.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}

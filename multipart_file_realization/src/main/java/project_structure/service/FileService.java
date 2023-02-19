package project_structure.service;

import org.springframework.web.multipart.MultipartFile;
import project_structure.dto.FileResponse;
import project_structure.model.File;

public interface FileService {
    File save(MultipartFile file);

    File findById(Long id);

    FileResponse generateFileResponse(MultipartFile multipartFile);
}

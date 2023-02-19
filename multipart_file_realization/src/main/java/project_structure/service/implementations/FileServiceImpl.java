package project_structure.service.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import project_structure.dto.FileResponse;
import project_structure.model.File;
import project_structure.repository.FileRepository;
import project_structure.service.FileService;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final FileRepository fileRepository;

    @Override
    public File save(MultipartFile multipartFile) {
        File file;
        try {
            file = File.builder()
                    .fileName(multipartFile.getOriginalFilename())
                    .fileType(multipartFile.getContentType())
                    .fileSize(multipartFile.getSize())
                    .content(multipartFile.getBytes())
                    .build();
        } catch (IOException e) {
            throw new MultipartException("Could not save file: " + multipartFile.getOriginalFilename() + " for some reason");
        }

        return fileRepository.save(file);
    }

    @Override
    public File findById(Long id) {
        return fileRepository.findById(id)
                .orElseThrow(() -> new MultipartException("File was not found"));
    }

    @Override
    public FileResponse generateFileResponse(MultipartFile multipartFile) {
        File file = save(multipartFile);

        String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/file/download/")
                .path(file.getId().toString())
                .toUriString();

        return FileResponse.builder()
                .fileName(file.getFileName())
                .fileType(file.getFileType())
                .fileSize(file.getFileSize())
                .downloadUrl(downloadURL)
                .build();
    }
}

package project_structure.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project_structure.dto.FileResponse;
import project_structure.model.File;
import project_structure.service.FileService;

@RestController
@RequestMapping("/api/file/")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @GetMapping("download/{id}")
    public ResponseEntity<Resource> handleDownloadFile(@PathVariable Long id){
        File file = fileService.findById(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.getFileName() + "\"")
                .body(new ByteArrayResource(file.getContent()));

    }

    @PostMapping("upload")
    public ResponseEntity<FileResponse> handleUploadFile(@RequestParam("file")MultipartFile multipartFile){
        FileResponse response = fileService.generateFileResponse(multipartFile);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}

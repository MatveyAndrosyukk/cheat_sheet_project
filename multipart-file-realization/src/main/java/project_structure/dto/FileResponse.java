package project_structure.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileResponse {
    private String fileName;

    private String fileType;

    private String downloadUrl;

    private long fileSize;
}

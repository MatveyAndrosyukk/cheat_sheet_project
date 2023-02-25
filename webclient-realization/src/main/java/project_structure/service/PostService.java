package project_structure.service;

import project_structure.dto.PostRequestDto;
import project_structure.dto.PostResponseDto;

public interface PostService {
    PostResponseDto findById(Long id);
    PostResponseDto save(PostRequestDto postRequestDto);
}

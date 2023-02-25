package project_structure.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_structure.dto.PostRequestDto;
import project_structure.dto.PostResponseDto;
import project_structure.service.PostService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    @GetMapping("{id}")
    public ResponseEntity<PostResponseDto> handleGetPostById(@PathVariable Long id){
        PostResponseDto response = postService.findById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<PostResponseDto> handleSavePost(@RequestBody PostRequestDto postRequestDto){
        PostResponseDto response = postService.save(postRequestDto);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}

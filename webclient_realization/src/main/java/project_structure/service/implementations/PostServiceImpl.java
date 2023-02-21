package project_structure.service.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import project_structure.dto.PostRequestDto;
import project_structure.dto.PostResponseDto;
import project_structure.service.PostService;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final WebClient webClient;

    @Override
    public PostResponseDto findById(Long id) {
        return webClient.get()
                .uri("https://jsonplaceholder.typicode.com/posts/" + id)
                .retrieve()
                .bodyToMono(PostResponseDto.class)
                .block();
    }

    @Override
    public PostResponseDto save(PostRequestDto postRequestDto) {
        return webClient.post()
                .uri("https://jsonplaceholder.typicode.com/posts")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(postRequestDto), PostRequestDto.class)
                .retrieve()
                .bodyToMono(PostResponseDto.class)
                .block();
    }
}

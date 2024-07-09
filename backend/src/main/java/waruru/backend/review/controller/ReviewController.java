package waruru.backend.review.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import waruru.backend.review.dto.ReviewRequestDTO;
import waruru.backend.review.dto.ReviewResponseDTO;
import waruru.backend.review.dto.ReviewUpdateRequestDTO;
import waruru.backend.review.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@Tag(name = "Review 관리", description = "매물 후기 관리를 위한 api")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    @Operation(summary = "새 매물 후기 등록", description = "[설명] /api/reviews 새 매물 후기 등록")
    public ResponseEntity<ReviewResponseDTO> createReview(@RequestBody ReviewRequestDTO reviewRequestDTO) {
        ReviewResponseDTO response = reviewService.createReview(reviewRequestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    @Operation(summary = "모든 매물 후기 조회하기", description = "[설명] /api/reviews/list 모든 매물 후기 조회하기")
    public ResponseEntity<List<ReviewResponseDTO>> getAllReviews() {
        List<ReviewResponseDTO> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @PutMapping("/update/{reviewNo}")
    @Operation(summary = "매물 후기 수정하기", description = "[설명] /api/reviews/update/{} 특정 매물 후기 수정하기")
    public ReviewResponseDTO updateReview(@PathVariable Long reviewNo, @RequestBody ReviewUpdateRequestDTO reviewUpdateRequestDTO) {
        return reviewService.updateReview(reviewNo, reviewUpdateRequestDTO);
    }
}

package waruru.backend.review.dto;

import lombok.Getter;
import lombok.Setter;
import waruru.backend.review.domain.Review;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReviewResponseDTO {

    private Long reviewNo;

    private Long userId;

    private Long saleNo;

    private String title;

    private String content;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;

    public ReviewResponseDTO(Review review) {
        this.userId = review.getUserNo().getId();
        this.saleNo = review.getSaleNo().getNo();
        this.title = review.getTitle();
        this.content = review.getContent();
        this.registerDate = review.getRegisterDate();
    }

}
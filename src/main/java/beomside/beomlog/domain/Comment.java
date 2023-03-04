package beomside.beomlog.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    private String content;
    private String nickname;

    @Column(name = "comment_date")
    private LocalDateTime commentDate;

    // 연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(mappedBy = "comment")
    private final List<CommentReply> commentReplies = new ArrayList<>();

    // 비즈니스 로직
    public void delete() {
        if (!commentReplies.isEmpty()) {
            content = "삭제된 댓글입니다.";
        }
    }
}

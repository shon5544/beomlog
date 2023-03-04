package beomside.beomlog.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "comment_reply")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentReply {

    @Id
    @GeneratedValue
    @Column(name = "comment_reply_id")
    private Long id;

    private String content;
    private String nickname;

    @Column(name = "comment_date")
    private LocalDateTime commentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;
}

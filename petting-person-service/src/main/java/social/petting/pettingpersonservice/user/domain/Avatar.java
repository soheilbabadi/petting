package social.petting.pettingpersonservice.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Avatar implements Serializable {
    @Serial
    private static final long serialVersionUID = -2058536936420515464L;
    @Id

    private String id;

    @Column(columnDefinition = "VARCHAR(200)", nullable = false)
    private String imageUrl;


    @Column(columnDefinition = "VARCHAR(200)", nullable = false, length = 200)
    private String originalFileName;

    private long originalFileSize;

    @Column(columnDefinition = "VARCHAR(10)", nullable = false, length = 10)
    private String originalFileExtension;

    @Column(columnDefinition = "VARCHAR(200)", nullable = false, length = 200)
    private String originalFileMimeType;


    @Lob
    private byte[] originalFile;

    private String username;
    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime modifiedOn;
}

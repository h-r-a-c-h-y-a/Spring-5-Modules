package am.gitc.entities;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Album implements Serializable {

    private Long id;
    private Long singerId;
    private String title;
    private LocalDate releaseDate;
}

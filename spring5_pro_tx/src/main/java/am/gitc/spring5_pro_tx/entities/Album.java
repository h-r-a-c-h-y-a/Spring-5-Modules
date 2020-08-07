package am.gitc.spring5_pro_tx.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name = "album",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"singer_id", "title"})
)
public class Album extends AbstractEntity {


    private String title;

    @Temporal(TemporalType.DATE)
    @Column(name = "release_date")
    private Date releaseDate;

    @ManyToOne
    @JoinColumn(name = "singer_id")
    private Singer singer;

    public Album(String title, Date releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + getId() +
                ", singerId=" + singer.getId() +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", version=" + getVersion() +
                '}';
    }
}

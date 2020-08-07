package am.gitc.spring5_pro_tx.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@NamedQueries({
        @NamedQuery(name = Singer.FIND_ALL,
        query = "select s from Singer s"),
        @NamedQuery(name = Singer.COUNT_ALL,
        query = "select count (s) from Singer s")
})
@SqlResultSetMapping(
        name = "singerResult",
        entities = @EntityResult(entityClass = Singer.class)
)
@Entity
@Table(name = "singer",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"first_name", "last_name"}) )
public class Singer extends AbstractEntity {

    public static final String FIND_ALL = "Singer.findAll";
    public static final String COUNT_ALL = "Singer.countAll";

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @OneToMany(
            mappedBy = "singer",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Album> albums = new HashSet<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public boolean addAlbum(Album album) {
        album.setSinger(this);
        return getAlbums().add(album);
    }

    public void removeAlbum(Album album) {
        getAlbums().remove(album);
    }

    @Override
    public String toString() {
        return "Singer{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", version=" + getVersion() +
                ", albums=" + albums +
                '}';
    }
}

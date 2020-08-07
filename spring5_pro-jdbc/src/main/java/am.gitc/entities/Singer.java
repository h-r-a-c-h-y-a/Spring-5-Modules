package am.gitc.entities;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class Singer implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Set<Album> albums;

    public Singer(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public boolean addAlbum(Album album) {
        if (albums == null) {
            albums = new HashSet<>();
            albums.add(album);
            return true;
        }
        albums.add(album);
        return true;
    }
}

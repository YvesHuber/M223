package ch.zli.m223.model;
import java.util.Set;
import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;


@Entity
@Table(name="USERS")
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(name="Username")
  private String username;

  @ManyToMany(mappedBy = "users")
  private Set<Entry> entries;

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * @return Set<Entry> return the entries
     */
    public Set<Entry> getEntries() {
        return entries;
    }

    /**
     * @param entries the entries to set
     */
    public void setEntries(Set<Entry> entries) {
        this.entries = entries;
    }

}
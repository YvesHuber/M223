package ch.zli.m223.model;
import javax.persistence.*;
import java.util.Set;
import org.eclipse.microprofile.openapi.annotations.media.Schema;


@Entity
@Table(name="TAG")
public class Tag {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(nullable = false)
  private String title;

  @ManyToMany(mappedBy = "tags")
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
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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

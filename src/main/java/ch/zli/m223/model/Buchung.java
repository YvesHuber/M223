package ch.zli.m223.model;
import javax.persistence.*;
import java.time.LocalDate;

import org.eclipse.microprofile.openapi.annotations.media.Schema;


@Entity
@Table(name="BUCHUNG")
public class Buchung {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(name="Visablility")
  private boolean visability;

  @Column(name="Status")
  private String status;

  @Column(name="Begründung")
  private String begründung;

  @Column(name="Datum")
  private LocalDate datum;

  @Column(name="Halbtag")
  private boolean halbtag;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;
 
    


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
     * @return boolean return the visability
     */
    public boolean isVisability() {
        return visability;
    }

    /**
     * @param visability the visability to set
     */
    public void setVisability(boolean visability) {
        this.visability = visability;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return String return the begründung
     */
    public String getBegründung() {
        return begründung;
    }

    /**
     * @param begründung the begründung to set
     */
    public void setBegründung(String begründung) {
        this.begründung = begründung;
    }

    /**
     * @return LocalDate return the datum
     */
    public LocalDate getDatum() {
        return datum;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    /**
     * @return boolean return the halbtag
     */
    public boolean isHalbtag() {
        return halbtag;
    }

    /**
     * @param halbtag the halbtag to set
     */
    public void setHalbtag(boolean halbtag) {
        this.halbtag = halbtag;
    }

    /**
     * @return User return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

}
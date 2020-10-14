package apap.tutorial.traveloke.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="review")
public class ReviewModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noReview;

    @NotNull
    @Size(max=10)
    @Column(name = "namaReviewerKamar", nullable = false)
    private String namaReviewerKamar;

    @NotNull
    @Size(max = 50)
    @Column(name = "isiReviewKamar",nullable = false)
    private String isiReviewKamar;

    @Size(max = 50)
    @Column(name = "saran", nullable = false)
    private String saran;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "noKamar",referencedColumnName = "noKamar",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private KamarModel kamar;

    public Long getNoReview() {
        return noReview;
    }

    public void setNoReview(Long noReview) {
        this.noReview = noReview;
    }

    public String getNamaReviewerKamar() {
        return namaReviewerKamar;
    }

    public void setNamaReviewerKamar(String namaReviewerKamar) {
        this.namaReviewerKamar = namaReviewerKamar;
    }

    public String getIsiReviewKamar() {
        return isiReviewKamar;
    }

    public void setIsiReviewKamar(String isiReviewKamar) {
        this.isiReviewKamar = isiReviewKamar;
    }

    public String getSaran() {
        return saran;
    }

    public void setSaran(String saran) {
        this.saran = saran;
    }

    public KamarModel getKamar() {
        return kamar;
    }

    public void setKamar(KamarModel kamar) {
        this.kamar = kamar;
    }
}
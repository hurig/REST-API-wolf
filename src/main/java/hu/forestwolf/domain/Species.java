package hu.forestwolf.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Species {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String family;
    @OneToMany(mappedBy = "species")
    @JsonIgnore
    private List<Forest> forests;

    public Species(int id, String name, String family) {
        this.id = id;
        this.name = name;
        this.family = family;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public List<Forest> getForests() {
        return forests;
    }

    public void setForests(List<Forest> forests) {
        this.forests = forests;
    }
}

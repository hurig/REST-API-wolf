package hu.forestwolf.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Country {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int territory;
    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<Forest> forests;

    public Country(int id, String name, int territory) {
        this.id = id;
        this.name = name;
        this.territory = territory;
    }

    public Country(String name, int territory) {
        this.name = name;
        this.territory = territory;
    }

    public Country() {
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

    public int getTerritory() {
        return territory;
    }

    public void setTerritory(int territory) {
        this.territory = territory;
    }
}

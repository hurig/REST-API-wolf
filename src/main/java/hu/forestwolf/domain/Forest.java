package hu.forestwolf.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Forest {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Species species;
    private int area;
    @ManyToOne
    private Country country;
    private int wolfs;

    public Forest(int id, Species species, int area, Country country, int wolfs) {
        this.id = id;
        this.species = species;
        this.area = area;
        this.country = country;
        this.wolfs = wolfs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getWolfs() {
        return wolfs;
    }

    public void setWolfs(int wolfs) {
        this.wolfs = wolfs;
    }
}

package javay.main.model;

import javax.persistence.*;

@Entity
public class Acount {

    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "branch_name")
    private String branchName;

    @Override
    public String toString() {
        return "Acount{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", branchName='" + branchName + '\'' +
                '}';
    }

    public Acount() {
    }

    public Acount(String name, String branchName) {
        this.name = name;
        this.id = id;
        this.branchName = branchName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}

package model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String name;

    @Column(name = "last_name")
    private String lastName;
    private String password;
    private String email;

    @Column(name = "date_of_registration")
    private Date dateOfRegistartion;

    @ManyToMany(mappedBy = "followedByUser")
    private Set<AppUser> followers = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "follower_followed",
            joinColumns = {@JoinColumn(name = "follower_id")},
            inverseJoinColumns = {@JoinColumn(name = "followed_id")})
    private Set<AppUser> followedByUser = new HashSet<>();


    public AppUser() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfRegistartion() {
        return dateOfRegistartion;
    }

    public void setDateOfRegistartion(Date dateOfRegistartion) {
        this.dateOfRegistartion = dateOfRegistartion;
    }

    public Set<AppUser> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<AppUser> followers) {
        this.followers = followers;
    }

    public Set<AppUser> getFollowings() {
        return followedByUser;
    }

    public void setFollowings(Set<AppUser> followedByUser) {
        this.followedByUser = followedByUser;
    }
}

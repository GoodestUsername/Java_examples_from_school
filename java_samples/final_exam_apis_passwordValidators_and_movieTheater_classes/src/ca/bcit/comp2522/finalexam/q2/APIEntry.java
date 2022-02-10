package ca.bcit.comp2522.finalexam.q2;

import java.util.Objects;

/**
 * API Entry Class to represent the JSON object
 *   Example:
 *     {
 *     "API": "Cat Facts",
 *     "Description": "Daily cat facts",
 *     "Auth": "",
 *     "HTTPS": true,
 *     "Cors": "no",
 *     "Link": "https://alexwohlbruck.github.io/cat-facts/",
 *     "Category": "Animals"
 *   }
 */
public class APIEntry {
    private String API;
    private String Description;
    private String Auth;
    private String HTTPS;
    private String Cors;
    private String Link;
    private String Category;

    public String getAPI() {
        return API;
    }

    public void setAPI(String API) {
        this.API = API;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAuth() {
        return Auth;
    }

    public void setAuth(String auth) {
        Auth = auth;
    }

    public String getHTTPS() {
        return HTTPS;
    }

    public void setHTTPS(String HTTPS) {
        this.HTTPS = HTTPS;
    }

    public String getCors() {
        return Cors;
    }

    public void setCors(String cors) {
        Cors = cors;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public APIEntry(String API, String description, String auth, String HTTPS, String cors, String link, String category) {
        this.API = API;
        Description = description;
        Auth = auth;
        this.HTTPS = HTTPS;
        Cors = cors;
        Link = link;
        Category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        APIEntry apiEntry = (APIEntry) o;
        return Objects.equals(API, apiEntry.API) &&
                Objects.equals(Description, apiEntry.Description) &&
                Objects.equals(Auth, apiEntry.Auth) &&
                Objects.equals(HTTPS, apiEntry.HTTPS) &&
                Objects.equals(Cors, apiEntry.Cors) &&
                Objects.equals(Link, apiEntry.Link) &&
                Objects.equals(Category, apiEntry.Category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(API, Description, Auth, HTTPS, Cors, Link, Category);
    }

    @Override
    public String toString() {
        return "APIEntry{" +
                "API='" + API + '\'' +
                ", Description='" + Description + '\'' +
                ", Auth='" + Auth + '\'' +
                ", HTTPS='" + HTTPS + '\'' +
                ", Cors='" + Cors + '\'' +
                ", Link='" + Link + '\'' +
                ", Category='" + Category + '\'' +
                '}';
    }
}

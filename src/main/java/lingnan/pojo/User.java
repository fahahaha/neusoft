package lingnan.pojo;

/**
 * @author whongf
 * @create 2020-05-22-20:25
 */
public class User {
    private Integer id;
    private String name;
    private  String xh;
    private  float score;
    public User() {

    }
    public User(Integer id, String name, String xh, float score) {
        this.id = id;
        this.name = name;
        this.xh = xh;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", xh='" + xh + '\'' +
                ", score=" + score +
                '}';
    }
}

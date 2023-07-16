import java.io.Serializable;

public class Cat implements Serializable {
    private String name;
    private Integer age;
    private transient Double weight;
    private static final long serialVersionUID = 10L;

    public Cat(String name, Integer age, Double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat " +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", weight = " + weight;
    }
}

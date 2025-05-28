package OCP_Revisit.IO_Java8.serialization;

import java.io.Serializable;

public class Animal implements Serializable {
    private static final long serialVersionUID = 2L;
    private String name;
    private int age = 10;
    private static char type = 'C';

    {
        this.age = 14;
    }

    /*
     * public Animal() {
     * this.name = "Unknown";
     * this.age = 12;
     * this.type = 'Q';
     * }
     */

    public Animal(String name, int age, char type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Animal [name=" + name + ", age=" + age + ", hashCode()=" + hashCode()
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        return true;
    }
    

}

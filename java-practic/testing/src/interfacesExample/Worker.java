package interfacesExample;

public abstract class Worker {
    private String name;


    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void voice() {
        System.out.println(getName());
    }
}

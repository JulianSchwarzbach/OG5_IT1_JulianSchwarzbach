package sortiererei;

public class Produkt {
    private final int id;
    private final String name;

    public Produkt(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

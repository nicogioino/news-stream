package resource;

public class LaNacionResource implements Resource{

    String label;
    String link;

    @Override
    public String link() {
        return link;
    }

    @Override
    public String label() {
        return label;
    }

    private LaNacionResource(String label, String link) {
        this.label = label;
        this.link = link;
    }

    public static LaNacionResource laNacionResource(String label, String link) {
        return new LaNacionResource(label,link);
    }

    @Override
    public String toString() {
        return "LaNacionResource{" +
                "label='" + label + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}

package resource;

public class ClarinResource implements Resource{

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

    private ClarinResource(String label, String link) {
        this.label = label;
        this.link = link;
    }

    public static ClarinResource clarinResource(String label, String link) {
        return new ClarinResource(label,link);
    }

    @Override
    public String toString() {
        return "ClarinResource{" +
                "label='" + label + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}

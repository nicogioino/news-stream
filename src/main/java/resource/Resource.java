package resource;

public interface Resource {
    default String id() { return this.link(); }
    String link();
    String label();
}

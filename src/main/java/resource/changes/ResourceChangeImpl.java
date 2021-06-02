package resource.changes;

import resource.Resource;

public class ResourceChangeImpl implements ResourceChange {

    private final Resource resource;

    private final ChangeType type;


    private ResourceChangeImpl(Resource resource, ChangeType type) {
        this.resource = resource;
        this.type = type;
    }

    @Override
    public Resource resource() {
        return resource;
    }

    @Override
    public ChangeType type() {
        return type;
    }

    public static ResourceChangeImpl addedResource(Resource resource) {
        return new ResourceChangeImpl(resource, ChangeType.ADD);
    }

    public static ResourceChangeImpl deletedResource(Resource resource) {
        return new ResourceChangeImpl(resource, ChangeType.REMOVE);
    }

    public static ResourceChangeImpl modifiedResource(Resource resource) {
        return new ResourceChangeImpl(resource, ChangeType.MODIFY);
    }

    @Override
    public String toString() {
        return type + " : " + resource.label() + " -> " + resource.link();
    }
}

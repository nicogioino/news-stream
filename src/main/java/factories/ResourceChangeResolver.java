package factories;

import resource.Resource;
import resource.changes.ResourceChange;
import resource.changes.ResourceChangeImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceChangeResolver {
    /**
     * Map containing last resources
     * The link functions as the key and the label as the value
     */
    private Map<String, Resource> lastResources;

    public ResourceChangeResolver() {
        this.lastResources = new HashMap<>();
    }

    public List<ResourceChangeImpl> calculateDeltas(Iterable<Resource> resources) {
        List<ResourceChangeImpl> changes = new ArrayList<>();
        Map<String,Resource> newResources= new HashMap<>();

        for (Resource resource : resources) {
            boolean isNew  = !lastResources.containsKey(resource.link());
            if (isNew) {
                changes.add(ResourceChangeImpl.addedResource(resource));
            }
            else {
                if (!lastResources.get(resource.link()).label().equals(resource.label())) {
                    changes.add(ResourceChangeImpl.modifiedResource(resource));
                }
            }
            lastResources.remove(resource.link());
            newResources.put(resource.link(),resource);
        }

        lastResources.forEach((link,resource) -> {
            changes.add(ResourceChangeImpl.deletedResource(resource));
        });

        lastResources.clear();
        lastResources.putAll(newResources);
        return changes;
    }
}

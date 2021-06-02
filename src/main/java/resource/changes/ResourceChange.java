package resource.changes;

import resource.Resource;

public interface ResourceChange <T extends Resource> {
    T resource();
    ChangeType type();
}

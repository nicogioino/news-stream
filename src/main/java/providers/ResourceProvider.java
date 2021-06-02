package providers;
import resource.Resource;

import java.io.IOException;
import java.time.Duration;

public interface ResourceProvider {

    Iterable<Resource> resources() throws IOException;

    Duration interval();

}

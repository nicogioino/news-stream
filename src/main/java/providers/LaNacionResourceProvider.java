package providers;

import factories.LaNacionResourceFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import resource.LaNacionResource;
import resource.Resource;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LaNacionResourceProvider implements ResourceProvider {

    static final String FRONT_PAGE_URL = "https://www.lanacion.com.ar/";
    private final Duration duration;
    private final LaNacionResourceFactory laNacionResourceFactory = new LaNacionResourceFactory();

    public LaNacionResourceProvider(Duration duration) {
        this.duration = duration;
    }

    @Override
    public List<Resource> resources() throws IOException {
        List<Resource> result = new ArrayList<>();
        Document doc = Jsoup.connect(FRONT_PAGE_URL).get();
        for (Element e : doc.body().select(".com-title a")) {
            result.add(laNacionResourceFactory.generateResource(FRONT_PAGE_URL + e.attr("href"), e.text()));
        }
        return result;

    }

    @Override
    public Duration interval() {
        return duration;
    }
}

package providers;

import factories.LaNacionResourceFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import resource.Resource;

import java.io.IOException;
import java.time.Duration;
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
        Document webPage = Jsoup.connect(FRONT_PAGE_URL).get();
        List<Element> elements = webPage.getElementsByClass("com-title")
                .stream()
                .map(Element::getAllElements)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        List<Element> filteredList = elements.stream()
                .filter(element -> !element.hasClass("com-title") && !element.hasClass("com-volanta"))
                .collect(Collectors.toList());
        return filteredList.stream().map(laNacionResourceFactory::generateResource).collect(Collectors.toList());
    }

    @Override
    public Duration interval() {
        return duration;
    }
}

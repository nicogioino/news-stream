package providers;

import factories.ClarinResourceFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.TextNode;
import resource.Resource;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClarinResourceProvider implements ResourceProvider {

    static final String FRONT_PAGE_URL = "https://www.clarin.com/";
    private final Duration duration;
    ClarinResourceFactory clarinResourceFactory = new ClarinResourceFactory();

    public ClarinResourceProvider(Duration duration) {
        this.duration = duration;
    }

    @Override
    public List<Resource> resources() throws IOException {
        Document webPage = Jsoup.connect(FRONT_PAGE_URL).get();
        List<TextNode> nodes = new ArrayList<>();
        nodes.addAll(webPage.getElementsByTag("h1").textNodes());
        nodes.addAll(webPage.getElementsByTag("h2").textNodes());
        return nodes.stream().map(textNode -> clarinResourceFactory.generateResource(textNode)).collect(Collectors.toList());
    }

    @Override
    public Duration interval() {
        return duration;
    }
}

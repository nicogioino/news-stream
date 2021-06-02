package factories;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import resource.ClarinResource;
import resource.LaNacionResource;

import static resource.LaNacionResource.*;

public class LaNacionResourceFactory {

    public LaNacionResource generateResource(Element element) {
        String label = element.attr("title");
        String link = element.attr("href");

        return laNacionResource(label,link);
    }
}

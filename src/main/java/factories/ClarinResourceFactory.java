package factories;

import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import resource.ClarinResource;
import static resource.ClarinResource.*;

public class ClarinResourceFactory {

    public ClarinResource generateResource(TextNode textNode) {
        String label = textNode.text();
        String link = "https://clarin.com" + crawlToHref(textNode);
        return clarinResource(label,link);
    }

    private String crawlToHref(TextNode textNode) {
        String link = "";
        Node currentNode = textNode;
        while (link.equals("") && currentNode.hasParent()) {
            link =  currentNode.attr("href");
            currentNode = currentNode.parentNode();
        }
        return link;
    }
}

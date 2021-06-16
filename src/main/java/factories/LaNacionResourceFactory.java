package factories;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import resource.ClarinResource;
import resource.LaNacionResource;

import static resource.LaNacionResource.*;

public class LaNacionResourceFactory {

    public LaNacionResource generateResource(String title,String link) {
        return laNacionResource(title,link);
    }
}


import consumers.ConsoleResourceConsumer;
import providers.ClarinResourceProvider;
import providers.LaNacionResourceProvider;
import streams.ResourceStream;

import java.net.UnknownHostException;
import java.time.Duration;

public class TestMain {
    public static void main(String[] args) {
        ClarinResourceProvider clarinResourceProvider = new ClarinResourceProvider(Duration.ofSeconds(60));
        LaNacionResourceProvider laNacionResourceProvider = new LaNacionResourceProvider(Duration.ofSeconds(60));

        ResourceStream clarinResourceStream = new ResourceStream(clarinResourceProvider);
        ResourceStream laNacionResourceStream = new ResourceStream(laNacionResourceProvider);

        ConsoleResourceConsumer consoleConsumer = new ConsoleResourceConsumer();

        clarinResourceStream.subscribe(consoleConsumer);
        laNacionResourceStream.subscribe(consoleConsumer);

        while (true) {

        }


    }
}

package ninckblokje.tools.heater;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Heater {
    public static void main(String[] args) throws InterruptedException, URISyntaxException, IOException {

        Path tempPoster = Files.createTempDirectory("tempPoster34.jpg");
        Files.copy(Heater.class.getResourceAsStream("/poster34.jpg"), tempPoster, StandardCopyOption.REPLACE_EXISTING);
        System.gc();

        List<byte[]> manyData = new ArrayList<>();

        long counter = 0L;
        while (true) {
            System.err.println("-- " + ++counter);
            System.err.println("free memory: " + Runtime.getRuntime().freeMemory());
            System.err.println("total memory: " + Runtime.getRuntime().totalMemory());
            System.err.println("max memory: " + Runtime.getRuntime().maxMemory());

            manyData.add(Files.readAllBytes(tempPoster));

            Thread.sleep(1000L);
        }
    }
}

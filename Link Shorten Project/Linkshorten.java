
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class URLShortener {
    private Map<String, String> urlMap = new HashMap<>();
    private static final String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_URL_LENGTH = 6;
    private Random random = new Random();

    public String shortenURL(String longUrl) {
        String shortUrl;
        do {
            shortUrl = generateShortURL();
        } while (urlMap.containsKey(shortUrl));
        urlMap.put(shortUrl, longUrl);
        return shortUrl;
    }

    public String expandURL(String shortUrl) {
        return urlMap.getOrDefault(shortUrl, "URL not found");
    }

    private String generateShortURL() {
        StringBuilder shortUrl = new StringBuilder();
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            shortUrl.append(CHAR_SET.charAt(random.nextInt(CHAR_SET.length())));
        }
        return shortUrl.toString();
    }

    public static void main(String[] args) {
        URLShortener urlShortener = new URLShortener();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Shorten URL");
            System.out.println("2. Expand URL");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter long URL: ");
                    String longUrl = scanner.nextLine();
                    String shortUrl = urlShortener.shortenURL(longUrl);
                    System.out.println("Shortened URL: " + shortUrl);
                    break;
                case 2:
                    System.out.print("Enter short URL: ");
                    String shortUrlToExpand = scanner.nextLine();
                    String expandedUrl = urlShortener.expandURL(shortUrlToExpand);
                    System.out.println("Expanded URL: " + expandedUrl);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}

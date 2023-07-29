import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SimpleSearchEngine {
    private Map<String, List<String>> documentIndex;

    public SimpleSearchEngine() {
        documentIndex = new HashMap<>();
    }

    public void indexDocument(String documentName, String documentContent) {
        String[] words = documentContent.toLowerCase().split("\\s+");
        for (String word : words) {
            documentIndex.putIfAbsent(word, new ArrayList<>());
            documentIndex.get(word).add(documentName);
        }
    }

    public List<String> search(String query) {
        String[] queryWords = query.toLowerCase().split("\\s+");
        List<String> results = new ArrayList<>();

        for (String queryWord : queryWords) {
            List<String> documents = documentIndex.getOrDefault(queryWord, new ArrayList<>());
            results.addAll(documents);
        }

        return results;
    }

    public static void main(String[] args) {
        SimpleSearchEngine searchEngine = new SimpleSearchEngine();
        Scanner scanner = new Scanner(System.in);

        // Index some sample documents
        searchEngine.indexDocument("document1.txt", "The quick brown fox jumps over the lazy dog");
        searchEngine.indexDocument("document2.txt", "A quick brown dog jumps over a lazy fox");
        searchEngine.indexDocument("document3.txt", "The fox is quick and the dog is lazy");

        System.out.println("Welcome to Simple Search Engine!");

        while (true) {
            System.out.print("Enter your search query (or 'exit' to quit): ");
            String query = scanner.nextLine();

            if (query.equalsIgnoreCase("exit")) {
                break;
            }

            List<String> searchResults = searchEngine.search(query);

            if (searchResults.isEmpty()) {
                System.out.println("No results found.");
            } else {
                System.out.println("Search Results:");
                for (String result : searchResults) {
                    System.out.println("- " + result);
                }
            }
        }

        System.out.println("Thank you for using Simple Search Engine!");
        scanner.close();
    }
}

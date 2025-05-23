import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilitária para lidar com operações de arquivo, como leitura de nomes.
 * Segue o Princípio da Responsabilidade Única (SRP).
 */
public class FileHander {

    public static List<String> readNamesFromFile(String filePath) {
        List<String> names = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String trimmedLine = line.trim();
                if (!trimmedLine.isEmpty()) {
                    names.add(trimmedLine);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + filePath + ": " + e.getMessage());
            e.printStackTrace();
        }
        return names;
    }

    public static void printDistribution(int[] distribution) {
        for (int i = 0; i < distribution.length; i++) {
            System.out.printf("  Slot %d: %d chaves%n", i, distribution[i]);
        }
    }
}
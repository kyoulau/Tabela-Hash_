import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final String PATH_FAMALE_NAMES = "src/female_names.txt";
    public static void main(String[] args) {
        System.out.println("Inicianlizando programa");

        List<String> names = FileHander.readNamesFromFile(PATH_FAMALE_NAMES);

        if (names.isEmpty()) {
            System.err.println("Nenhum nome foi lido do arquivo. Verifique o caminho ou conteúdo do arquivo.");
            return;
        } else {
            System.out.println("Total de " + names.size() + " nomes lidos do arquivo.");
        }

        // Tempo de inserção da tabela 1
        FNVHashTable fnvHash = new FNVHashTable();
        long startInsertFNV = System.nanoTime();
        for (String name : names) {
            fnvHash.insert(name);
        }
        long endInsertFNV = System.nanoTime();
        double timeInsertFNV = (endInsertFNV - startInsertFNV) / 1_000_000.0;
        // Tempo de busca da tabela 1
        long startSearchFNV = System.nanoTime();
        for (String name : names) {
            fnvHash.search(name);
        }
        long endSearchFNV = System.nanoTime();
        double timeSearchFNV = (endSearchFNV - startSearchFNV) / 1_000_000.0;
        double totalFNV = (timeInsertFNV + timeSearchFNV); // Tempo total da tabela 1

        // Tempo de inserção da tabela 2
        long startInsertChaning = System.nanoTime();
        SeparateChainingHashTable chaningHash = new SeparateChainingHashTable();
        for (String name : names) {
            chaningHash.insert(name);
        }
        long endInsertChaning = System.nanoTime();
        double timeInsertChaning = (endInsertChaning - startInsertChaning) / 1_000_000.0;
        // Tempo de busca da tabela 2
        long startSearchChaning = System.nanoTime();
        for (String name : names) {
            chaningHash.search(name);
        }
        long endSearchChaning = System.nanoTime();
        double timeSearchChaning = (endSearchChaning - startSearchChaning) / 1_000_000.0;
        double totalChaning = (timeInsertChaning + timeSearchChaning); // Tempo total da tabela 2

        System.out.println("## Testes Tabela 1: ##");
        System.out.println("Tempo para inserir todas as chaves na Hash Table 1: " + timeInsertFNV);
        System.out.println("Tempo para bsucar todas as chaves na Hash Table 1: " + timeSearchFNV);
        System.out.println("Tempo total de execução da Hash Table 1:" + totalFNV);
        System.out.println("Total de colisões na Hash Table 1: " + fnvHash.getCollision());
        System.out.println("Distribuição das chaves da Hash Table 1: " + Arrays.toString(fnvHash.getKeyDistribution()));

        System.out.println("## Testes Tabela 2: ##");
        System.out.println("Tempo para inserir todas as chaves na Hash Table 2: " + timeInsertChaning);
        System.out.println("Tempo para bsucar todas as chaves na Hash Table 2: " + timeSearchChaning);
        System.out.println("Tempo total de execução da Hash Table 2:" + totalChaning);
        System.out.println("Total de colisões na Hash Table 1: " + chaningHash.getCollision());
        System.out.println("Distribuição das chaves da Hash Table 2: " + Arrays.toString(chaningHash.getKeyDistribution()));
    }
}
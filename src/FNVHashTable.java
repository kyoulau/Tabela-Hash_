import java.util.LinkedList;
import java.util.List;
import java.nio.charset.StandardCharsets; // Import para garantir UTF-8

public class FNVHashTable extends HashTable {

    private List<String>[] table;

    public FNVHashTable() {
        this.capacity = 32;
        this.table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
        this.size = 0;
        this.collision = 0;
    }

    private int hashFunction(String key) {
        if (key == null || key.isEmpty()) {
            return 0;
        }

        final int FNV_PRIME = 0x01000193;
        final int FNV_OFFSET_BASIS = 0x811C9DC5;

        int hash = FNV_OFFSET_BASIS;

        try {
            byte[] data = key.getBytes(StandardCharsets.UTF_8);
            for (byte b : data) {
                hash ^= (b & 0xFF);
                hash *= FNV_PRIME;
            }
        } catch (Exception e) {
            System.err.println("Erro ao converter string para bytes em FNV-1a: " + e.getMessage());
            return 0;
        }

        return (hash & (capacity - 1));
    }

    @Override
    public boolean insert(String name) {
        if (search(name)) {
            return false;
        }

        int index = hashFunction(name);
        if (!table[index].isEmpty()) {
            this.collision++; // Incrementa o contador de colisões [cite: 13]
        }
        table[index].add(name);
        this.size++;
        return true;
    }

    @Override
    public boolean delete(String name) {
        int index = hashFunction(name);
        if (table[index].remove(name)) {
            this.size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean search(String name) {
        int index = hashFunction(name);
        return table[index].contains(name);
    }

    // Método auxiliar para obter a distribuição das chaves [cite: 15, 18]
    public int[] getKeyDistribution() {
        int[] distribution = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            distribution[i] = table[i].size();
        }
        return distribution;
    }
}
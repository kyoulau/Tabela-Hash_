import java.util.LinkedList;
import java.util.List;

public class SeparateChainingHashTable extends HashTable {

    private List<String>[] table;

    public SeparateChainingHashTable() {
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

        int hash = 0;
        int prime = 31;

        for (int i = 0; i < key.length(); i++) {
            hash = prime * hash + key.charAt(i);
        }

        // Otimização para potência de 2: hash & (capacity - 1)
        // Garante que o índice esteja entre 0 e capacity - 1
        return (hash & (capacity - 1));
    }

    @Override
    public boolean insert(String name) {
        if (search(name)) {
            return false; // Nome já existe, não insere novamente
        }

        int index = hashFunction(name);
        if (!table[index].isEmpty()) {
            this.collision++; // Incrementa o contador de colisões [cite: 13]
        }
        table[index].add(name); // Adiciona o nome à lista do balde
        this.size++; // Incrementa o número de elementos na tabela
        return true;
    }

    @Override
    public boolean delete(String name) {
        int index = hashFunction(name);
        if (table[index].remove(name)) { // Tenta remover o nome da lista no balde
            this.size--; // Decrementa o número de elementos se a remoção for bem-sucedida
            return true;
        }
        return false; // Nome não encontrado
    }

    @Override
    public boolean search(String name) {
        int index = hashFunction(name);
        return table[index].contains(name); // Verifica se o nome está na lista do balde
    }

    // Método auxiliar para obter a distribuição das chaves [cite: 15, 18]
    public int[] getKeyDistribution() {
        int[] distribution = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            distribution[i] = table[i].size(); // Conta quantos elementos há em cada balde
        }
        return distribution;
    }
}
abstract class HashTable {
    int capacity;
    int  size;
    String[] table;
    int collision;


    abstract boolean insert(String name);
    abstract boolean delete(String name);
    abstract  boolean search(String name);

    public int getCollision(){
        return collision;
    }

}

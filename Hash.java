import java.util.Arrays;

class HashTable {
    private int tableSize;
    private String[] hashTable;

    public HashTable(int size) {
        tableSize = size;
        hashTable = new String[tableSize];
        Arrays.fill(hashTable, null);
    }

    public int hash(String key) {
        int hashValue = key.hashCode() % tableSize;
        // Ensure the hash value is non-negative
        if (hashValue < 0) {
            hashValue += tableSize;
        }
        return hashValue;
    }

    public void put(String key, String value) {
        int index = hash(key);
        hashTable[index] = value;
    }

    public String get(String key) {
        int index = hash(key);
        return hashTable[index];
    }

    public void remove(String key) {
        int index = hash(key);
        hashTable[index] = null;
    }

    public void displayTable() {
        for (int i = 0; i < tableSize; i++) {
            if (hashTable[i] != null) {
                System.out.println("Index " + i + ": " + hashTable[i]);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        HashTable table = new HashTable(10);

        table.put("Alice", "123-456-7890");
        table.put("Bob", "987-654-3210");
        table.put("Charlie", "555-123-4567");

        System.out.println("Hash table:");
        table.displayTable();

        String key = "Bob";
        String value = table.get(key);
        if (value != null) {
            System.out.println("Value for key '" + key + "': " + value);
        } else {
            System.out.println("Key not found: " + key);
        }

        key = "David";
        value = table.get(key);
        if (value != null) {
            System.out.println("Value for key '" + key + "': " + value);
        } else {
            System.out.println("Key not found: " + key);
        }

        table.remove("Alice");
        System.out.println("After removing 'Alice':");
        table.displayTable();
    }
}

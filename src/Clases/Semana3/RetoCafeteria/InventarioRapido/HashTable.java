package Clases.Semana3.RetoCafeteria.InventarioRapido;

public class HashTable<K, V> {
    public HashNode<K, V>[] bucket;
    public int capacity;
    public int size;

    public HashTable(int capacity){
        this.capacity = capacity;
        this.bucket = new HashNode[capacity];
        this.size = 0;
    }

    public int getBucketIndex(K key){
        // Función nativa de java para generar codigo hash
        int hashCode = key.hashCode();
        //operación modulo para ajustar al rango del arreglo
        return Math.abs(hashCode) % capacity;
    }

    public void put(K key, V value){
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucket[bucketIndex];
        //buscar si la llave ya existe para actualizar su valor
        HashNode<K, V> current = head;
        while (current != null){
            if (current.key.equals(key)){
                current.value = value;
                return;
            }
            current = current.next;
        }
        size++;
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next =head;
        bucket[bucketIndex] = newNode;
    }

    public V getV(K key){
        int cubetitaIndex = getBucketIndex(key);
        HashNode<K, V> actual = bucket[cubetitaIndex];
        while (actual != null){
            if (actual.key.equals(key)) {
                return actual.value;
            }
            actual = actual.next;
        }
        System.out.println("Elemento no encontrado");
        return null;
    }

    public void showTable(){
        for(int i = 0; i < capacity; i++) {
            System.out.print("Registro " + i + ": ");
            HashNode<K, V> current = bucket[i];
            if (current == null) {
                System.out.println("[Vacio]");
            } else {
                System.out.print("-> ");
                while (current != null) {
                    System.out.print("[" + current.key + " : " + current.value + "] -> ");
                    current = current.next;
                }
                System.out.println("null");
            }
        }
    }
}

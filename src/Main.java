import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Book> table = new MyHashTable<>(50);
        Random rand = new Random();

        for (int i = 0; i < 10000; i++) {
            int id = rand.nextInt(1_000_000);
            int serialNumber = rand.nextInt(1_000_000);
            MyTestingClass key = new MyTestingClass(id, serialNumber);

            int isbn = rand.nextInt(1_000_000);
            int pageCount = rand.nextInt(500) + 100;
            Book book = new Book(isbn, pageCount);

            table.put(key, book);
        }

        for (int i = 0; i < 50; i++) {
            int count = 0;

            var current = table.getBuckets()[i];
            while (current != null) {
                count++;
                current = current.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }
}

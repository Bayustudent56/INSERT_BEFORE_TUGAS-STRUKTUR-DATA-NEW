//KELOMPOK HARIMAU

//24051130002 Luthfian Afif
//24051130010 Bayu Arya Wijaya

//Menu:
// ====== MENU DOUBLE LINKED LIST ======
// 1. Insert First
// 2. Insert Last
// 3. Insert After
// 4. Insert Before
// 5. Delete First
// 6. Delete Last
// 7. Tampil Maju
// 8. Tampil Mundur
// 9. Sort Ascending (Data1)
//10. Sort Descending (Data1)
//11. Sort Ascending (Data2)
//12. Sort Descending (Data2)
// 0. Keluar



import java.util.Scanner;

class Node {
    public int angkaInt;
    public double angkaDouble;
    public Node next;
    public Node previous;

    public Node(int angkaInt, double angkaDouble) {
        this.angkaInt = angkaInt;
        this.angkaDouble = angkaDouble;
    }

    public void tampilNode() {
        System.out.print("{" + angkaInt + ", " + angkaDouble + "} ");
    }
}

class DoubleLink {
    private Node first;
    private Node last;

    public DoubleLink() {
        first = null;
        last = null;
    }

    // Memeriksa apakah list kosong
    public boolean isEmpty() {
        return first == null;
    }

    // Menyisipkan node baru di awal list
    public void insertFirst(int angkaInt, double angkaDouble) {
        Node newNode = new Node(angkaInt, angkaDouble);
        if (isEmpty())
            last = newNode; // Jika list kosong, set last sebagai newNode
        else
            first.previous = newNode; // Jika tidak, set previous first ke newNode
        newNode.next = first; // Set next newNode ke first
        first = newNode; // Set first ke newNode
    }

    // Menyisipkan node baru di akhir list
    public void insertLast(int angkaInt, double angkaDouble) {
        Node newNode = new Node(angkaInt, angkaDouble);
        if (isEmpty())
            first = newNode; // Jika list kosong, set first sebagai newNode
        else {
            last.next = newNode; // Jika tidak, set next last ke newNode
            newNode.previous = last; // Set previous newNode ke last
        }
        last = newNode; // Set last ke newNode
    }

    // Menyisipkan node setelah node dengan key
    public boolean insertAfter(int key, int angkaInt, double angkaDouble) {
        Node current = first;
        while (current != null && current.angkaInt != key) {
            current = current.next; // Cari node dengan key
        }
        if (current == null) return false; // Jika key tidak ditemukan

        Node newNode = new Node(angkaInt, angkaDouble);
        newNode.next = current.next; // Set next newNode ke node setelah current
        newNode.previous = current; // Set previous newNode ke current
        if (current.next != null)
            current.next.previous = newNode; // Set previous node setelah current ke newNode
        else
            last = newNode; // Jika current adalah last, set last ke newNode
        current.next = newNode; // Set next current ke newNode
        return true;
    }

    // Menyisipkan node sebelum node dengan key
    public boolean insertBefore(int key, int angkaInt, double angkaDouble) {
        Node current = first;
        while (current != null && current.angkaInt != key) {
            current = current.next; // Cari node dengan key
        }
        if (current == null) return false; // Jika key tidak ditemukan

        Node newNode = new Node(angkaInt, angkaDouble);
        newNode.next = current; // Set next newNode ke current
        newNode.previous = current.previous; // Set previous newNode ke previous current

        if (current.previous != null)
            current.previous.next = newNode; // Set next previous current ke newNode
        else
            first = newNode; // Jika current adalah first, set first ke newNode

        current.previous = newNode; // Set previous current ke newNode
        return true;
    }

    // Menghapus node pertama
    public Node deleteFirst() {
        if (isEmpty()) return null; // Jika list kosong, kembalikan null
        Node temp = first;
        if (first.next == null)
            last = null; // Jika hanya ada satu node, set last ke null
        else
            first.next.previous = null; // Set previous node kedua ke null
        first = first.next; // Set first ke node kedua
        return temp; // Kembalikan node yang dihapus
    }

    // Menghapus node terakhir
    public Node deleteLast() {
        if (isEmpty()) return null; // Jika list kosong, kembalikan null
        Node temp = last;
        if (last.previous == null)
            first = null; // Jika hanya ada satu node, set first ke null
        else
            last.previous.next = null; // Set next node sebelum last ke null
        last = last.previous; // Set last ke node sebelumnya
        return temp; // Kembalikan node yang dihapus
    }

    // Menampilkan list dari awal ke akhir
    public void tampilMaju() {
        System.out.print("List (first-->last): ");
        Node current = first;
        while (current != null) {
            current.tampilNode(); // Tampilkan node saat ini
            current = current.next; // Pindah ke node berikutnya
        }
        System.out.println();
    }

    // Menampilkan list dari akhir ke awal
    public void tampilMundur() {
        System.out.print("List (last-->first): ");
        Node current = last;
        while (current != null) {
            current.tampilNode(); // Tampilkan node saat ini
            current = current.previous; // Pindah ke node sebelumnya
        }
        System.out.println();
    }

    // Mengurutkan list berdasarkan angkaInt secara ascending atau descending
    public void sortByInt(boolean ascending) {
        if (first == null) return;

        for (Node i = first; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if ((ascending && i.angkaInt > j.angkaInt) || (!ascending && i.angkaInt < j.angkaInt)) {
                    int tempInt = i.angkaInt;
                    double tempDouble = i.angkaDouble;
                    i.angkaInt = j.angkaInt;
                    i.angkaDouble = j.angkaDouble;
                    j.angkaInt = tempInt;
                    j.angkaDouble = tempDouble;
                }
            }
        }
    }

    // Mengurutkan list berdasarkan angkaDouble secara ascending atau descending
    public void sortByDouble(boolean ascending) {
        if (first == null) return;

        for (Node i = first; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if ((ascending && i.angkaDouble > j.angkaDouble) || (!ascending && i.angkaDouble < j.angkaDouble)) {
                    int tempInt = i.angkaInt;
                    double tempDouble = i.angkaDouble;
                    i.angkaInt = j.angkaInt;
                    i.angkaDouble = j.angkaDouble;
                    j.angkaInt = tempInt;
                    j.angkaDouble = tempDouble;
                }
            }
        }
    }
}

public class DoubleLinkList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoubleLink list = new DoubleLink();
        int pilihan;

        do {
            System.out.println("\n====== MENU DOUBLE LINKED LIST ======");
            System.out.println("1. Insert First");
            System.out.println("2. Insert Last");
            System.out.println("3. Insert After");
            System.out.println("4. Insert Before");
            System.out.println("5. Delete First");
            System.out.println("6. Delete Last");
            System.out.println("7. Tampil Maju");
            System.out.println("8. Tampil Mundur");
            System.out.println("9. Sort Ascending (angkaInt)");
            System.out.println("10. Sort Descending (angkaInt)");
            System.out.println("11. Sort Ascending (angkaDouble)");
            System.out.println("12. Sort Descending (angkaDouble)");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilihan = sc.nextInt();

            int intData, key;
            double doubleData;

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan angka int: ");
                    intData = sc.nextInt();
                    System.out.print("Masukkan angka double: ");
                    doubleData = sc.nextDouble();
                    list.insertFirst(intData, doubleData);
                    break;
                case 2:
                    System.out.print("Masukkan angka int: ");
                    intData = sc.nextInt();
                    System.out.print("Masukkan angka double: ");
                    doubleData = sc.nextDouble();
                    list.insertLast(intData, doubleData);
                    break;
                case 3:
                    System.out.print("Masukkan key angka int: ");
                    key = sc.nextInt();
                    System.out.print("Masukkan angka int baru: ");
                    intData = sc.nextInt();
                    System.out.print("Masukkan angka double baru: ");
                    doubleData = sc.nextDouble();
                    if (!list.insertAfter(key, intData, doubleData))
                        System.out.println("Key tidak ditemukan!");
                    break;
                case 4:
                    System.out.print("Masukkan key angka int: ");
                    key = sc.nextInt();
                    System.out.print("Masukkan angka int baru: ");
                    intData = sc.nextInt();
                    System.out.print("Masukkan angka double baru: ");
                    doubleData = sc.nextDouble();
                    if (!list.insertBefore(key, intData, doubleData))
                        System.out.println("Key tidak ditemukan!");
                    break;
                case 5:
                    list.deleteFirst();
                    break;
                case 6:
                    list.deleteLast();
                    break;
                case 7:
                    list.tampilMaju();
                    break;
                case 8:
                    list.tampilMundur();
                    break;
                case 9:
                    list.sortByInt(true);
                    System.out.println("Berhasil sort ascending berdasarkan angkaInt");
                    break;
                case 10:
                    list.sortByInt(false);
                    System.out.println("Berhasil sort descending berdasarkan angkaInt");
                    break;
                case 11:
                    list.sortByDouble(true);
                    System.out.println("Berhasil sort ascending berdasarkan angkaDouble");
                    break;
                case 12:
                    list.sortByDouble(false);
                    System.out.println("Berhasil sort descending berdasarkan angkaDouble");
                    break;
                case 0:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        // tutup scanner
        sc.close();
    }
}

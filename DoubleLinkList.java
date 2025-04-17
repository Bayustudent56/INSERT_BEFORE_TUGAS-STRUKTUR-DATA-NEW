class Node {
	public int Data1;
	public double Data2;
	public Node next;		// pointer untuk terhubung dengan Node berikutnya
	public Node previous;	// pointer untuk terhubung dengan Node sebelumnya
// -------------------------------------------------------------
	public Node(int dat1, double dat2) {
		Data1 = dat1;
		Data2 = dat2;
	}
// -------------------------------------------------------------
	public void tampilNode() {
		System.out.print("{" + Data1 + ", " + Data2 + "} ");
	}
} // end class Node
////////////////////////////////////////////////////////////////

class DoubleLink {
	private Node first; // pointer first digunakan untuk menunjukkan awal list
	private Node last;  // pointer last digunakan untuk menunjukkan akhir list
// -------------------------------------------------------------
	public DoubleLink() { 
		first = null; 
		last = null;  
	}
// -------------------------------------------------------------
	public boolean isEmpty() { 
		return first==null;
	}
// -------------------------------------------------------------
	// memasukkan data di awal list
	public void insertFirst(int dat1, double dat2) {
		Node newNode = new Node(dat1, dat2);
		if(isEmpty())
			last = newNode;
		else
			first.previous = newNode;
		newNode.next = first;
		first = newNode;
	}
// -------------------------------------------------------------
	// memasukkan data di akhir list
	public void insertLast(int dat1, double dat2) {
		Node newNode = new Node(dat1,dat2);
		if( isEmpty() )
			first = newNode;
		else {
			last.next = newNode;
			newNode.previous = last;
		}
		last = newNode;
	}
// -------------------------------------------------------------
	// menghapus data di awal list
	public Node deleteFirst() {
		Node temp = first;
		if(first.next == null)
			last = null;
		else
			first.next.previous = null;
		first = first.next;
		return temp;
	}
// -------------------------------------------------------------
	// menghapus data di akhir list
	public Node deleteLast() {
		Node temp = last;
		if(first.next == null)
			first = null;
		else
			last.previous.next = null;
		last = last.previous;
		return temp;
	}
// -------------------------------------------------------------
	// memasukkan data setelah data tertentu
	public boolean insertAfter(int dat, int dat1, double dat2) {
		Node indek = first;
		while(indek.Data1 != dat) { // cari data dahulu
			indek = indek.next;
			if(indek == null)
				return false; // data tidak ditemukan
		}
		
		// data ditemukan dan data baru dimasukkan
		Node newNode = new Node(dat1,dat2);
		if(indek == last) 
			last = newNode;
		else {
			newNode.next = indek.next;
			indek.next.previous = newNode;
		}
		newNode.previous = indek;
		indek.next = newNode;
		return true; 
	}

	//Insert before setelah daftar tertentu
	public boolean insertBefore(int dat, int dat1, double dat2) {
		Node indek = first;
		while(indek.Data1 != dat) { // cari data dahulu
			indek = indek.next;
			if(indek == null)
				return false; // data tidak ditemukan
		}
		
		// data ditemukan dan data baru dimasukkan
		Node newNode = new Node(dat1,dat2);
		if(indek == first) {
			newNode.next=indek;
			first=newNode;
		} 
		else {
			newNode.next = indek;
			newNode.previous = indek.previous;
			indek.previous.next = newNode;
		}
		newNode.previous = newNode;
		return true; 
	}
// -------------------------------------------------------------
	// menghapus data tertentu (tidak diawal maupun diakhir list)
	public Node hapus(int dat) {
		Node indek = first;
		while(indek.Data1 != dat) { // cari datanya
			indek = indek.next;
			if(indek == null)
				return null; // data tidak ditemukan
		}
		// jika data yang dihapus terletak di awal list
		if(indek == first)
			first = indek.next;
		else
			indek.previous.next = indek.next;
		
		// jika data yang dihapus terletak di akhir list
		if(indek == last)
			last = indek.previous;
		else
			indek.next.previous = indek.previous;
		return indek;
	}
// -------------------------------------------------------------
	public void tampilMaju() {
		System.out.print("List (first-->last): ");
		Node indek = first;
		while(indek != null) {
			indek.tampilNode();
			indek = indek.next;
		}
		System.out.println("");
	}
// -------------------------------------------------------------
	public void tampilMundur() {
		System.out.print("List (last-->first): ");
		Node indek = last;
		while(indek != null) {
			indek.tampilNode();
			indek = indek.previous;
		}
		System.out.println("");
	}
// -------------------------------------------------------------
} // end class DoubleLink
////////////////////////////////////////////////////////////////

class DoubleLinkList {
	public static void main(String[] args) {
		DoubleLink list = new DoubleLink();
		System.out.println("Data pertama, {22,22.99} dimasukkan dengan insertFirst");
		list.insertFirst(22, 22.99);
		list.tampilMaju();
		System.out.println("");
		list.insertFirst(44, 44.99);
		System.out.println("Memasukkan data ke-2, {44, 44.99}, di depan");
		list.tampilMaju();
		list.insertLast(11, 11.99);
		list.insertLast(33, 33.99);
		System.out.println("Memasukkan data ke-2, {44, 44.99}, di belakang");
		list.tampilMundur();
		list.insertBefore(11, 11.99);
		list.insertBefore(33, 33.99);
		System.out.println("");
		System.out.println("Memasukkan data ke-3 --> {11, 11.99} dan ke-4 --> {33, 33.99}, di belakang");
		list.tampilMaju();
		System.out.println("");
		System.out.println("Menampilkan data dari depan ke belakang");
		list.tampilMaju();
		System.out.println("");
		System.out.println("Menampilkan data dari belakang ke depan");
		list.tampilMundur();
		list.deleteFirst();
		System.out.println("");
		System.out.println("Menghapus data paling depan, {44, 44.99}");
		list.tampilMaju();
		list.deleteLast();
		System.out.println("");
		System.out.println("Menghapus data paling belakang, {33, 33.99}");
		list.tampilMaju();
		list.hapus(11);
		System.out.println("");
		System.out.println("Menghapus data {11,11.99}");
		list.tampilMaju();
		list.insertAfter(22, 77, 77.99);
		System.out.println("");
		System.out.println("Memasukkan data {77,77.99} setelah data {22,22.99}");
		list.tampilMaju();
		list.insertAfter(22, 88, 88.99);
		System.out.println("");
		System.out.println("Memasukkan data {88,88.99} setelah data {22,22.99}");
		list.tampilMaju();
		System.out.println("Memasukkan data {88,88.99} sebelum data {22,22.99}");
		list.tampilMundur();
		list.hapus(22);
		System.out.println("");
		System.out.println("Menghapus data {22,22.99}");
		list.tampilMaju();
	} // end main()
} // end class DoubleLinkList
////////////////////////////////////////////////////////////////
package praktikum3;

import java.util.Scanner;

class linkedlistnode {

    linkedlistnode next;
    linkedlistnode prev;
    int data;

    linkedlistnode(int newnode) {
        this.data = newnode;
        this.next = null;
        this.prev = null;
    }

    void set_prev(linkedlistnode other) {
        this.prev = other;
        if (other != null) {
            other.next = this;
        }
    }

    void set_next(linkedlistnode other) {
        this.next = other;
        if (other != null) {
            other.prev = this;
        }
    }
}

class linkedlist {

    linkedlistnode head;
    linkedlistnode tail;

    linkedlist() {
        this.head = null;
        this.tail = null;
    }

    void print() {
        linkedlistnode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }

    void push(linkedlistnode newnode) {
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
    }

    void insert(linkedlistnode new_node) {
        if (head == null) {
            head = new_node;
            tail = new_node;
        } else if (new_node.data <= this.head.data) {
            head.set_prev(new_node);
            head = new_node;
        } else if (new_node.data >= this.tail.data) {
            tail.set_next(new_node);
            tail = new_node;
        } else {
            linkedlistnode position = head;
            while (position.data <= new_node.data) {
                position = position.next;
            }
            linkedlistnode previous_position = position.prev;
            new_node.set_prev(previous_position);
            new_node.set_next(position);
        }

    }

    linkedlistnode find_node_by_data(int data) {
        linkedlistnode current = this.head;
        while (current != null) {
            if (current.data == data) {
                return current;
            }return current.next;
        }
        return null;
    }

    void delete(linkedlistnode deleted) {
        if (deleted != null && this.head != null) {
            if (this.head == this.tail && deleted == this.head) {
                this.head = null;
                this.tail = null;
            } else if (deleted == this.head) {
                linkedlistnode new_head = this.head.next;
                this.head.set_next(null);
                new_head.set_prev(null);
                this.head = new_head;
            } else if (deleted == this.tail) {
                linkedlistnode new_tail = this.tail.prev;
                this.tail.set_prev(null);
                new_tail.set_next(null);
                this.tail = new_tail;
            } else {
                linkedlistnode deleted_prev = deleted.prev;
                linkedlistnode deleted_next = deleted.next;
                deleted.set_prev(null);
                deleted.set_next(null);
                deleted_prev.set_next(deleted_next);
            }
        }
    }
    void find (int angka){
        linkedlistnode x = find_node_by_data(angka);
        if (x != null ){
            System.out.println("data yang di cari ada");
        }else{
            System.out.println("data tidak ada");
        }
    }
}

public class Praktikum3 {

    public static void main(String[] args) {
        int pilih;
        Scanner input = new Scanner(System.in);
        linkedlist a = new linkedlist();
        boolean keluar = true;
        int b;
        do {

            System.out.println("menu");
            System.out.println("1.masukan data ");
            System.out.println("2.lihat data");
            System.out.println("3.hapus data");
            System.out.println("4.cari data");
            System.out.println("5.keluar");
            System.out.println("masukan inputan =");
            pilih = input.nextInt();
            switch (pilih) {
                case 1:
                    System.out.println("------------");
                    System.out.print("masukan data =");
                     b = input.nextInt();
                    a.insert(new linkedlistnode(b));
                    break;
                case 2:
                    System.out.println("data yang ada =");
                    a.print();
                    break;
                case 3:
                    System.out.println("masukan angka yang mau di hapus =");
                    b = input.nextInt();
                    a.delete(a.find_node_by_data(b));
                    break;
                case 4:
                    System.out.println("masukan angka yang mau di cari =");
                    b = input.nextInt();
                    a.find(b);
                    break;
                case 5:
                    keluar = false;
                    break;
            }
            System.out.println("");

        } while (keluar);
    }
}

/*a.print();
        a.insert(new linkedlistnode(5));
        a.insert(new linkedlistnode(4));
        a.insert(new linkedlistnode(7));
        a.insert(new linkedlistnode(6));
        a.print();
        a.delete(a.head);
        a.print();
        a.delete(a.tail.prev);
        a.print();
        a.delete(a.tail);
        a.print();
        a.delete(a.head);
        a.print();*/

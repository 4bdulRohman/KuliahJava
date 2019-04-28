public class DoubleLinkedList {
    Node head;
    int size;
    
    public DoubleLinkedList(){
        head = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void addFirst(Mahasiswa item){
        if (isEmpty()) {
            head = new Node(null, item, null);
        }else{
            Node newNode = new Node (null, item, head);
            head.prev = newNode;
            head = newNode;
        }
        
        size++;
    }
    
    public void addLast(Mahasiswa item){
        if (isEmpty()) {
            addFirst(item);
        }else{
            Node current = head;
            while (current.next != null) {                
                current = current.next;
            }
            Node newNode = new Node(current, item, null);
            current.next = newNode;
            size++;
            
        }
    }
    
    public void add(Mahasiswa item, int index)throws Exception{
        if (isEmpty()) addFirst(item);
        if (index < 0 || index > size) throw new Exception("Nilai index diluar batas;");
        else{
            Node current = head;
            int i = 0;
            while (i<index){
                current = current.next;
                i++;
            }
            
            if (current.prev == null) {
                Node newNode = new Node(null, item, current);
                newNode.prev = newNode;
                head = newNode;
            }else{
                Node newNode = new Node(current.prev, item, current);
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        size++;
    }
    
    public int size(){
        return size;
    }
    
    public void clear(){
        head = null;
        size = 0;
    }
    
    public void print(){
        if (!isEmpty()) {
            Node tmp = head;
            while(tmp!=null){
                tmp.m.print();
                tmp = tmp.next;
            }
        }else{
            System.out.println("Linked List Kosong");
        }
    }
    
    public void removeFirst()throws Exception{
        if (isEmpty()) throw new Exception("LinkedList Kosong");
        else if (size == 1) {
            removeLast();
            
        }else{
            head = head.next;
            head.prev = null;
            size--;
        }
    }
    
    public void removeLast() throws Exception{
        if (isEmpty()) throw new Exception("Linked List Kosong");
        if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node current = head;
        while(current.next.next != null){
            current = current.next;
        }
        
        current.next = null;
        size--;
    }
    
    public void remove(int index) throws Exception{
        if (index==0) {
            removeFirst();
        }else{
            Node current = head;
            int i = 0;
            while (i < index) {                
                current = current.next;
                i++;
            }
            
            if (current.next == null) {
                current.prev.next = null;
            }else if(current.prev == null){
                current = current.next;
                current.prev = null;
                head = current;
            }else{
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            
            size--;
        }
    }
    
    public void getFirst()throws Exception{
        if (isEmpty()) throw new Exception("Linked List Kosong");
        head.m.print();
    }
    
    public void getLast() throws Exception{
        if (isEmpty()) throw new Exception("Linked List Kosong");
        Node tmp = head;
        while (tmp.next != null) {            
            tmp = tmp.next;
        }
        
        tmp.m.print();
    }
    
    public void get(int index) throws Exception{
        if (isEmpty() || index>=size) throw new Exception("Nilai index diluar batas");
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        
        tmp.m.print();
    }
    
    public void BubbleSort(){
        for (int i = 0; i < size-1; i++) {
            Node tmp = head;
            for (int j = 0; j < size-i-1; j++) {
                
                
                if (tmp.m.nilai > tmp.next.m.nilai){
                    Mahasiswa temp = tmp.m;
                    tmp.m = tmp.next.m;
                    tmp.next.m = temp;
                }
                
                tmp = tmp.next;
            }
        }
    }
    
}

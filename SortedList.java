public class SortedList<E extends Comparable<? super E>> {  
    // We need the "extends Comparable<? super E>" part because we'll be calling compareTo 
    // on variables of type E, and this lets Java know that compareTo will be defined for class E
    
    private ListNode<E> head;
    private int count;
    // Invariant: count accurately reflects the number of ListNodes in the linked list
    // and the items in the list are in "increasing" order, as defined by the compareTo method
    // for class E
    
    public SortedList() {
        head = null;
        count = 0;
    }
    
    public void insert(E item) {
        if (head==null || item.compareTo(head.element) < 0) { // Note short circuit eval
            // Handle the special case(s) where we insert at the front
            head = new ListNode<E>(item, head);
        }
        else {
            ListNode<E> current = head;
            ListNode<E> previous = null;   // keep pointer to ListNode just before current
            while (current != null && current.element.compareTo(item) <= 0) {
                previous = current;
                current = current.next;
            }
            ListNode<E> temp = new ListNode<E>(item, current);
            previous.next = temp;   // make the previous ListNode refer to the new ListNode
        }
        count++;
    }
    
    public int size() {
        return count;
    }
    
    public String toString() {
        String result = "";
        ListNode<E> current = head;
        while (current != null) {
            result = result + current.element.toString();
            current = current.next;
            if (current != null)  // if there will be another element...
                result += ", ";
        }
        return result; 
    }
    
    public void clear(){
    	head = null;
    	count = 0;
    	//Garbage Collector takes care of everything
    }
    
    public void merge(SortedList<E> other){
    	ListNode<E> current = other.head;
    	while (current !=null){
    		this.insert(current.element);
    		current = current.next;
    		//iterates through the other SortedList and uses insert()s each element
    	}
    }
    
    public boolean remove(E item){
    	ListNode<E> current = head;
    	ListNode<E> previous = null;
    	while (current!=null && current.element.compareTo(item) <= 0){
    		//iterates through every element in the list
    		if (current.element.equals(item)){
    			if (current == head){
    				head = current.next;
    				count = count--;
    				return true;
    				//everything starts at the head, so we just have to move the head forward
    				//and it'll never reach this element.
    			}
    			else{
    				previous.next=current.next;
    				count = count--;
    				return true;
    				//just tells the previous element to skip it
    			}
    		}
    		else{
    			previous = current;
    			current = current.next;
    		}
    	}
    	return false;
    }
    
}

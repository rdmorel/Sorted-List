# Sorted-List
Simple sorted list data structure in Java

Assignment:

Download the files ListNode.java, SortedList.java, and DemoSortedList.java.

The SortedList class is a new (fairly simple) data structure. As the name suggests, it's intended to keep a list of elements in sorted order; the order will depend on the compareTo(...) method defined in the element class E. (See the DemoSortedList program to see how this works with Integers and Strings.)

1. (3 pts) Add a new method, clear(), to the class; this should make the SortedList empty.

public void clear()

2. (8 pts) Add a new method, merge(...), to the class; this takes another SortedList and incorporates its elements into the current SortedList. Don't modify the other list. Hint: reuse code.

public void merge(SortedList<E> other)

For example, this snippet of code gave the following output, when run with my solution:

SortedList<Integer> list1 = new SortedList<Integer>();
list1.insert(3);
list1.insert(1);
list1.insert(5);
SortedList<Integer> list2 = new SortedList<Integer>();
list2.insert(6);
list2.insert(2);
list2.insert(4);

list1.merge(list2);
System.out.println("List1: " + list1 + " and list2 (should be unchanged): " + list2);

------- Program snippet output follows --------

List1: 1, 2, 3, 4, 5, 6 and list2 (should be unchanged): 2, 4, 6

3. (12 pts) Add a new method, remove(...) to this class; this takes an object of type E and removes it (or one copy of it, if there are multiple copies in the SortedList) from the SortedList, returning true if the item was found and deleted, and false if the item wasn't in the SortedList. Recall that the compareTo method returns zero if the items being compared are equal/equivalent.

boolean remove(E item)

Hint: consider (and test) a number of special cases: an empty list, removing the first/last element from the list, removing an element that isn't in the list at all. This one takes some careful thought. Don't be shy about sketching the ListNodes as you think through the problem. You may end up with a surprising number of cases in your code.

Hint for slightly greater efficiency (although no improvement in big-O): since the SortedList is sorted, you may not have to search the entire list; once you find an element that's "greater than" the item, you can assume the item is not farther along in the list.

package ch9J.chapter8_DataStructure;

public class _07Rehashing {
/**
 * @param hashTable: A list of The first node of linked list
 * @return: A list of The first node of linked list which have twice size
 */
public ListNode[] rehashing(ListNode[] hashTable) {
    // write your code here
    if (hashTable.length <= 0) {
        return hashTable;
    }
    int newcapacity = 2 * hashTable.length;
    ListNode[] newTable = new ListNode[newcapacity];
    for (int i = 0; i < hashTable.length; i++) {
        while (hashTable[i] != null) {
            int newindex
             = (hashTable[i].val % newcapacity + newcapacity) % newcapacity;
            if (newTable[newindex] == null) {
                newTable[newindex] = new ListNode(hashTable[i].val);
               // newTable[newindex].next = null;
            } else {
                ListNode dummy = newTable[newindex];
                while (dummy.next != null) {
                    dummy = dummy.next;
                }
                dummy.next = new ListNode(hashTable[i].val);
            }
            hashTable[i] = hashTable[i].next;
        }
    }
    return newTable;
}
}

/*The size of the hash table is not determinate at the very beginning. 
 * If the total size of keys is too large (e.g. size >= capacity / 10),
 *  we should double the size of the hash table and rehash every keys. 
 *  Say you have a hash table looks like below:
 

size=3, capacity=4

[null, 21, 14, null]
       ↓    ↓
       9   null
       ↓
      null
The hash function is:

int hashcode(int key, int capacity) {
    return key % capacity;
}
here we have three numbers, 9, 14 and 21, where 21 and 9 share the same
 position as they all have the same hashcode 1 (21 % 4 = 9 % 4 = 1). 
 We store them in the hash table by linked list.

rehashing this hash table, double the capacity, you will get:

size=3, capacity=8

index:   0    1    2    3     4    5    6   7
hash : [null, 9, null, null, null, 21, 14, null]
Given the original hash table, return the new hash table after rehashing.

 Notice

For negative integer in hash table, the position can be calculated as 
follow:

C++/Java: if you directly calculate -4 % 3 you will get -1. You can use
 function: a % b = (a % b + b) % b to make it is a non negative integer.
Python: you can directly use -1 % 3, you will get 2 automatically.
Have you met this question in a real interview? Yes
Example
Given [null, 21->9->null, 14->null, null],

return [null, 9->null, null, null, null, 21->null, 14->null, null]

Tags 
LintCode Copyright Hash Table*/
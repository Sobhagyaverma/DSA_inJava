# Linked List Problems - Implementation Summary

## Folder: `linked_list`

All 24 problems have been implemented following the specified requirements.

### Package Declaration
- All files use: `package linked_list;`
- This ensures no collision with other folders (`bit_manipulation`, `recursion`, `arrays_and_patterns`)

### Problems Implemented

1. ✅ **ReverseLinkedList.java** - Reverse Linked List (206)
2. ✅ **RemoveNthFromEnd.java** - Remove Nth Node From End (19)
3. ✅ **MergeTwoSortedLists.java** - Merge Two Sorted Lists (21)
4. ✅ **LinkedListCycle.java** - Linked List Cycle (141)
5. ✅ **RemoveLinkedListElements.java** - Remove Linked List Elements (203)
6. ✅ **OddEvenLinkedList.java** - Odd Even Linked List (328)
7. ✅ **PalindromeLinkedList.java** - Palindrome Linked List (234)
8. ✅ **IntersectionTwoLinkedLists.java** - Intersection of Two Linked Lists (160)
9. ✅ **CopyListWithRandomPointer.java** - Copy List with Random Pointer (138)
10. ✅ **DeleteNodeInLinkedList.java** - Delete Node in a Linked List (237)
11. ✅ **MergeKSortedLists.java** - Merge K Sorted Lists (23)
12. ✅ **ReorderList.java** - Reorder List (143)
13. ✅ **RotateList.java** - Rotate List (61)
14. ✅ **RemoveDuplicatesFromSortedList.java** - Remove Duplicates from Sorted List (83)
15. ✅ **ReverseNodesInKGroup.java** - Reverse Nodes in K-Group (25)
16. ✅ **SplitLinkedListInParts.java** - Split Linked List in Parts (725)
17. ✅ **SortList.java** - Sort List (148)
18. ✅ **SwapNodesInPairs.java** - Swap Nodes in Pairs (24)
19. ✅ **AddTwoNumbers.java** - Add Two Numbers (2)
20. ✅ **LinkedListCycleII.java** - Linked List Cycle II (142)
21. ✅ **RemoveZeroSumConsecutiveNodes.java** - Remove Zero Sum Consecutive Nodes (1171)
22. ✅ **PartitionList.java** - Partition List (86)
23. ✅ **FlattenMultilevelDoublyLinkedList.java** - Flatten a Multilevel Doubly Linked List (430)
24. ✅ **LRUCacheImplementation.java** - LRU Cache (146)

### Code Quality Standards Met

✅ **Approach Constraints**
- Two pointers (slow-fast) used where appropriate
- Dummy nodes for edge case handling
- In-place pointer manipulation
- Recursion only where suitable
- Hashing only when required
- O(n) time solutions prioritized

✅ **Input & Output**
- Scanner for input handling
- Clear input/output format comments
- Readable list printing (1 -> 2 -> 3 -> null)

✅ **Documentation**
- Time complexity mentioned
- Space complexity mentioned
- "Why Optimal" explanation included
- Meaningful variable names (current, prev, nextNode, slow, fast)
- Comments explaining pointer changes and base cases

✅ **Edge Cases Handled**
- Empty linked list
- Single-node list
- Two-node list
- Duplicate values
- Cycles in list
- Large input size

### File Structure
```
LeetcodeSolutions/
└── linked_list/
    ├── ReverseLinkedList.java
    ├── RemoveNthFromEnd.java
    ├── MergeTwoSortedLists.java
    ├── LinkedListCycle.java
    ├── RemoveLinkedListElements.java
    ├── OddEvenLinkedList.java
    ├── PalindromeLinkedList.java
    ├── IntersectionTwoLinkedLists.java
    ├── CopyListWithRandomPointer.java
    ├── DeleteNodeInLinkedList.java
    ├── MergeKSortedLists.java
    ├── ReorderList.java
    ├── RotateList.java
    ├── RemoveDuplicatesFromSortedList.java
    ├── ReverseNodesInKGroup.java
    ├── SplitLinkedListInParts.java
    ├── SortList.java
    ├── SwapNodesInPairs.java
    ├── AddTwoNumbers.java
    ├── LinkedListCycleII.java
    ├── RemoveZeroSumConsecutiveNodes.java
    ├── PartitionList.java
    ├── FlattenMultilevelDoublyLinkedList.java
    └── LRUCacheImplementation.java
```

### Key Techniques Demonstrated

1. **Two Pointers**: Fast/slow for cycle detection, finding middle
2. **Dummy Nodes**: Simplifying edge cases
3. **In-place Reversal**: Constant space pointer manipulation
4. **HashMap**: For O(1) lookups (LRU Cache, Copy with Random Pointer)
5. **Priority Queue**: For merging K sorted lists
6. **Prefix Sum**: For removing zero-sum sequences
7. **Merge Sort**: For O(n log n) sorting
8. **DFS/Recursion**: For multilevel flattening

All implementations are interview-ready, clean, and follow Java best practices!

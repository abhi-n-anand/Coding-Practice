/**

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    public ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start < end) {
            int middle = (start + end) / 2;
            ListNode l1 = partition(lists, middle + 1, end);
            ListNode l2 = partition(lists, start, middle);
            return merge(l1, l2);
        } else {
            return null;
        }
    }



    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l2.next, l1);
            return l2;
        }
    }

}

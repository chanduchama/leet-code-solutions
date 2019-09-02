package com.leetcode.solutions.addtwonumbers;

/***
 * Leet code problem statement 2
 */

public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(9);
        ListNode listNode6 = new ListNode(9);

        listNode4.next = listNode5;
        listNode5.next = listNode6;

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(listNode1,listNode4);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        printNodes(l1);
        printNodes(l2);

        ListNode listNode = new ListNode(-1);

        ListNode l1Next = l1;
        ListNode l2Next = l2;

        int sum = 0;
        int carry = 0;

        while (l1Next != null || l2Next != null){

            if(l1Next != null){
                sum += l1Next.val;
                l1Next = l1Next.next;
            }

            if(l2Next != null){
                sum += l2Next.val;
                l2Next = l2Next.next;
            }

            sum = sum + carry;

            if(sum > 9){
                carry = sum/10;
                sum = sum % 10;
            }else {
                carry = 0;
            }

            if(listNode.val == -1){
                listNode.val = sum;
            }else{
                ListNode node = new ListNode(sum);
                addLeafNode(listNode, node);
            }

            sum = 0;

        }

        if(carry != 0){
            ListNode node = new ListNode(carry);
            addLeafNode(listNode, node);
        }

        printNodes(listNode);

        return listNode;
    }

    private void addLeafNode(ListNode listNode, ListNode node) {

        ListNode currentNode = listNode;
        boolean hasLeaf = true;

        while(hasLeaf) {

            if(currentNode.next != null) {
                currentNode = currentNode.next;
            }else {
                hasLeaf = false;
                currentNode.next = node;
            }

        }

    }

    public void printNodes(ListNode listNode){
        ListNode printNode = listNode;

        boolean hasNext = true;

        while (hasNext){
            System.out.print(printNode.val);
            if(printNode.next != null) {
                printNode = printNode.next;
            }else {
                hasNext = false;
            }
        }

        System.out.println("");
    }
}

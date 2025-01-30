package com.ss.leetcode.LC2025.january;

public class NextGreaterElementIV {
    // https://leetcode.com/problems/next-greater-element-iv
    /** Algorithm
        1. On Next Greater Elemement, you traverse the monotonic stack and pop all the heads that are lesser than current element.
        2. With this one though, you also keep a count of each element.
        3. When traversing, increment the count of each element that is lesser than current one. If the count is 2, remove that element only.
            - So you need a linkedList or double linked list.
        4. Stop traversing the queue when you reach an element in the queue that is equal or greater than current elememnt.
     */
    public int[] secondGreaterElement(int[] nums) {
        int[] secondGreater = new int[nums.length];
        Element[] head = new Element[1];
        for (int i = 0; i < nums.length; i++) {
            findSecondGreater(i, nums, secondGreater, head);
        }
        return secondGreater;
    }

    private void findSecondGreater(int index, int[] nums, int[] secondGreater, Element[] head) {
        secondGreater[index] = -1;
        if (head[0] == null) {
            head[0] = new Element(index);
        } else {
            traverseAndMark(index, nums, secondGreater, head);
        }
    }

    private void traverseAndMark(int index, int[] nums, int[] secondGreater, Element[] head) {
        Element currentElement = head[0], nextElement = null;
        while (currentElement.next != null && nums[currentElement.index] < nums[index]) {
            currentElement.count++;
            nextElement = currentElement.next;
            if (currentElement.count == 2) {
                secondGreater[currentElement.index] = nums[index];
                removeElement(currentElement, head);
            }
            currentElement = nextElement;
        }
        if (nums[currentElement.index] < nums[index]) {
            currentElement.count++;
        }
        addElementToList(index, nums, currentElement, head);
    }

    private void addElementToList(int index, int[] nums, Element currentElement, Element[] head) {
        if (nums[index] <= nums[currentElement.index]) {
            addInFront(index, currentElement, head);
        } else { // add after
            Element newElement = new Element(index);
            newElement.prev = currentElement;
            newElement.next = currentElement.next;
            if (currentElement.next != null) {
                currentElement.next.prev = newElement;
            }
            currentElement.next = newElement;
        }
    }

    private void addInFront(int value, Element currentElement, Element[] head) {
        Element newElement = new Element(value);
        newElement.next = currentElement;
        newElement.prev = currentElement.prev;
        if (currentElement.prev != null) {
            currentElement.prev.next = newElement;
        }
        currentElement.prev = newElement;
        if (currentElement == head[0]) {
            head[0] = newElement;
        }
    }

    private void removeElement(Element currentElement, Element[] head) {
        if (currentElement == head[0]) {
            Element next = currentElement.next;
            next.prev = null;
            head[0].next = null;
            head[0] = next;
        } else {
            currentElement.prev.next = currentElement.next;
            currentElement.next.prev = currentElement.prev;
            currentElement.next = null;
            currentElement.prev = null;
        }
    }

    private static class Element {
        int index;
        int count;
        Element next;
        Element prev;
        public Element(int index) {
            this.index = index;
        }
    }
}

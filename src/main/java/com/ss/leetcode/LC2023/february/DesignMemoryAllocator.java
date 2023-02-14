package com.ss.leetcode.LC2023.february;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignMemoryAllocator {
    // https://leetcode.com/problems/design-memory-allocator
    /** Algorithm
        1. Create a double linked list of MemoryBlock (int start, end)
        2. Start by adding MemoryBlocks traverse from head and  stopping when there is a gap between current and next.
        - Pay attention to the case when you can add before the head or at the tail.
        3. Maintain a Map<mId, List<MemoryBlock>> to access the elements in the LinkedList for deletion.
        4. For a shallow quick-fail, also keep track of remaining capacity to reject allocations when not enough space remains globally
     */
    private final Map<Integer, List<MemoryBlock>> mids;
    private final int maxSize;
    private MemoryBlock head;
    private int remaining;
    public DesignMemoryAllocator(int n) {
        this.maxSize = n;
        this.remaining = n;
        mids = new HashMap<>();
    }

    public int allocate(int size, int mID) {
        if (remaining < size) {
            return -1;
        }
        if (head == null) {
            head = new MemoryBlock(0, size, mID);
            remaining -= size;
            mids.computeIfAbsent(mID, k -> new ArrayList<>()).add(head);
            return head.start;
        } else {
            return traverseAndInsert(size, mID);
        }
    }

    private int traverseAndInsert(int size, int mID) {
        MemoryBlock iterator = head;
        while(iterator != null) {
            int leftAvailable = iterator.previous == null ? iterator.start : (iterator.start - iterator.previous.end) - 1;
            if (leftAvailable >= size) {
                MemoryBlock newBlock;
                if (iterator.previous == null) {
                    // new head!
                    newBlock = new MemoryBlock(0, size, mID);
                    newBlock.next = iterator;
                    iterator.previous = newBlock;
                    head = newBlock;
                } else {
                    newBlock = new MemoryBlock(iterator.previous.end +1, size, mID);
                    iterator.previous.next = newBlock;
                    newBlock.previous = iterator.previous;
                    newBlock.next = iterator;
                    iterator.previous = newBlock;
                }
                mids.computeIfAbsent(mID, k -> new ArrayList<>()).add(newBlock);
                remaining -= size;
                return newBlock.start;
            }
            if (iterator.next == null) {
                break;
            }
            iterator = iterator.next;
        }
        // reached the end/tail.
        if (maxSize - iterator.end > size) {
            // add at the end
            MemoryBlock newBlock = new MemoryBlock(iterator.end +1, size, mID);
            newBlock.previous = iterator;
            iterator.next = newBlock;
            mids.computeIfAbsent(mID, k -> new ArrayList<>()).add(newBlock);
            remaining -= size;
            return newBlock.start;
        } else {
            return -1;
        }
    }

    public int free(int mID) {
        List<MemoryBlock> deallocated = mids.remove(mID);
        if (deallocated != null && !deallocated.isEmpty()) {
            int space = 0;
            for (MemoryBlock mb : deallocated) {
                space += mb.end - mb.start + 1;
                deallocateBlock(mb);
            }
            return space;
        }
        return 0;
    }

    private void deallocateBlock(MemoryBlock mb) {
        if (head == mb) {
            if (head.next != null) {
                head.next.previous = null;
            }
            head = mb.next;
            mb.next = null;
            // tail
        } else if (mb.next == null) {
            mb.previous.next = null;
            mb.previous = null;
        } else { // somewhere in the middle
            mb.previous.next = mb.next;
            mb.next.previous = mb.previous;
        }
        remaining += (mb.end - mb.start + 1);
    }

    private static class MemoryBlock {
        int start;
        int end;
        int mID;
        MemoryBlock previous;
        MemoryBlock next;

        public MemoryBlock(int start, int size, int mID) {
            this.start = start;
            this.end = start + size - 1;
            this.mID = mID;
        }
    }
}

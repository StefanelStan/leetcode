package com.ss.leetcode.LC2022.june;

import java.util.Arrays;
import java.util.LinkedList;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    // https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
    /** Algorithm
        1. Count and sort the frequencies
        2. Starting from back, IF needed, to make each frequency distinct from previous one, deducting 1 from prev one.
        3. For i =  n -2 .. 0 in array of frequencies
            - If freq[i] >= freq[i+1], then freq[i] then freq[i] = diff + 1, unless freq[i+1] is 0,
            which means current freq needs to be 0 as well.
        4. Loop and lower each freq until you reach 0.
        5. Return the sum
     */
    public int minDeletions(String s) {
        int deletions = 0, toDelete;
        int[] sortedCount = getCharCount(s);
        for (int i = sortedCount.length - 2; i >= 0 && sortedCount[i] != 0; i--) {
            if (sortedCount[i] >= sortedCount[i+1]) {
                toDelete = sortedCount[i+1] == 0 ? sortedCount[i] : 1 + sortedCount[i] - sortedCount[i+1];
                deletions += toDelete;
                sortedCount[i] = sortedCount[i] - toDelete;
            }
        }
        return deletions;
    }

    private int[] getCharCount(String s) {
        int[] count =  new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        Arrays.sort(count);
        return count;
    }


    public int minDeletions2(String s) {
        int[] minDeletions = {0};
        int[] count = countAndSortLetters(s);
        if (count.length == 1) {
            return 0;
        }
        LinkedList<Integer> freeFrequencies = new LinkedList<>();
        addAvailableFrequencies(freeFrequencies, count, count[0] - 1, 1, 25);
        for (int i = 1; i < count.length; i++) {
            if (count[i] != count[i-1]) {
                addAvailableFrequencies(freeFrequencies, count, count[i]-1, count[i-1] + 1, count.length - i);
            } else {
                if (!freeFrequencies.isEmpty()) {
                    minDeletions[0] += count[i] - freeFrequencies.removeLast();
                } else {
                    minDeletions[0] += count[i];
                }
            }
        }
        return minDeletions[0];
    }

    private void addAvailableFrequencies(LinkedList<Integer> freeFrequencies, int[] count, int from, int to, int steps) {
        int start = Math.max(from - steps, to);
        while (start <= from && steps >= 0) {
            freeFrequencies.addLast(start);
            start++;
            steps--;
        }
    }
    /** Algorithm/Theory
         1. Count the letters (a-z) and get their int[] count: eg: "aabbc" [2,2,1].
         2. In order for char frequencies to be unique, we need to make the count array unique.
         3. Sort the letters. A sorted array will be a good indicator to know where would be the first free frequency available
             eg: "aaabbbc" -> frequency is [1,3,3].
             So when we are on frequency[2] == 3, we need to lower it to the first smallest free frequency, which is 2.
         4. As observed, in fact we have an array/list of numbers and we have to move/swap between them so they are unique.
            Thus, a DOUBLE LINKED LIST of preferred, as we can move backwords from current position to find the next "free" frequency and insert the node.
         5. Create the DLL and start adding objects/frequencies into it. When a frequency repeats, just navigate back in the list and
             find the first free slot where this new node/frequency can be introduced.
             eg:  1->2->4->5 and next frequency is 5. Thus, we need to navigate backwords in DLL and find the first pair where the diff > 1
             Once found, just insert the new node between the two nodes. Pay attention IF you are inserting at the beginning of list.
         6. PRO TIP: you don't need to always navigate from current node (tail all the way back. You can actually keep a pointer to the
             last node that was introduced with a gap > 1.
             eg: 1->2->4->5->7->8
             As we can see, when we introduce 4, the difference between 4 and 2 is 2, so this node (4) can be the pointer to the first free available slot/frequency
             When we introduce 7, the same, we see that 7-5 > 1 so, 7 is the NEW pointer to the closest free frequency /slot.
             You can use a stack to put these or just one pointer; when used, then find a new one, navigating back
     */
    public int minDeletions3(String s) {
        int[] minDeletions = {0};
        int[] count = countAndSortLetters(s);
        if (count.length == 1) {
            return 0;
        }
        UniqueFrequency current = new UniqueFrequency(count[0]);
        UniqueFrequency firstLowest = current;
        for (int i = 1; i < count.length; i++) {
            if (count[i] != count[i-1]) {
                // if current frequency is not repeated, just insert it.
                UniqueFrequency newNode = new UniqueFrequency(count[i]);
                current.next = newNode;
                newNode.previous = current;
                current = newNode;
                // if the gap between current and previous is > 1, then this new node will be the pointer to the first available frequency slot.
                // if the gap is == 1, them a new node cannot be introduced between current and previous, so leave the pointer alone.
                if (count[i] - count[i-1] > 1) {
                    firstLowest = current;
                }
            } else {
                // equal frequencies
                UniqueFrequency firstAvailable = getFirstAvailable(firstLowest, count[i]);
                if (firstAvailable == null) {
                    // if no free slot was found, the whole frequency must be deleted.
                    minDeletions[0] += count[i];
                } else {
                    UniqueFrequency newNode = new UniqueFrequency(firstAvailable.count - 1);
                    UniqueFrequency prev = firstAvailable.previous;
                    // if the insert point is NOT head, insert this new node in between
                    if (prev != null) {
                        prev.next = newNode;
                        newNode.previous = prev;
                    }
                    newNode.next = firstAvailable;
                    firstAvailable.previous = newNode;
                    firstLowest = newNode;
                    minDeletions[0] += (count[i] - newNode.count);
                }
            }
        }
        return minDeletions[0];
    }

    private UniqueFrequency getFirstAvailable(UniqueFrequency from, int value) {
        // while you did not reach the head and the frequency is > 1 (if frequency is 1, you cannot inser with a frequency of 0)
        while (from.previous != null && from.count > 1) {
            // found a gap ? return it!
            if (from.count - from.previous.count > 1) {
                return from;
            }
            from = from.previous;
        }
        // if loop broke when frequency hit 1. This means the new node cannot be introduced, as no free frequency slot available
        return from.count == 1 ? null : from;
    }

    private int[] countAndSortLetters(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Arrays.sort(count);
        int index = 0;
        while(count[index] == 0) {
            index++;
        }
        // depending on letters, the frequencies might be 0,0,0,0,1,2.... Trim from the first non zero, to ease of handling it
        return Arrays.copyOfRange(count, index, count.length);
    }

    private static class UniqueFrequency {
        UniqueFrequency next;
        UniqueFrequency previous;
        int count;

        public UniqueFrequency(int count) {
            this.count = count;
        }
    }
}

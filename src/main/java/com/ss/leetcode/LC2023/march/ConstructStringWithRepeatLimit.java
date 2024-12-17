package com.ss.leetcode.LC2023.march;

public class ConstructStringWithRepeatLimit {
    // https://leetcode.com/problems/construct-string-with-repeat-limit/
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        return repeatString(charCount, repeatLimit);
    }

    private String repeatString(int[] charCount, int limit) {
        StringBuilder stb = new StringBuilder();
        boolean finished = false;
        int currentLargest = 25, nextLargest;
        int lastAppendedCount = 0;
        int lastAppendedChar = -1;
        while (!finished) {
            while (currentLargest >= 0 && charCount[currentLargest] == 0) {
                currentLargest--;
            }
            if (currentLargest == -1) {
                finished = true;
            } else {
                lastAppendedCount = currentLargest == lastAppendedChar
                    ? Math.min(limit - lastAppendedCount, charCount[currentLargest])
                    : Math.min(limit, charCount[currentLargest]);
                lastAppendedChar = currentLargest;
                append(stb, (char)(currentLargest + 'a'), lastAppendedCount);
                charCount[currentLargest] -= lastAppendedCount;

                if (charCount[currentLargest] > 0) {
                    nextLargest = currentLargest - 1;
                    while (nextLargest >= 0 && charCount[nextLargest] == 0) {
                        nextLargest--;
                    }
                    if (nextLargest == -1) {
                        finished = true;
                    } else {
                        lastAppendedChar = nextLargest;
                        lastAppendedCount = 1;
                        append(stb, (char)(nextLargest + 'a'), lastAppendedCount);
                        charCount[nextLargest] -= lastAppendedCount;
                    }
                }
            }
        }
        return stb.toString();
    }

    private void append(StringBuilder stb, char ch, int times) {
        while (times-- > 0) {
            stb.append(ch);
        }
    }

    public String repeatLimitedString2(String s, int repeatLimit) {
        CharNode[] tail = countChars(s);

        StringHolder sh = new StringHolder();
        boolean canAddCharacters = true;
        while(canAddCharacters && tail[0] != null) {
            if (sh.lastChar != tail[0].ch)
                canAddCharacters = addCharsFrom(sh, repeatLimit, tail, tail[0]);
            else if (sh.lastCount < repeatLimit) {
                canAddCharacters = addCharsFrom(sh, repeatLimit - sh.lastCount, tail, tail[0]);
            } else {
                canAddCharacters = addCharsFrom(sh, 1, tail, tail[0].prev);
            }
        }
        return sh.stb.toString();
    }

    private boolean addCharsFrom(StringHolder sh, int limit, CharNode[] tail, CharNode from) {
        if (from == null) {
            return false;
        }
        while (limit > 0 && from != null) {
            sh.addChar(from.ch);
            if (--from.count == 0) {
                CharNode prev = from.prev;
                removeNode(from, tail);
                from = prev;
            }
            limit--;
        }
        return true;
    }

    private void removeNode (CharNode node, CharNode[] tail) {
        if (node == tail[0]) {
            tail[0] = node.prev;
            // avoid useless objects being referenced
            if(node.prev != null) {
                node.prev = null;
            }
        } else if (node.prev == null) {
            node.next.prev = null;
            node.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }
    }

    private CharNode[] countChars(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        CharNode head = null;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                CharNode newNode = new CharNode((char)(i + 'a'), count[i]);
                if (head == null) {
                    head = newNode;
                } else {
                    head.next = newNode;
                    newNode.prev = head;
                    head = newNode;
                }
            }
        }
        return new CharNode[]{head};
    }

    private static class StringHolder {
        StringBuilder stb;
        char lastChar;
        int lastCount;

        public StringHolder() {
            stb = new StringBuilder();
        }

        public void addChar(char ch) {
            stb.append(ch);
            if (lastChar == ch) {
                lastCount++;
            } else {
                lastChar = ch;
                lastCount = 1;
            }
        }
    }

    private static class CharNode {
        char ch;
        int count;
        CharNode prev;
        CharNode next;

        public CharNode(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}

import java.util.TreeMap;

class Solution {
    // Segment Tree Node definition
    class Node {
        int maxLen;
        int prefixLen;
        int suffixLen;
        char leftChar;
        char rightChar;
        int totalLen;

        Node(char ch) {
            this.maxLen = 1;
            this.prefixLen = 1;
            this.suffixLen = 1;
            this.leftChar = ch;
            this.rightChar = ch;
            this.totalLen = 1;
        }

        Node() {
            this.maxLen = 0;
            this.prefixLen = 0;
            this.suffixLen = 0;
            this.totalLen = 0;
        }
    }

    private Node[] tree;
    private char[] chars;

    // Helper method to merge two adjacent segment tree nodes
    private Node merge(Node left, Node right) {
        if (left.totalLen == 0) return right;
        if (right.totalLen == 0) return left;

        Node parent = new Node();
        parent.totalLen = left.totalLen + right.totalLen;
        parent.leftChar = left.leftChar;
        parent.rightChar = right.rightChar;

        // Base merge logic: max is at least the max of either side
        parent.maxLen = Math.max(left.maxLen, right.maxLen);
        parent.prefixLen = left.prefixLen;
        parent.suffixLen = right.suffixLen;

        // If the middle characters match, the boundaries can merge
        if (left.rightChar == right.leftChar) {
            int combinedMiddle = left.suffixLen + right.prefixLen;
            parent.maxLen = Math.max(parent.maxLen, combinedMiddle);

            // If the entire left node is uniform, the prefix extends into the right node
            if (left.prefixLen == left.totalLen) {
                parent.prefixLen = left.totalLen + right.prefixLen;
            }
            // If the entire right node is uniform, the suffix extends into the left node
            if (right.suffixLen == right.totalLen) {
                parent.suffixLen = right.totalLen + left.suffixLen;
            }
        }

        return parent;
    }

    // Build the Segment Tree initially
    private void buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(chars[start]);
            return;
        }
        int mid = start + (end - start) / 2;
        buildTree(2 * node, start, mid);
        buildTree(2 * node + 1, mid + 1, end);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    // Point update: Change character at a specific index
    private void updateTree(int node, int start, int end, int idx, char ch) {
        if (start == end) {
            chars[idx] = ch;
            tree[node] = new Node(ch);
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            updateTree(2 * node, start, mid, idx, ch);
        } else {
            updateTree(2 * node + 1, mid + 1, end, idx, ch);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        this.chars = s.toCharArray();
        this.tree = new Node[4 * n];

        buildTree(1, 0, n - 1);

        int q = queryIndices.length;
        int[] result = new int[q];

        for (int i = 0; i < q; i++) {
            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            // Execute point update in O(log N)
            updateTree(1, 0, n - 1, idx, ch);
            
            // The root node (index 1) always holds the maximum for the entire string
            result[i] = tree[1].maxLen;
        }

        return result;
    }
}

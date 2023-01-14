class Solution0116 { 
    public Node connect(Node root) {
        if (root == null) return root;
        Node leftmost = root;
        while(leftmost.left != null) {
            Node cur = leftmost;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            leftmost = leftmost.left;
        }

        return root;
    }
}
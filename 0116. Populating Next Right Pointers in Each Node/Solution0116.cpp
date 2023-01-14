class Solution0116 {
public:
    Node* connect(Node* root) {
        if (root == NULL) {
            return root;
        }
        Node* leftmost = root;
        while (leftmost->left != NULL) {
            Node* cur = leftmost;
            while (cur != NULL) {
                cur->left->next = cur->right;
                if (cur->next != NULL) {
                    cur->right->next = cur->next->left;
                }
                cur = cur->next;
            }
            leftmost = leftmost->left;
        }
        return root;
    }
};
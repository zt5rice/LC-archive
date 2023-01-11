#include<vector>
#include<iostream>
#include<queue>

using namespace std;

class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};


class Solution0429 {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;
        if (root == nullptr) return res;
        queue<Node*> queue;
        queue.push(root);
        while (!queue.empty()) {
            int size = queue.size();
            vector<int> curLayer;
            for (int i = 0; i < size; i++) {
                Node* tmp = queue.front(); queue.pop();
                curLayer.push_back(tmp->val);
                for (Node* child : tmp->children) {
                    queue.push(child);
                }
            }
            res.push_back(curLayer);
        }
        return res;
    }
};
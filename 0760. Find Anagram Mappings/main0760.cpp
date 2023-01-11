class Solution0760 {
public:
    vector<int> anagramMappings(vector<int>& A, vector<int>& B) {
        map<int, int> D;
        for (int i = 0; i < B.size(); ++i)
            D[B[i]] = i;
        vector<int>ans(A.size(),0);
        int t = 0;
        for (int x: A)
            ans[t++] = D[x];
        return ans;        
    }
};
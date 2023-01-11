class Solution0274 {
public:
    int hIndex0(vector<int>& citations) {
        sort(citations.begin(), citations.end());
        int res = 0, i = citations.size()-1;
        while (i >= 0 && citations[i] > res) {
            res++;
            i--;
        }
        return res;
    }

    int hIndex(vector<int>& arr) {
        int n = arr.size();
        vector<int> mapAN(n+1, 0);
        for(int i = 0; i < n; i++)
            if(arr[i] < n)
                mapAN[arr[i]]++;
            else
                mapAN[n]++;
        
        int countGreater = 0;
        for(int i = n; i >= 0; i--){
            if(i <= countGreater+mapAN[i])
                return i;
            countGreater = countGreater + mapAN[i];
        }
        return 0;
    }
};
import java.util.TreeMap;

public class Solution0715 {
 public static void main(String[] args) {
     RangeModule obj = new RangeModule();
     int left = 10, right = 15;
     obj.addRange(left,right);
     boolean param_2 = obj.queryRange(left,right);
     obj.removeRange(left,right);
 }
}


class RangeModule {

    TreeMap<Integer,Integer> map;
    public RangeModule() {
        map = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        if(left >= right) return;
        //找到当前区间的左边的参考区间开始start
        Integer start = map.floorKey(left);
        if(start == null) start = map.ceilingKey(left);
        
        while(start != null && start <= right){
            int end = map.get(start);
            //start,end <--->. 
            //[left, right]
            if(end >= left){
                //有重叠？ 怎么做->1.先删除重叠区间。2.更新区间和Merge Interval一样，左边取小，右边取大。
                map.remove(start);
                //更新区间
                left = Math.min(left,start);
                right = Math.max(right,end);
            }
            start = map.ceilingKey(end);
        }
        map.put(left,right);
        
    }
    
    public boolean queryRange(int left, int right) {
        Integer start = map.floorKey(left);
        // [start,end] 包含 left,right
        return start != null && map.get(start) >= right;
    }
    
    public void removeRange(int left, int right) {
        if(left >= right) return;
        Integer start = map.floorKey(left);
        if(start == null) start = map.ceilingKey(left);//找不到左边最近的，就找右边的最近的，这两个最有可能重合
        while(start != null && start < right){
            int end = map.get(start);
            if(end >= left){
                //有重叠，怎么做 -> 1、删掉重合部分 2、将剩下新生成的加入map 
                map.remove(start);
                // start----[left,... right] --- end
                //切掉重叠，不就是剩start-left, right-end吗
                if(start < left) map.put(start,left); 
                if(end > right) map.put(right,end);
                
            }
            start = map.ceilingKey(end);//更新start，查看下一个可能的区间有没有重复。
        }
    }

// 作者：script_kiddle
// 链接：https://leetcode.cn/problems/range-module/solution/yong-treemaplai-zuo-shi-qu-jian-he-bing-oh76z/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
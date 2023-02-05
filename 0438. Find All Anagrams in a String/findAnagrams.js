/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams = function(s, p) {
    let smap = {};
    let pmap = {};
    let slen = s.length;
    let plen = p.length;
    res = [];
    let equals = function(amap, bmap) {
        for (let akey in amap) {
            if (!bmap[akey]) return false;
            if (amap[akey] != bmap[akey]) return false;
        }
        return true;
    }
    for (let i = 0; i < plen; i++) {
        pmap[p[i]] = (pmap[p[i]] || 0) + 1;
    }
    // console.log(pmap)
    for (let i = 0; i < slen; i++) {
        if (i >= plen) {
            smap[s[i-plen]]--;
        }
        smap[s[i]] = (smap[s[i]] || 0) + 1;
        if (i >= plen - 1) {
            if (equals(pmap, smap)) { // !!! pmap, smap sequence matters
                res.push(i+1-plen);
            }
            // console.log(smap)
        }
    }
    return res;
};
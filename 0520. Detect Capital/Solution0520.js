/**
 * @param {string} word
 * @return {boolean}
 */
var detectCapitalUse = function(word) {
    let cap = 0;
    let first = false;
    for (let i = 0; i < word.length; i++) {
        if (i == 0 && word[i].toUpperCase()==word[i]) {
            first = true;
        }
        if (word[i].toUpperCase()==word[i]) {
            cap++;
        }
    }
    return (cap == 0 || cap == word.length || (cap == 1 && first));      
};
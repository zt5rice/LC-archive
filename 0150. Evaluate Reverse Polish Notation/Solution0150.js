var evalRPN = function(tokens) {
    let stk = [];
    let ops = {
        '+': (a, b) => a + b,
        '-': (a, b) => a - b,
        '*': (a, b) => a * b,
        '/': (a, b) => a / b >= 0 ? Math.floor(a / b) : Math.ceil(a / b)
    };

    for (let t of tokens) {
        if (ops[t]) {
            let n2 = stk.pop();
            let n1 = stk.pop();
            stk.push(ops[t](n1, n2));
        } else {
            stk.push(Number(t));
        }
    }
    return stk.pop();
};
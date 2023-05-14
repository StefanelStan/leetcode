// https://leetcode.com/problems/counter-ii
var createCounter = function (init) {
    let value = init;
    const snapshot = init;

    function increment() {
        value++;
        return value;
    }

    function decrement() {
        value--;
        return value;
    }

    function reset() {
        value = snapshot;
        return value;
    }

    return {increment, decrement, reset};
};
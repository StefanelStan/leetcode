// https://leetcode.com/problems/apply-transform-over-each-element-in-array
/** Algorithm
 1. Replace each item of arr with the result of fn(item, index);
 2. Return arr;
 */
var map = function (arr, fn) {
    for (let i = 0; i < arr.length; i++) {
        arr[i] = fn(arr[i], i);
    }
    return arr;
};
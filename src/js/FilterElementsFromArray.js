// https://leetcode.com/problems/filter-elements-from-array
/** Algorithm
 1. Iterate over array and pass each item and its index to the fn.
 2. If fn returns true, add that element to the result array
 3. Return result array
 */
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
  let result = [];
  for (let i = 0; i < arr.length; i++) {
    if (fn(arr[i], i)) {
      result.push(arr[i]);
    }
  }
  return result;
};
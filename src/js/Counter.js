// https://leetcode.com/problems/counter
/** Algorithm
 *  1. Declare a variable m that stores n -1;
 *  2. On the return function just increment m by 1 and return m;
 */
/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
  let m = n - 1;
  return function() {
    m++;
    return m;
  };
};
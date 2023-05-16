// https://leetcode.com/problems/chunk-array
/** Algorithm
 1. Declare an array chunks[] that will hold the result and a part[] temp/bag array
 2. Traverse arr and add each element to part, increasing capacity
 3. When capacity hits size, add part to chunks and reset capacity
 4. If capacity > 0, add the last part to chunks.
 */
var chunk = function(arr, size) {
    const chunks = [];
    let capacity = 0;
    let part = [];
    for (let num of arr) {
        part.push(num);
        capacity++;
        if (capacity === size) {
            chunks.push(part);
            capacity = 0;
            part = [];
        }
    }
    if (capacity > 0) {
        chunks.push(part);
    }
    return chunks;
};
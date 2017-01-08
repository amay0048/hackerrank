// This is the actual component, if I was to write the real version, I would
// probably abstract the parseInput into the test harness, but this way is easier
// when I submit things to hackerrank.

// For the requirements for this see:
// https://www.hackerrank.com/challenges/s10-standard-deviation

function parseInput(input) {
    var lines = input.split('\n');
    var set = Uint32Array.from(lines[1].split(' '));

    if (set.length != parseInt(lines, 10)) {
        throw 'Error reading input';
    }
    
    return set;
}

function standardDeviation(set) {
    var mean = set.reduce((prev, curr) => curr + prev, 0) / set.length;
    var sumSquares = set.reduce((prev, curr) => Math.pow((curr - mean), 2) + prev, 0);
    return Math.sqrt(sumSquares / set.length);
}

function solution(input) {
    return standardDeviation(parseInput(input)).toFixed(1).toString();
}

// Typically the api wouldn't expose solution, and it would be the 
// responsibility of the function calling the api to be responsible for
// providing the data in the correct format. i.e. and array of numbers
module.exports = {
    standardDeviation: standardDeviation,
    solution: solution
};
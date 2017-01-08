// Hackerrank passes the input via std, this is a harness to run the solution the hackerrank way.

const solution = require('./index.js');

function processData(input) {
    process.stdout.write(solution(input));
} 

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
   processData(_input);
});

module.exports = processData;
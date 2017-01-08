// The simplest possible test, iterates through the data in the test/data
// folder, executes the solution for each case, and assets the output 
// matches the expected output from the data.

const assert = require('assert');
const path = require('path');
const fs = require('fs');
const solution = require('../index.js').solution;

var cwd = process.cwd();
var baseDataDir = path.join(cwd,'test','data');

var files = fs.readdirSync(baseDataDir);

files.forEach((file) => {
    var input = fs.readFileSync(path.join(baseDataDir,file,'in.txt'));
    var expected = fs.readFileSync(path.join(baseDataDir,file,'out.txt'));
    assert.equal(solution(input.toString()), expected.toString());
    process.stdout.write(`TEST ${file.toUpperCase()}: Completed successfully\n`);
});

process.stdout.write('ALL TESTS: Completed successfully\n');
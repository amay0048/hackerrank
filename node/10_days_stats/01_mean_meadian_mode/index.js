// This is the actual component, if I was to write the real version, I would
// probably abstract the parseInput into the test harness, but this way is easier
// when I submit things to hackerrank.

// For the requirements for this see:
// https://www.hackerrank.com/challenges/s10-basic-statistics

function parseInput(input) {
    var lines = input.split('\n');
    var set = Uint32Array.from(lines[1].split(' '));

    if (set.length != parseInt(lines, 10)) {
        throw 'Error reading input';
    }
    
    return set;
}

function mean(set) {
    var out = set.reduce((prev, curr) => curr + prev, 0) / set.length
    return out.toFixed(1);
}

function median(set) {
    var out;
    var mid = Math.floor(set.length/2);
    if (set.length % 2 == 0) {
        out = (set[mid] + set[mid - 1]) / 2;
    } else {
        out = set[mid];
    }
    return out.toFixed(1);
}

function mode(set) {
    var out = 0;
    var dict = {};
    var maxCount = 0;

    set.forEach((curr) => {
        if (dict.hasOwnProperty(curr)) {
             dict[curr]++;
        } else {
            dict[curr] = 1;
        }

        if (dict[curr] > maxCount) {
            maxCount = dict[curr];
            out = curr;
        } else if (dict[curr] == maxCount) {
            if (curr < out) {
                out = curr;
            }
        }
    });

    return out;
}

function solution(input) {
    var output = [];
    var set = parseInput(input);

    // Typically, the sort should be part of the mean, median, and mode 
    // functions, but I'm pre-sorting the list to maximize performance
    set.sort();
    output.push(mean(set).toString());
    output.push(median(set).toString());
    output.push(mode(set).toString());

    return output.join('\n');
}


// Typically the api wouldn't expose solution, and it would be the 
// responsibility of the function calling the api to be responsible for
// providing the data in the correct format. i.e. and array of numbers
module.exports = {
    mean: mean,
    median: median,
    mode: mode,
    solution: solution
};
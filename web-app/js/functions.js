var arrFunctions = new Array();

function executeFunctions() {
    for (i = 0; i < arrFunctions.length; i++) {
        arrFunctions[i].call();
    }
}

function addFunction(f) {
    arrFunctions.push(f);
}
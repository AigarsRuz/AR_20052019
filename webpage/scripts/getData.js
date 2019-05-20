
const addBtn = document.getElementById('cardBtn');
const getBtn = document.getElementById('getDataBtn');

var csvRequest = new XMLHttpRequest();

csvRequest.onreadystatechange = function() {
    if (csvRequest.readyState == XMLHttpRequest.DONE) 
    {
        addTable(csvRequest.responseText);
    }
}

addBtn.onclick = function() 
{
    var xhr = new XMLHttpRequest();
    var url = "http://localhost:8080/addCard";

    var bank = document.getElementById("bankText").value;
    var card = document.getElementById("cardText").value;
    var expiry = document.getElementById("expiryText").value;

    var params = "bank=" + bank + "&card=" + card + "&date=" + expiry;
    console.log(params);

    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(params);

    clearTable();
}

getBtn.onclick = function()
{
    var url = "http://localhost:8080/getTable";
    csvRequest.open("GET", url, true);
    csvRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    csvRequest.send();
}

function processSelectedFiles(fileInput) {
    var files = fileInput.files;
  
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/addCSV");
    xhr.overrideMimeType('text/plain; charset=x-user-defined-binary');
    xhr.send(files[0]);
  }
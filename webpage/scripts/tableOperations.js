function clearTable()
{
    document.getElementById("bankText").value = "";
    document.getElementById("cardText").value = "";
    document.getElementById("expiryText").value = "";
}

function addHeaders(table, keys) {
  var row = table.insertRow();
  for( var i = 0; i < keys.length; i++ ) {
    var cell = row.insertCell();
    cell.appendChild(document.createTextNode(keys[i]));
  }
}

function addTable(responseJson)
{
    var children = JSON.parse(responseJson);

    var table = document.createElement('table');

    for( var i = 0; i < children.length; i++ ) 
    {
    var child = children[i];
    if(i === 0 ) {
        addHeaders(table, ["Bank", "Card Number", "Expiry Date"]);
    }
    var row = table.insertRow();
    Object.keys(child).forEach(function(k) 
    {
        var cell = row.insertCell();
        cell.appendChild(document.createTextNode(child[k]));
    })
    }

    const container = document.getElementById('container');

    container.innerHTML = "";
    container.appendChild(table);
}

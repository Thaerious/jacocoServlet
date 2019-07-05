
async function postJSON(url, json = "{}") {    
    let callback = function (resolve, reject) {
        document.querySelector("#throbber").style.display = "block";
        var xhttp = new XMLHttpRequest();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4) {
                document.querySelector("#throbber").style.display = "none";
                console.log(xhttp.responseText);
                if (xhttp.status === 200) {
                    resolve(JSON.parse(xhttp.responseText));
                } 
                if (xhttp.status === 404) {
                    reject(xhttp.responseText);                
                }
                else {
                    reject(JSON.parse(xhttp.responseText));
                }
            }
        };

        xhttp.open("POST", url, true);
        xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");        
        xhttp.send(json);
    };

    return new Promise(callback);
}


//Variables
let elements = [1,2,3,4,5];
let fullWeight = document.getElementById('findWeight');
let button = document.getElementById('searchButton');
let select = document.querySelector('#what');
let select2 = document.querySelector('#what2');
let bestRoute = document.getElementById('bestRoute');



/*
for(let i = 0; i < 5; i++){
    let opt2 = document.createElement("option");
    opt2.value = elements[i].toString();
    opt2.text = elements[i].toString();
    select2.add(opt2);
}
*/

button.onclick = function(){
    //Add code to generate route
    console.log("Hola");
    bestRoute.innerHTML = "La mejor ruta: ";
}
fullWeight.onclick = function(){
    console.log("Khe");
    bestRoute.innerHTML = "El costo total es: ";
}

document.addEventListener("DOMContentLoaded", function(){
    getData();
});
async function getData(){
    const request = await fetch('vertex/get',{
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },

    });

    const routes = await request.json();

    //let i = 1
    for (let route of routes) {
        let opt3 = document.createElement("option");
        opt3.value = route.value;
        opt3.text = route.name;
        select2.add(opt3);
    }

    for (let route of routes) {
        let opt2 = document.createElement("option");
        opt2.value = route.value;
        opt2.text = route.name;
        select.add(opt2);
    }
    //document.querySelector("#tablePlayers tbody").outerHTML = listHtml
}


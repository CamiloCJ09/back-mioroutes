

//Variables
let generalRoutes = [];
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
    calculateBestRoute();
}
fullWeight.onclick = function(){
    console.log("Khe");
    getAllWeight();
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
        generalRoutes.push(route);
    }
}

async function getAllWeight() {
    const request = await fetch('routeAll/allCity',{
        method: 'PUT',
        headers: {
            'Content-Type':'application/json'
        },
    })
    const request2 = await fetch('routeAll/getBestCostAllCity',{
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },

    });
    const calc = await request.json();
    const calc2 = await request2.json();

    bestRoute.innerHTML = "El costo total en km es: "+calc2.totalCost.toString();
}

async function calculateBestRoute() {
    let value1 = select.value;
    let value2 = select2.value;
    const request = await fetch('routes/calculate/'+value1+'/'+value2,{
        method: 'PUT',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(value1,value2)
    })
    const request2 = await fetch('routes/getBestRoute',{
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },

    });
    const calc = await request.json();
    const routes = await request2.json();


    let bestR = routes.bestRoute.toString();
    let vert = bestR.split(',');
    let answ = "";
    console.log(vert);
    vert.forEach(function(vert){
        generalRoutes.forEach(function(rt){
            //console.log(vert+"hi");
            //console.log(rt.value+"Lo");
            if(vert==rt.value){
                console.log(rt.value);
                answ += (rt.name+",");
            }
        })
    })
    answ = answ.substr(0,answ.length-1);
    bestRoute.innerHTML = "La mejor ruta es: "+answ+".";
}

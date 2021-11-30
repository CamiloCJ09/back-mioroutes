

//Variables
let elements = [1,2,3,4,5];
let button = document.getElementById('searchButton');
let select = document.querySelector('#what');
let select2 = document.querySelector('#what2');



for(let i = 0; i < 5; i++){
    let opt1 = document.createElement("option");
    opt1.value = elements[i].toString();
    opt1.text = elements[i].toString();
    select.add(opt1);
}
for(let i = 0; i < 5; i++){
    let opt2 = document.createElement("option");
    opt2.value = elements[i].toString();
    opt2.text = elements[i].toString();
    select2.add(opt2);
}

button.onclick = function(){
    //Add code to generate route
    console.log("Hola");
}
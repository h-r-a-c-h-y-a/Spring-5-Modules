document.addEventListener('DOMContentLoaded', function(){
    document.getElementById("all").addEventListener("click", () => {
        const xmlHttpRequest = new XMLHttpRequest();
        xmlHttpRequest.open("GET", "http://localhost:8080/all");
        xmlHttpRequest.send();
        let arr = new Array();
        xmlHttpRequest.onreadystatechange = () => {
            arr.push((xmlHttpRequest.response).split('data:')[1]);
        };
        console.log(arr);
    })
});
window.onload = fetchpdetails;
let aid;
async function fetchpdetails(){
    let url = new URL(window.location.href);
    aid=url.searchParams.get("aid");
    if(aid===null){
        alert("Session expired, Please login");
        window.open("index.html","_self");
        return;
    }
    let response = await fetch('api/viewdata/pdetails',{
        method:'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            id:parseInt(aid),
        })
    });
    let result = await response.json();
    console.log(result);
        let div = document.createElement("div");
        div.className="row";

        let cell1 = document.createElement("div");
        cell1.className="cell";
        cell1.innerHTML=result.student.roll;
        div.append(cell1);
        let cell2 = document.createElement("div");
        cell2.className="cell";
        cell2.innerHTML=result.email;
        div.append(cell2);
        let cell3 = document.createElement("div");
        cell3.className="cell";
        cell3.innerHTML=result.contact;
        div.append(cell3);

        document.getElementById("pinfo").append(div);

        fetchedetails();
}

async function fetchedetails(){

    let response = await fetch('api/viewdata/edetails',{
        method:'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            id:parseInt(aid),
        })
    });

    let result = await response.json();
    console.log(result);

    for(let i=0;i<result.length;i++){

        let div = document.createElement("div");
        div.className="row";

        let cell1 = document.createElement("div");
        cell1.className="cell";
        cell1.innerHTML=result[i].college_name;
        div.append(cell1);
        let cell2 = document.createElement("div");
        cell2.className="cell";
        cell2.innerHTML=result[i].degree;
        div.append(cell2);
        let cell3 = document.createElement("div");
        cell3.className="cell";
        cell3.innerHTML=result[i].joining_year;
        div.append(cell3);
        let cell4 = document.createElement("div");
        cell4.className="cell";
        cell4.innerHTML=result[i].passing_year;
        div.append(cell4);
        document.getElementById("einfo").append(div);

    }

    fetchodetails();

}

async  function  fetchodetails(){

    let response = await fetch('api/viewdata/odetails',{
        method:'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            id:parseInt(aid),
        })
    });

    let result = await response.json();
    console.log(result);

    for(let i=0;i<result.length;i++){

        let div = document.createElement("div");
        div.className="row";

        let cell1 = document.createElement("div");
        cell1.className="cell";
        cell1.innerHTML=result[i].organisation.name;
        div.append(cell1);
        let cell2 = document.createElement("div");
        cell2.className="cell";
        cell2.innerHTML=result[i].position;
        div.append(cell2);
        let cell3 = document.createElement("div");
        cell3.className="cell";
        cell3.innerHTML=result[i].joining_year;
        div.append(cell3);
        let cell4 = document.createElement("div");
        cell4.className="cell";
        cell4.innerHTML=result[i].leaving_year;
        div.append(cell4);
        document.getElementById("oinfo").append(div);

    }
}
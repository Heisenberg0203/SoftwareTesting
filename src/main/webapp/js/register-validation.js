let signup_form = document.getElementById('signup-form');
let alumni_form = document.getElementById("individual-form");

let signupsec = document.getElementById('signup-section');
let alumnisec = document.getElementById('alumni-section');
window.onload = hidealumnisec;

let student_list;
signup_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (signup_form.checkValidity() === true) {
        let response = await fetch('api/alumni/getinfo', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                fname: document.getElementById('fname').value,
                lname: document.getElementById('lname').value,
                year: document.getElementById('gradyear').value,
            })
        });
        student_list = await response.json();
        // console.log("helloworld");
        // console.log(result[0].fname);
        signupsec.style.display="none";
        alumnisec.style.display="block";

        // insert rows
        let table = document.getElementById("alumni-table");
        var i=1;
        student_list.forEach(function (student){
            let row = table.insertRow(i);
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            let cell4 = row.insertCell(3);
            let cell5 = row.insertCell(4);
            cell1.innerHTML = "<input name=\"select\" id="+i+" type=\"radio\" required>";
            cell2.innerHTML = student.roll;
            cell3.innerHTML = student.fname;
            cell4.innerHTML = student.lname;
            cell5.innerHTML = student.email;
            i=i+1;
        });

    }
    signup_form.classList.add('was-validated');
});

async  function  hidealumnisec(){
    alumnisec.style.display="none";
}

alumni_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (alumni_form.checkValidity() === true) {

        console.log(student_list[parseInt($("#individual-form input[type='radio']:checked")[0].id)-1].id);
        console.log(student_list[parseInt($("#individual-form input[type='radio']:checked")[0].id)-1].roll);

        let sid=student_list[parseInt($("#individual-form input[type='radio']:checked")[0].id)-1].id;
        if (alumni_form.checkValidity() === true) {
            let response = await fetch('api/alumni/isregistered', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                },
                body: JSON.stringify({
                    student:{id:parseInt(sid),},
                })
            });
            let result = await response;
            console.log(result);
            if(result.ok){
                window.open("personalinfo.html?id="+student_list[parseInt($("#individual-form input[type='radio']:checked")[0].id)-1].id,"_self");
            }
            else {
                alert("You are already registered");
                window.open("index.html","_self");
            }


        }



    }
    alumni_form.classList.add('was-validated');
});
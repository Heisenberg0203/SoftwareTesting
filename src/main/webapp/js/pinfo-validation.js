let pinfo_form = document.getElementById('pinfo-form');
pinfo_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    let url = new URL(window.location.href);
    let sid=url.searchParams.get("id");
    if(sid===null){
        alert("Session expired, Please login");
        window.open("index.html","_self");
        return;
    }
    console.log(sid);
    if (pinfo_form.checkValidity() === true) {
        let response = await fetch('api/pinfo/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                email: document.getElementById('email').value,
                contact: document.getElementById('contact').value,
                student:{id:parseInt(sid),},
            })
        });
        let result = await response.json();
        console.log(result.id);
        if(result.id===0){
            alert("You have already registered");
            window.open("index.html","_self");
        }
        else{
            window.open("educationinfo.html?aid="+result.id,"_self");
        }
        // console.log("helloworld");
        // console.log(result[0].fname);

        pinfo_form.classList.add('was-validated');
        //window.open("educationinfo.html?aid="+result.id,"_self");
        // window.location.href="educationinfo.html";
    }


});



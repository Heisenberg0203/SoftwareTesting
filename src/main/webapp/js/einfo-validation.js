let einfo_form = document.getElementById('einfo-form');


einfo_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    let url = new URL(window.location.href);
    let aid=url.searchParams.get("aid");
    if(aid===null){
        alert("Session expired, Please login");
        window.open("index.html","_self");
        return;
    }
    if (einfo_form.checkValidity() === true) {
        let alumni_list=[];
        let array = $("#einfo-form").serializeArray();

        for(let i=0;i<array.length;){
            let alumni={};
            alumni['college_name']=array[i++].value;
            alumni['address']=array[i++].value;
            alumni['degree']=array[i++].value;
            alumni['joining_year']=parseInt(array[i++].value);
            alumni['passing_year']=parseInt(array[i++].value);
            alumni['alumni']={id:parseInt(aid)};

            alumni_list.push(alumni);
        }

        let response = await fetch('api/einfo/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(alumni_list),
        });
        let result = await response;
        console.log(result);
        // console.log("helloworld");
        // console.log(result[0].fname);
        einfo_form.classList.add('was-validated');
        alert(response.status);
        if(response.status==204){
            alert("Please Enter Details, SKip if you don't have any");
        }
        else if(response.status==409){
            alert("You have already registered");
            window.open("index.html","_self");
        }
        else{
            window.open("orginfo.html?aid="+aid,"_self");
        }
        //window.href.location="orginfo.html";

    }

    //console.log($("#einfo-form").serializeObject());


});

function add_more(btn) {
    const div = document.createElement('div');
    div.className = "form-row element";
    div.innerHTML = $(btn).closest("div.element")[0].innerHTML;

    document.getElementById("einfo-element").appendChild(div);
    //console.log($(btn)[0]);
    $(btn)[0].value="-";
    $(btn)[0].setAttribute("onclick","remove_div(this)");
    $(btn).removeClass("btn-success");
    $(btn).addClass("btn-danger");
    // return false;
}

function remove_div(btn){
    $(btn).closest("div.element").remove();
}
function skip_edetails(){
    window.location.href="orginfo.html";
}


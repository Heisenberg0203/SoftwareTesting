window.onload = fetch_feeds;

async function fetch_feeds(){
    let url = new URL(window.location.href);
    let aid=url.searchParams.get("aid");
    if(aid===null){
        alert("Session expired, Please login");
        window.open("index.html","_self");
        return;
    }

    let response  = await fetch("api/feeds/get");
    let feeds = await response.json();

    for(let i=feeds.length-1;i>=0;i--){
        console.log(feeds);
        console.log(feeds[i].text);

        let div = document.createElement("div");
        div.className="card gedf-card";
        div.innerHTML=document.getElementById("feed-template").innerHTML;

        div.querySelector(".username").innerHTML="@"+feeds[i].alumni.student.fname+feeds[i].alumni.student.lname;
        div.querySelector(".email").innerHTML=feeds[i].alumni.email;
        div.querySelector(".posttext").innerHTML=feeds[i].text;
        div.querySelector(".likes").innerHTML="<i class=\"fa fa-gittip\"></i> ";
        if(feeds[i].likes>0){
            div.querySelector(".likes").innerHTML+=feeds[i].likes;
        }
        else{
            div.querySelector(".likes").innerHTML+=" Like";
        }
        div.querySelector(".posttime").innerHTML="<i class=\"fa fa-clock-o\"></i> ";
        let currentDate = new Date();
        let diff = (currentDate.getTime()-feeds[i].createdDate)/1000;
        let timediff = parseInt(diff);
        if(timediff<60){
            div.querySelector(".posttime").innerHTML+=timediff+" seconds ago";
        }
        else if(timediff<3600){
            div.querySelector(".posttime").innerHTML+=parseInt((timediff)/60)+" minutes ago";
        }
        else if(timediff<86400){
            div.querySelector(".posttime").innerHTML+=parseInt(timediff/3600)+" Hours ago";
        }
        else{
            div.querySelector(".posttime").innerHTML+=parseInt(timediff/86400)+" Days ago";
        }

        document.querySelector(".main").insertBefore(div,document.getElementById("#feed-template"));





    }
}

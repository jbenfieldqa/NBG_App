$(document).ready(function(){
    $("#menuIcon").click(function(){
        $("#sidenav").animate({left: '0px'});
    });
    
    $("#closeIcon").click(function(){
        $("#sidenav").animate({left: '-200px'});
    });
    
    /*
    $(".productCard").hover(function(){
        $(this).css("background-color", "#ddd");
        $(".addToBtn").css("backround-color", "rgba(111, 212, 62, 0.8)");
        $(".quickLookBtn").css("backround-color", "rgba(111, 212, 62, 0.8)");
        }, function(){
        $(this).css("background-color", "rgba(111, 212, 62, 0.2)");
        $(".addToBtn").css("backround-color", "rgba(111, 212, 62, 0.8)");
        $(".quickLookBtn").css("backround-color", "rgba(111, 212, 62, 0.8)");
    });
    */
});

var acc = document.getElementsByClassName("accordion");
var i;
for (i = 0; i < acc.length; i++) {
    acc[i].onclick = function(){
        this.classList.toggle("active");
        this.nextElementSibling.classList.toggle("show");
    }
}

var sbl = document.getElementById("sortByList");
sbl.addEventListener('click', function(e){
    if(e.target.tagName === 'LI'){
        document.getElementById("nameAZ").classList.remove("selected");
        document.getElementById("nameAZ").classList.add("unselected");
        document.getElementById("nameZA").classList.remove("selected");
        document.getElementById("nameZA").classList.add("unselected");
        document.getElementById("priceHigh").classList.remove("selected");
        document.getElementById("priceHigh").classList.add("unselected");
        document.getElementById("priceLow").classList.remove("selected");
        document.getElementById("priceLow").classList.add("unselected");
        e.target.classList.toggle("unselected");
        e.target.classList.toggle("selected");
    }
});

var npl = document.getElementById("numPerList");
npl.addEventListener('click', function(e){
    if(e.target.tagName === 'LI'){
        document.getElementById("12").classList.remove("selected");
        document.getElementById("12").classList.add("unselected");
        document.getElementById("24").classList.remove("selected");
        document.getElementById("24").classList.add("unselected");
        document.getElementById("36").classList.remove("selected");
        document.getElementById("36").classList.add("unselected");
        document.getElementById("48").classList.remove("selected");
        document.getElementById("48").classList.add("unselected");
        e.target.classList.remove("unselected");
        e.target.classList.add("selected");
    }
});

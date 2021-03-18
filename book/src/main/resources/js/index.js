
    var pointer = document.getElementById("pointer");

    var index = 0;
    var allA = document.getElementById("pointer");
   alert(allA);
    for(var i=0;i<allA.length;i++) {
        allA[i].onclick = function() {
            alert("hello");
        }
    }

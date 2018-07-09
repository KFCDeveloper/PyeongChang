    /*调试headerNav居中*/
    var width = window.screen.width;
    document.getElementsByClassName("inner")[0].style.marginLeft = (width * 1 / 2 - 609) + "px";

    /*navString-line显示及特效*/
    var navStringWidth0 = document.getElementById("navString0").offsetWidth;
    document.getElementById("navString-line0").style.marginLeft = (97 - navStringWidth0 * 1 / 2) + "px";
    $("#navString0").mouseover(function () {
        document.getElementById("navString0").style.color = "#5d8ccf";
        $("#navString-line0").animate({width: navStringWidth0 + "px"});
    });
    $("#navString0").mouseleave(function () {
        document.getElementById("navString0").style.color = "#000000";
        $("#navString-line0").animate({width: "0px"});
    })

    var navStringWidth1 = document.getElementById("navString1").offsetWidth;
    document.getElementById("navString-line1").style.marginLeft = (97 - navStringWidth1 * 1 / 2) + "px";
    $("#navString1").mouseover(function () {
        document.getElementById("navString1").style.color = "#5d8ccf";
        $("#navString-line1").animate({width: navStringWidth1 + "px"});
    });
    $("#navString1").mouseleave(function () {
        document.getElementById("navString1").style.color = "#000000";
        $("#navString-line1").animate({width: "0px"});
    })

    var navStringWidth2 = document.getElementById("navString2").offsetWidth;
    document.getElementById("navString-line2").style.marginLeft = (97 - navStringWidth2 * 1 / 2) + "px";
    $("#navString2").mouseover(function () {
        document.getElementById("navString2").style.color = "#5d8ccf";
        $("#navString-line2").animate({width: navStringWidth2 + "px"});
    });
    $("#navString2").mouseleave(function () {
        document.getElementById("navString2").style.color = "#000000";
        $("#navString-line2").animate({width: "0px"});
    })

    var navStringWidth3 = document.getElementById("navString3").offsetWidth;
    document.getElementById("navString-line3").style.marginLeft = (97 - navStringWidth3 * 1 / 2) + "px";
    $("#navString3").mouseover(function () {
        document.getElementById("navString3").style.color = "#5d8ccf";
        $("#navString-line3").animate({width: navStringWidth3 + "px"});
    });
    $("#navString3").mouseleave(function () {
        document.getElementById("navString3").style.color = "#000000";
        $("#navString-line3").animate({width: "0px"});
    })

    var navStringWidth4 = document.getElementById("navString4").offsetWidth;
    document.getElementById("navString-line4").style.marginLeft = (97 - navStringWidth4 * 1 / 2) + "px";
    $("#navString4").mouseover(function () {
        document.getElementById("navString4").style.color = "#5d8ccf";
        $("#navString-line4").animate({width: navStringWidth4 + "px"});
    });
    $("#navString4").mouseleave(function () {
        document.getElementById("navString4").style.color = "#000000";
        $("#navString-line4").animate({width: "0px"});
    })


    $(function () {
        $(document).tooltip();
    });

    $("#picto-ALP1-w").mouseover(function () {
        document.getElementById("picto-ALP1-w").setAttribute("fill","#b45127");
    })
    $("#picto-ALP1-w").mouseleave(function () {
        document.getElementById("picto-ALP1-w").setAttribute("fill","#0090d4");
    })
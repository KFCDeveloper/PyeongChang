

/*调试headerNav居中*/
/*var width = window.screen.width;
document.getElementsByClassName("inner")[0].style.marginLeft = (width * 1 / 2 - 609) + "px";
/!*athelets居中*!/
document.getElementsByClassName("panel-body")[0].style.marginLeft = (width * 1 / 2 - 609) + "px";
document.getElementsByClassName("nav nav-tabs row")[0].style.marginLeft = (width * 1 / 2 - 609) + "px";
document.getElementsByClassName("TopMenuLinks btn")[0].style.marginLeft = (width * 1 / 2 - 609) + "px";
document.getElementsByClassName("nav nav-tabs row")[0].style.marginLeft = (width * 1 / 2 - 609) + "px";*/
/*navString-line显示及特效*/
var navString = new Array();
navString = ["navString0", "navString1", "navString2", "navString3", "navString4"];

var navStringWidth = new Array();
$.each(navString, function (i, val) { //两个参数，第一个参数表示遍历的数组的下标，第二个参数表示下标对应的值
    navStringWidth[i] = document.getElementById(navString[i]).offsetWidth;
    document.getElementById("navString-line" + i.toString()).style.marginLeft = (97 - navStringWidth[i] * 1 / 2) + "px";

    $("#" + navString[i]).mouseover(function () {
        document.getElementById(navString[i]).style.color = "#5d8ccf";
        $("#navString-line" + i.toString()).stop(true, false).animate({width: navStringWidth[i] + "px"});
    });
    $("#" + navString[i]).mouseleave(function () {
        document.getElementById(navString[i]).style.color = "#000000";
        $("#navString-line" + i.toString()).stop(true, false).animate({width: "0px"});
        $("#" + navString[i]).stop(true, false);
    });
});

$(function () {
    $(document).tooltip();
});

$("#picto-ALP1-w").mouseover(function () {
    document.getElementById("picto-ALP1-w").setAttribute("fill","#b45127");
})

$("#picto-ALP1-w").mouseleave(function () {
    document.getElementById("picto-ALP1-w").setAttribute("fill","#0090d4");
})
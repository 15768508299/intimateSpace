//获取当天日期，返回格式2020-03-06
function today() {
    var today = new Date();
    var str = "";
    str += today.getFullYear() + "-";
    var month = today.getMonth() + 1;//返回值是 0（一月） 到 11（十二月） 之间的一个整数。
    if (month < 10) {
        str += "0";
    }
    str += month + "-";
    var day = today.getDate();//返回值是 1 ~ 31 之间的一个整数
    if (day < 10) {
        str += "0";
    }
    str += day;
    return str;
}

//sDate1和sDate2是2006-12-18格式
//两个时间相差天数 兼容firefox chrome
function datedifference(sDate1, sDate2) {
    var dateSpan,
        iDays;
    sDate1 = Date.parse(sDate1);
    sDate2 = Date.parse(sDate2);
    dateSpan = sDate2 - sDate1;
    dateSpan = Math.abs(dateSpan);
    iDays = Math.floor(dateSpan / (24 * 3600 * 1000));
    return iDays
};
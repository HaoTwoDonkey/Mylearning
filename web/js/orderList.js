
$(document).ready(function () {
    OrderList.init();
})


OrderList = {

    gird : null,
    init : function () {
        OrderList.gird = $('#orderGrid');
        OrderList.queryList();
    },
    queryList : function () {
        OrderList.gird.datagrid('load',{
            name:$('#itemName').val()
        });
    },
    formatDate : function (val) {
        return OrderList.timeStampToTime(val);
    },
    timeStampToTime : function (val) {
        var date = new Date(val);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
        Y = date.getFullYear() + '-';
        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        D = date.getDate() + ' ';
        return Y+M+D;
    }






}
/*
* 信息显示的js
* */

var form;
$(function () {

    layui.use('table', function () {
        var table = layui.table;
        form = layui.form;

        tableIns = table.render({
            elem: '#roleList',
            url: '/notice/show',
            method: 'get', //默认：get请求
            cellMinWidth: 80,
            page: true,
            /*方法中没有请求策数，就不传*/
            // request: {
            //     pageName: 'pageNum', //页码的参数名称，默认：pageNum
            //     limitName: 'pageSize' //每页数据量的参数名，默认：pageSize
            // },
            response: {
                statusName: 'code', //数据状态的字段名称，默认：code
                statusCode: 200, //成功的状态码，默认：0
                countName: 'totals', //数据总数的字段名称，默认：count
                dataName: 'list' //数据列表的字段名称，默认：data
            },
            cols: [[
                {type: 'numbers'}
                , {field: 'title', title: '标题', align: 'center'}
                , {field: 'content', title: '内容', align: 'center'}
                , {field: 'author', title: '作者', align: 'center'}
                , {field: 'time', title: '时间', align: 'center'}
                , {fixed: 'right', title: '查看详情', align: 'center', toolbar: '#optBar'}
            ]]

        });

        //监听工具条
        table.on('tool(roleTable)', function (obj) {
            var data = obj.data;
            if (obj.event === 'info') {
                //显示详情
                lookInfo(data);
            }
        });
    });

});

//查看详情
function lookInfo(data) {
    var NId = data.id;
    $.ajax({
        type: "get",
        url: "/notice/showNotice?id=" + NId,
        success: function (data) {
            if (data == 1) {
                layer.open({
                    type: 2
                    ,
                    title: '显示详情' //不显示标题栏
                    ,
                    closeBtn: false
                    ,
                    area: ['90%', '100%']
                    // ,shade: 0.8
                    // ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                    ,
                    btn: ['继续', '关闭']
                    ,
                    btnAlign: 'c'
                    ,
                    moveType: 1 //拖拽模式，0或者1
                    ,
                    moveOut: true
                    ,
                    closeBtn: 1
                    ,
                    content: '/pdf/localpdf/example.html'
                    ,
                    success: function (layero) {

                    }
                });
            } else {
                layer.alert("显示失败，请您稍后再试", function () {
                    layer.closeAll();
                });
            }
        },
        error: function () {
            layer.alert("网络异常，请您稍后再试", function () {
                layer.closeAll();
            });
        }
    });
}

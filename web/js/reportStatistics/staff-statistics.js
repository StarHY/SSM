var tempData = tempData = {
    chart: {
        type: 'line'
    },
    title: {
        text: '员工工单本月统计'
    },
    yAxis: {
        title: {
            text: '条数 (条)'
        }
    },

    plotOptions: {
        line: {
            dataLabels: {
                enabled: true          // 开启数据标签
            },
            enableMouseTracking: false // 关闭鼠标跟踪，对应的提示框、点击事件会失效
        }
    },
    credits: {
        enabled: false
    },
    series: []
};
var type = '';
function switchs(graphics){
    if(graphics == 'bar'){
        tempData = {
            chart: {
                type: 'column'
            },
            title: {
                text: '员工工单本月统计'
            },
            yAxis: {
                min: 0,
                title: {
                    text: '条数 (条)'
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} 条</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            credits: {
                enabled: false
            },
            series: []
        };
        switchsValidator();
    }else if(graphics == 'line'){
        tempData = {
            chart: {
                type: 'line'
            },
            title: {
                text: '员工工单本月统计'
            },
            yAxis: {
                title: {
                    text: '条数 (条)'
                }
            },

            plotOptions: {
                line: {
                    dataLabels: {
                        enabled: true          // 开启数据标签
                    },
                    enableMouseTracking: false // 关闭鼠标跟踪，对应的提示框、点击事件会失效
                }
            },
            credits: {
                enabled: false
            },
            series: []
        };
        switchsValidator();
    }
}

var companyId='';
$(function () {
    $("#checkWin").modal('show');
    validatorCompany();
    initSelect2("company", "请选择公司", "/company/company_all", "565");
    destoryValidator("checkWin","checkForm");
    initDateTime("datatimepicker")
    $("#myTab a").click(function(e){
        $(this).tab("show");
        $(".datatimepicker").val("");
    });
});

function showCompany(){
    validatorCompany();
    $("#checkWin").modal('show');
}

function check(){
    $("#checkForm").data('bootstrapValidator').validate();
    if ($("#checkForm").data('bootstrapValidator').isValid()) {
        $("#companyButton").attr("disabled","disabled");
    } else {
        $("#companyButton").removeAttr("disabled");
    }
}

function search(count){
    if(count == 1){
        type = 'year'
        var start = $("#start1").val();
        var end = $("#end1").val();
        validator(start,end,type,"员工工单年统计");
    }else if(count == 2){
        type = 'quarter'
        var start = $("#start2").val();
        var end = $("#end2").val();
        validator(start,end,type,'员工工单季度统计');
    }else if(count == 3){
        type = 'month'
        var start = $("#start3").val();
        var end = $("#end3").val();
        validator(start,end,type,'员工工单月统计');
    }else if(count == 4){
        type = 'week'
        var start = $("#start4").val();
        var end = $("#end4").val();
        validator(start,end,type,'员工工单周统计');
    }else if(count == 5){
        type = 'day'
        var start = $("#start5").val();
        var end = $("#end5").val();
        validator(start,end,type,'员工工单日统计');
    }
}

function initDateTime(clazz) {
    $('.' + clazz).datetimepicker({
        language: 'zh-CN',
        format: 'yyyy-mm-dd',
        initialDate: new Date(),
        autoclose: true,
        todayHighlight: true,
        minView: "month",//选择日期后，不会再跳转去选择时分秒
        todayBtn: true//显示今日按钮
    })
}

function validator( start, end, type,text){
    if($("#spans").text() != ''){
        if(start != '' && end != ''){
            getLineBasicChart("columnar", "/peopleManage/query_condition?start=" + start +"&end=" + end + "&type=" + type + "&companyId="+companyId, tempData,type,text);
        }else{
            getLineBasicChart("columnar", "/peopleManage/query_default?companyId="+companyId, tempData,"default","员工工单本月统计");
        }
    }else{
        showCompany();
    }
}


function switchsValidator(){
    if(type == 'year'){
        type = 'year'
        var start = $("#start1").val();
        var end = $("#end1").val();
        validator(start,end,type,"员工工单年统计");
    }else if(type == 'quarter'){
        type = 'quarter';
        var start = $("#start2").val();
        var end = $("#end2").val();
        validator(start,end,type,'员工工单季度统计');
    }else if(type == 'month') {
        type = 'month';
        var start = $("#start3").val();
        var end = $("#end3").val();
        validator(start,end,type,'员工工单月统计');
    }else if(type == 'week'){
        type = 'week';
        var start = $("#start4").val();
        var end = $("#end4").val();
        validator(start,end,type,'员工工单周统计');
    } else if(type == 'day') {
        type = 'day';
        var start = $("#start5").val();
        var end = $("#end5").val();
        validator(start,end,type,'员工工单日统计');
    }else{
        getLineBasicChart("columnar", "/peopleManage/query_default?companyId="+companyId, tempData,"default","员工工单本月统计");
    }
}

function checkCompany(company) {
    companyId = company.value;
}

function validatorCompany(){
    $("#companyButton").removeAttr("disabled");
    $('#checkForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            companyId: {
                message: '验证失败',
                validators: {
                    notEmpty: {
                        message: '请选择公司'
                    }
                }

            }
        }
    })

        .on('success.form.bv', function (e) {
            $("#checkWin").modal('hide');
            var companyName = $("#company").find("option:selected").text();
            $('#spans').html("当前公司:"+companyName);
            $('#checkForm').data('bootstrapValidator').resetForm(true);
            getLineBasicChart("columnar", "/peopleManage/query_default?companyId="+companyId, tempData,"default","员工工单本月统计");
        })
}

/**
 * Created by xiao-qiang 2017/4/18.
 */
var contextPath = '';
$(document).ready(function () {
    //调用函数，初始化表格
    initTable("cusTable", contextPath + "/module/query_pager");

    //当点击查询按钮的时候执行
    $("#search").bind("click", initTable);
});

/** 编辑数据 */
function showEditWin() {
    var selectRow = $("#cusTable").bootstrapTable('getSelections');
    if (selectRow.length == 0) {
        swal('编辑失败', "必须选择一条数据进行编辑", "error");
        return false;
    } else if (selectRow.length > 1) {
        swal('编辑失败', "只能选择一条数据进行编辑", "error");
    } else {
        var module = selectRow[0];
        $("#updateForm").fill(module);
        $("#editWin").modal('show');
    }
}

/**提交编辑数据 */
function updateModule() {
    $.post(contextPath + "/module/update_module",
        $("#updateForm").serialize(),
        function (data) {
            if (data.result == "success") {
                $('#editWin').modal('hide');
                swal(data.message, "", "success");
                $('#cusTable').bootstrapTable('refresh');
            } else if (data.result == "fail") {
                swal(data.message, "", "error");
            }
        }, "json");

}

/**提交添加数据 */
function addModule() {
    $.post(contextPath + "/module/add_module",
        $("#addForm").serialize(),
        function (data) {
            if (data.result == "success") {
                $('#addWin').modal('hide');
                swal(data.message, "", "success");
                $('#cusTable').bootstrapTable('refresh');
                $("input[type=reset]").trigger("click");
            } else if (data.result == "fail") {
                swal(data.message, "", "error");
            }
        }, "json");

}

/**
 * 批量删除数据
 */
function deleteModule() {
    var rows = $("#cusTable").bootstrapTable('getSelections');
    if (rows.length < 1) {
        swal('删除失败', "请选择一条或多条数据进行删除", "error");
    } else {
        var ids = "";
        for (var i = 0, len = rows.length; i < len; i++) {
            if (ids == "") {
                ids = rows[i].id;
            } else {
                ids += "," + rows[i].id
            }
            if (ids != "") {
                swal({
                        title: "确定要删除所选数据?",
                        text: "删除后将无法恢复，请谨慎操作！",
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "是的，我要删除!",
                        cancelButtonText: "让我在考虑一下....",
                        closeOnConfirm: false
                    },
                    function () {
                        $.get(contextPath + "/module/deleteById/" + rows[0].ids,
                            function (data) {
                                swal(data.message, "您已经永久删除了这条信息。", "success");
                                $('#cusTable').bootstrapTable('refresh');
                            }, "json");

                    });
            }
        }

    }
}

function thisStatus(value, row, index) {
    if (value == 'Y') {
        return "可用";
    } else {
        return "不可用";
    }
}

function operateFormatter(value, row, index) {
    if (row.moduleStatus == 'Y') {
        return [
            '<button type="button" class="updateActive btn btn-default  btn-sm" style="margin-right:15px;" >冻结</button>'
        ].join('');
    } else {
        return [
            '<button type="button" class="updateInactive btn btn-default  btn-sm" style="margin-right:15px;" >激活</button>'
        ].join('');
    }
}

window.operateEvents = {
    'click .updateActive': function (e, value, row, index) {
        var status = 'N';
        $.get(contextPath + "/module/update_status?id=" + row.moduleId + "&status=" + status,
            function (data) {
                if (data.result == "success") {
                    $('#addWin').modal('hide');
                    // swal(data.message, "", "success");
                    $('#cusTable').bootstrapTable('refresh');
                } else if (data.result == "fail") {
                    swal(data.message, "", "error");
                }
            }, "json");
    },
    'click .updateInactive': function (e, value, row, index) {
        var status = 'Y';
        $.get(contextPath + "/module/update_status?id=" + row.moduleId + "&status=" + status,
            function (data) {
                if (data.result == "success") {
                    $('#addWin').modal('hide');
                    // swal(data.message, "", "success");
                    $('#cusTable').bootstrapTable('refresh');
                } else if (data.result == "fail") {
                    swal(data.message, "", "error");
                }
            }, "json");
    }
}

function queryAll() {
    initTable(contextPath + "cusTable", "/module/query_pager");
}

function queryStatus(status) {
    initTable('cusTable', contextPath + '/module/queryByStatus_module?status=' + status);
}

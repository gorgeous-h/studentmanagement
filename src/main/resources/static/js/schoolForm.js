$(function () {
    provinces = JSON.parse(provinces);
    schoolTypes = JSON.parse(schoolTypes);
    
    school = {
        save: function () {
            $('#schoolForm').form('submit',{
                url: basePath+'/hjj/school/saveSchool',
                onSubmit:function(param){
                    return $(this).form('enableValidation').form('validate');
                },
                success:function(data){
                    var schoolId;
                    if(data.indexOf("add")>=0){
                        // 添加操作
                        schoolId = data.slice(3);
                        $.messager.alert('提示信息','添加成功！','info');
                    } else if(data.indexOf("update")>=0){
                        // 修改操作
                        schoolId = data.slice(6);
                        $.messager.alert('提示信息','修改成功！','info');
                    } else {
                        $.messager.alert('提示信息','保存失败！','info');
                    }
                    if(schoolId){
                        loadSchoolForm(schoolId);
                        refreshTDatagridOfCustomTab('学校字典', '#schools');
                    }
                }
            });
        }
    };

    initialRegion('province', 'city', 'region');

    $('#schoolType').combobox({
        valueField:'id',
        textField:'name',
        data:schoolTypes,
        limitToList:true,
        panelHeight:'auto',
    });

    if(schoolId){
        $('#save').linkbutton('disable');
        loadSchoolForm(schoolId);
    } else {
        $('#province').combobox('setValue', 19);
    }

    $('#schoolForm').form({
        onLoadSuccess: function (school) {
            if(school){
                $('#save').linkbutton('enable');
            }
        }
    });

    // 初始化省市区
    function initialRegion(province, city, region) {
        if(province&&city&&region){
            //省份
            $('#'+province).combobox({
                valueField:'id',
                textField:'name',
                data:provinces,
                // limitToList:true,
                onChange:function(newValue,oldValue){
                    $('#'+city).combobox({
                        url:basePath+"/hjj/city/getCitiesByProvinceId",
                        queryParams: {
                            "provinceId" : newValue
                        },
                        valueField:'id',
                        textField:'name',
                        // limitToList:true,
                    });
                    $('#'+region).combobox({
                        url:basePath+"/hjj/region/getRegionsByCityId",
                        queryParams: {
                            "cityId" : null
                        },
                        valueField:'id',
                        textField:'name',
                        // limitToList:true
                    });
                }
            });

            //城市
            $('#'+city).combobox({
                valueField:'id',
                textField:'name',
                // limitToList:true,
                onChange:function(newValue,oldValue){
                    $('#'+region).combobox({
                        url:basePath+"/hjj/region/getRegionsByCityId",
                        queryParams: {
                            "cityId" : newValue
                        },
                        valueField:'id',
                        textField:'name',
                        // limitToList:true
                    });
                }
            });
        }
    }

});

function loadSchoolForm(id) {
    $('#schoolForm').form('load',basePath+'/hjj/school/getSchoolVO?schoolId='+id);
}

// 刷新指定Tab里面的datagrid列表
function refreshTDatagridOfCustomTab(tab, datagrid){
    if(tab&&datagrid){
        var jq = top.jQuery;
        var preTab = jq("#tabs").tabs('getTab',tab);
        if(preTab){
            var preJq = preTab.find('iframe')[0].contentWindow.jQuery;
            preJq(datagrid).datagrid('reload');
        }
    }
}
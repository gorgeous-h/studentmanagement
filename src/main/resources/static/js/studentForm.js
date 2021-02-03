$(function () {
    provinces = JSON.parse(provinces);
    schoolTypes = JSON.parse(schoolTypes);
    nations = JSON.parse(nations);

    student = {
        display: 'block',

        save: function () {
            $('#studentForm').form('submit',{
                url: basePath+'/hjj/student/saveStudent',
                onSubmit:function(param){
                    return $(this).form('enableValidation').form('validate');
                },
                success:function(data){
                    var studentId;
                    if(data.indexOf("add")>=0){
                        // 添加操作
                        studentId = data.slice(3);
                        $.messager.alert('提示信息','添加成功！','info');
                    } else if(data.indexOf("update")>=0){
                        // 修改操作
                        studentId = data.slice(6);
                        $.messager.alert('提示信息','修改成功！','info');
                    } else {
                        $.messager.alert('提示信息','保存失败！','info');
                    }
                    if(studentId){
                        loadStudentForm(studentId);
                        refreshTDatagridOfCustomTab('学生字典', '#students');
                    }
                }
            });
        },
        detail: function () {
            document.getElementById('studentDetail').style.display = student.display;
            if(student.display==='block'){
                student.display = 'none';
            } else {
                student.display = 'block';
            }
        }
    };

    initialRegion('province', 'city', 'region', 'school');
    initialRegion2('addressProvince', 'addressCity', 'addressRegion');

    $('#schoolType').combobox({
        valueField:'id',
        textField:'name',
        data:schoolTypes,
        limitToList:true,
        panelHeight:'auto',
        onChange:function(newValue,oldValue){
            $('#school').combobox({
                url:basePath+"/hjj/school/getAllSchool",
                queryParams: {
                    "schoolTypeId" : newValue,
                    "provinceId" : $('#province').combobox('getValue'),
                    "cityId" : $('#city').combobox('getValue'),
                    "regionId" : $('#region').combobox('getValue'),
                },
                valueField:'id',
                textField:'name',
            });
        }
    });

    $('#gender').combobox({
        valueField:'id',
        textField:'name',
        data:[{id:'男',name:'男'},{id:'女',name:'女'}],
        limitToList:true,
        panelHeight:'auto',
    });

    $('#nation').combobox({
        valueField:'id',
        textField:'name',
        data:nations,
        limitToList:true,
        // panelHeight:'auto',
    });

    if(studentId){
        $('#save').linkbutton('disable');
        loadStudentForm(studentId);
    } else {
        $('#province').combobox('setValue', 19);
        $('#addressProvince').combobox('setValue', 19);
    }

    $('#studentForm').form({
        onLoadSuccess: function (student) {
            if(student){
                $('#province').combobox('setValue', student.provinceId);
                $('#city').combobox('setValue', student.cityId);
                $('#region').combobox('setValue', student.regionId);
                $('#schoolType').combobox('setValue', student.schoolTypeId);
                $('#school').combobox('setValue', student.schoolId);
                $('#addressProvince').combobox('setValue', student.addressProvinceId);
                $('#addressCity').combobox('setValue', student.addressCityId);
                $('#addressRegion').combobox('setValue', student.addressRegionId);
                $('#save').linkbutton('enable');
            }
        }
    });

    // 初始化省市区学校
    function initialRegion(province, city, region, school) {
        if(province&&city&&region&&school){
            //省份
            $('#'+province).combobox({
                valueField:'id',
                textField:'name',
                data:provinces,
                onChange:function(newValue,oldValue){
                    $('#'+city).combobox({
                        url:basePath+"/hjj/city/getCitiesByProvinceId",
                        queryParams: {
                            "provinceId" : newValue
                        },
                        valueField:'id',
                        textField:'name',
                    });
                    $('#'+region).combobox({
                        url:basePath+"/hjj/region/getRegionsByCityId",
                        queryParams: {
                            "cityId" : null
                        },
                        valueField:'id',
                        textField:'name',
                    });
                    $('#'+school).combobox({
                        url:basePath+"/hjj/school/getAllSchool",
                        queryParams: {
                            "provinceId" : newValue,
                            "schoolTypeId" : $('#schoolType').combobox('getValue')
                        },
                        valueField:'id',
                        textField:'name',
                    });
                }
            });

            //城市
            $('#'+city).combobox({
                valueField:'id',
                textField:'name',
                onChange:function(newValue,oldValue){
                    $('#'+region).combobox({
                        url:basePath+"/hjj/region/getRegionsByCityId",
                        queryParams: {
                            "cityId" : newValue
                        },
                        valueField:'id',
                        textField:'name',
                    });
                    $('#'+school).combobox({
                        url:basePath+"/hjj/school/getAllSchool",
                        queryParams: {
                            "cityId" : newValue,
                            "schoolTypeId" : $('#schoolType').combobox('getValue')
                        },
                        valueField:'id',
                        textField:'name',
                    });
                }
            });

            // 地区
            $('#'+region).combobox({
                valueField:'id',
                textField:'name',
                onChange:function(newValue,oldValue){
                    $('#'+school).combobox({
                        url:basePath+"/hjj/school/getAllSchool",
                        queryParams: {
                            "regionId" : newValue,
                            "schoolTypeId" : $('#schoolType').combobox('getValue')
                        },
                        valueField:'id',
                        textField:'name',
                    });
                }
            });
        }
    }

    // 初始化省市区
    function initialRegion2(province, city, region) {
        if(province&&city&&region){
            //省份
            $('#'+province).combobox({
                valueField:'id',
                textField:'name',
                data:provinces,
                onChange:function(newValue,oldValue){
                    $('#'+city).combobox({
                        url:basePath+"/hjj/city/getCitiesByProvinceId",
                        queryParams: {
                            "provinceId" : newValue
                        },
                        valueField:'id',
                        textField:'name',
                    });
                    $('#'+region).combobox({
                        url:basePath+"/hjj/region/getRegionsByCityId",
                        queryParams: {
                            "cityId" : null
                        },
                        valueField:'id',
                        textField:'name',
                    });
                }
            });

            //城市
            $('#'+city).combobox({
                valueField:'id',
                textField:'name',
                onChange:function(newValue,oldValue){
                    $('#'+region).combobox({
                        url:basePath+"/hjj/region/getRegionsByCityId",
                        queryParams: {
                            "cityId" : newValue
                        },
                        valueField:'id',
                        textField:'name',
                    });
                }
            });
        }
    }
});

function loadStudentForm(id) {
    $('#studentForm').form('load',basePath+'/hjj/student/getStudentVO?studentId='+id);
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

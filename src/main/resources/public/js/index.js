layui.use(['element', 'layer'], function(){
    let element = layui.element
        ,layer = layui.layer
        ,$ = layui.$;

    $(function (){
        $.get({
            url:"getLoginUser",
            success:function (data){
                $("#loginUser").text(data.data)
            }
        })
    })

    element.on('nav(menu)',function (elem){
        layer.msg(elem)
    })
});
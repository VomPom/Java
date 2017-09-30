/**
 * Created by Julis on 17/9/9.
 * User:Julis 落叶挽歌
 * Date:17/9/9
 * Time:上午9:50
 */
var count=0;
var allPrice=0;

$(document).ready(function(){

    /**
     * 点击 加入购物车按钮
     */
    $(".add").click(function(){

        $("#num").text(++count);//设置购物车数量
        var name=$(this).parent().find(".name").eq(0).text();
        var price=$(this).parent().find(".price").find("label").eq(0).text();
        var del="<input type=\"button\" value=\"结算\">";
       //$("#allPrice").text(allPrice);//设置总金额

        $("#tableofMyOrderFoods").append(//动态添加行
            '<tr>' +
                '<td><input class="singleChoose" type="checkbox"> </td>' +
                '<td>'+name+'</td>' +
                '<td>'+price+'</td>' +
                '<td> <input type="button" class="delOne" value="删除"></td>' +
            '</tr>');

        if(count==0){
            $("#empty").show();
        }else{
            $("#empty").hide();
        }
        alert("加入购物车成功");
    });
    /**
     * 点击 进入购物车详情单
     * 实现界面的显示与隐藏
     */
    $("#font").click(function(){
        $("#foodOrder").show();
        $("#main").hide();
        if(count==0){
            $("#empty").show();
        }else{
            $("#empty").hide();
        }
    });
    /**
     * 全选
     */
    $("#seleteAll").click(function(){
        if(this.checked) {
            allPrice=0;
            $("input[type=checkbox]").prop("checked", true);
            $("#tableofMyOrderFoods input[type=checkbox]:checked").each(function () {
                n = $(this).parents("tr").index();  // 获取checkbox所在行的顺序
                if (n != 0) {
                    var price = $("#tableofMyOrderFoods").find("tr:eq(" + n + ")").find("td:eq(2)").text();
                    allPrice += parseFloat(price);
                }
            });
        }else{
            $("input[type=checkbox]").prop("checked", false);
           allPrice=0;
        }
        $("#allPrice").text(allPrice);//设置总金额
    });
    /**
     * 单选
     */
    $(".singleChoose").live("click",function () {
        n = $(this).parents("tr").index();
        var price=$("#tableofMyOrderFoods").find("tr:eq("+n+")").find("td:eq(2)").text();
        if(this.checked){
            allPrice+=parseFloat(price);
        }else{
            $("#seleteAll").prop("checked", false);
            allPrice-=parseFloat(price);
        }
        $("#allPrice").text(allPrice);//设置总金额
    });
    /**
     * 单一删除按钮
     * 采用动态绑定事件
     *
     * 因为 js文件在一开始就家在好了,但是删除按钮之后添加的,如果采用普通的 .click事件,无法实现其效果
     */
    $(".delOne").live("click",function () {
        if(window.confirm('你确定要删除所选择订单吗')){
            n = $(this).parents("tr").index();  // 获取checkbox所在行的顺序
            var price=$("#tableofMyOrderFoods").find("tr:eq("+n+")").find("td:eq(2)").text();

            $("#num").text(--count);
            if($("#tableofMyOrderFoods").find("tr:eq("+n+")").find("input").is(":checked")){//判断所删除行是否选中
                allPrice-=parseFloat(price);
            }

            $("#tableofMyOrderFoods").find("tr:eq(" + n + ")").remove();
            $("#allPrice").text(allPrice);//设置总金额
       }
        if(count==0){
            $("#empty").show();
        }else{
            $("#empty").hide();
        }
    });

    /**
     * 多选删除按钮
     */
    $("#delSelected").click(function(){
        if(window.confirm('你确定要删除所有订单吗？')) {
            $("#tableofMyOrderFoods input[type=checkbox]:checked").each(function () {
                n = $(this).parents("tr").index();  // 获取checkbox所在行的顺序
                var price=$("#tableofMyOrderFoods").find("tr:eq("+n+")").find("td:eq(2)").text();
                allPrice-=parseFloat(price);
                $("#tableofMyOrderFoods").find("tr:eq(" + n + ")").remove();
                $("#num").text(--count);
                $("#allPrice").text(allPrice);//设置总金额
            });
        }
        if(count==0){
            $("#empty").show();
        }else{
            $("#empty").hide();
        }

    });
    /**
     * 结算功能
     */
    $("#settlement").click(function(){
        alert("总共付款"+allPrice+"元")

    });
    /**
     * 继续点餐
     */
    $("#goOn").click(function(){
        $("#foodOrder").hide();
        $("#main").show();

    })
});
/**
 * Created by Julis on 17/9/6.
 * User:Julis 落叶挽歌
 * Date:17/9/6
 * Time:上午12:10
 */
var reg= new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
var str="161@qq.com"
var result=reg.test(str);
alert(result)
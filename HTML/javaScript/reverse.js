/**
 * Created by Julis on 17/9/5.
 * User:Julis 落叶挽歌
 * Date:17/9/5
 * Time:下午10:44
 */

var number="123321"
var newStr="";

newNumber = number.split("").reverse().join("");
if(newNumber==number){
    alert(number+":  是回文数");
}else{
    alert(number+":  不是回文数");
}

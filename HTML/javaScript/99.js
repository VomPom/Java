/**
 * Created by Julis on 17/9/5.
 * User:Julis 落叶挽歌
 * Date:17/9/5
 * Time:下午10:22
 */
var out="";
for (var i =1;i<=9;i++){
    for (var j=1;j<=9;j++){
        out+=i+"*"+j+"="+i*j+" ";
    }
    out+="\n";
}
alert(out);
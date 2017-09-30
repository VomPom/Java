/**
 * Created by Julis on 17/9/5.
 * User:Julis 落叶挽歌
 * Date:17/9/5
 * Time:下午10:39
 */
var txt="201010-34234-354234-323423"
var number=txt.split("-")
var sum = 0;
for (var i=0;i<number.length;i++)
{
    sum+= parseInt(number[i])
}
alert(sum)
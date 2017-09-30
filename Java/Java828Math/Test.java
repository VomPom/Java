package WORK.Java.Java828Math;

import java.util.*;

public class Test {


	//19.打印出杨辉三角形
	/*
	 	1
	 1		1
1		2		1
1	3		3		1
1	4	6		4		1
1	5	10	10	5	1
	 */
	public static void nineteen() {
		int[][] arr = new int[6][];
		for(int i=0;i<arr.length;i++) {
			arr[i] = new int[i+1];
			//给第i+1行中的每个元素赋值
//			for(int k=1;k<=arr.length-arr[i].length;k++)System.out.print("\t");

			for(int j=0;j<arr[i].length;j++) {
				if(j==0||j==arr[i].length-1)
					arr[i][j]=1;
				else
					arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}

	//18.
	/**
	 * 有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
	 * @param arr - 已经排好序的数组
	 */
	public static void eighteen(int[] arr) {
		System.out.println("请输入一个整数");
		Scanner scan = new Scanner(System.in);
		int data = scan.nextInt();

		//将输入的数按原来的规律插入到数组
		//先找到要插入到数组中的位置
		int j = arr.length-1;
		if(arr[0]<arr[arr.length-1])//升序
			while(j>=0 && arr[j] > data) {
				j--;
			}
		else//降序
			while(j>=0 && arr[j] < data) {
				j--;
			}

		//j+1的位置就是要插入的位置
		int[] brr = new int[arr.length+1];
		//1:要复制的源数组,2:要复制的源数组的起始位置,3:要复制的目标数组,4:要复制的目标数组起始位置,5:要复制的元素的个数
		System.arraycopy(arr, 0, brr, 0, j+1);
		brr[j+1]=data;
		System.arraycopy(arr, j+1, brr, j+2, arr.length-j-1);

		//打印数组中的元素
		for(int e:brr) {
			System.out.print(e+" ");
		}
	}

	// 2. 随机产生20个不重复的小写字母并且排序
	public static void two() {
		Random rand = new Random();

		TreeSet<Character> ts = new TreeSet<Character>();
		while (ts.size() < 20) {
			// 生成一个0~25之间的一个随机数,再加上97即为97~122
			char c = (char) (rand.nextInt(26) + 97);
			ts.add(c);
		}

		// 打印
		for (Character ch : ts) {
			System.out.print(ch + " ");
		}
	}

	// 3.判断101-200之间有多少个素数，并输出所有素数。
	public static int three() {
		int count = 0;
		a: for (int i = 101; i < 200; i += 2) {
			// 判断i是否是素数(只能被1和自身整除)
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {// 不是素数
					continue a;
				}
			}

			System.out.print(i + " ");
			count++;
		}
		return count;
	}

	// 4.将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5
	public static void four(int n) {
		System.out.print(n + "=");
		int k = 2;// 最小的质数
		while (n != k) {
			if (n % k == 0) {// k是n的质因数
				// 打印
				System.out.print(k + "*");
				n = n / k;// 用n/k的商作为下一个除数
			} else {// k不是n的质因数
				k++;// 判断下一个质因数
			}
		}
		System.out.println(k);
	}

	// 5、输入两个正整数x和y，求其最大公约数和最小公倍数.
	// 欧几里得算法：（最大公约数）
	// 思考题：交换两个变量的值，不使用第三个变量
	public static void five(int x, int y) {
		int s = x * y;

		// 保证x是较大的数，y是较小的数
		if (x < y) {
			int t = x;
			x = y;
			y = t;
		}
		// 求最大公约数
		while (y != 0) {
			int m = x % y;
			x = y;// 将除数作为下一轮较大的数
			y = m;// 取得的余数作为下一轮较小的数
		}
		System.out.println("最大公约数：" + x + ",最小公倍数：" + s / x);
	}

	// 6.输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数.
	public static void six() {
		// 输入一行字符
		System.out.println("输入一行字符：");
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();

		// 统计字符个数
		int chara = 0, space = 0, number = 0, other = 0;
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
				chara++;
			else if (ch == ' ')
				space++;
			else if (ch >= '0' && ch <= '9')
				number++;
			else
				other++;
		}

		System.out.println("字母：" + chara + ",空格：" + space + ",数字：" + number + ",其它：" + other);
	}

	/*
	 * 7. 求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此
	 * 时共有5个数相加)，几个数相加有键盘控制.
	 */
	public static long seven(int a, int n) {
		long sum = 0;
		int p = a;
		for (int i = 1; i <= n; i++) {
			sum += p;
			p = p * 10 + a;// 下一个数
		}
		return sum;
	}

	// 8.一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。例如6=1＋2＋3.编程找出1000以内的所有完数
	public static void eight() {// 28=1+2+4+7+14
		for (int i = 6; i <= 1000; i++) {
			// 判断i是否是完数
			int s = 0;// 因子的和
			for (int j = 1; j <= i / 2; j++) {
				if (i % j == 0)// j是i的因子
					s += j;
			}
			if (i == s)// 是完数
				System.out.println(i);
		}
	}

	// 9.一球从100米高度自由落下，每次落地后反弹回原高度的一半；再落下，求它在 第10次落地时，共经过多少米？第10次反弹多高？
	public static void nine() {
		// 第n次落地经过的米数=第n-1次落地经过的米数+第n-1次反弹的高度*2
		// 第1次落地经过的米数s,反弹高度为h
		double s = 100;
		double h = 50;

		for (int i = 2; i <= 10; i++) {
			s = s + h * 2;
			h = h / 2;
			System.out.println("第" + i + "次落地共经过" + s + "米，反弹：" + h + "米");
		}

	}

	// 10.有1、2、3、4四个数字，能组成多少个互不相同且无重复数字的三位数？都是多少?
	public static void ten() {
		int count = 0;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				for (int k = 1; k <= 4; k++) {
					if (i != j && i != k && j != k) {
						count++;
						System.out.println(i * 100 + j * 10 + k);
					}
				}
			}
		}

		System.out.println("共有" + count + "个互不相同且无重复数字的三位数");
	}

	// 11.在1-1000内有一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
	public static void eleven() {
		for (int i = 1; i <= 1000; i++) {
			if (Math.sqrt(i + 100) % 1 == 0 && Math.sqrt(i + 268) % 1 == 0) {
				System.out.println(i);
			}
		}
	}

	// 12.输入某年某月某日，判断这一天是这一年的第几天?
	public static int twelve(int year,int month,int day) {
		int date=day;
		/*for(int i=1;i<month;i++) {
			switch(i) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					date+=31;break;
				case 2:
					if(year%4==0&&year%100!=0 || year%400==0)
						date+=29;
					else date+=28;
					break;
				default:date+=30;break;
			}
		}*/

		/*switch(month-1) {
		case 11: date+=30;
		case 10: date+=31;
		case 9: date+=30;
		case 8: date+=31;
		case 7: date+=31;
		case 6: date+=30;
		case 5: date+=31;
		case 4: date+=30;
		case 3: date+=31;
		case 2: if(year%4==0&&year%100!=0 || year%400==0)
					date+=29;
				else date+=28;
		case 1: date+=31;
		}*/
		int[] arr= {31,28,31,30,31,30,31,31,30,31,30,31};
		if(year%4==0&&year%100!=0 || year%400==0) arr[1] = 29;

		for(int i=0;i<month-1;i++) {
			date+=arr[i];
		}

		return date;
	}

	/*
	 * 13.猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
	 * 以后每天早上都吃了前一天剩下的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。 求第一天共摘了多少。
	 */
	public static void thirteen() {
		//a2=a1/2-1 --> a1 = (a2+1)*2
		int t=1;
		for(int i=9;i>=1;i--) {
			t = (t+1)*2;
		}
		System.out.println("第1天共摘了"+t+"个桃子");
	}

	// 14.打印出图案（菱形）
	/*
	 	* 			1---3空格，1*
 	   *** 			2---2空格，3*
 	  *****			3---1空格，5*
 	 ******* 		4---0空格，7*
 	  ***** 		5---1空格，5*
       *** 			6---2空格，3*
        *			7---3空格，1*
	 */
	public static void forteen(int n) {
		if(n%2==1)
			for(int i=1;i<=n;i++) {
				//打印空格
				for(int j=1;j<=Math.abs(i-(n+1)/2);j++) {
					System.out.print(" ");
				}
				//打印*
				for(int j=1;j<=n-Math.abs(i-(n+1)/2)*2;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
	}

	// 15.有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
	public static void fifteen(int n) {
		//x:分子，y：分母
		double s = 0,x = 2,y=1;
		for(int i=1;i<=n;i++) {
			//第i个项的值
			s += x/y;
			//下一个项
			double t = x;
			x = x+y;
			y = t;
		}
		System.out.println("前"+n+"项的和为："+s);
	}

	/**
	 * @param x - 数列中最后一个项的分子
	 * @param y - 数列中最后一个项的分母
	 * @param n - 数列中项的个数
	 * @return 返回的是前n个项的和
	 */
	public static double fifteen2(double x,double y,int n) {
		if(n==1)return 2;
		else return (x+y)/x+fifteen2(x+y,x,n-1);
	}

	//16.一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同
	public static void sixteen(int n) {
		if(n<10000||n>99999) {
			System.out.println(n+"不是一个5位数");
			return;
		}

		String hw = n+"";
		if(hw.charAt(0)==hw.charAt(4)&&hw.charAt(1)==hw.charAt(3)) {
			System.out.println(n+"是回文数");
		}else {
			System.out.println(n+"不是回文数");
		}
	}

	//17.求100之内的素数
	public static void seventeen() {
		boolean flag;
		for(int i=2;i<100;i++){
			flag=true;
			for(int j=2;j<=Math.sqrt(new Double(i));j++){
				if(i%j==0){
					flag=false;
					break;
				}
			}
			if(flag==true)
				System.out.print(i+" ");
		}

	}



	//20.输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组
	public static void twenty() {
		int array[]=new int[]{113,24,23,41,24,23,4123,4,1235,3,4623,6};
		int max=array[0];
		int min=array[0];
		int minflag=0;
		int maxflag=0;
		for(int i=0;i<array.length;i++){
			if(array[i]<min){
				min=array[i];
				minflag=i;
			}
			if(array[i]>max){
				max=array[i];
				maxflag=i;
			}
		}
		int temp;
		temp=array[0];
		array[0]=array[maxflag];
		array[maxflag]=temp;

		temp=array[array.length-1];
		array[array.length-1]=array[minflag];
		array[minflag]=temp;

		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}

	/**
	 * 21、有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数
	 * @param
     */
	public static void twentyone(){
		int N =10;
		int[] a = new int[N];
		Scanner s = new Scanner(System.in);
		System.out.println("请输入10个整数：");
		for(int i=0; i<N; i++) {
			a[i] = s.nextInt();
		}
		System.out.print("你输入的数组为：");
		for(int i=0; i<N; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("\n请输入向后移动的位数：");
		int m = s.nextInt();
		int[] b = new int[m];
		for(int i=0; i<m; i++) {
			b[i] = a[N-m+i];
		}
		for(int i=N-1; i>=m; i--) {
			a[i] = a[i-m];
		}
		for(int i=0; i<m; i++) {
			a[i] = b[i];
		}
		System.out.print("位移后的数组是：");
		for(int i=0; i<N; i++) {
			System.out.print(a[i] + " ");
		}
	}
	public static void twentytwo(){

		int n=100;
		List<Integer> group=new ArrayList<Integer>();
		//1、给数组列表初始化数据
		for(int i=1;i<=n;i++){
			group.add(i);
		}
		//2、报数
		int number=1;//第一个人报数为1
		//圈里的人循环报数
		for(int i=0;i<n;i++){
			if(number==3){//当圈里第i+1个人报道的数是3
				group.remove(i);//圈里第i+1个人退出圈子
				i--;//下一个报数的人在数组列表中的下标值
				n--;//圈子的总人数减少1
				number=0;//通过number++，下一个人报的数是1
			}
			number++;  //报数时，每次加1
			if(i==n-1){//当所有的人报完一圈
				i=-1;//下一次从圈里的第一个人报，通过for循环的i++,对应数组列表下标值为0
			}
			if(n==1){//如果整个圈子最后只剩下一人
				break;
			}

		}
		System.out.println("最后留下的是原来"+group.get(0)+"号的那位。");
	}

	static int twentyfour(int i){
		int u=i;
		for(int x=0;x<5;x++){
			if(i%5!=1)
				return twentyfour(u+1);
			i=(i-1)/5*4;
		}
		return u;
	}

	public void twentyfive() {
		int number=2135;
		// 分解出位数
		int a, aa, aaa, aaaa;
		a = number % 10;
		aa = number / 10 % 10;
		aaa = number / 100 % 10;
		aaaa = number / 1000;
		// 代替数字
		a = (a + 5) % 10;
		aa = (aa + 5) % 10;
		aaa = (aaa + 5) % 10;
		aaaa = (aaaa + 5) % 10;
		// 第一位和第四位交换
		int temp;
		temp = a;
		a = aaaa;
		aaaa = temp;
		// 第二位和第三位交换
		temp = aa;
		aa = aaa;
		aaa = temp;
		System.out.println("交换后的数为" + aaaa + aaa + aa + a);
	}
	public static void twentysex(){
		String parent = "select * from t where t.id is null";
		String child = "e";
		String[] arr = (","+parent.toLowerCase()+",").split(child);
		System.out.println(arr.length - 1);
	}

	public static void main(String[] args) {

		//twenty();
		//seventeen();
		// two();
		/*
		 * int count = three(); System.out.println("共有"+count+"个素数");
		 */
		// four(120);
		// five(12,20);
		// six();
		/*
		 * long s= seven(2,5); System.out.println(s);
		 */
		// eight();
		// nine();
		// ten();
//		eleven();
		/*int date =twelve(2017,12,31);
		System.out.println("是这一年中的第"+date+"天");*/
//		thirteen();
//		forteen(11);
		/*fifteen(4);
		double sum = fifteen2(2,1,4);
		System.out.println("前2项的和为："+sum+"-------");*/
		//sixteen(4);

//		int[] arr= {1,23,45,67,89};
		/*int[] arr= {89,67,45,23,1};
		eighteen(arr);*/

		//nineteen();
	}

}




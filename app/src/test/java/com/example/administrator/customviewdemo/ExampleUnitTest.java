package com.example.administrator.customviewdemo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
//        assertEquals(4, 2 + 2);

//        0000 0000 0000 0000 0000 0000 0000 00100 二進制
//       用八进制表达时，你不能少了最前的那个0。否则计算机会通通当成10进制。不过，有一个地方使用八进制数时，却不能使用加0，那就是我们前面学的用于表达字符的“转义符”表达法。
//        现在，对于同样一个数，比如是100，我们在代码中可以用平常的10进制表达，例如在变量初始化时：
//        int   a   =   100;
//        我们也可以这样写：
//        int   a   =   0144;
//        //0144是八进制的100；一个10进制数如何转成8进制

//        如果不使用特殊的书写形式，16进制数也会和10进制相混。随便一个数：9876，就看不出它是16进制或10进制。
//        16进制数必须以   0x开头。比如   0x1表示一个16进制数。而1则表示一个十进制。另外如：0xff,0xFF,0X102A,等等。其中的x也不区分大小写。
//        (注意：0x中的0是数字0，而不是字母O)     以下是一些用法示例：
//        int   a   =   0x100F;     int   b   =   0x70   +   a;

//        Integer.toBinaryString(64)  轉換成二進制  結果  1000000

//        用二进制的最高位表示数 就是二进制的最高位为0表示这是正数,二进制的最高位为1表示 这是负数.简言之,就是数的符号,0为正,1为负.


//        C语言中位运算符之间，按优先级顺序排列为
//        1 ~
//        2 <<、>>
//        3 &
//        4 ^
//        5 |
//        6 &=、^=、|=、<<=、>>=



//        int n1 = 14;
//        //十进制转成十六进制：
//        Integer.toHexString(n1);
//        //十进制转成八进制
//        Integer.toOctalString(n1);
//        //十进制转成二进制
//        Integer.toBinaryString(12);
//
//        //十六进制转成十进制
//        Integer.valueOf("FFFF",16).toString();
//        //十六进制转成二进制
//        Integer.toBinaryString(Integer.valueOf("FFFF",16));
//        //十六进制转成八进制
//        Integer.toOctalString(Integer.valueOf("FFFF",16));
//
//        //八进制转成十进制
//        Integer.valueOf("576",8).toString();
//        //八进制转成二进制
//        Integer.toBinaryString(Integer.valueOf("23",8));
//        //八进制转成十六进制
//        Integer.toHexString(Integer.valueOf("23",8));
//
////二进制转十进制
//        Integer.valueOf("0101",2).toString();
//        //二进制转八进制
//        Integer.toOctalString(Integer.parseInt("0101", 2));
//        //二进制转十六进制
//        Integer.toHexString(Integer.parseInt("0101", 2));

//        以下的都是為8進制
//     且 （&；或者and）   相同位的两个数字都为1，则为1；若有一个不为1，则为0。
        int a = 00101&11100; //00100
//     或 （|或者or） 相同位只要一个为1即为1。
        int b = 000101|011100; //11101
//     xor   （^或者xor） 相同位不同则为1，相同则为0。
//        异或的符号是^。按位异或运算, 对等长二进制模式按位或二进制数的每一位执行逻辑按位异或操作. 操作的结果是如果某位不同则该位为1, 否则该位为0.
        int c = 000101^
                011100;//011001
//     not not运算的定义是把内存中的0和1全部取反
        int d =  ~00000010;// 8  二進制 00001000   最高為1表示負數 1111 0111 位 -(2^3+1)
//     shl运算  << 左移  a shl b就表示把a转为二进制后左移b位（在后面添b个0）
//     例如100的二进制为1100100，而110010000转成十进制是400，那么100 shl 2 = 400。
//     可以看出，a shl b的值实际上就是a乘以2的b次方，因为在二进制数后添一个0就相当于该数乘以2。
        int e =  010 << 1 ;
//    shr运算 >> 右移 和shl相似，a shr b表示二进制右移b位（去掉末b位），相当于a除以2的b次方（取整）。我们也经常用shr 1来代替div 2，
//  比如二分查找、堆的插入操作等等。想办法用shr代替除法运算可以使程序效率大大提高。
//  最大公约数的二进制算法用除以2操作来代替慢得出奇的mod运算，效率可以提高60%。
        int f = 010 >> 1;
//     java中>>代表的是向右移位运算，而>>=代表的是向右移位运算时将运算的结果同时赋值给原值，举个例子说明一下：
//        int  index = 7;
//        int  index2 = index>>1,则表示将7转化为二进制数后向右移动一位，而原值不变，故index = 7 ,index2 = 3；
//        int  index3 = index>>=1,则表示将7转化为二进制数后向右移动一位并且将结果赋值给原值，故 index = 3 ，index3 = 3.
        int g = 1;
        g>>=1;
        System.out.println(a+" "+b+" "+c+" "+d+" "+e+" "+f+" "+g);

//        以下的都是為8進制 5個位一組輸出
/**
 * A组   START
 */
//        A組
//        去掉最后一位 | (101101->10110) | x shr 1
        int Agroup1 = 011; // 二進制 1001  十進制 9
        Agroup1 >>=1;// 1001 --> 100 右移

//        在最后加一个0　| (101101->1011010) | x shl 1
        int Agroup2 = 011;//二進制 1001 十進制 9
        Agroup2 <<=1;// 1001 --> 10010 左移

//     在最后加一个1　| (101101->1011011) | x shl 1+1
        int Agroup3 = 011;//二進制  1001 十進制 9
        Agroup3 <<= 1;//    1001-->10010        18
        Agroup3+=1;//              10011        19

//      把最后一位变成1　| (101100->101101) | x or 1
        int Agroup4 = 010;//二進制  1000 十進制 8
        Agroup4^=1;
        //  1000
//          0001
//        --------
//          1001
//        把最后一位变成0　| (101101->101100) | x or 1-1
        int Agroup5 = 011;//二進制  1001 十進制 9
//                                  1000
        Agroup5|=1;
        Agroup5-=1;
        System.out.println("A組:"+Agroup1+" "+Agroup2+" "+Agroup3+" "+Agroup4+" "+Agroup5);
/**
 * A组   END
 */

/**
 * B组  START
 */
//        最后一位取反 | (101101->101100) | x xor 1
        int Bgroup1 = 021;//二進制  10001 十進制 17
        Bgroup1^=1;
//        10001
//    ^   00001
//   ------------------
//        10000

//        把右数第k位变成1 | (101001->101101,k=3) | x or (1 shl (k-1))
        int Bgroup2 = 021;//二進制  10001 十進制 17
//        k = 4                     11001        17+8=25
        int i = 1;
//        00001
        i<<=3;
//        01000
        Bgroup2^=i;
//        10001
//      ^ 01000
//      ------------
//         11001

//        把右数第k位变成0 | (101101->101001,k=3) | x and not (1 shl (k-1))
        int Bgroup3 = 023;//二進制  10011 十進制 19
//        k=2                       10001        17
        i = 1;
        i<<=1;
//        00010
        i = ~i;
//        11101;
        Bgroup3&=i;
//        10011
//       &11101
//     -------------
//        10001

//        右数第k位取反　| (101001->101101,k=3) | x xor (1 shl (k-1))
        int Bgroup4 = 023;//二進制  10011 十進制 19
//        k = 2                     10001        17
         i = 1;
         i<<=1;
//        第一种
//         i=~i;
//         Bgroup4&=i;

//        第二种 最简单快捷
        Bgroup4^=i;
//        10011
//     ^  00010
//      -------------
//        10001

//        取末三位 | (1101101->101) | x and 7
//        1101101
//     &  0000111
//       ---------
//        0000101
        int Bgroup5 = 023;//二進制  10011 十進制 19
        Bgroup5&=05;     //      &  00101
//                   取末k位　| (1101101->1101,k=5) | x and(1 shl k-1)              ----------
//                                  00001
        System.out.println("B組:"+Bgroup1+" "+Bgroup2+" "+Bgroup3+" "+Bgroup4+" "+Bgroup5);


/**
 * C组 START
 */
//        取末k位　| (1101101->1101,k=5) | x and(1 shl k-1)
        int Cgroup1 = 026;//二進制  11010 十進制 24
//        k=2                       00010         2
        i = 1;
        i<<=1;
        Cgroup1&=i;


//        取右数第k位　| (1101101->1,k=4) | x shr (k-1) and 1
        int Cgroup2 = 026;//二進制  10110 十進制 22
//         k = 3        取1
        Cgroup2 >>= 2;// 00001;
        Cgroup2 &= 1;  //


//        把末k位变成1　| (101001->101111,k=4) | x or (1 shl k-1)
        int Cgroup3 = 030;//二進制  11000 十進制 24
//        k = 3                     11111    16 8 4 2 1  31
        i = 1;
        i <<= 3; //                 01000
        i-=1;   //                  00111
        Cgroup3 |= i;   //          11100    16 8 4
//        末k位取反 | (101001->100110,k=4) | x xor (1 shl k-1)
        int Cgroup4 = 031;//二進制  11001 十進制 24
//       k = 3;                     11110        30
        i = 1;
        i<<=2;   //     00100
        Cgroup4^=i;


//        11001
//      ^ 00100
//       --------
//        11101

//        把右边连续的1变成0 | (100101111->100100000) | x and (x+1)
        int Cgroup5 = 023;//二進制  10011 十進制 19
        Cgroup5 &=(Cgroup5 + 1);
//        10011 + 00001 = 10100
//        10011
//     &  10100
//     -----------
//        10000
        System.out.println("C組:"+Cgroup1+" "+Cgroup2+" "+Cgroup3+" "+Cgroup4+" "+Cgroup5);
        /**
         * C组 END
         */
/**
 * D 组 START
 */
//                                                        16 8 4 2 1
//        把右起第一个0变成1 | (100101111->100111111) | x or (x+1)
        int Dgroup1 = 031;//二進制  11001 十進制 25       16 8 0 0 1
        Dgroup1|=(Dgroup1+1);
//        11001
//     |  11010
//-----------------------
//        11011                                   27
//        把右边连续的0变成1 | (11011000->11011111) | x or (x-1)
        int Dgroup2 = 034;//二進制  11100 十進制 28       16 8 4 2 1
        Dgroup2|=(Dgroup2-1);
//        11100
//     |  11011
//-----------------------
//        11111                                   31
//        取右边连续的1 | (100101111->1111) | (x xor (x+1)) shr 1
        int Dgroup3 = 033;//二進制  11011 十進制 30
        Dgroup3 = Dgroup3^=(Dgroup3+1);
        Dgroup3>>=1;
//        11011
//      ^ 11100
//   ----------------
//        00111
//        右移一位  00011   取出右边的连续的1    3

//        去掉右起第一个1的左边 | (100101000->1000) | x and (x xor (x-1))（或 x and (-x)）
        int Dgroup4 = 034; //二進制  11100 十進制 28
        Dgroup4&=(Dgroup4^=(Dgroup4-1));
//        11100
//    ^   11011
//    -------------
//        00111
//
//        11100
//    &   00111
//-----------------
//        00100                                  4
        int Dgroup5 = 037;//          11100      28
        Dgroup5 = -Dgroup5;//
        System.out.println("D組:"+Dgroup1+" "+Dgroup2+" "+Dgroup3+" "+Dgroup4+" "+Integer.toBinaryString(Dgroup5));
/**
 * D 组 END
 */

        /**
         * *****************************
         */

//        short占两个字节　ｉｎｔ占４个字节　long占８个字节 一个字节8位
        short T1 = 0x0000;
        short T2 = 0x0001;
        System.out.printf("%d  %d",T1,T2);
        System.out.println();
        T1 = (short) 0xFFFE;
        T2 = (short) 0xFFFF;
        System.out.printf("%d  %d",T1,T2);
        System.out.println();
        T1 = 0x7FFE;
        T2 = (short) 0x8000;
        System.out.printf("%d  %d",T1,T2);
        System.out.println();

//        byte是1个字节，也就是8位
//        最大的应该是0111 1111，因为第一位是符号位，0表示正数
//        最小的应该是1000 0000，同理，表示负数最小的（1111 1111是最大的负数-1）

//        负数表示的方式 http://blog.csdn.net/yi_afly/article/details/52484576
//        byte的取值范围是+127到—128
        System.out.println(Byte.MAX_VALUE +" "+Byte.MIN_VALUE+" "+Byte.valueOf("01111111",2)+" "+Byte.valueOf("-10000000",2));


//        高低为交换  给出一个小于2^32的正整数。这个数可以用一个32位的二进制数表示（不足32位用0补足）。
//        我们称这个二进制数的前16位为“高位”，后16位为“低位”。
        int SwpeA = Integer.valueOf("00000000000101000000111011011000",2);
        int Apart = SwpeA<<16;
        int Bpart = SwpeA>>16;
        int SwpeResult = Apart|Bpart;
        System.out.println(Integer.toBinaryString(1314520));
        System.out.println(Integer.toBinaryString(SwpeResult));
//
//        0000 0000 0001 0100 0000 1110 1101 1000
//        0000 1110 1101 1000 0000 0000 0001 0100

//       获取二进制的1的个数
        int InitA = 211;
        InitA = (InitA&0x555555) + ((InitA>>1)&0x55555);
        InitA = (InitA&0x333333) + ((InitA>>2)&0x33333);
        InitA = (InitA&0xF0F0F0F) + ((InitA>>4)&0xF0F0F0F);
        InitA = (InitA&0xFF00FF) + ((InitA>>8)&0xFF00FF);
        InitA = (InitA&0x00FFFF) + ((InitA>>16)&0x00FFFF);
        System.out.println("211的二进制的1的个数:"+InitA);
//        下面的程序读入一个32位整数并输出它的二进制倒序后所表示的数。
//        输入：1314520 （二进制为00000000000101000000111011011000）
//        输出：460335104 （二进制为00011011011100000010100000000000）
//        0000 0000 0001 0100 0000 1110 1101 1000
//        0001 1011 0111 0000 0010 1000 0000 0000


    }

//    intnlz(unsigned x)
//    {
//        intn;
//        if(x==0)return(32);
//        n=1;
//        if((x>>16)==0){n=n+16;x=x<<16;}
//        if((x>>24)==0){n=n+8;x=x<<8;}
//        if((x>>28)==0){n=n+4;x=x<<4;}
//        if((x>>30)==0){n=n+2;x=x<<2;}
//        n=n-(x>>31);
//        returnn;
//    }
}
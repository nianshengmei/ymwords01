package com.ym.common.code;

public class Number {


    char[] danWei = { '万','千', '百', '十' };

    /**
     * 把单位数字转换成汉字--->作为返回值
     */
    public char hanZi(int i) {
        switch (i) {
            case 1:
                return '一';
            case 2:
                return '二';
            case 3:
                return '三';
            case 4:
                return '四';
            case 5:
                return '五';
            case 6:
                return '六';
            case 7:
                return '七';
            case 8:
                return '八';
            case 9:
                return '九';
            default:
                return '零';
        }
    }
    /**
     * 把char类型的单位数字转换成int类型返回
     * @param c
     * @return
     */
    public int charToInt(char c) {
        switch (c) {
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                return 0;
        }
    }
    /**
     * 返回数字的长度，即该数字有几位
     * @param strNumber
     * @return
     */
    public int numberLength(String strNumber) {
        return strNumber.length();
    }
    /**
     * 将int类型的数字转换为String类型返回
     * @param i
     * @return
     */
    public String numberToString(int i) {
        return String.valueOf(i);
    }

    public void output() {
        for (int i = 0; i < 10000; i++) {
            if (i < 10) {
                System.out.println(hanZi(i));
            } else {
                //char类型的数组，用来存储每位的数字
                char[] numToChar = new char[100];
                String numberToString = numberToString(i);
                //int类型的数组，用来存储每位的数字
                int[] arrayNumber = new int[100];
                //numLength获取数字的位数
                int numLength = numberLength(numberToString);
                //左到右遍历数字，分别存入char和int数组
                for (int j = 0; j < numLength; j++) {
                    numToChar[j] = numberToString.charAt(j);
                    arrayNumber[j] = charToInt(numToChar[j]);
                }
                // 数字-->数字数组 正确
                //获取单位下标的起始位置
                int danWeiIndex = danWei.length - numLength;
                //从左到右遍历数字
                for (int k = 0; k < numLength; k++) {
                    // 第K位的数字
                    int everyStateNum = arrayNumber[k];
                    boolean flag = false;
                    if (everyStateNum == 0) {
                        // 左到右遍历，碰到第一个0开始如果后面一直是零则不输出，否则输出一个零
                        for (int q = k + 1; q < numLength; q++) {
                            danWeiIndex++;
                            if (arrayNumber[q] != 0) {
                                k = q - 1;
                                System.out.print("零");
                                flag = true;
                                break;
                            }
                            if (danWeiIndex == danWei.length) {
                                break;
                            }
                        }
                        if (flag) {
                            continue;
                        } else {
                            break;
                        }
                    } else {
                        System.out.print(hanZi(everyStateNum));
                        danWeiIndex++;
                        //控制单位数组的下标不能越界，到个位数字时候直接输出数字，但不输出单位
                        if (danWeiIndex == danWei.length) {
                            break;
                        }
                        System.out.print(danWei[danWeiIndex]);
                    }
                }
                System.out.println();
            }
        }
    }

}

package com.ym.common.io;

import java.io.*;

public class OpTxt {
    public void write(String filePath, String context) throws IOException {
        File file = new File(filePath);
        //写文件
        FileOutputStream fileOutPutStream =new FileOutputStream(file);
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(fileOutPutStream));
        bufferedWriter.write(context);
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}

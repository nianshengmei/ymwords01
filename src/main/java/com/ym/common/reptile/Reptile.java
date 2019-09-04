package com.ym.common.reptile;


import com.ym.common.code.StringOperation;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/*
* @author ym
* date 2019-08-07
* */
public class Reptile {

    //get HTML pages by url
    public StringBuilder fromURLGetHtml(String url){
        StringBuilder ret = new StringBuilder();
        try {
            URL realUrl = new URL(url);
            //连接url
            URLConnection connection = realUrl.openConnection();
            //读取rul流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while(bufferedReader.readLine() != null) {
                String str = bufferedReader.readLine();
                ret.append(str);
            }
            bufferedReader.close();
        }catch(MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }


    public void sendPost(String url, Map<String, Object> params) throws IOException {
        String response = null;


    }


    public StringBuilder getPage(String url) throws IOException {
        StringBuilder ret = new StringBuilder();
        HttpClientBuilder builder = HttpClients.custom();
        CloseableHttpClient client = builder.build();

        HttpGet request = new HttpGet(url);

        CloseableHttpResponse response =  client.execute(request);
        HttpEntity entity = response.getEntity();
        System.out.println(response.getStatusLine());
        ret.append(EntityUtils.toString(entity));
        return ret;
    }


    public String ChineseToEnglishTranslationLink(String query) throws Exception {
        String url = "http://dict.youdao.com/search";
        String newQuery = new StringOperation().toURLCode(query);
        url = url+"?q="+newQuery+"&keyfrom=new-fanyi.smartResult";
        return url;
    }

    public String fromEnglishGetDetail(String query) throws UnsupportedEncodingException {
        String url ="http://dict.youdao.com/w/eng/";
        String newQuery = new StringOperation().toURLCode(query);
        url+=newQuery+"/";
        return url;
    }





}

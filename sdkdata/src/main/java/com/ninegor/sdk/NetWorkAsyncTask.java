package com.ninegor.sdk;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by joye on 2017/2/27.
 */

public class NetWorkAsyncTask extends AsyncTask<String, Integer, Map<String, Object>> {
    URL url = null;//请求的URL地址
    HttpURLConnection conn = null;
    String requestHeader = null;//请求头
    byte[] requestBody = null;//请求体
    String responseHeader = null;//响应头
    byte[] responseBody = null;//响应体

    private Context context;
    private ICallBack callBack;

    public NetWorkAsyncTask(Context context, ICallBack callBack) {
        this.context = context;
        this.callBack = callBack;
    }

    public static interface  ICallBack{
        void issuccess(boolean b);

    }

    public NetWorkAsyncTask(Context context) {
        this.context = context;
    }



    @Override
    protected Map<String, Object> doInBackground(String... params) {
        Map<String, Object> result = new HashMap<>();
        try {
            url = new URL("http://apk.adminso.com/member/get_active");

            conn = (HttpURLConnection) url.openConnection();
            //通过setRequestMethod将conn设置成POST方法
            conn.setRequestMethod("POST");
            //调用conn.setDoOutput()方法以显式开启请求体
            conn.setDoOutput(true);
            //获取请求头
            requestHeader = getReqeustHeader(conn);
            //获取conn的输出流
            OutputStream os = conn.getOutputStream();
            //获取两个键值对name=孙群和age=27的字节数组，将该字节数组作为请求体
            String imei = NinegorManager.getIMEI(context);
            String appId = NinegorManager.getAppId(context);
            requestBody = new String("imei=" + imei + "&appid=" + appId + "&sig=" + getPwd(imei + appId + "OldManWong")+"&channel="+params[0]+"&action="+params[1]).getBytes("UTF-8");
            //将请求体写入到conn的输出流中
            os.write(requestBody);
            //记得调用输出流的flush方法
            os.flush();
            //关闭输出流
            os.close();
            //当调用getInputStream方法时才真正将请求体数据上传至服务器

            InputStream is = conn.getInputStream();
            //获得响应体的字节数组
            responseBody = getBytesByInputStream(is);
            //获得响应头
            responseHeader = getResponseHeader(conn);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //最后将conn断开连接
            if (conn != null) {
                conn.disconnect();
            }
        }

        result.put("url", url.toString());
        result.put("requestHeader", requestHeader);
        result.put("requestBody", requestBody);
        result.put("responseHeader", responseHeader);
        result.put("responseBody", responseBody);
        return result;
    }


    @Override
    protected void onPostExecute(Map<String, Object> result) {
        super.onPostExecute(result);
        String url = (String)result.get("url");//请求的URL地址
        String requestHeader = (String) result.get("requestHeader");//请求头
        byte[] requestBody = (byte[]) result.get("requestBody");//请求体
        String responseHeader = (String) result.get("responseHeader");//响应头
        byte[] responseBody = (byte[]) result.get("responseBody");//响应体
        int response = parseJsonResultByBytes(responseBody);
        if(callBack!=null){
            callBack.issuccess(response==0);
        }
//        tvResponseBody.setText(response);
    }

    //将表示json的字节数组进行解析
    private int parseJsonResultByBytes(byte[] bytes){
        String jsonString = getStringByBytes(bytes);
        return JsonParser.parse(jsonString);
//        StringBuilder sb = new StringBuilder();
//        for (Person person : persons) {
//            sb.append(person.toString()).append("\n");
//        }
//        return sb.toString();
    }

    //根据字节数组构建UTF-8字符串
    private String getStringByBytes(byte[] bytes) {
        String str = "";
        try {
            str = new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }


    //从InputStream中读取数据，转换成byte数组，最后关闭InputStream
    private byte[] getBytesByInputStream(InputStream is) {
        byte[] bytes = null;
        BufferedInputStream bis = new BufferedInputStream(is);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(baos);
        byte[] buffer = new byte[1024 * 8];
        int length = 0;
        try {
            while ((length = bis.read(buffer)) > 0) {
                bos.write(buffer, 0, length);
            }
            bos.flush();
            bytes = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return bytes;
    }

    //读取请求头
    private String getReqeustHeader(HttpURLConnection conn) {
        //https://github.com/square/okhttp/blob/master/okhttp-urlconnection/src/main/java/okhttp3/internal/huc/HttpURLConnectionImpl.java#L236
        Map<String, List<String>> requestHeaderMap = conn.getRequestProperties();
        Iterator<String> requestHeaderIterator = requestHeaderMap.keySet().iterator();
        StringBuilder sbRequestHeader = new StringBuilder();
        while (requestHeaderIterator.hasNext()) {
            String requestHeaderKey = requestHeaderIterator.next();
            String requestHeaderValue = conn.getRequestProperty(requestHeaderKey);
            sbRequestHeader.append(requestHeaderKey);
            sbRequestHeader.append(":");
            sbRequestHeader.append(requestHeaderValue);
            sbRequestHeader.append("\n");
        }
        return sbRequestHeader.toString();
    }

    //读取响应头
    private String getResponseHeader(HttpURLConnection conn) {
        Map<String, List<String>> responseHeaderMap = conn.getHeaderFields();
        int size = responseHeaderMap.size();
        StringBuilder sbResponseHeader = new StringBuilder();
        for (int i = 0; i < size; i++) {
            String responseHeaderKey = conn.getHeaderFieldKey(i);
            String responseHeaderValue = conn.getHeaderField(i);
            sbResponseHeader.append(responseHeaderKey);
            sbResponseHeader.append(":");
            sbResponseHeader.append(responseHeaderValue);
            sbResponseHeader.append("\n");
        }
        return sbResponseHeader.toString();
    }



    /**
     * 获取MD5加密
     *
     * @param pwd 需要加密的字符串
     * @return String字符串 加密后的字符串
     */
    public static String getPwd(String pwd) {
        try {
            // 创建加密对象
            MessageDigest digest = MessageDigest.getInstance("md5");

            // 调用加密对象的方法，加密的动作已经完成
            byte[] bs = digest.digest(pwd.getBytes());
            // 接下来，我们要对加密后的结果，进行优化，按照mysql的优化思路走
            // mysql的优化思路：
            // 第一步，将数据全部转换成正数：
            String hexString = "";
            for (byte b : bs) {
                // 第一步，将数据全部转换成正数：
                // 解释：为什么采用b&255
                /*
                 * b:它本来是一个byte类型的数据(1个字节) 255：是一个int类型的数据(4个字节)
                 * byte类型的数据与int类型的数据进行运算，会自动类型提升为int类型 eg: b: 1001 1100(原始数据)
                 * 运算时： b: 0000 0000 0000 0000 0000 0000 1001 1100 255: 0000
                 * 0000 0000 0000 0000 0000 1111 1111 结果：0000 0000 0000 0000
                 * 0000 0000 1001 1100 此时的temp是一个int类型的整数
                 */
                int temp = b & 255;
                // 第二步，将所有的数据转换成16进制的形式
                // 注意：转换的时候注意if正数>=0&&<16，那么如果使用Integer.toHexString()，可能会造成缺少位数
                // 因此，需要对temp进行判断
                if (temp < 16 && temp >= 0) {
                    // 手动补上一个“0”
                    hexString = hexString + "0" + Integer.toHexString(temp);
                } else {
                    hexString = hexString + Integer.toHexString(temp);
                }
            }
            return hexString;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


}

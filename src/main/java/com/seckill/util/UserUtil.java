package com.seckill.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seckill.entity.User;
import com.seckill.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserUtil {
	@Autowired
	private UserMapper userMapper;

	public  void createUser(int count) throws Exception{
		List<User> users = new ArrayList<>(count);
		//生成用户
		for(int i=0;i<count;i++) {
			User user = new User();
			user.setMobile("18299999999_"+i);
			user.setSalt("5d495e6db1fc4285aa87cab3eed94a14");
			user.setPassword("1bb13696e7bec593530267e27a1525b0");
			users.add(user);
			//userMapper.insert(user);
		}
		//登录，生成token
		String urlString = "http://localhost:8080/login/do";
		File file = new File("user.txt");
		if(file.exists()) {
			file.delete();
		}
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		file.createNewFile();
		raf.seek(0);
		for(int i=0;i<users.size();i++) {
			User user = users.get(i);
			URL url = new URL(urlString);
			HttpURLConnection co = (HttpURLConnection)url.openConnection();
			co.setRequestMethod("POST");
			co.setDoOutput(true);
			OutputStream out = co.getOutputStream();
			String params = "mobile="+user.getMobile()+"&password="+"67cbf38191f965aa070cd90b85b4b772";
			out.write(params.getBytes());
			out.flush();
			InputStream inputStream = co.getInputStream();
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			byte buff[] = new byte[1024];
			int len = 0;
			while((len = inputStream.read(buff)) >= 0) {
				bout.write(buff, 0 ,len);
			}
			inputStream.close();
			bout.close();
			String response = new String(bout.toByteArray());
			JSONObject jo = JSON.parseObject(response);
			String token = jo.getString("data");
			System.out.println("create token : " + user.getId());

			String row = user.getMobile()+","+token;
			raf.seek(raf.length());
			raf.write(row.getBytes());
			raf.write("\r\n".getBytes());
			System.out.println("write to file : " + user.getId());
		}
		raf.close();

		System.out.println("over");
	}

//	public static void main(String[] args)throws Exception {
//		createUser(5000);
//	}
}

package com.nginx001.demo.test.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nginx001.demo.test.dao.ADao;
import com.nginx001.demo.test.entity.A;

@Component
public class TestTask {

	@Autowired
	private ADao aDao;

	private int i = 10000;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(cron = "0/10 * * * * ?")
	private void task1() {
		i++;
		A a = aDao.getById(i);
		a.setText(a.getText()+"----"+i);
		a = aDao.save(a);
		String string = i + (a==null?"null":a.toString());
		System.out.println("[" + Thread.currentThread().getName() + "][" + dateFormat.format(new Date()) + "]" + string);
	}

}

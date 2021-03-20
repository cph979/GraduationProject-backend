package org.cph.vhr.web.system.data;

import org.cph.vhr.model.RespBean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 数据库备份还原
 *
 * @author cph
 * @date 2021/03/17
 */
@RestController
@RequestMapping("/system/data")
public class DatabaseController {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	/**
	 * 数据库备份
	 *
	 * @param driveLetter 盘符
	 * @return
	 */
	@GetMapping("/backup")
	public RespBean backupDatabase(@RequestParam("driveletter") String driveLetter) {
		String currentDate = sdf.format(new Date());
		StringBuffer sqlFilePlace = new StringBuffer();
		sqlFilePlace.append(driveLetter).append(":\\emp").append(currentDate).append(".sql");

		String cmd =  "cmd /c mysqldump -uroot -proot vhr > " + sqlFilePlace.toString();
		try {
			Runtime.getRuntime().exec(cmd);
			return RespBean.ok("备份成功");
		} catch (Exception e) {
			return RespBean.error("备份失败", e.toString());
		}
	}

	/**
	 * 数据库初始化
	 *
	 * @param file 上传的sql文件
	 * @return
	 */
	@PostMapping("/reduction")
	public RespBean reductionDatabase(MultipartFile file) {
		String originalFilename = file.getOriginalFilename();
		String fileType = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
		if (!"sql".equals(fileType)) {
			return RespBean.error("只支持sql类型的文件进行数据库初始化");
		}
		Runtime runtime = Runtime.getRuntime();
		try {
			Process exec = runtime.exec("mysql -uroot -proot vhr");
			OutputStream os = exec.getOutputStream();

			StringBuffer sb = new StringBuffer();
			String strCache;

			BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
			while ((strCache = br.readLine()) != null) {
				sb.append(strCache + "\r\n");
			}

			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			osw.write(sb.toString());
			// 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免
			osw.flush();
			osw.close();
			br.close();
			os.close();
			return RespBean.ok("数据库初始化成功");
		} catch (IOException e) {
			return RespBean.error("数据库初始化失败", e.toString());
		}
	}
}
